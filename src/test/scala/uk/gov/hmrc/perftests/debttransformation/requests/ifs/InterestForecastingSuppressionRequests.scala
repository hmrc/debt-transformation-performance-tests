package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef.StringBody
import io.gatling.http.Predef.{http, status}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object InterestForecastingSuppressionRequests extends ServicesConfiguration {

  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json")

  val ifsInterestRateChangeBeforeSuppression =
    s"""
       |{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\":" +
       |            " \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
       |            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
       |            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
       |            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
       |            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
       |            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
       |            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
       |            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
       |            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
       |            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000," +
       |            "\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
       |            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
       |            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
       |            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
       |            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
       |            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
       |            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
       |            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
       |            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
       |            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
       |            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
       |            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
       |            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
       |            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
       |            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
       |            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": []}], \"breathingSpaces\": [\n\n\t]\n\n}"
       |
       """.stripMargin

  def interestRateChangeBeforeSuppression(baseUri: String): HttpRequestBuilder =
    http("interest rate change before suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsInterestRateChangeBeforeSuppression))
      .check(status.is(200))

  val ifsinterestRateChangeAfterSuppression =
  s"""{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": " +
    |"\"1525\",\n\t\t\"dateCreated\": \"2018-06-01\",\n\t\t\"interestStartDate\": \"2018-06-01\",\n\t\t\"interestRequestedTo\": " +
    |"\"2021-03-31\",\n\t\t\"paymentHistory\": [{\n\t\t\t\"paymentAmount\": 100000,\n\t\t\t\"paymentDate\": \"2019-03-15\"\n\t\t}, {\n\t\t\t\"paymentAmount\": " +
    |"100000,\n\t\t\t\"paymentDate\": \"2020-04-15\"\n\t\t}]\n\t}, {\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": " +
    |"\"1090\",\n\t\t\"mainTrans\": \"1545\",\n\t\t\"dateCreated\": \"2009-01-01\",\n\t\t\"interestStartDate\": \"2009-01-01\",\n\t\t\"interestRequestedTo\": " +
    |"\"2010-01-01\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}""".stripMargin

  def interestRateChangeAfterSuppression(baseUri: String): HttpRequestBuilder =
    http("interest rate change after suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsinterestRateChangeAfterSuppression))
      .check(status.is(200))

  val ifsInterestRateChangeADuringSuppression =
    s""" {\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\":
       | \"1090\",\n\t\t\"mainTrans\": \"1520\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\":
       | \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"
       |
     """.stripMargin

  def interestRateChangeADuringSuppression(baseUri: String): HttpRequestBuilder =
    http("Interest rate changes during suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsInterestRateChangeADuringSuppression))
      .check(status.is(200))

  val ifsPaymentBeforeSuppression =
    s""" {\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\":
       | \"1090\",\n\t\t\"mainTrans\": \"1520\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\":
       | \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"
       |
     """.stripMargin
  def paymentBeforeSuppression(baseUri: String): HttpRequestBuilder =
    http("payment before suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsPaymentBeforeSuppression))
      .check(status.is(200))

  val ifsPaymentAfterSuppression =
    s""" {\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\":
       | \"1090\",\n\t\t\"mainTrans\": \"1520\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\":
       | \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"
       |
     """.stripMargin
  def paymentBeforeSuppression(baseUri: String): HttpRequestBuilder =
    http("payment before suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsPaymentAfterSuppression))
      .check(status.is(200))


  val ifsOpenEndedSuppression =
    s""" {\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": " +
       |            "\"1530\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"interestRequestedTo\": " +
       |            "\"2021-03-20\",\n\t\t\"paymentHistory\": []\n\t}],\n\n\t\"breathingSpaces\": [{\n\t\t\"debtRespiteFrom\": \"2021-03-07\",\n\t\t\"debtRespiteTo\":" +
       |            " \"2021-03-10\"\n\t}]\n}
     """.stripMargin
  def openEndedSuppression(baseUri: String): HttpRequestBuilder =
    http("open ended suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsOpenEndedSuppression))test
      .check(status.is(200))


}
