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

package uk.gov.hmrc.perftests.debttransformation.requests.sol

import io.gatling.core.Predef.{StringBody, configuration, _}
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object FCStatementOfLiabilityRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:statement-of-liability"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  val fcSolAPIRequestWithSingleDebt =
    s"""{
       |   "customerUniqueRef":"NEHA1234",
       |   "solRequestedDate":"2021-05-13",
       |   "debts":[
       |      {
       |         "debtId":"Idle_01",
       |         "originalAmount":10000,
       |         "solDescription":"Debt Description",
       |         "interestStartDate":"2020-05-13",
       |         "interestRequestedTo":"2021-08-01",
       |         "interestIndicator":"Y",
       |         "periodEnd":"2020-05-13",
       |         "paymentHistory":[
       |            {
       |               "paymentDate":"2021-04-06",
       |               "paymentAmount":300
       |            },
       |            {
       |               "paymentDate":"2021-05-06",
       |               "paymentAmount":100
       |            }
       |         ]
       |      }
       |   ]
       |}
       |""".stripMargin

  def fcSolAPIRequestWithSingleDebtRequest(baseUri: String): HttpRequestBuilder =
    http("POST Single Debt FC SOL Statement of Liability")
      .post(s"$baseUri/fc-sol")
      .headers(requestHeaders)
      .body(StringBody(fcSolAPIRequestWithSingleDebt))
      .check(status.is(200))

  val fcSolAPIRequestWithMultipleDebts =
    s"""{
       |   "customerUniqueRef":"NEHA1234",
       |   "solRequestedDate":"2021-05-13",
       |   "debts":[
       |      {
       |         "debtId":"Idle_01",
       |         "originalAmount":10000,
       |         "solDescription":"Debt Description",
       |         "interestStartDate":"2020-05-13",
       |         "interestRequestedTo":"2021-08-01",
       |         "interestIndicator":"Y",
       |         "periodEnd":"2020-05-13",
       |         "paymentHistory":[
       |            {
       |               "paymentDate":"2021-04-06",
       |               "paymentAmount":300
       |            },
       |            {
       |               "paymentDate":"2021-05-06",
       |               "paymentAmount":100
       |            }
       |         ]
       |      },
       |      {
       |         "debtId":"Idle_02",
       |         "originalAmount":10000,
       |         "solDescription":"Debt Description",
       |         "interestStartDate":"2020-05-13",
       |         "interestRequestedTo":"2021-08-01",
       |         "interestIndicator":"Y",
       |         "periodEnd":"2020-05-13",
       |         "paymentHistory":[
       |            {
       |               "paymentDate":"2021-04-06",
       |               "paymentAmount":300
       |            },
       |            {
       |               "paymentDate":"2021-05-06",
       |               "paymentAmount":100
       |            }
       |         ]
       |      }
       |   ]
       |}
       |""".stripMargin

  def fcSolRequestFormultipleDebts(baseUri: String): HttpRequestBuilder =
    http("POST Multiple Debts FC SOL Statement of Liability")
      .post(s"$baseUri/fc-sol")
      .headers(requestHeaders)
      .body(StringBody(fcSolAPIRequestWithMultipleDebts))
      .check(status.is(200))

  val fcSolAPIRequestWithNoPaymentHistory =
    s"""{
       |   "customerUniqueRef":"NEHA1234",
       |   "solRequestedDate":"2021-05-13",
       |   "debts":[
       |      {
       |         "debtId":"Idle_01",
       |         "originalAmount":10000,
       |         "solDescription":"Debt Description",
       |         "interestStartDate":"2020-05-13",
       |         "interestRequestedTo":"2021-08-01",
       |         "interestIndicator":"Y",
       |         "periodEnd":"2020-05-13",
       |         "paymentHistory":[
       |
       |         ]
       |      }
       |   ]
       |}
       |""".stripMargin

  def fcSolAPIRequestWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("POST Single Debt FC SOL Statement of Liability With No Payments")
      .post(s"$baseUri/fc-sol")
      .headers(requestHeaders)
      .body(StringBody(fcSolAPIRequestWithNoPaymentHistory))
      .check(status.is(200))

}
