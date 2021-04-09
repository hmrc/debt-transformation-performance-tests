/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.debttransformation.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object InterestForecastingRequests extends ServicesConfiguration {

  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  def createDebtCalculationRule(baseUri: String): HttpRequestBuilder =
    http("create debt calculator rules")
      .post(s"$baseUri/interest-forecasting/settings")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\"settings\": \"IF regime == 'DRIER' AND chargeType == 'NI' -> intRate = 1% OTHERWISE -> intRate = 0%\"}"
        )
      )
      .check(status.is(200))

  def InterestBearingdrierdebtForChargeTypeNino(baseUri: String): HttpRequestBuilder =
    http("Interest bearing drier debt -MVP")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\"amount\": 500000, \"chargeType\": \"NI\", \"regime\": \"DRIER\", \"dateAmount\": \"2021-01-01\", \"dateCalculationTo\": \"2021-05-01\"}"
        )
      )
      .check(status.is(200))

  def nonInterestBearingDrierdebtForChargeTypeHIPG(baseUri: String): HttpRequestBuilder =
    http("Non Interest bearing drier debt -MVP")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\"amount\": 500000, \"chargeType\": \"HIPG\", \"regime\": \"DRIER\", \"dateAmount\": \"2021-01-01\", \"dateCalculationTo\": \"2021-05-01\"}"
        )
      )
      .check(status.is(200))

  def InterestBearingDebtCalculationForASinglePayment(baseUri: String): HttpRequestBuilder =
    http("Interest bearing drier single payment")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "\n    {\"debtItems\": [\n    {\n      \"uniqueItemReference\": \"123\",\n      \"amount\": 500000,\n      \"chargeType\": \"NI\",\n      \"regime\": \"DRIER\",\n      \"dateAmount\": \"2020-12-16\",\n      \"dateCalculationTo\": \"2021-04-14\",\n      \"paymentHistory\": [\n      \t\t         {\n      \t\t  \"amountPaid\": 100000,\n      \t\t  \"dateOfPayment\": \"2021-02-03\"\n      \t}\n      ]\n    }\n  ]\n}"
        )
      )
      .check(status.is(200))

  def InterestBearingDebtCalculationForMultiplePayment(baseUri: String): HttpRequestBuilder =
    http("Interest bearing drier multiple payments")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\"debtItems\": [\n    {\n      \"uniqueItemReference\": \"123\",\n      \"amount\": 500000,\n      \"chargeType\": \"NI\",\n      \"regime\": \"DRIER\",\n      \"dateAmount\": \"2020-12-16\",\n      \"dateCalculationTo\": \"2021-04-14\",\n      \"paymentHistory\": [\n      \t\t         {\n      \t\t  \"amountPaid\": 100000,\n      \t\t  \"dateOfPayment\": \"2021-02-03\"\n      \t},\n        {\n      \t\t  \"amountPaid\": 50000,\n      \t\t  \"dateOfPayment\": \"2021-02-05\"\n      \t}\n      ]\n    }\n  ]\n}"
        )
      )
      .check(status.is(200))

  def nonInterestBearingDebtCalculationForASinglePayment(baseUri: String): HttpRequestBuilder =
    http("non interest bearing drier single payment")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\"debtItems\": [\n    {\n      \"uniqueItemReference\": \"123\",\n      \"amount\": 500000,\n      \"chargeType\": \"HIPG\",\n      \"regime\": \"DRIER\",\n      \"dateAmount\": \"2020-12-16\",\n      \"dateCalculationTo\": \"2021-04-14\",\n      \"paymentHistory\": [\n      \t\t         {\n      \t\t  \"amountPaid\": 100000,\n      \t\t  \"dateOfPayment\": \"2021-02-03\"\n      \t}\n      ]\n    }\n  ]\n}"
        )
      )
      .check(status.is(200))

  def nonInterestBearingDebtCalculationForMultiplePayment(baseUri: String): HttpRequestBuilder =
    http("non interest bearing drier multiple payments")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "\n    {\"debtItems\": [\n    {\n      \"uniqueItemReference\": \"123\",\n      \"amount\": 500000,\n      \"chargeType\": \"HIPG\",\n      \"regime\": \"DRIER\",\n      \"dateAmount\": \"2020-12-16\",\n      \"dateCalculationTo\": \"2021-04-14\",\n      \"paymentHistory\": [\n      \t\t         {\n      \t\t  \"amountPaid\": 100000,\n      \t\t  \"dateOfPayment\": \"2021-02-03\"\n      \t},\n        {\n      \t\t  \"amountPaid\": 50000,\n      \t\t  \"dateOfPayment\": \"2021-02-05\"\n      \t}\n      ]\n    }\n  ]\n}"
        )
      )
      .check(status.is(200))

}
