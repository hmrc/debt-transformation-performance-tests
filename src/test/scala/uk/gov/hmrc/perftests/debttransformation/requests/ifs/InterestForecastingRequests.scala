/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import play.api.libs.json.{JsArray, JsNumber, JsObject, Json}
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

import java.time.LocalDate

object InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate          = LocalDate.now().toString
  var instalmentDate     = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken        = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders     = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  object DataForMemoryLoadTests {
    def requestWithManyUngroupedCharges(baseUri: String): HttpRequestBuilder = {
      val rawRequest =
        s"""{
           |  "debtItemCharges": ${Json.prettyPrint(manyUngroupableChargesUsingTheSameIfsRule)},
           |  "quoteDate": "$quoteDate",
           |  "quoteType": "duration",
           |  "instalmentPaymentDate": "$instalmentDate",
           |  "paymentFrequency": "monthly",
           |  "instalmentPaymentAmount": 10000,
           |  "customerPostCodes": [],
           |  "interestCallDueTotal": 5900,
           |  "initialPaymentDate": "$initialPaymentDate",
           |  "initialPaymentAmount": 100
           |}""".stripMargin

      http("Instalment Plan with max number of debt items - Unique debtId's")
        .post(s"$baseUri/instalment-calculation")
        .headers(requestHeaders)
        .body(StringBody(rawRequest))
        .check(status.is(200))
    }

    def requestWithManyGroupedCharges(baseUri: String): HttpRequestBuilder = {
      val rawRequest =
        s"""{
           |  "debtItemCharges": ${Json.prettyPrint(manyIdenticalCharges)},
           |  "quoteDate": "$quoteDate",
           |  "quoteType": "duration",
           |  "instalmentPaymentDate": "$instalmentDate",
           |  "paymentFrequency": "monthly",
           |  "instalmentPaymentAmount": 10000,
           |  "customerPostCodes": [],
           |  "interestCallDueTotal": 5900,
           |  "initialPaymentDate": "$initialPaymentDate",
           |  "initialPaymentAmount": 100
           |}""".stripMargin

      http("Instalment Plan with max number of debt items - Non unique debtId's")
        .post(s"$baseUri/instalment-calculation")
        .headers(requestHeaders)
        .body(StringBody(rawRequest))
        .check(status.is(200))
    }

    def requestRelyingOnManyIfsRules(baseUri: String): HttpRequestBuilder = {
      val rawRequest =
        s"""{
         |  "debtItemCharges": ${Json.prettyPrint(manyUngroupableChargesForDistinctIfsRules)},
         |  "quoteDate": "$quoteDate",
         |  "quoteType": "duration",
         |  "instalmentPaymentDate": "$instalmentDate",
         |  "paymentFrequency": "monthly",
         |  "instalmentPaymentAmount": 10000,
         |  "customerPostCodes": [],
         |  "interestCallDueTotal": 5900,
         |  "initialPaymentDate": "$initialPaymentDate",
         |  "initialPaymentAmount": 100
         |}""".stripMargin

      http("Instalment Plan with max number of debt items - Unique main and subTrans")
        .post(s"$baseUri/instalment-calculation")
        .headers(requestHeaders)
        .body(StringBody(rawRequest))
        .check(status.is(200))
    }

    def requestWithManyInstalments(baseUri: String): HttpRequestBuilder = {
      val instalmentAmount: BigDecimal = 100
      val charges                      = chargesCausingManyInstalments(instalmentAmountPence = instalmentAmount)

      val rawRequest =
        s"""{
         |  "debtItemCharges": ${Json.prettyPrint(charges)},
         |  "quoteDate": "$quoteDate",
         |  "quoteType": "duration",
         |  "instalmentPaymentDate": "$instalmentDate",
         |  "paymentFrequency": "monthly",
         |  "instalmentPaymentAmount": ${JsNumber(instalmentAmount)},
         |  "customerPostCodes": [],
         |  "interestCallDueTotal": 5900,
         |  "initialPaymentDate": "$initialPaymentDate",
         |  "initialPaymentAmount": 100
         |}""".stripMargin

      http("Instalment Plan with many instalments - 7000 instalments")
        .post(s"$baseUri/instalment-calculation")
        .headers(requestHeaders)
        .body(StringBody(rawRequest))
        .check(status.is(200))
    }

    private def manyUngroupableChargesUsingTheSameIfsRule: JsArray = {
      val mainTrans: String      = "1530"
      val subTrans: String       = "1000"
      val numberOfCharges        = 500
      val approxTotalAmount: Int = 1000

      val chargeReferences: IndexedSeq[String] = (1 to numberOfCharges).map(index => s"ChargeRef$index")

      val charges: IndexedSeq[JsObject] = chargeReferences.map { chargeRef =>
        Json.obj(
          "debtId"     -> s"Debt$chargeRef",
          "debtAmount" -> approxTotalAmount / numberOfCharges,
          "subTrans"   -> subTrans,
          "mainTrans"  -> mainTrans
        )
      }

      JsArray(charges)
    }

    private def manyIdenticalCharges: JsArray = {
      val mainTrans: String      = "1530"
      val subTrans: String       = "1000"
      val numberOfCharges        = 900
      val approxTotalAmount: Int = 1000

      val charges: IndexedSeq[JsObject] = (1 to numberOfCharges).map { _ =>
        Json.obj(
          "debtId"     -> s"SharedChargeRef",
          "debtAmount" -> approxTotalAmount / numberOfCharges,
          "subTrans"   -> subTrans,
          "mainTrans"  -> mainTrans
        )
      }

      JsArray(charges)
    }

    private def manyUngroupableChargesForDistinctIfsRules: JsArray = {
      val approxTotalAmount: Int = 1000

      // TODO DTD-3479: This needs to have many, many more pairs of mainTrans and subTrans.
      val mainTransAndSubTrans: IndexedSeq[(String, String)] =
        IndexedSeq(
          ("1530", "1000"),
          ("1525", "1000"),
          ("1535", "1000"),
          ("1540", "1000"),
          ("1545", "1000"),
          ("5330", "7006"),
          ("5330", "7010"),
          ("5330", "7011"),
          ("5350", "7012"),
          ("5350", "7014"),
          ("5350", "7013"),
          ("1085", "1000"),
          ("1085", "1020"),
          ("1085", "1025"),
          ("1085", "1180"),
          ("1511", "2000"),
          ("1515", "1090"),
          ("1520", "1090"),
          ("1526", "2000"),
          ("1531", "2000"),
          ("1536", "2000"),
          ("1541", "2000"),
          ("1546", "2000"),
          ("2421", "1150"),
          ("1441", "1150"),
          ("2005", "2000"),
          ("2005", "2020"),
          ("2005", "2023"),
          ("2005", "2026"),
          ("2005", "2030"),
          ("2005", "2100"),
          ("2007", "1107"),
          ("2045", "2000"),
          ("2045", "2100"),
          ("2065", "2020"),
          ("2095", "2000"),
          ("2095", "2020"),
          ("2095", "2023"),
          ("2095", "2026"),
          ("2095", "2100"),
          ("2105", "2000"),
          ("2105", "2023"),
          ("2105", "2026"),
          ("2105", "2030"),
          ("2105", "2100"),
          ("2135", "2355"),
          ("2505", "2090"),
          ("2515", "2090"),
          ("2525", "2090"),
          ("2535", "2090"),
          ("2545", "2090"),
          ("2555", "2090"),
          ("2565", "2090"),
          ("2575", "2090"),
          ("2585", "2090"),
          ("2595", "2090"),
          ("1025", "1090"),
          ("1030", "1090"),
          ("1035", "1090"),
          ("1040", "1090"),
          ("1045", "1090"),
          ("2110", "1090"),
          ("2115", "1090"),
          ("2120", "1090"),
          ("2125", "1090"),
          ("2000", "1000"),
          ("2000", "1020"),
          ("2000", "1023"),
          ("2000", "1026"),
          ("2000", "1030"),
          ("2000", "1100"),
          ("2006", "1106"),
          ("2030", "1250"),
          ("2030", "1260"),
          ("2030", "1270"),
          ("2030", "1280"),
          ("2030", "1290"),
          ("2030", "1300"),
          ("2030", "1310"),
          ("2030", "1320"),
          ("2030", "1330"),
          ("2030", "1340"),
          ("2030", "1350"),
          ("2030", "1390"),
          ("2030", "1395"),
          ("2040", "1000"),
          ("2060", "1020"),
          ("2090", "1000"),
          ("2090", "1020"),
          ("2090", "1023"),
          ("2090", "1026"),
          ("2090", "1100"),
          ("2090", "1250"),
          ("2090", "1260"),
          ("2090", "1270"),
          ("2090", "1280"),
          ("2090", "1290"),
          ("2090", "1300"),
          ("2090", "1310"),
          ("2090", "1320"),
          ("2090", "1330"),
          ("2090", "1340"),
          ("2090", "1350"),
          ("2100", "1000"),
          ("2100", "1023"),
          ("2100", "1026"),
          ("2100", "1030"),
          ("2100", "1100"),
          ("2130", "1355"),
          ("2500", "1090"),
          ("2510", "1090"),
          ("2520", "1090"),
          ("2530", "1090"),
          ("2540", "1090"),
          ("2550", "1090"),
          ("2560", "1090"),
          ("2570", "1090"),
          ("2580", "1090"),
          ("2590", "1090"),
          ("4700", "1174"),
          ("4760", "1090"),
          ("4766", "1090"),
          ("4745", "1090"),
          ("4770", "1090"),
          ("4773", "1090"),
          ("4776", "1090"),
          ("4755", "1090"),
          ("4783", "1090"),
          ("4765", "1090"),
          ("4775", "1090"),
          ("4790", "1090"),
          ("4793", "1090"),
          ("4748", "1090"),
          ("4703", "1090"),
          ("4704", "1090"),
          ("4735", "1090"),
          ("3996", "1091")
        )

      val numberOfCharges = mainTransAndSubTrans.size

      val charges: IndexedSeq[JsObject] = mainTransAndSubTrans.map { case (mainTrans, subTrans) =>
        Json.obj(
          "debtId"     -> s"debt_for_${mainTrans}_$subTrans",
          "debtAmount" -> approxTotalAmount / numberOfCharges,
          "subTrans"   -> subTrans,
          "mainTrans"  -> mainTrans
        )
      }

      JsArray(charges)
    }

    private def chargesCausingManyInstalments(instalmentAmountPence: BigDecimal): JsArray = {
      val mainTrans: String = "1530"
      val subTrans: String  = "1000"

      val totalAmount: BigDecimal = instalmentAmountPence * 1420 // 7000 instalments

      Json.arr(
        Json.obj(
          "debtId"     -> s"IdForLargeDebt",
          "debtAmount" -> totalAmount,
          "subTrans"   -> subTrans,
          "mainTrans"  -> mainTrans
        )
      )
    }

  }

  val InitialPaymentInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "1234",
       |		"debtAmount": 80000,
       |		"subTrans": "1000",
       |		"mainTrans": "1525"
       |
       |	}],
       |	"quoteDate": "$quoteDate",
       |	"quoteType": "duration",
       |	"instalmentPaymentDate": "$instalmentDate",
       |	"paymentFrequency": "monthly",
       |	"instalmentPaymentAmount": 10000,
       |	"customerPostCodes": [
       |
       |	],
       |	"interestCallDueTotal": 5900,
       |	"initialPaymentDate": "$initialPaymentDate",
       |	"initialPaymentAmount": 100
       |
       |}""".stripMargin

  def instalmentPlanWithInitialPayment(baseUri: String): HttpRequestBuilder =
    http("Single Debt Instalment Plan  : Initial Payment Date Before Instalment Date")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(InitialPaymentInstalmentPlan))
      .check(status.is(200))

  val MultipleDebtInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "debtId",
       |		"debtAmount": 50000,
       |		"subTrans": "7012",
       |		"mainTrans": "5350"
       |
       |	}, {
       |		"debtId": "debtId",
       |		"debtAmount": 50000,
       |		"subTrans": "7013",
       |		"mainTrans": "5350"
       |
       |	}],

       |	"quoteDate": "$quoteDate",
       |	"quoteType": "duration",
       |	"instalmentPaymentDate": "$instalmentDate",

       |	"paymentFrequency": "single",
       |	"instalmentPaymentAmount": 10000,
       |	"customerPostCaodes": [
       |
       |	],
       |	"interestCallDueTotal": 1423,	"interestCallDueTotal": 0,
       | 	"initialPaymentDate": "$initialPaymentDate",
       | 	"initialPaymentAmount": 100
       |
       |}""".stripMargin

  def instalmentPlanWithMultipleDebts(baseUri: String): HttpRequestBuilder =
    http("Multiple Debt Instalment Plan")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtInstalmentPlan))
      .check(status.is(200))

  val noInitialPaymentInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "Debt1",
       |		"debtAmount": 100000,
       |		"subTrans": "1000",
       |		"mainTrans": "1525"
       |
       |	}, {
       |		"debtId": "Debt2",
       |		"debtAmount": 150000,
       |		"subTrans": "1000",
       |		"mainTrans": "1530"
       |
       |	}],
       |	"quoteDate": "$quoteDate",
       |	"quoteType": "instalmentAmount",
       |	"instalmentPaymentDate": "$instalmentDate",
       |	"paymentFrequency": "monthly",
       |	"duration": 24,
       |	"customerPostCodes": [
       |
       |	],
       |	"interestCallDueTotal": 0
       |
       |}""".stripMargin

  def instalmentPlanWithNoInitialPayment(baseUri: String): HttpRequestBuilder =
    http("Instalment Plan For Multiple Debts - With No Initial payment")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(noInitialPaymentInstalmentPlan))
      .check(status.is(200))

  val multipleDebtsWithOnePaymentHistory =
    s"""
       |{
       |	"debtItems": [{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
       |
       |			"interestStartDate": "2018-12-16",
       |			"interestRequestedTo": "2019-04-14",
       |
       |			"paymentHistory": [{
       |					"paymentAmount": 100000,
       |					"paymentDate": "2019-02-03"
       |				}
       |
       |			]
       |		}
       |
       |		, {
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
       |
       |			"interestStartDate": "2018-12-16",
       |			"interestRequestedTo": "2019-04-14",
       |
       |			"paymentHistory": [
       |
       |			]
       |		}
       |
       |
       |	],
       |
       |	"breathingSpaces": [
       |
       |	],
       |
       |	"customerPostCodes": [
       |
       |	]
       |
       |}
                                             """.stripMargin

  val multipleDebtsNonInterestingBearing =
    s"""{
       |      "debtItemCharges":[    {
       |          "debtId": "debtId",
       |          "debtAmount": 50000,
       |          "subTrans": "7012",
       |          "mainTrans": "5350"
       |
       |    },    {
       |          "debtId": "debtId",
       |          "debtAmount": 50000,
       |          "subTrans": "7013",
       |          "mainTrans": "5350"
       |
       |    }],

       |      "quoteDate": "$quoteDate",
       |      "quoteType": "duration",
       |      "instalmentPaymentDate": "$instalmentDate",
       |      "paymentFrequency":"single",
       |       "instalmentPaymentAmount":10000 ,
       |      "customerPostCodes": [
       |
       |        ],
       |	    "interestCallDueTotal": 1423
       |
       |    }""".stripMargin

  def multipleDebtsWithOnePaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple debt items with one payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(multipleDebtsWithOnePaymentHistory))
      .check(status.is(200))

  val twoDebtsWithLeapYear =
    s"""
       |{
       |	"debtItems": [{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
       |			"interestStartDate": "2018-06-01",
       |			"interestRequestedTo": "2021-03-31",
       |			"paymentHistory": [{
       |				"paymentAmount": 100000,
       |				"paymentDate": "2019-03-15"
       |			}, {
       |				"paymentAmount": 100000,
       |				"paymentDate": "2020-04-15"
       |			}]
       |		},
       |		{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1090",
       |			"mainTrans": "1545",
       |			"interestStartDate": "2009-01-01",
       |			"interestRequestedTo": "2010-01-01",
       |			"paymentHistory": []
       |		}
       |	],
       |	"breathingSpaces": [],
       |	"customerPostCodes": []
       |}

       """.stripMargin

  def TwoDebtItemsWithLeapYearPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts with Interest rate changes and leap year payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(twoDebtsWithLeapYear))
      .check(status.is(200))

  val noInterestBearing =
    """{
      |	"debtItems": [{
      |		"debtID": "123",
      |		"originalAmount": 500000,
      |		"subTrans": "1000",
      |		"mainTrans": "1525",
      |		"interestStartDate": "2018-12-16",
      |		"interestRequestedTo": "2019-04-14",
      |		"paymentHistory": []
      |	}, {
      |		"debtID": "123",
      |		"originalAmount": 500000,
      |		"subTrans": "1000",
      |		"mainTrans": "1525",
      |		"interestStartDate": "2018-12-16",
      |		"interestRequestedTo": "2019-04-14",
      |		"paymentHistory": []
      |	}],
      |	"breathingSpaces": [],
      |	"customerPostCodes": []
      |
      |}""".stripMargin

  def nonInterestBearingDebtItemWithNoBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Non Interest Bearing TPSS MainTrans 1525 debt")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(noInterestBearing))
      .check(status.is(200))

  val multipleSAdebtsWithPaymentsAndBreathingSpaces: String =
    s"""{
       |    "debtItems": [
       |        {
       |            "debtID": "1233",
       |            "originalAmount": 50000,
       |            "subTrans": "1553",
       |            "mainTrans": "4920",
       |            "interestStartDate": "2022-01-31",
       |            "interestRequestedTo": "2023-06-17",
       |            "breathingSpaces": [
       |                {
       |                    "debtRespiteFrom": "2022-03-01",
       |                    "debtRespiteTo": "2022-04-29"
       |                },
       |                {
       |                    "debtRespiteFrom": "2023-04-01",
       |                    "debtRespiteTo": "2034-06-17"
       |                }
       |            ],
       |            "paymentHistory": [
       |                {
       |                    "paymentAmount": 25000,
       |                    "paymentDate": "2022-05-30"
       |                }
       |            ]
       |        },
       |        {
       |            "debtID": "1234",
       |            "originalAmount": 1500,
       |            "subTrans": "1090",
       |            "mainTrans": "1520",
       |            "interestStartDate": "2034-11-12",
       |            "interestRequestedTo": "2022-06-10",
       |            "breathingSpaces": [],
       |            "paymentHistory": []
       |        },
       |        {
       |            "debtID": "1235",
       |            "originalAmount": 50000,
       |            "subTrans": "1553",
       |            "mainTrans": "4920",
       |            "interestStartDate": "2022-07-30",
       |            "interestRequestedTo": "2023-03-31",
       |            "breathingSpaces": [
       |                {
       |                    "debtRespiteFrom": "2023-04-01",
       |                    "debtRespiteTo": "2034-06-17"
       |                }
       |            ],
       |            "paymentHistory": []
       |        }
       |    ],
       |    "customerPostCodes": []
       |}""".stripMargin

  def multipleDebtItemsWithPaymentsAndBreathingSpaces(baseUri: String): HttpRequestBuilder =
    http("Multiple SA debt items with payments and breathing spaces")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(multipleSAdebtsWithPaymentsAndBreathingSpaces))
      .check(status.is(400))

  val interestType: String =
    s"""[
       |    {
       |        "mainTrans": "2000",
       |        "subTrans": "1000"
       |    }
       |]""".stripMargin

  def debtInterestTypeRequest(baseUri: String): HttpRequestBuilder =
    http("debt Interest Type")
      .post(s"$baseUri/debt-interest-type")
      .headers(requestHeaders)
      .body(StringBody(interestType))
      .check(status.is(400))

}
