package uk.gov.hmrc.perftests.debttransformation.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object InterestForecastingRequests extends ServicesConfiguration {

  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  print("created bearerToken ::::::::   " + bearerToken)
  val requestHeaders = Map("Authorization" -> s"Bearer $bearerToken", "Accept" -> "application/vnd.hmrc.1.0+json")

  def InterestForecastingRequestsHelloWorld(baseUri: String): HttpRequestBuilder =
    http("GET Interest Forecasting")
      .get(s"$baseUri/interest-forecasting/hello-world")
      .headers(requestHeaders)
      .check(status.is(200))
}
