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

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

import java.time.LocalDateimport io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

import java.time.LocalDate

object InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate = LocalDate.now().toString
  var instalmentDate = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept" -> "application/vnd.hmrc.1.0+json",
    "Content-Type" -> "application/json"
  )
  
  var debtItemCharges200300: String =
    s"""    ,    {
       |          "debtId": "Debt300",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt301",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt302",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt303",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt304",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt305",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt306",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt307",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt308",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt309",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt310",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt311",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt312",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt313",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt314",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt315",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt316",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt317",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt318",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt319",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt320",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt321",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt322",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt323",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt324",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt325",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt326",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt327",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt328",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt329",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt330",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt331",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt332",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt333",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt334",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt335",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt336",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt337",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt338",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt339",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt340",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt341",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt342",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt343",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt344",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt345",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt346",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt347",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt348",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt349",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt350",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    }""".stripMargin

  val InitialPaymentInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "1234",
       |		"debtAmount": 80000,
       |		"subTrans": "1553",
       |		"mainTrans": "4910"
       |
       |	}],
       |	"quoteDate": "$quoteDate",
       |	"quoteType": "duration",
       |	"instalmentPaymentDate": "$instalmentDate",
       |	"paymentFrequency": "monthly",
       |	"instalmentPaymentAmount": 10000,
       |	"customerPostCodes": [
       |
       |	],
       |	"interestCallDueTotal": 5900,
       |	"initialPaymentDate": "$initialPaymentDate",
       |	"initialPaymentAmount": 100
       |
       |}""".stripMargin

  def instalmentPlanWithInitialPayment(baseUri: String): HttpRequestBuilder =
    http("Single Debt Instalment Plan  : Initial Payment Date Before Instalment Date")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(InitialPaymentInstalmentPlan))
      .check(status.is(200))


  val MultipleDebtInstalmentPlan: String =
    s"""{
       |          "debtId": "Debt1",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt2",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt3",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt4",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt5",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt6",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt7",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt8",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt9",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt10",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt11",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt12",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt13",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt14",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt15",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt16",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt17",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt18",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt19",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt20",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt21",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt22",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt23",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt24",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt25",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt26",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt27",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt28",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt29",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt30",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt31",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt32",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt33",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt34",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt35",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt36",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt37",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt38",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt39",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt40",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt41",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt42",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt43",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt44",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt45",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt46",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt47",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt48",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt49",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt50",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt51",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt52",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt53",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt54",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt55",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt56",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt57",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt58",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt59",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt60",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt61",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt62",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt63",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt64",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt65",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt66",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt67",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt68",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt69",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt70",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt71",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt72",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt73",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt74",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt75",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt76",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt77",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt78",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt79",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt80",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt81",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt82",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt83",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt84",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt85",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt86",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt87",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt88",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt89",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt90",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt91",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt92",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt93",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt94",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt95",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt96",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt97",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt98",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt99",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt100",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt101",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt102",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt103",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt104",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt105",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt106",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt107",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt108",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt109",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt110",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt111",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt112",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt113",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt114",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt115",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt116",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt117",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt118",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt119",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt120",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt121",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt122",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt123",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt124",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt125",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt126",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt127",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt128",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt129",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt130",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt131",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt132",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt133",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt134",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt135",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt136",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt137",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt138",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt139",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt140",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt141",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt142",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |          },    {
       |          "debtId": "Debt143",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt144",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt145",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt146",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt147",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt148",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt149",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt150",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt151",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt152",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt153",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt154",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt155",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt156",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt157",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt158",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt159",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt160",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt161",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt162",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt163",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt164",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt165",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt166",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt167",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt168",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt169",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt170",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt171",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt172",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt173",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt174",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt175",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt176",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt177",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt178",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt179",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt180",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt181",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt182",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt183",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt184",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt185",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt186",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt187",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt188",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt189",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt190",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt191",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt192",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt193",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt194",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt195",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt196",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt197",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt198",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt199",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt200",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt201",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt202",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt203",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt204",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt205",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt206",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt207",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt208",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt209",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt210",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt211",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt212",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt213",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt214",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt215",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt216",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt217",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt218",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt219",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt220",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt221",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt222",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt223",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt224",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt225",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt226",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt227",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt228",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt229",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt230",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt231",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt232",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt233",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt234",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt235",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt236",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt237",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt238",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt239",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt240",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt241",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt242",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt243",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt244",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt245",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt246",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt247",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt248",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt249",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt250",
       |          "debtAmount": 3000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    }],
       |    "quoteDate": "$quoteDate",
       |    "quoteType": "instalmentAmount",
       |    "instalmentPaymentDate": "$instalmentDate",
       |    "paymentFrequency": "monthly",
       |	"duration":6 ,
       |	"customerPostCodes": [
       |    ],
       |	"interestCallDueTotal": 1423,	"interestCallDueTotal": 0,
       | 	"initialPaymentDate": "$initialPaymentDate",
       | 	"initialPaymentAmount": 100
       |
       |}""".stripMargin

  def instalmentPlanWithMultipleDebts(baseUri: String): HttpRequestBuilder =
    http("Multiple Debt Instalment Plan")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtInstalmentPlan))
      .check(status.is(200))


  val noInitialPaymentInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "Debt1",
       |		"debtAmount": 100000,
       |		"subTrans": "1553",
       |		"mainTrans": "4910"
       |
       |	}, {
       |		"debtId": "Debt2",
       |		"debtAmount": 150000,
       |		"subTrans": "1553",
       |		"mainTrans": "4910"
       |
       |	}],
       |	"quoteDate": "$quoteDate",
       |	"quoteType": "instalmentAmount",
       |	"instalmentPaymentDate": "$instalmentDate",
       |	"paymentFrequency": "monthly",
       |	"duration": 24,
       |	"customerPostCodes": [
       |
       |	],
       |	"interestCallDueTotal": 0
       |
       |}""".stripMargin

  def instalmentPlanWithNoInitialPayment(baseUri: String): HttpRequestBuilder =
    http("Instalment Plan For Multiple Debts - With No Initial payment")
      .post(s"$baseUri/instalment-calculation")
      .headers(requestHeaders)
      .body(StringBody(noInitialPaymentInstalmentPlan))
      .check(status.is(200))


  val multipleDebtsWithOnePaymentHistory =
    s"""
       |{
       |	"debtItems": [{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1553",
       |			"mainTrans": "4910",
       |
       |			"interestStartDate": "2018-12-16",
       |			"interestRequestedTo": "2019-04-14",
       |
       |			"paymentHistory": [{
       |					"paymentAmount": 100000,
       |					"paymentDate": "2019-02-03"
       |				}
       |
       |			]
       |		}
       |
       |		, {
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1553",
       |			"mainTrans": "4910",
       |
       |			"interestStartDate": "2018-12-16",
       |			"interestRequestedTo": "2019-04-14",
       |
       |			"paymentHistory": [
       |
       |			]
       |		}
       |
       |
       |	],
       |
       |	"breathingSpaces": [
       |
       |	],
       |
       |	"customerPostCodes": [
       |
       |	]
       |
       |}""".stripMargin

  val multipleDebtsNonInterestingBearing =
    s"""{
       |      "debtItemCharges":[    {
       |          "debtId": "debtId",
       |          "debtAmount": 50000,
       |          "subTrans": "7012",
       |          "mainTrans": "5350"
       |
       |    },    {
       |          "debtId": "debtId",
       |          "debtAmount": 50000,
       |          "subTrans": "7013",
       |          "mainTrans": "5350"
       |
       |    }],
       |      "quoteDate": "$quoteDate",
       |      "quoteType": "duration",
       |      "instalmentPaymentDate": "$instalmentDate",
       |      "paymentFrequency":"single",
       |       "instalmentPaymentAmount":10000 ,
       |      "customerPostCodes": [
       |
       |        ],
       |	    "interestCallDueTotal": 1423
       |
       |    }""".stripMargin

  def multipleDebtsWithOnePaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple debt items with one payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(multipleDebtsWithOnePaymentHistory))
      .check(status.is(200))

  val twoDebtsWithLeapYear =
    s"""
       |{
       |	"debtItems": [{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1553",
       |			"mainTrans": "4910",
       |			"interestStartDate": "2018-06-01",
       |			"interestRequestedTo": "2021-03-31",
       |			"paymentHistory": [{
       |				"paymentAmount": 100000,
       |				"paymentDate": "2019-03-15"
       |			}, {
       |				"paymentAmount": 100000,
       |				"paymentDate": "2020-04-15"
       |			}]
       |		},
       |		{
       |			"debtID": "123",
       |			"originalAmount": 500000,
       |			"subTrans": "1090",
       |			"mainTrans": "1545",
       |			"interestStartDate": "2009-01-01",
       |			"interestRequestedTo": "2010-01-01",
       |			"paymentHistory": []
       |		}
       |	],
       |	"breathingSpaces": [],
       |	"customerPostCodes": []
       |}""".stripMargin

  def TwoDebtItemsWithLeapYearPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("2 debts with Interest rate changes and leap year payment history")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(twoDebtsWithLeapYear))
      .check(status.is(200))

  val noInterestBearing =
    """{
      |	"debtItems": [{
      |		"debtID": "123",
      |		"originalAmount": 500000,
      |		"subTrans": "1553",
      |		"mainTrans": "4910",
      |		"interestStartDate": "2018-12-16",
      |		"interestRequestedTo": "2019-04-14",
      |		"paymentHistory": []
      |	}, {
      |		"debtID": "123",
      |		"originalAmount": 500000,
      |		"subTrans": "1553",
      |		"mainTrans": "4910",
      |		"interestStartDate": "2018-12-16",
      |		"interestRequestedTo": "2019-04-14",
      |		"paymentHistory": []
      |	}],
      |	"breathingSpaces": [],
      |	"customerPostCodes": []
      |
      |}""".stripMargin

  def nonInterestBearingDebtItemWithNoBreathingSpace(baseUri: String): HttpRequestBuilder =
    http("Non Interest Bearing TPSS MainTrans 1525 debt")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(noInterestBearing))
      .check(status.is(200))

  val multipleSAdebtsWithPaymentsAndBreathingSpaces: String =
    s"""{
       |    "debtItems": [
       |        {
       |            "debtID": "1233",
       |            "originalAmount": 50000,
       |            "subTrans": "1553",
       |            "mainTrans": "4920",
       |            "interestStartDate": "2022-01-31",
       |            "interestRequestedTo": "2023-06-17",
       |            "breathingSpaces": [
       |                {
       |                    "debtRespiteFrom": "2022-03-01",
       |                    "debtRespiteTo": "2022-04-29"
       |                },
       |                {
       |                    "debtRespiteFrom": "2023-04-01",
       |                    "debtRespiteTo": "2034-06-17"
       |                }
       |            ],
       |            "paymentHistory": [
       |                {
       |                    "paymentAmount": 25000,
       |                    "paymentDate": "2022-05-30"
       |                }
       |            ]
       |        },
       |        {
       |            "debtID": "1234",
       |            "originalAmount": 1500,
       |            "subTrans": "1090",
       |            "mainTrans": "1520",
       |            "interestStartDate": "2034-11-12",
       |            "interestRequestedTo": "2022-06-10",
       |            "breathingSpaces": [],
       |            "paymentHistory": []
       |        },
       |        {
       |            "debtID": "1235",
       |            "originalAmount": 50000,
       |            "subTrans": "1553",
       |            "mainTrans": "4920",
       |            "interestStartDate": "2022-07-30",
       |            "interestRequestedTo": "2023-03-31",
       |            "breathingSpaces": [
       |                {
       |                    "debtRespiteFrom": "2023-04-01",
       |                    "debtRespiteTo": "2034-06-17"
       |                }
       |            ],
       |            "paymentHistory": []
       |        }
       |    ],
       |    "customerPostCodes": []
       |}""".stripMargin

  def multipleDebtItemsWithPaymentsAndBreathingSpaces(baseUri: String): HttpRequestBuilder =
    http("Multiple SA debt items with payments and breathing spaces")
      .post(s"$baseUri/debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(multipleSAdebtsWithPaymentsAndBreathingSpaces))
      .check(status.is(200))

  val interestType: String =
    s"""[
       |    {
       |        "mainTrans": "2000",
       |        "subTrans": "1000"
       |    }
       |]""".stripMargin

  def debtInterestTypeRequest(baseUri: String): HttpRequestBuilder =
    http("debt Interest Type")
      .post(s"$baseUri/debt-interest-type")
      .headers(requestHeaders)
      .body(StringBody(interestType))
      .check(status.is(200))
}