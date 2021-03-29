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

//  Assumptions
//  1 Debt item
//  Initial amount and date
//    REGIME == DRIERd
//  Where charge type is DRIER NI, then interest bearing is assumed to be true
//  Where charge type is DRIER HiPG, then interest bearing is assumed to be false
//  NO repayments
//    NO suppression period
//  NO breathing space
//  Date Amount  == Interest start date
//    No outstanding interests to pay
//  When bearing the interest rate is 1%
//
//  DTD-191: IFS Amounts to be in pennies. Is outstanding

  val bearerToken = BaseRequests.creatAuthorizationBearerToken(
    enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map("Authorization" -> s"Bearer $bearerToken",
                           "Accept" -> "application/vnd.hmrc.1.0+json",
                           "Content-Type" -> "application/json")

  def InterestBearingdrierdebtForChargeTypeNino(
      baseUri: String): HttpRequestBuilder =
    http("Interest bearing drier debt -MVP")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(
        "{\"amount\": 500000, \"chargeType\": \"NI\", \"regime\": \"DRIER\", \"dateAmount\": \"2021-01-01\", \"dateCalculationTo\": \"2021-05-01\"}"))
      .check(status.is(200))

  def nonInterestBearingDrierdebtForChargeTypeHIPG(
      baseUri: String): HttpRequestBuilder =
    http("Non Interest bearing drier debt -MVP")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(
        "{\"amount\": 500000, \"chargeType\": \"HIPG\", \"regime\": \"DRIER\", \"dateAmount\": \"2021-01-01\", \"dateCalculationTo\": \"2021-05-01\"}"))
      .check(status.is(200))
}
