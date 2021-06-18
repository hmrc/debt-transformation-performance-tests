package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object SuppressionsRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:statement-of-liability"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  val suppressionData =
    s"""
       |{
       |   "suppression":[
       |      {
       |         "code":"code-3",
       |         "reason":"Reason-1",
       |         "enabled":true,
       |         "fromDate":"2021-01-01",
       |         "toDate":"2022-01-01"
       |      },
       |      {
       |         "code":"code-4",
       |         "reason":"Reason-2",
       |         "enabled":false,
       |         "fromDate":"2021-01-01",
       |         "toDate":"2022-01-01"
       |      }
       |   ]
       |}

       """.stripMargin

  def addSuppressionData(baseUri: String): HttpRequestBuilder =
    http("add suppression data")
      .post(s"$baseUri/suppressions/8/suppression")
      .headers(requestHeaders)
      .body(StringBody(suppressionData))
      .check(status.is(200))

  def getSuppressionData(baseUri: String): HttpRequestBuilder =
    http("retrieve suppression data")
      .get(s"$baseUri/suppressions")
      .headers(requestHeaders)
      .check(status.is(200))

  def deleteSuppressionData(baseUri: String): HttpRequestBuilder =
    http("delete suppression data")
      .delete(s"$baseUri/suppressions")
      .headers(requestHeaders)
      .body(StringBody(addSuppressionRules))
      .check(status.is(200))

  val addSuppressionRules =
    s"""
       |{
       |    "suppressionRules":
       |    [
       |        {
       |            "ruleId": "1",
       |            "rule": "IF postCode LIKE 'TW3 4QQ' -> suppression = 1"
       |        },
       |        {
       |            "ruleId": "2",
       |            "rule": "IF postCode LIKE 'SE18 6PH' -> suppression = 2, 3, 4"
       |        }
       |         {
       |            "ruleId": "3",
       |            "rule": "IF mainTrans LIKE '1530' -> suppression = 1"
       |        }
       |    ]
       |}
       """.stripMargin

  def addSuppressionRules(baseUri: String): HttpRequestBuilder =
    http("add suppression rules")
      .post(s"$baseUri/suppression-rules/2/suppression-rule")
      .headers(requestHeaders)
      .body(StringBody(addSuppressionRules))
      .check(status.is(200))

  def retrieveSuppressionRules(baseUri: String): HttpRequestBuilder =
    http("retrieve suppression data")
      .get(s"$baseUri/suppression-rules")
      .headers(requestHeaders)
      .check(status.is(200))

  def deleteSuppressionRules(baseUri: String): HttpRequestBuilder =
    http("retrieve suppression data")
      .delete(s"$baseUri/suppression-rules")
      .headers(requestHeaders)
      .check(status.is(200))

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

  val ifsOverlappingSuppression =
    s"""{
       |	"debtItems": [{
       |		"debtID": "123",
       |		"originalAmount": 500000,
       |		"subTrans": "1000",
       |		"mainTrans": "1535",
       |		"dateCreated": "2021-01-01",
       |		"interestStartDate": "2021-02-01",
       |		"interestRequestedTo": "2021-07-06",
       |		"paymentHistory": []
       |	}],
       |
       |	"breathingSpaces": [],
       |
       |	"customerPostCodes": [{
       |		"postCode": "TW3 4QQ",
       |		"postCodeDate": "2019-07-06"
       |	}]
       |
       |}""".stripMargin

  def twoOverlappingSuppression(baseUri: String): HttpRequestBuilder =
    http("1 duty, 2 overlapping suppressions")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsOverlappingSuppression))
      .check(status.is(200))

  val ifsTwoDutiesTwoPaymentsOnSameDay  =
    s""" {
       |	"debtItems": [{
       |			"debtID": "123",
       |			"originalAmount": 400000,
       |			"subTrans": "1000",
       |			"mainTrans": "1535",
       |			"dateCreated": "2020-01-01",
       |			"interestStartDate": "2021-02-01",
       |			"interestRequestedTo": "2021-07-06",
       |			"paymentHistory": [{
       |				"paymentAmount": 100000,
       |				"paymentDate": "2021-02-20"
       |			}, {
       |				"paymentAmount": 50000,
       |				"paymentDate": "2021-02-20"
       |			}]
       |		}
       |
       |		, {
       |			"debtID": "123",
       |			"originalAmount": 400000,
       |			"subTrans": "1000",
       |			"mainTrans": "1535",
       |			"dateCreated": "2020-01-01",
       |			"interestStartDate": "2021-02-01",
       |			"interestRequestedTo": "2021-07-06",
       |			"paymentHistory": []
       |		}
       |	],
       |
       |	"breathingSpaces": [],
       |
       |	"customerPostCodes": [{
       |		"postCode": "TW3 4QQ",
       |		"postCodeDate": "2019-07-06"
       |	}]
       |}
     """.stripMargin
  def TwoDutiesTwoPaymentsOnSameDaySuppression(baseUri: String): HttpRequestBuilder =
    http("Suppression, 2 duties, 2 payments on same day for one of the duties")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsTwoDutiesTwoPaymentsOnSameDay))
      .check(status.is(200))

  val ifsOpenEndedSuppression                                   =
    s""" {
       |	"debtItems": [{
       |		"debtID": "123",
       |		"originalAmount": 500000,
       |		"subTrans": "1000",
       |		"mainTrans": "1535",
       |		"dateCreated": "2020-01-01",
       |		"interestStartDate": "2020-04-01",
       |		"interestRequestedTo": "2020-07-06",
       |		"paymentHistory": []
       |	}],
       |	"breathingSpaces": [],
       |	"customerPostCodes": [{
       |		"postCode": "TW3 4QQ",
       |		"postCodeDate": "2019-07-06"
       |	}]
       |}
     """.stripMargin
  def openEndedSuppression(baseUri: String): HttpRequestBuilder =
    http("open ended suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsOpenEndedSuppression))
      .check(status.is(200))

  val ifsInterestRateChangeADuringSuppression =
    s""" {
       |	"debtItems": [{
       |		"debtID": "123",
       |		"originalAmount": 500000,
       |		"subTrans": "1000",
       |		"mainTrans": "1535",
       |		"dateCreated": "2020-01-01",
       |		"interestStartDate": "2020-04-01",
       |		"interestRequestedTo": "2020-07-06",
       |		"paymentHistory": []
       |	}],
       |	"breathingSpaces": [],
       |	"customerPostCodes": [{
       |		"postCode": "TW3 4QQ",
       |		"postCodeDate": "2019-07-06"
       |	}]
       |}
     """.stripMargin

  def interestRateChangeADuringSuppression(baseUri: String): HttpRequestBuilder =
    http("Interest rate changes during suppression")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(ifsInterestRateChangeADuringSuppression))
      .check(status.is(200))

  val mainTransSuppressionRules=
  s"""
    |{
    |	"debtItems": [{
    |			"debtID": "123",
    |			"originalAmount": 500000,
    |			"subTrans": "1000",
    |			"mainTrans": "1530",
    |			"dateCreated": "2020-01-01",
    |			"interestStartDate": "2021-02-01",
    |			"interestRequestedTo": "2021-07-06",
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
    |	"customerPostCodes": [{
    |		"postCode": "TW3 4QQ",
    |		"postCodeDate": "2019-07-06"
    |	}]
    |
    |}
      """.stripMargin

  def mainTransAppliedToSuppressionRules(baseUrl:String): HttpRequestBuilder =
    http("Suppression applied to sub trans")
      .post(s"$baseUrl/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(mainTransSuppressionRules))
      .check(status.is(200))

  val twoPaymentsSuppression=
    s"""
       |{
       |  "debtItems": [
       |         {
       |          "debtID": "123",
       |          "originalAmount": 500000,
       |          "subTrans": "1000",
       |          "mainTrans": "1535",
       |          "dateCreated": "2020-01-01",
       |          "interestStartDate": "2021-02-01",
       |          "interestRequestedTo": "2021-07-06",
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 100000,
       |      		  "paymentDate" :"2021-04-20"
       |      	}
       |,        {
       |      		  "paymentAmount": 50000,
       |      		  "paymentDate" :"2021-04-20"
       |      	}
       |
       |          ]
       |     }
       |
       |  ],
       |
       |  "breathingSpaces": [
       |
       |  ],
       |
       |  "customerPostCodes": [
       |          {
       |              "postCode":"TW3 4QQ",
       |              "postCodeDate": "2019-07-06"
       |        }
       |  ]
       |
       |}

       """.stripMargin

  def TwoPaymentsDuringSuppression(baseUrl:String): HttpRequestBuilder =
    http("Suppression applied to sub trans")
      .post(s"$baseUrl/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(twoPaymentsSuppression))
      .check(status.is(200))

}
