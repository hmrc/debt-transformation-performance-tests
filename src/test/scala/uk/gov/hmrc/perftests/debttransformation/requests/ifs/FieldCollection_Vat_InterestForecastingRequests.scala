/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

  val multipleDebtsWithMultipleBreathingSpaces:String =
    """
      |{
      |	"debtItems": [
      |
      |		{
      |			"debtItemChargeId": "123",
      |			"originalAmount": 500000,
      |			"interestIndicator": "Y",
      |			"interestRequestedTo": "2022-02-07",
      |			"periodEnd": "2022-04-01",
      |			"paymentHistory": [{
      |				"paymentAmount": 100000,
      |				"paymentDate": "2021-06-01"
      |			}],
      |			"breathingSpaces": [{
      |				"debtRespiteFrom": "2022-01-30",
      |				"debtRespiteTo": "2022-02-28"
      |			}, {
      |				"debtRespiteFrom": "2021-08-16",
      |				"debtRespiteTo": "2021-08-18"
      |			}]
      |		},
      |		{
      |			"debtItemChargeId": "debtItemChargeId1",
      |			"originalAmount": 500000,
      |			"interestIndicator": "Y",
      |			"interestRequestedTo": "2021-03-14",
      |			"periodEnd": "2022-04-01",
      |			"paymentHistory": [{
      |				"paymentAmount": 50000,
      |				"paymentDate": "2021-10-01"
      |			}],
      |
      |			"breathingSpaces": [{
      |				"debtRespiteFrom": "2021-01-04",
      |				"debtRespiteTo": "2021-02-14"
      |			}]
      |
      |		}
      |	]
      |}

      |""".stripMargin

 def fcVatFoMultipleDebtsWithMultipleBreathingSpaces(baseUri: String): HttpRequestBuilder =
  http("Multiple debts with multiple breathing spaces")
    .post(s"$baseUri/fc-vat-debt-calculation")
    .headers(requestHeaders)
    .body(StringBody(multipleDebtsWithMultipleBreathingSpaces))
    .check(status.is(200))

  val singDebtWithBreathingSpace: String=
    """
      |{
      |	"debtItems": [
      |
      |		{
      |			"debtItemChargeId": "123",
      |			"originalAmount": 500000,
      |			"interestIndicator": "Y",
      |			"interestRequestedTo": "2021-11-15",
      |			"periodEnd": "2022-04-01",
      |			"paymentHistory": [{
      |				"paymentAmount": 100000,
      |				"paymentDate": "2021-06-01"
      |			}],
      |
      |			"breathingSpaces": [{
      |				"debtRespiteFrom": "2021-11-01",
      |				"debtRespiteTo": "2021-12-01"
      |			}]
      |
      |		}
      |	]
      |}
      |""".stripMargin


   def fcVatForSingleDebtWithBreathingSpace(baseUri: String): HttpRequestBuilder =
     http("Single debt with breathing space and payment history")
       .post(s"$baseUri/fc-vat-debt-calculation")
       .headers(requestHeaders)
       .body(StringBody(singDebtWithBreathingSpace))
       .check(status.is(200))
}