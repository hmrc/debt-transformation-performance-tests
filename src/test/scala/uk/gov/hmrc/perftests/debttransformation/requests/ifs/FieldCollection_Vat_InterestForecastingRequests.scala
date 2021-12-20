package uk.gov.hmrc.perftests.debttransformation.requests.ifs

import java.time.LocalDate

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object FieldCollection_Vat_InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate = LocalDate.now().toString
  var instalmentDate = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept" -> "application/vnd.hmrc.1.0+json",
    "Content-Type" -> "application/json"
  )


  val SingleVatDebtItemWithPaymentHistory: String =
    s"""|{
        |  "debtItems": [
        |       {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 5000,
        |          "interestIndicator": "Y",
        |          "interestRequestedTo": "2021-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          		         {
        |      		  "paymentAmount": 200,
        |      		  "paymentDate" :"2021-06-01"
        |      	}
        |
        |          ]
        |     }
        |
        |  ]
        |}
        |""".stripMargin

  def singleDebtItem(baseUri: String): HttpRequestBuilder =
    http("Single Vat Debt Item with single payment")
      .post(s"$baseUri/fc-vat-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(SingleVatDebtItemWithPaymentHistory))
      .check(status.is(200))

  val MultipleVatDebtItemWithPaymentHistory: String =
    s"""|{
        |  "debtItems": [
        |       {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 5000,
        |          "interestIndicator": "Y",
        |          "interestRequestedTo": "2021-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          		         {
        |      		  "paymentAmount": 200,
        |      		  "paymentDate" :"2021-06-01"
        |      	}
        |
        |          ]
        |     },
        |     {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 4000,
        |          "interestIndicator": "Y",
        |          "interestRequestedTo": "2022-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          		         {
        |      		  "paymentAmount": 400,
        |      		  "paymentDate" :"2021-06-01"
        |      	}
        |
        |          ]
        |     }
        |
        |
        |  ]
        |}
        |""".stripMargin

  def multipleDebtItems(baseUri: String): HttpRequestBuilder =
    http("Multiple Vat Debt Item with Payment History")
      .post(s"$baseUri/fc-vat-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleVatDebtItemWithPaymentHistory))
      .check(status.is(200))

  val MultipleVatDebtItemWithSinglePaymentHistory: String =
    s"""|{
        |  "debtItems": [
        |       {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 5000,
        |          "interestIndicator": "Y",
        |          "interestRequestedTo": "2021-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          		         {
        |      		  "paymentAmount": 200,
        |      		  "paymentDate" :"2021-06-01"
        |      	}
        |
        |          ]
        |     },
        |     {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 4000,
        |          "interestIndicator": "Y",
        |          "interestRequestedTo": "2022-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          ]
        |     }
        |
        |
        |  ]
        |}
        |""".stripMargin

  def multipleDebtItemsWithSinglePaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple VAT Debt Item with Single Payment History")
      .post(s"$baseUri/fc-vat-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleVatDebtItemWithSinglePaymentHistory))
      .check(status.is(200))


  val SingleVatDebtItemWithNoInterestIndicator: String =
    s"""|{
        |  "debtItems": [
        |       {
        |          "debtItemChargeId": "123",
        |          "originalAmount": 5000,
        |          "interestIndicator": "N",
        |          "interestRequestedTo": "2021-11-24",
        |          "periodEnd": "2022-04-01",
        |          "paymentHistory": [
        |          		         {
        |      		  "paymentAmount": 200,
        |      		  "paymentDate" :"2021-06-01"
        |      	}
        |
        |          ]
        |     }
        |
        |  ]
        |}
        |""".stripMargin

  def singleVatDebtItemWithNoInterestIndicator(baseUri: String): HttpRequestBuilder =
    http("Single Vat Debt Item with Payment History and No interest indicator")
      .post(s"$baseUri/fc-vat-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(SingleVatDebtItemWithNoInterestIndicator))
      .check(status.is(200))


}