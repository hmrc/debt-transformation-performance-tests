package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object InterestForecastingRequests extends ServicesConfiguration {

  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  def multipleDebtsWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple debt items with no paymentHistory")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\":" +
            " \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000," +
            "\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": []}], \"breathingSpaces\": [\n\n\t]\n\n}"
        )
      )
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

  def nonInterestBearingDebtItemWithNoBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Non Interest Bearing TPSS MainTrans 1525 debt")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1090\",\n\t\t\"mainTrans\": \"1520\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"
        )
      )
      .check(status.is(200))

  def debtItemInterestRateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts, 5 payments on 1 debt ")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 1000000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 200000,\n\t\t\t\t\"paymentDate\": " +
            "\"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\": \"2019-02-13\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-06\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\":" +
            " \"2019-02-13\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": []\n\t\t}\n\t],\n\n\t\"breathingSpaces\": []\n\n}"
        )
      )
      .check(status.is(200))

  def LeapYearsdebtItemsWithPaymentHistory(baseUri: String): HttpRequestBuilder =
    http(" 2 leap year debt items with payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2020-02-02\",\n\t\t\t\"interestStartDate\":" +
            " \"2020-02-02\",\n\t\t\t\"interestRequestedTo\": \"2021-05-01\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\":" +
            " 300000,\n\t\t\t\t\"paymentDate\": \"2020-05-03\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1090\",\n\t\t\t\"mainTrans\": \"1520\",\n\t\t\t\"dateCreated\": \"2016-05-16\",\n\t\t\t\"interestStartDate\": " +
            "\"2016-05-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\t\"paymentAmount\": " +
            "200000,\n\t\t\t\t\t\"paymentDate\": \"2016-12-03\"\n\t\t\t\t}\n\n\t\t\t]\n\t\t}\n\n\n\t],\n\n\t\"breathingSpaces\": [\n\n\t]\n\n}"
        )
      )
      .check(status.is(200))

  val singlePaymentFrequency=
    """
      |{
      |	"totalNumberOfInstalments": 11,
      |	"expectedPayment": 101462,
      |	"totalPlanInt": 39,
      |	"interestAccrued": 1423,
      |	"paymentPlanCalculationResponse": [{
      |			"serialNo": 1,
      |			"paymentDueDate": "2021-06-01",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 100000,
      |			"interestDue": 7,
      |			"totalPaidAmount": 10000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 2,
      |			"paymentDueDate": "2021-06-02",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 90000,
      |			"interestDue": 6,
      |			"totalPaidAmount": 20000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 3,
      |			"paymentDueDate": "2021-06-03",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 80000,
      |			"interestDue": 5,
      |			"totalPaidAmount": 30000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 4,
      |			"paymentDueDate": "2021-06-04",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 70000,
      |			"interestDue": 4,
      |			"totalPaidAmount": 40000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 5,
      |			"paymentDueDate": "2021-06-05",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 60000,
      |			"interestDue": 4,
      |			"totalPaidAmount": 50000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 6,
      |			"paymentDueDate": "2021-06-06",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 50000,
      |			"interestDue": 3,
      |			"totalPaidAmount": 60000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 7,
      |			"paymentDueDate": "2021-06-07",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 40000,
      |			"interestDue": 2,
      |			"totalPaidAmount": 70000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 8,
      |			"paymentDueDate": "2021-06-08",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 30000,
      |			"interestDue": 2,
      |			"totalPaidAmount": 80000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 9,
      |			"paymentDueDate": "2021-06-09",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 20000,
      |			"interestDue": 1,
      |			"totalPaidAmount": 90000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 10,
      |			"paymentDueDate": "2021-06-10",
      |			"amountDue": 10000,
      |			"uniqueDebtId": "debtId",
      |			"balance": 10000,
      |			"interestDue": 0,
      |			"totalPaidAmount": 100000,
      |			"intRate": 2.6
      |		},
      |		{
      |			"serialNo": 11,
      |			"paymentDueDate": "2021-06-11",
      |			"amountDue": 1462,
      |			"uniqueDebtId": "debtId",
      |			"balance": 0,
      |			"interestDue": 0,
      |			"totalPaidAmount": 101462,
      |			"intRate": 2.6
      |		}
      |	]
      |}
      """
  def singlePaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency type single")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody("{\n    \"totalNumberOfInstalments\": 11,\n    \"expectedPayment\": 101462,\n    \"totalPlanInt\": 39,\n    \"interestAccrued\": 1423,\n    \"paymentPlanCalculationResponse\": [\n        {\n            \"serialNo\": 1,\n            \"paymentDueDate\": \"2021-06-01\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 100000,\n            \"interestDue\": 7,\n            \"totalPaidAmount\": 10000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 2,\n            \"paymentDueDate\": \"2021-06-02\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 90000,\n            \"interestDue\": 6,\n            \"totalPaidAmount\": 20000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 3,\n            \"paymentDueDate\": \"2021-06-03\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 80000,\n            \"interestDue\": 5,\n            \"totalPaidAmount\": 30000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 4,\n            \"paymentDueDate\": \"2021-06-04\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 70000,\n            \"interestDue\": 4,\n            \"totalPaidAmount\": 40000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 5,\n            \"paymentDueDate\": \"2021-06-05\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 60000,\n            \"interestDue\": 4,\n            \"totalPaidAmount\": 50000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 6,\n            \"paymentDueDate\": \"2021-06-06\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 50000,\n            \"interestDue\": 3,\n            \"totalPaidAmount\": 60000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 7,\n            \"paymentDueDate\": \"2021-06-07\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 40000,\n            \"interestDue\": 2,\n            \"totalPaidAmount\": 70000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 8,\n            \"paymentDueDate\": \"2021-06-08\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 30000,\n            \"interestDue\": 2,\n            \"totalPaidAmount\": 80000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 9,\n            \"paymentDueDate\": \"2021-06-09\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 20000,\n            \"interestDue\": 1,\n            \"totalPaidAmount\": 90000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 10,\n            \"paymentDueDate\": \"2021-06-10\",\n            \"amountDue\": 10000,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 10000,\n            \"interestDue\": 0,\n            \"totalPaidAmount\": 100000,\n            \"intRate\": 2.6\n        },\n        {\n            \"serialNo\": 11,\n            \"paymentDueDate\": \"2021-06-11\",\n            \"amountDue\": 1462,\n            \"uniqueDebtId\": \"debtId\",\n            \"balance\": 0,\n            \"interestDue\": 0,\n            \"totalPaidAmount\": 101462,\n            \"intRate\": 2.6\n        }\n    ]\n}"))
      .check(status.is(200))

  val weeklyPaymentFrequency=
    """{
      |    "totalNumberOfInstalments": 11,
      |    "expectedPayment": 101462,
      |    "totalPlanInt": 39,
      |    "interestAccrued": 1423,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2021-06-01",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 7,
      |            "totalPaidAmount": 10000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2021-06-02",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 6,
      |            "totalPaidAmount": 20000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2021-06-03",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 5,
      |            "totalPaidAmount": 30000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2021-06-04",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 4,
      |            "totalPaidAmount": 40000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2021-06-05",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 4,
      |            "totalPaidAmount": 50000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2021-06-06",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 3,
      |            "totalPaidAmount": 60000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2021-06-07",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 2,
      |            "totalPaidAmount": 70000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2021-06-08",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 2,
      |            "totalPaidAmount": 80000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2021-06-09",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 1,
      |            "totalPaidAmount": 90000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2021-06-10",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 0,
      |            "totalPaidAmount": 100000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2021-06-11",
      |            "amountDue": 1462,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 101462,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      |""".stripMargin
  def weeklyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency -Weekly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(weeklyPaymentFrequency))
      .check(status.is(200))

  val twoWeeklyPaymentFrequency=
    """
      |{
      |    "totalNumberOfInstalments": 11,
      |    "expectedPayment": 101971,
      |    "totalPlanInt": 548,
      |    "interestAccrued": 1423,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2021-06-01",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 99,
      |            "totalPaidAmount": 10000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2021-06-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 89,
      |            "totalPaidAmount": 20000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2021-06-29",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 79,
      |            "totalPaidAmount": 30000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2021-07-13",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 69,
      |            "totalPaidAmount": 40000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2021-07-27",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 59,
      |            "totalPaidAmount": 50000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2021-08-10",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 49,
      |            "totalPaidAmount": 60000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2021-08-24",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 39,
      |            "totalPaidAmount": 70000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2021-09-07",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 29,
      |            "totalPaidAmount": 80000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2021-09-21",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 19,
      |            "totalPaidAmount": 90000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2021-10-05",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 9,
      |            "totalPaidAmount": 100000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2021-10-19",
      |            "amountDue": 1971,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 101971,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      """.stripMargin
  def twoWeeklyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency - 2-Weekly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(twoWeeklyPaymentFrequency))
      .check(status.is(200))

  val fourweeklyPaymentFrequency=
    """
      |{
      |    "totalNumberOfInstalments": 11,
      |    "totalPlanInt": 455,
      |    "interestAccrued": 1423,
      |    "totalInterest": 1878,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2021-08-13",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 7,
      |            "totalPaidAmount": 10000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2021-08-27",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 89,
      |            "totalPaidAmount": 20000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2021-09-10",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 79,
      |            "totalPaidAmount": 30000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2021-09-24",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 69,
      |            "totalPaidAmount": 40000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2021-10-08",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 59,
      |            "totalPaidAmount": 50000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2021-10-22",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 49,
      |            "totalPaidAmount": 60000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2021-11-05",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 39,
      |            "totalPaidAmount": 70000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2021-11-19",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 29,
      |            "totalPaidAmount": 80000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2021-12-03",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 19,
      |            "totalPaidAmount": 90000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2021-12-17",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 9,
      |            "totalPaidAmount": 100000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2021-12-31",
      |            "amountDue": 1878,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 101878,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      """.stripMargin
  def fourweeklyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency - 4-Weekly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(fourweeklyPaymentFrequency))
      .check(status.is(200))

  val monthlyPaymentFrequency=
    """
      |{
      |    "totalNumberOfInstalments": 12,
      |    "expectedPayment": 111027,
      |    "totalPlanInt": 1485,
      |    "interestAccrued": 9542,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2019-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 275,
      |            "totalPaidAmount": 10000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2020-01-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 231,
      |            "totalPaidAmount": 20000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2020-02-29",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 220,
      |            "totalPaidAmount": 30000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2020-03-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 186,
      |            "totalPaidAmount": 40000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2020-04-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 165,
      |            "totalPaidAmount": 50000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2020-05-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 133,
      |            "totalPaidAmount": 60000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2020-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 110,
      |            "totalPaidAmount": 70000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2020-07-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 82,
      |            "totalPaidAmount": 80000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2020-08-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 53,
      |            "totalPaidAmount": 90000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2020-09-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 27,
      |            "totalPaidAmount": 100000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2020-10-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 110000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 12,
      |            "paymentDueDate": "2020-11-30",
      |            "amountDue": 1027,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 111027,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      """.stripMargin
  def monthlyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency -Monthly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(monthlyPaymentFrequency))
      .check(status.is(200))

  val quarterlyPaymentFrequency=
    """
      |{
      |    "totalNumberOfInstalments": 11,
      |    "expectedPayment": 105884,
      |    "totalPlanInt": 4461,
      |    "interestAccrued": 1423,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2020-01-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 808,
      |            "totalPaidAmount": 10000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2020-04-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 727,
      |            "totalPaidAmount": 20000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2020-07-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 653,
      |            "totalPaidAmount": 30000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2020-10-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 571,
      |            "totalPaidAmount": 40000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2021-01-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 480,
      |            "totalPaidAmount": 50000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2021-04-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 405,
      |            "totalPaidAmount": 60000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2021-07-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 327,
      |            "totalPaidAmount": 70000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2021-10-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 245,
      |            "totalPaidAmount": 80000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2022-01-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 160,
      |            "totalPaidAmount": 90000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2022-04-15",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 81,
      |            "totalPaidAmount": 100000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2022-07-15",
      |            "amountDue": 5884,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 105884,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      """.stripMargin
  def quarterlyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency -Quarterly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(quarterlyPaymentFrequency))
      .check(status.is(200))

  val halfYearlyPaymentFrequency=
    """{
      |    "totalNumberOfInstalments": 12,
      |    "expectedPayment": 112466,
      |    "totalPlanInt": 8928,
      |    "interestAccrued": 3538,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2019-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 1616,
      |            "totalPaidAmount": 10000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2020-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 1470,
      |            "totalPaidAmount": 20000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2020-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 1285,
      |            "totalPaidAmount": 30000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2021-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 1146,
      |            "totalPaidAmount": 40000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2021-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 966,
      |            "totalPaidAmount": 50000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2022-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 819,
      |            "totalPaidAmount": 60000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2022-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 644,
      |            "totalPaidAmount": 70000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2023-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 491,
      |            "totalPaidAmount": 80000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2023-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 323,
      |            "totalPaidAmount": 90000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2024-06-30",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 163,
      |            "totalPaidAmount": 100000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2024-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 110000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 12,
      |            "paymentDueDate": "2025-06-30",
      |            "amountDue": 2466,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 112466,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      """.stripMargin
  def halfYearlyPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency -Weekly")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(halfYearlyPaymentFrequency))
      .check(status.is(200))

  val annualPaymentFrequency=
    """{
      |    "totalNumberOfInstalments": 12,
      |    "expectedPayment": 119284,
      |    "totalPlanInt": 17861,
      |    "interestAccrued": 1423,
      |    "paymentPlanCalculationResponse": [
      |        {
      |            "serialNo": 1,
      |            "paymentDueDate": "2019-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 100000,
      |            "interestDue": 3250,
      |            "totalPaidAmount": 10000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 2,
      |            "paymentDueDate": "2020-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 90000,
      |            "interestDue": 2917,
      |            "totalPaidAmount": 20000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 3,
      |            "paymentDueDate": "2021-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 80000,
      |            "interestDue": 2600,
      |            "totalPaidAmount": 30000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 4,
      |            "paymentDueDate": "2022-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 70000,
      |            "interestDue": 2275,
      |            "totalPaidAmount": 40000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 5,
      |            "paymentDueDate": "2023-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 60000,
      |            "interestDue": 1950,
      |            "totalPaidAmount": 50000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 6,
      |            "paymentDueDate": "2024-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 50000,
      |            "interestDue": 1620,
      |            "totalPaidAmount": 60000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 7,
      |            "paymentDueDate": "2025-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 40000,
      |            "interestDue": 1300,
      |            "totalPaidAmount": 70000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 8,
      |            "paymentDueDate": "2026-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 30000,
      |            "interestDue": 975,
      |            "totalPaidAmount": 80000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 9,
      |            "paymentDueDate": "2027-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 20000,
      |            "interestDue": 650,
      |            "totalPaidAmount": 90000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 10,
      |            "paymentDueDate": "2028-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 10000,
      |            "interestDue": 324,
      |            "totalPaidAmount": 100000,
      |            "intRate": 3.25
      |        },
      |        {
      |            "serialNo": 11,
      |            "paymentDueDate": "2029-12-31",
      |            "amountDue": 10000,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 110000,
      |            "intRate": 2.6
      |        },
      |        {
      |            "serialNo": 12,
      |            "paymentDueDate": "2030-12-31",
      |            "amountDue": 9284,
      |            "uniqueDebtId": "debtId",
      |            "balance": 0,
      |            "interestDue": 0,
      |            "totalPaidAmount": 119284,
      |            "intRate": 2.6
      |        }
      |    ]
      |}
      |""".stripMargin
  def annualPaymentFrequencyPlan(baseUrl: String): HttpRequestBuilder =
    http("payment plan frequency -Annually")
      .post(s"$baseUrl/payment-plan")
      .headers(requestHeaders)
      .body(StringBody(annualPaymentFrequency))
      .check(status.is(200))


}
