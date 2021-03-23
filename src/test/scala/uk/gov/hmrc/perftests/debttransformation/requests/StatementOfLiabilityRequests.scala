package uk.gov.hmrc.perftests.debttransformation.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object StatementOfLiabilityRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:statement-of-liability"))
  print("created bearerToken ::::::::   " + bearerToken)
  val requestHeaders = Map("Authorization" -> s"Bearer $bearerToken", "Accept" -> "application/vnd.hmrc.1.0+json")
  print("Headers ::::::::   " + requestHeaders)

  def statementOfLiabilityHelloWorld(baseUri: String): HttpRequestBuilder =
    http("GET Statement of Liability")
      .get(s"$baseUri/statement-of-liability/hello-world")
      .headers(requestHeaders)
      .check(status.is(200))
}
