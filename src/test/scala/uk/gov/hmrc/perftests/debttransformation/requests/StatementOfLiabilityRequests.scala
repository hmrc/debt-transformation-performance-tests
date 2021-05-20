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

object StatementOfLiabilityRequests extends ServicesConfiguration {
  val bearerToken    = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:statement-of-liability"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )

  def statementOfLiabilityHelloWorld(baseUri: String): HttpRequestBuilder =
    http("GET Statement of Liability")
      .get(s"$baseUri/hello-world")
      .headers(requestHeaders)
      .check(status.is(200))


  val solAPIRequestWithSingleDebt =
    s"""
       |{
       |  "solType" : "CO",
       |  "solRequestedDate": "2021-05-18",
       |  "debts" : [ {
       |    "debtID" : "debt001",
       |    "dutyID" : [ "duty01", "duty02" ],
       |    "interestRequestedTo": "2021-08-10"
       |  }]
       |}
       |""".stripMargin

  def solAPIRequestWithSingleDebtRequest(baseUri: String): HttpRequestBuilder =
    http("POST Single Debt SOL Statement of Liability")
      .post(s"$baseUri/sol")
      .headers(requestHeaders)
      .body(StringBody(solAPIRequestWithSingleDebt))
      .check(status.is(200))


  val solAPIRequestWithMultipleDebts =
    s"""
       |{
       |  "solType": "UI",
       |  "solRequestedDate": "2021-05-17",
       |  "debts": [
       |    {
       |      "debtID": "debt001",
       |      "dutyID": [
       |        "duty01",
       |        "duty02"
       |      ],
       |      "interestRequestedTo": "2021-08-10"
       |    },
       |    {
       |      "debtID": "debt004",
       |      "dutyID": [
       |        "duty04"
       |      ],
       |      "interestRequestedTo": "2021-08-10"
       |    }
       |  ]
       |}
       |""".stripMargin

  def statementOfLiabilityRequestFormultipleDebts(baseUri: String): HttpRequestBuilder =
    http("POST Multiple Debts SOL Statement of Liability")
      .post(s"$baseUri/sol")
      .headers(requestHeaders)
      .body(StringBody(solAPIRequestWithMultipleDebts))
      .check(status.is(200))

}
