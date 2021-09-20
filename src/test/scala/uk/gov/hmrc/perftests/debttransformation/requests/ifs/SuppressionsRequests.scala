package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import play.api.libs.json.Json
import play.api.libs.ws.StandaloneWSResponse
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls.interestForecostingApiUrl
import uk.gov.hmrc.perftests.debttransformation.utils.WsClient

object SuppressionsRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
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
       |         "code":"1",
       |         "reason":"Reason-1",
       |         "description": "covid",
       |         "enabled":true,
       |         "fromDate":"2021-03-01",
       |         "toDate":"2022-01-01"
       |      }
       |   ]
       |}

       """.stripMargin


  val openEndedSuppressionData =
    s"""
       |{
       |   "suppression":[
       |      {
       |         "code":"2",
       |         "reason":"Reason-2",
       |         "description": "open ended",
       |         "enabled":false,
       |         "fromDate":"2020-04-02",
       |         "toDate":"9999-12-31"
       |      }
       |   ]
       |}

       """.stripMargin

  val addSuppressionRules =
    s"""
       |{
       |    "suppressionRules":
       |    [
       |        {
       |            "ruleId": "1",
       |            "rule": "IF postCode LIKE 'TW3' -> suppression = 1",
       |            "enabled": true
       |        },
       |        {
       |            "ruleId": "2",
       |            "rule": "IF postCode LIKE 'SE18' -> suppression = 2",
       |            "enabled": true
       |        },
       |         {
       |            "ruleId": "3",
       |            "rule": "IF mainTrans LIKE '1530' -> suppression = 1",
       |            "enabled": true
       |        }
       |    ]
       |}
       """.stripMargin


  def postSuppressionData() = {
    val baseUri = s"$interestForecostingApiUrl/test-only/suppressions/1"
    val headers = Map(
      "Authorization" -> s"Bearer $bearerToken",
      "Content-Type"  -> "application/json",
      "Accept"        -> "application/vnd.hmrc.1.0+json"
    )
    WsClient.post(baseUri, headers = headers, Json.parse(suppressionData))
  }

  def postOpenEndedSuppressionData() = {
    val baseUri = s"$interestForecostingApiUrl/test-only/suppressions/2"
    val headers = Map(
      "Authorization" -> s"Bearer $bearerToken",
      "Content-Type"  -> "application/json",
      "Accept"        -> "application/vnd.hmrc.1.0+json"
    )
    WsClient.post(baseUri, headers = headers, Json.parse(openEndedSuppressionData))
  }

  def deleteSuppressionData(): StandaloneWSResponse = {
    val baseUri = s"$interestForecostingApiUrl/test-only/suppressions"
    val headers = Map(
      "Authorization" -> s"Bearer $bearerToken",
      "Content-Type"  -> "application/json",
      "Accept"        -> "application/vnd.hmrc.1.0+json"
    )
    WsClient.delete(baseUri, headers = headers)
  }

  def postSuppressionRules(): StandaloneWSResponse = {
    val baseUri = s"$interestForecostingApiUrl/test-only/suppression-rules"
    val headers = Map(
      "Authorization" -> s"Bearer $bearerToken",
      "Content-Type"  -> "application/json",
      "Accept"        -> "application/vnd.hmrc.1.0+json"
    )
    WsClient.post(baseUri, headers = headers, Json.parse(addSuppressionRules))
  }

  def deleteSuppressionRules(): StandaloneWSResponse = {
    val baseUri = s"$interestForecostingApiUrl/test-only/suppression-rules"
    val headers = Map(
      "Authorization" -> s"Bearer $bearerToken",
      "Content-Type"  -> "application/json",
      "Accept"        -> "application/vnd.hmrc.1.0+json"
    )
    WsClient.delete(baseUri, headers = headers)
  }

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

  val ifsTwoDutiesTwoPaymentsOnSameDay                                              =
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
       |		"postCode": "SE18 6PH",
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
       |		"postCode": "SE18 4TQ",
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

  val mainTransSuppressionRules =
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
    |	],
    |
    |	"breathingSpaces": [
    |
    |	],
    |
    |	"customerPostCodes": [{
    |		"postCode": "TW3 4UQ",
    |		"postCodeDate": "2019-07-06"
    |	}]
    |
    |}
      """.stripMargin

  def mainTransAppliedToSuppressionRules(baseUrl: String): HttpRequestBuilder =
    http("Suppression applied to main trans")
      .post(s"$baseUrl/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(mainTransSuppressionRules))
      .check(status.is(200))

  val twoPaymentsSuppression =
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

  def twoPaymentsDuringSuppression(baseUrl: String): HttpRequestBuilder =
    http("Suppression applied to postcode. Two payments during suppression")
      .post(s"$baseUrl/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(twoPaymentsSuppression))
      .check(status.is(200))

}
