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

  def InterestBearingDebtCalculationForASinglePayment(baseUri: String): HttpRequestBuilder =
    http("Interest Bearing: 1 Payment of 1 debt")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1525\",\n\t\t\"dateCreated\": \"2020-12-16\",\n\t\t\"interestStartDate\": \"2020-12-16\",\n\t\t\"dateCalculationTo\": \"2021-04-14\",\n\t\t\"paymentHistory\": [{\n\t\t\t\"amountPaid\": 100000,\n\t\t\t\"dateOfPayment\": \"2021-02-03\"\n\t\t}]\n\t}]\n}"))
      .check(status.is(200))

  def InterestBearingDebtCalculationForMultiplePayment(baseUri: String): HttpRequestBuilder =
    http("Interest Bearing: 2 Payments of 1 debt")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1525\",\n\t\t\"dateCreated\": \"2020-12-16\",\n\t\t\"interestStartDate\": \"2020-12-16\",\n\t\t\"dateCalculationTo\": \"2021-04-14\",\n\t\t\"paymentHistory\": [{\n\t\t\t\"amountPaid\": 100000,\n\t\t\t\"dateOfPayment\": \"2021-02-23\"\n\t\t}, {\n\t\t\t\"amountPaid\": 100000,\n\t\t\t\"dateOfPayment\": \"2021-03-05\"\n\t\t}]\n\t}]\n\n\n\n\n}"))
      .check(status.is(200))

  def nonInterestBearingDebtCalculationForASinglePayment(baseUri: String): HttpRequestBuilder =
    http("Non Interest Bearing: 1 Payment of 1 debt.")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"debtItems\":\n\n\t\t[{\n\t\t\t\"uniqueItemReference\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-06-01\",\n\t\t\t\"interestStartDate\": \"2018-06-01\",\n\t\t\t\"dateCalculationTo\": \"2021-03-31\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"amountPaid\": 100000,\n\t\t\t\t\"dateOfPayment\": \"2019-03-15\"\n\t\t\t}]\n\t\t}]\n}"))
      .check(status.is(200))

//  def InterestBearingDebtCalculationForTwoDebtItemsWithAPaymentButNoTForSecondDebt(baseUri: String): HttpRequestBuilder =
//    http("Interest Bearing. 2 debts. 1 debt with payment the second debt with no payment")
//      .post(s"$baseUri/interest-forecasting/debt-calculation")
//      .headers(requestHeaders)
//      .body(StringBody(""))
//      .check(status.is(200))


  def debtItemInterestrateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
  http("Interest rate changes from 2.75% to 2.6%")
    .post(s"$baseUri/interest-forecasting/debt-calculation")
    .headers(requestHeaders)
    .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1525\",\n\t\t\"dateCreated\": \"2020-01-01\",\n\t\t\"interestStartDate\": \"2020-01-01\",\n\t\t\"dateCalculationTo\": \"2021-03-31\",\n\t\t\"paymentHistory\": []\n\t}]\n}"))
    .check(status.is(200))

def referenceDataInterestBearingTPSSMainTrans1530SubTrans1000(baseUri: String): HttpRequestBuilder =
  http("Interest Bearing TPSS MainTrans 1530 debt SubTrans 1000")
  .post(s"$baseUri/interest-forecasting/debt-calculation")
  .headers(requestHeaders)
  .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1530\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"dateCalculationTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\n\n\n\t}]\n}"))
  .check(status.is(200))

  def referenceDataInterestBearingTPSSMainTrans1535SubTrans1000(baseUri: String): HttpRequestBuilder =
    http("Interest Bearing TPSS MainTrans (1535) debt SubTrans (1000)")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1535\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"dateCalculationTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\n\n\n\t}]\n}"))
      .check(status.is(200))

  def referenceDataInterestBearingTPSSMainTrans1540SubTrans1000(baseUri: String): HttpRequestBuilder =
    http("Interest Bearing TPSS MainTrans (1540) debt SubTrans (1000)")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"debtItems\": [{\n\t\t\"uniqueItemReference\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1540\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"dateCalculationTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\n\n\n\t}]\n}"))
      .check(status.is(200))

  }