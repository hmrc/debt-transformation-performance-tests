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


  def InterestBearingDebtCalculationForMultiplePayment(baseUri: String): HttpRequestBuilder =
    http("Interest start date before debt created multiple payment for a debt")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n  \"debtItems\": [\n{\n\"uniqueItemReference\": \"123\",\n\"originalAmount\": 500000,\n\"subTrans\": \"1000\",\n\"mainTrans\": \"1525\",\n\"dateCreated\": \"2016-01-01\",\n\"interestStartDate\": \"2015-01-01\",\n\"dateCalculationTo\": \"2020-05-31\",\n\"paymentHistory\": [\n{\"amountPaid\" : 100000,\n\"dateOfPayment\" : \"2020-02-23\"},\n{\"amountPaid\" : 200000,\n\"dateOfPayment\" : \"2020-03-20\"}]\n }\n  ],\n  \"breathingSpaces\": [\n  ]\n}"))
      .check(status.is(200))



  def debtItemInterestRateChangeWithPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Debt touching 2 leap years with Interest rate changes from 3.25%, 3%, 2.75% to 2.6%")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n  \"debtItems\": [\n{\n\"uniqueItemReference\": \"123\",\n\"originalAmount\": 500000,\n\"subTrans\": \"1000\",\n\"mainTrans\": \"1525\",\n\"dateCreated\": \"2016-01-01\",\n\"interestStartDate\": \"2016-01-01\",\n\"dateCalculationTo\": \"2020-05-31\",\n\"paymentHistory\": [\n{\"amountPaid\" : 100000,\n\"dateOfPayment\" : \"2020-02-23\"},\n{\"amountPaid\" : 200000,\n\"dateOfPayment\" : \"2020-03-20\"}]\n}\n],\n \"breathingSpaces\": [\n  ]\n}"))
      .check(status.is(200))


  def debtItemInterestRateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
  http("Debt starting in a leap year and Interest rate changes from 3.25%, 2.75% to 2.6%")
    .post(s"$baseUri/interest-forecasting/debt-calculation")
    .headers(requestHeaders)
    .body(StringBody("{\n  \"debtItems\": [\n {\n\"uniqueItemReference\": \"123\",\n \"originalAmount\": 500000,\n\"subTrans\": \"1000\",\n\"mainTrans\": \"1525\",\n\"dateCreated\": \"2020-01-01\",\n\"interestStartDate\": \"2020-01-01\",\n\"dateCalculationTo\": \"2021-03-31\",\n\"paymentHistory\": [\n]\n}\n  ],\n  \"breathingSpaces\": [\n  ]\n}"))
    .check(status.is(200))



  }