package uk.gov.hmrc.perftests.debttransformation.requests.sol

import io.gatling.core.Predef.StringBody
import io.gatling.http.Predef.{http, status}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object StatementOfLiabilityRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:statement-of-liability"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  val solAPIRequestWithSingleDebt =
    s"""
       |{
       |  "solType" : "CO",
       |  "customerUniqueRef": "customer-1",
       |  "solRequestedDate": "2021-05-18",
       |  "debts" : [ {
       |    "debtId" : "debt001",
       |    "dutyIds" : [ "duty01", "duty02" ],
       |    "interestRequestedTo": "2021-08-10"
       |  }]
       |}
       |""".stripMargin

  def solAPIRequestWithSingleDebtRequest(baseUri: String): HttpRequestBuilder =
    http("POST Single Debt SOL Statement of Liability")
      .post(s"$baseUri/sol")
      .headers(requestHeaders)
      .body(StringBody(solAPIRequestWithSingleDebt))
      .check(status.is(200))

  val solAPIRequestWithMultipleDebts =
    s"""
       |{
       |  "solType": "UI",
       |  "solRequestedDate": "2021-05-17",
       |  "customerUniqueRef": "customer-1",
       |  "debts": [
       |    {
       |      "debtId": "debt001",
       |      "dutyIds": [
       |        "duty01",
       |        "duty02"
       |      ],
       |      "interestRequestedTo": "2021-08-10"
       |    },
       |    {
       |      "debtId": "debt004",
       |      "dutyIds": [
       |        "duty04"
       |      ],
       |      "interestRequestedTo": "2021-08-10"
       |    }
       |  ]
       |}
       |""".stripMargin

  def statementOfLiabilityRequestFormultipleDebts(baseUri: String): HttpRequestBuilder =
    http("POST Multiple Debts SOL Statement of Liability")
      .post(s"$baseUri/sol")
      .headers(requestHeaders)
      .body(StringBody(solAPIRequestWithMultipleDebts))
      .check(status.is(200))

}
