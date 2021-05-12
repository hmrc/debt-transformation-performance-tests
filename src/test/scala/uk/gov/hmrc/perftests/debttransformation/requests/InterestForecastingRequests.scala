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

  def InterestBearingForMultipleDebtsAndPayment(baseUri: String): HttpRequestBuilder =
    http("Multiple debt items with payments")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody("{\n\"combinedDailyAccrual\": 26,\n\"unpaidAmountTotal\": 300000,\n\"interestDueCallTotal\": 4495,\n\"amountIntTotal\": 304495,\n\"amountOnIntDueTotal\": 300000,\n\"debtCalculations\": [\n{\n\"debtID\": \"123\",\n\"interestBearing\": true,\n\"numberOfChargeableDays\": 267,\n\"interestDueDailyAccrual\": 26,\n\"interestDueDutyTotal\": 4495,\n\"amountOnIntDueDuty\": 300000,\n\"totalAmountIntDuty\": 304495,\n\"unpaidAmountDuty\": 300000,\n\"calculationWindows\": [\n{\n\"periodFrom\": \"2018-12-16\",\n\"periodTo\": \"2019-03-05\",\n\"numberOfDays\": 79,\n\"interestRate\": 3.25,\n\"interestDueDailyAccrual\": 8,\n\"interestDueWindow\": 703,\n\"amountOnIntDueWindow\": 100000,\n \"unpaidAmountWindow\": 100703,\n\"breathingSpaceApplied\": false\n},\n{\n\"periodFrom\": \"2018-12-16\",\n\"periodTo\": \"2019-02-23\",\n\"numberOfDays\": 69,\n\"interestRate\": 3.25,\n\"interestDueDailyAccrual\": 8,\n \"interestDueWindow\": 614,\n\"amountOnIntDueWindow\": 100000,\n\"unpaidAmountWindow\": 100614,\n\"breathingSpaceApplied\": false\n},\n \n\"periodFrom\": \"2018-12-16\",\n\"periodTo\": \"2019-04-14\",\n\"numberOfDays\": 119,\n\"interestRate\": 3.25,\n\"interestDueDailyAccrual\": 26,\n \"interestDueWindow\": 3178,\n\"amountOnIntDueWindow\": 300000,\n \"unpaidAmountWindow\": 303178,\n \"breathingSpaceApplied\": false\n }\n            ]\n        }\n    ]\n}"

      )
      .check(status.is(200))

  def debtItemInterestRateChangeWithPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("debt item touching 2 leap years with payment history")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\t\"combinedDailyAccrual\": 37,\n\t\"unpaidAmountTotal\": 500000,\n\t\"interestDueCallTotal\": 91282,\n\t\"amountIntTotal\": 591282,\n\t\"amountOnIntDueTotal\": 500000,\n\t\"debtCalculations\": [{\n\t\t\"debtID\": \"123\",\n\t\t\"interestBearing\": true,\n\t\t\"numberOfChargeableDays\": 2239,\n\t\t\"interestDueDailyAccrual\": 37,\n\t\t\"interestDueDutyTotal\": 91282,\n\t\t\"amountOnIntDueDuty\": 500000,\n\t\t\"totalAmountIntDuty\": 591282,\n\t\t\"unpaidAmountDuty\": 500000,\n\t\t\"calculationWindows\": [{\n\t\t\t\t\"periodFrom\": \"2011-01-01\",\n\t\t\t\t\"periodTo\": \"2011-12-31\",\n\t\t\t\t\"numberOfDays\": 364,\n\t\t\t\t\"interestRate\": 3,\n\t\t\t\t\"interestDueDailyAccrual\": 41,\n\t\t\t\t\"interestDueWindow\": 14958,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 514958,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"periodFrom\": \"2012-01-01\",\n\t\t\t\t\"periodTo\": \"2012-12-31\",\n\t\t\t\t\"numberOfDays\": 365,\n\t\t\t\t\"interestRate\": 3,\n\t\t\t\t\"interestDueDailyAccrual\": 40,\n\t\t\t\t\"interestDueWindow\": 14959,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 514959,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"periodFrom\": \"2013-01-01\",\n\t\t\t\t\"periodTo\": \"2015-12-31\",\n\t\t\t\t\"numberOfDays\": 1094,\n\t\t\t\t\"interestRate\": 3,\n\t\t\t\t\"interestDueDailyAccrual\": 41,\n\t\t\t\t\"interestDueWindow\": 44958,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 544958,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"periodFrom\": \"2016-01-01\",\n\t\t\t\t\"periodTo\": \"2016-08-15\",\n\t\t\t\t\"numberOfDays\": 227,\n\t\t\t\t\"interestRate\": 3,\n\t\t\t\t\"interestDueDailyAccrual\": 40,\n\t\t\t\t\"interestDueWindow\": 9303,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 509303,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"periodFrom\": \"2016-08-16\",\n\t\t\t\t\"periodTo\": \"2016-12-31\",\n\t\t\t\t\"numberOfDays\": 137,\n\t\t\t\t\"interestRate\": 2.75,\n\t\t\t\t\"interestDueDailyAccrual\": 37,\n\t\t\t\t\"interestDueWindow\": 5146,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 505146,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"periodFrom\": \"2017-01-01\",\n\t\t\t\t\"periodTo\": \"2017-02-22\",\n\t\t\t\t\"numberOfDays\": 52,\n\t\t\t\t\"interestRate\": 2.75,\n\t\t\t\t\"interestDueDailyAccrual\": 37,\n\t\t\t\t\"interestDueWindow\": 1958,\n\t\t\t\t\"amountOnIntDueWindow\": 500000,\n\t\t\t\t\"unpaidAmountWindow\": 501958,\n\t\t\t\t\"breathingSpaceApplied\": false\n\t\t\t}\n\t\t]\n\t}]\n}")
      )
      .check(status.is(200))

  def debtItemInterestRateChangeWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("debt starting in a leap year and Interest rate changes from 3.25%, 2.75% to 2.6%")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody("{\n\"combinedDailyAccrual\": 35,\n\"unpaidAmountTotal\": 500000,\n\"interestDueCallTotal\": 12904,\n\"amountIntTotal\": 512904,\n\"amountOnIntDueTotal\": 500000,\n    \"debtCalculations\": [\n{\n \"debtID\": \"123\",\n\"interestBearing\": true,\n \"numberOfChargeableDays\": 363,\n\"interestDueDailyAccrual\": 35,\n\"interestDueDutyTotal\": 12904,\n\"amountOnIntDueDuty\": 500000,\n\"totalAmountIntDuty\": 512904,\n\"unpaidAmountDuty\": 500000,\n\"calculationWindows\": [\n{\n\"periodFrom\": \"2020-05-02\",\n\"periodTo\": \"2020-12-31\",\n\"numberOfDays\": 243,\n\"interestRate\": 2.6,\n\"interestDueDailyAccrual\": 35,\n\"interestDueWindow\": 8631,\n\"amountOnIntDueWindow\": 500000,\n\"unpaidAmountWindow\": 508631,\n\"breathingSpaceApplied\": false\n},\n{\n\"periodFrom\": \"2021-01-01\",\n\"periodTo\": \"2021-05-01\",\n\"numberOfDays\": 120,\n\"interestRate\": 2.6,\n\"interestDueDailyAccrual\": 35,\n\"interestDueWindow\": 4273,\n\"amountOnIntDueWindow\": 500000,\n \"unpaidAmountWindow\": 504273,\n\"breathingSpaceApplied\": false\n}\n]\n}\n]\n}")
      )
      .check(status.is(200))

  def debtItemInterestRateChangeWithBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Breathing Space - open ended")
      .post(s"$baseUri/interest-forecasting/debt-calculation")
      .headers(requestHeaders)
      .body(
        StringBody("{\n\"combinedDailyAccrual\": 0,\n \"npaidAmountTotal\": 500000,\n\"interestDueCallTotal\": 178,\n \"amountIntTotal\": 500178,\n\"amountOnIntDueTotal\": 500000,\n\"debtCalculations\": [\n{\n\"debtID\": \"123\",\n\"interestBearing\": true,\n\"numberOfChargeableDays\": 5,\n\"interestDueDailyAccrual\": 0,\n\"interestDueDutyTotal\": 178,\n\"amountOnIntDueDuty\": 500000,\n\"totalAmountIntDuty\": 500178,\n\"unpaidAmountDuty\": 500000,\n\"calculationWindows\": [\n{\n\"periodFrom\": \"2021-03-01\",\n\"periodTo\": \"2021-03-06\",\n\"numberOfDays\": 5,\n\"interestRate\": 2.6,\n\"interestDueDailyAccrual\": 35,\n\"interestDueWindow\": 178,\n\"amountOnIntDueWindow\": 500000,\n\"unpaidAmountWindow\": 500178,\n\"breathingSpaceApplied\": false\n},\n{\n\"periodFrom\": \"2021-03-07\",\n\"periodTo\": \"2021-03-20\",\n\"numberOfDays\": 0,\n\"interestRate\": 0,\n\"interestDueDailyAccrual\": 0,\n\"interestDueWindow\": 0,\n\"amountOnIntDueWindow\": 500000,\n \"unpaidAmountWindow\": 500000,\n \"breathingSpaceApplied\": true\n}\n]\n}\n ]\n}")
      )
      .check(status.is(200))

}
