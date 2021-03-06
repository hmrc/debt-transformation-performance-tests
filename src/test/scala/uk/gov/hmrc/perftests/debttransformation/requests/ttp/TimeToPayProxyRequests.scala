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

  val createPlanRequestBody = """{
                                |  "customerReference": "customerRef1234",
                                |  "quoteReference":"quoteReference",
                                |  "channelIdentifier": "advisor",
                                |  "plan": {
                                |    "quoteId": "quoteId1234",
                                |    "quoteType": "instalmentAmount",
                                |    "quoteDate": "2021-09-08",
                                |    "instalmentStartDate": "2021-05-13",
                                |    "instalmentAmount": 100,
                                |    "paymentPlanType": "timeToPay",
                                |    "thirdPartyBank": true,
                                |    "numberOfInstalments": 1,
                                |    "frequency": "annually",
                                |    "duration": 12,
                                |    "initialPaymentDate": "2021-05-13",
                                |    "initialPaymentAmount": 100,
                                |    "totalDebtincInt": 100,
                                |    "totalInterest": 10,
                                |    "interestAccrued": 10,
                                |    "planInterest": 10
                                |  },
                                |  "debtItems": [
                                |    {
                                |      "debtItemId": "debtItemId1",
                                |      "debtItemChargeId": "debtItemChargeId1",
                                |      "mainTrans": "1525",
                                |      "subTrans": "1000",
                                |      "originalDebtAmount": 100,
                                |      "interestStartDate": "2021-05-13",
                                |      "paymentHistory": [
                                |        {
                                |          "paymentDate": "2021-05-13",
                                |          "paymentAmount": 100
                                |        }
                                |      ]
                                |    }
                                |  ],
                                |  "payments": [
                                |    {
                                |      "paymentMethod": "BACS",
                                |      "paymentReference": "ref123"
                                |    }
                                |  ],
                                |  "customerPostCodes": [
                                |    {
                                |      "addressPostcode": "NW9 5XW",
                                |      "postcodeDate": "2021-05-13"
                                |    }
                                |  ],
                                |  "instalments": [
                                |  {
                                |    "debtItemChargeId": "debtItemChargeId1",
                                |    "debtItemId": "debtItemId1",
                                |    "dueDate": "2021-05-13",
                                |    "amountDue": 100,
                                |    "expectedPayment": 100,
                                |    "interestRate": 0.25,
                                |    "instalmentNumber": 1,
                                |    "instalmentInterestAccrued": 10,
                                |    "instalmentBalance": 90
                                |  }
                                |  ]
                                |}""".stripMargin



  val updatePlanRequestBody =
    s"""
       |{
       |	"customerReference": "customerRef1234",
       |	"planId": "planId1234",
       |	"updateType": "updateType",
       |	"planStatus": "updated",
       |	"completeReason": "earlyRepayment",
       |	"cancellationReason": "",
       |	"thirdPartyBank": true,
       |	"paymentMethod": "BACS",
       |    "paymentReference": "paymentRef123"
       |
       |}
       """.stripMargin

  def createPlan(baseUri: String): HttpRequestBuilder =
    http("POST to create payment plan")
      .post(s"$baseUri/quote/arrangement")
      .headers(requestHeaders)
      .body(StringBody(createPlanRequestBody))
      .check(status.is(200))

  def updatePlan(baseUri: String): HttpRequestBuilder =
    http("PUT to update quote plan")
      .put(s"$baseUri/quote/custReference1234/planId1234")
      .headers(requestHeaders)
      .body(StringBody(updatePlanRequestBody))
      .check(status.is(200))

  def viewQuotePlan(baseUri: String): HttpRequestBuilder =
    http("GET view quote plan")
      .get(s"$baseUri/quote/custReference1234/planId1234")
      .headers(requestHeaders)
      .check(status.is(200))

}
