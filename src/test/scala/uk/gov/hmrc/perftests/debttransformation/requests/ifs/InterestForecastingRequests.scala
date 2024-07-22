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
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

import java.time.LocalDate

object InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate = LocalDate.now().toString
  var instalmentDate = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept" -> "application/vnd.hmrc.1.0+json",
    "Content-Type" -> "application/json"
  )


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
       |          "debtId": "Debt1",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt2",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt3",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt4",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt5",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt6",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt7",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt8",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt9",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt10",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt11",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt12",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt13",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt14",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt15",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt16",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt17",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt18",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt19",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt20",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt21",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt22",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt23",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt24",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt25",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt26",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt27",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt28",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt29",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt30",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt31",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt32",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt33",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt34",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt35",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt36",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt37",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt38",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt39",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt40",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt41",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt42",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt43",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt44",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt45",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt46",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt47",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt48",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt49",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt50",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt51",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt52",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt53",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt54",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt55",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt56",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt57",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt58",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt59",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt60",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt61",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt62",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt63",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt64",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt65",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt66",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt67",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt68",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt69",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt70",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt71",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt72",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt73",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt74",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt75",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt76",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt77",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt78",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt79",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt80",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt81",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt82",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt83",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt84",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt85",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt86",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt87",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt88",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt89",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt90",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt91",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt92",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt93",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt94",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt95",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt96",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt97",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt98",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt99",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt100",
       |          "debtAmount": 10000,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    }],
       |	"quoteDate": "$quoteDate",
       |    "quoteType": "instalmentAmount",
       |	"instalmentPaymentDate": "$instalmentDate",

       |	"paymentFrequency": "monthly",
       |	"duration":6 ,
       |	"customerPostCaodes": [
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
      .check(status.is(200))

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
      .check(status.is(200))

}