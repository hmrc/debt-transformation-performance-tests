package uk.gov.hmrc.perftests.debttransformation.requests.ttp

import io.gatling.core.Predef.{StringBody, configuration, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object TimeToPayProxyRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:time-to-pay-proxy"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  val generateQuoteAnnually =
    s"""
       |{
       |    "customerReference": "uniqRef1234",
       |    "channelIdentifier": "selfService",
       |    "plan": {
       |        "quoteType": "instalmentAmount",
       |        "quoteDate": "2021-05-13",
       |        "instalmentStartDate": "2021-05-13",
       |        "instalmentAmount": 100,
       |        "frequency": "annually",
       |        "duration": 12,
       |        "initialPaymentAmount": 100,
       |        "initialPaymentDate": "2021-05-13",
       |        "paymentPlanType": "timeToPay"
       |    },
       |    "customerPostCodes": [{
       |        "addressPostcode": "NW9 5XW",
       |        "postcodeDate": "2021-05-13"
       |    }],
       |    "debtItems": [{
       |        "debtItemId": "debtItemId1",
       |        "debtItemChargeId": "debtItemChargeId1",
       |        "mainTrans": "1546",
       |        "subTrans": "1090",
       |        "originalDebtAmount": 100,
       |        "interestStartDate": "2021-05-13",
       |        "paymentHistory": [{
       |            "paymentAmount": 100,
       |            "paymentDate": "2021-05-13"
       |        }]
       |    }]
       |}
       """.stripMargin

  def ttpGenerateAnnualFrequencyQuote(baseUri: String): HttpRequestBuilder =
    http("POST to generate ttp proxy quote annually")
      .post(s"$baseUri/quote")
      .headers(requestHeaders)
      .body(StringBody(generateQuoteAnnually))
      .check(status.is(200))

}
