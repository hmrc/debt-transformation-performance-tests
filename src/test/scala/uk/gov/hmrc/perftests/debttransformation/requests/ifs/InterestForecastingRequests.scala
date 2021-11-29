package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

import java.time.LocalDate

object InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate           = LocalDate.now().toString
  var instalmentDate = LocalDate.now().plusDays(1).toString
  var initialPaymentDate  = LocalDate.now().plusDays(1).toString
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )


  val InitialPaymentInstalmentPlan: String =s"""{
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

  val  MultipleDebtInstalmentPlan:String=s"""{
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


  val noInitialPaymentInstalmentPlan: String=s"""{
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

  val multipleDebtsWithOnePaymentHistory=s"""
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

  val multipleDebtsNonInterestingBearing=s"""{
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

  def TwoDebtItemsWithLeapYearPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts with Interest rate changes and leap year payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\"dateCreated\": \"2018-06-01\",\n\t\t\"interestStartDate\": \"2018-06-01\",\n\t\t\"interestRequestedTo\": " +
            "\"2021-03-31\",\n\t\t\"paymentHistory\": [{\n\t\t\t\"paymentAmount\": 100000,\n\t\t\t\"paymentDate\": \"2019-03-15\"\n\t\t}, {\n\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\"paymentDate\": \"2020-04-15\"\n\t\t}]\n\t}, {\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": " +
            "\"1090\",\n\t\t\"mainTrans\": \"1545\",\n\t\t\"dateCreated\": \"2009-01-01\",\n\t\t\"interestStartDate\": \"2009-01-01\",\n\t\t\"interestRequestedTo\": " +
            "\"2010-01-01\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"
        )
      )
      .check(status.is(200))

  val noInterestBearing="""{
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

  def debtItemInterestRateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts, 5 payments on 1 debt ")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(
        "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 1000000,\n\t\t\t\"subTrans\": " +
          "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\":" +
          " \"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\": " +
          "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 200000,\n\t\t\t\t\"paymentDate\": " +
          "\"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\": \"2019-02-13\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": " +
          "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-06\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\":" +
          " \"2019-02-13\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
          "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\": " +
          "\"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": []\n\t\t}\n\t],\n\n\t\"breathingSpaces\": []\n\n}"
      ))
      .check(status.is(200))

  def LeapYearsdebtItemsWithPaymentHistory(baseUri: String): HttpRequestBuilder =
    http(" 2 leap year debt items with payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(
        "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
          "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2020-02-02\",\n\t\t\t\"interestStartDate\":" +
          " \"2020-02-02\",\n\t\t\t\"interestRequestedTo\": \"2021-05-01\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\":" +
          " 300000,\n\t\t\t\t\"paymentDate\": \"2020-05-03\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
          "500000,\n\t\t\t\"subTrans\": \"1090\",\n\t\t\t\"mainTrans\": \"1520\",\n\t\t\t\"dateCreated\": \"2016-05-16\",\n\t\t\t\"interestStartDate\": " +
          "\"2016-05-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\t\"paymentAmount\": " +
          "200000,\n\t\t\t\t\t\"paymentDate\": \"2016-12-03\"\n\t\t\t\t}\n\n\t\t\t]\n\t\t}\n\n\n\t],\n\n\t\"breathingSpaces\": [\n\n\t]\n\n}"))
      .check(status.is(200))

}
