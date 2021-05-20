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
//    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  def multipleDebtsWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple debt items with no paymentHistory and breathing space")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\":" +
            " \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\":" +
            " \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000," +
            "\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\":" +
            " 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\":" +
            " \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\":" +
            " \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\":" +
            " [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\":" +
            " \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": " +
            "\"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": " +
            "[\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": " +
            "\"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, " +
            "{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": [\n\n\t\t\t]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": " +
            "\"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": \"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-01-01\",\n\t\t\t\"interestStartDate\": \"2018-01-01\",\n\t\t\t\"interestRequestedTo\": \"2018-10-30\",\n\t\t\t\"paymentHistory\": []}], \"breathingSpaces\": [\n\n\t]\n\n}"))
      .check(status.is(200))

  def TwoDebtItemsWithLeapYearPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts with Interest rate changes and leap year payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": " +
            "\"1525\",\n\t\t\"dateCreated\": \"2018-06-01\",\n\t\t\"interestStartDate\": \"2018-06-01\",\n\t\t\"interestRequestedTo\": " +
            "\"2021-03-31\",\n\t\t\"paymentHistory\": [{\n\t\t\t\"paymentAmount\": 100000,\n\t\t\t\"paymentDate\": \"2019-03-15\"\n\t\t}, {\n\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\"paymentDate\": \"2020-04-15\"\n\t\t}]\n\t}, {\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": " +
            "\"1090\",\n\t\t\"mainTrans\": \"1545\",\n\t\t\"dateCreated\": \"2009-01-01\",\n\t\t\"interestStartDate\": \"2009-01-01\",\n\t\t\"interestRequestedTo\": " +
            "\"2010-01-01\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"))
      .check(status.is(200))

  def nonInterestBearingDebtItemWithNoBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Non Interest Bearing TPSS MainTrans 1525 debt")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1090\",\n\t\t\"mainTrans\": \"1520\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-08\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": []\n}"))
      .check(status.is(200))

  def breathingSpaceAppliedToAsingleDebtWithNoPayments(baseUri: String): HttpRequestBuilder =
    http("Breathing Space applied to a single debt")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody("{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": " +
          "\"1530\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"interestRequestedTo\": " +
          "\"2021-03-20\",\n\t\t\"paymentHistory\": []\n\t}],\n\n\t\"breathingSpaces\": [{\n\t\t\"debtRespiteFrom\": \"2021-03-07\",\n\t\t\"debtRespiteTo\":" +
          " \"2021-03-10\"\n\t}]\n}"))
      .check(status.is(200))

  def debtItemWithOpenEndedBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Breathing Space - open ended")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"originalAmount\": 500000,\n\t\t\"subTrans\": \"1000\",\n\t\t\"mainTrans\": \"1530\",\n\t\t\"dateCreated\": \"2021-03-01\",\n\t\t\"interestStartDate\": \"2021-03-01\",\n\t\t\"interestRequestedTo\": \"2021-03-20\",\n\t\t\"paymentHistory\": []\n\t}],\n\t\"breathingSpaces\": [{\n\t\t\"debtRespiteFrom\": \"2021-03-07\"\n\t}]\n}"
        )
      )
      .check(status.is(200))

  def debtItemInterestRateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts, 5 payments on 1 debt ")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 1000000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\":" +
            " \"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 200000,\n\t\t\t\t\"paymentDate\": " +
            "\"2019-02-03\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\": \"2019-02-13\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": " +
            "100000,\n\t\t\t\t\"paymentDate\": \"2019-02-06\"\n\t\t\t}, {\n\t\t\t\t\"paymentAmount\": 100000,\n\t\t\t\t\"paymentDate\":" +
            " \"2019-02-13\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2018-12-16\",\n\t\t\t\"interestStartDate\": " +
            "\"2018-12-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": []\n\t\t}\n\t],\n\n\t\"breathingSpaces\": []\n\n}"
        )
      )
      .check(status.is(200))

  def LeapYearsdebtItemsWithPaymentHistory(baseUri: String): HttpRequestBuilder =
    http(" 2 leap year debt items with payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody(
          "{\n\t\"debtItems\": [{\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": 500000,\n\t\t\t\"subTrans\": " +
            "\"1000\",\n\t\t\t\"mainTrans\": \"1525\",\n\t\t\t\"dateCreated\": \"2020-02-02\",\n\t\t\t\"interestStartDate\":" +
            " \"2020-02-02\",\n\t\t\t\"interestRequestedTo\": \"2021-05-01\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\"paymentAmount\":" +
            " 300000,\n\t\t\t\t\"paymentDate\": \"2020-05-03\"\n\t\t\t}]\n\t\t}\n\n\t\t, {\n\t\t\t\"debtID\": \"123\",\n\t\t\t\"originalAmount\": " +
            "500000,\n\t\t\t\"subTrans\": \"1090\",\n\t\t\t\"mainTrans\": \"1520\",\n\t\t\t\"dateCreated\": \"2016-05-16\",\n\t\t\t\"interestStartDate\": " +
            "\"2016-05-16\",\n\t\t\t\"interestRequestedTo\": \"2019-04-14\",\n\t\t\t\"paymentHistory\": [{\n\t\t\t\t\t\"paymentAmount\": " +
            "200000,\n\t\t\t\t\t\"paymentDate\": \"2016-12-03\"\n\t\t\t\t}\n\n\t\t\t]\n\t\t}\n\n\n\t],\n\n\t\"breathingSpaces\": [\n\n\t]\n\n}"))
      .check(status.is(200))

}



