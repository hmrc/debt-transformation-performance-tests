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

import java.time.LocalDate

object InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate          = LocalDate.now().toString
  var instalmentDate     = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken        = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders     = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept"        -> "application/vnd.hmrc.1.0+json",
    "Content-Type"  -> "application/json"
  )
  var debtItemCharges200300: String =
    s""",    {
       |          "debtId": "Debt201",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt202",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt203",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt204",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt205",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt206",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt207",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt208",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt209",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt210",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt211",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt212",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt213",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt214",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt215",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt216",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt217",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt218",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt219",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt220",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt221",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt222",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt223",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt224",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt225",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt226",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt227",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt228",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt229",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt230",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt231",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt232",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt233",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt234",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt235",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt236",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt237",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt238",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt239",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt240",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt241",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt242",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt243",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt244",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt245",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt246",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt247",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt248",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt249",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt250",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt251",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt252",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt253",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt254",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt255",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt256",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt257",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt258",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt259",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt260",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt261",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt262",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt263",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt264",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt265",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt266",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt267",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt268",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt269",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt270",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt271",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt272",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt273",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt274",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt275",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt276",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt277",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt278",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt279",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt280",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt281",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt282",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt283",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt284",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt285",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt286",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt287",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt288",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt289",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt290",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt291",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt292",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt293",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt294",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt295",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt296",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt297",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt298",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt299",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt300",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt301",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt302",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt303",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt304",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt305",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt306",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt307",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt308",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt309",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt310",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt311",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt312",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt313",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt314",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt315",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt316",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt317",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt318",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt319",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt320",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt321",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt322",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt323",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt324",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt325",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt326",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt327",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt328",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt329",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt330",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt331",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt332",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt333",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt334",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt335",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt336",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt337",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt338",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt339",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt340",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt341",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt342",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt343",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt344",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt345",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt346",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt347",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt348",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt349",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt350",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt351",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt352",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt353",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt354",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt355",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt356",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt357",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt358",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt359",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt360",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt361",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt362",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt363",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt364",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt365",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt366",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt367",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt368",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt369",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt370",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt371",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt372",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt373",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt374",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt375",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt376",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt377",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt378",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt379",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt380",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt381",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt382",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt383",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt384",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt385",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt386",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt387",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt388",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt389",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt390",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt391",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt392",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt393",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt394",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt395",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt396",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt397",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt398",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt399",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt400",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    }""".stripMargin

  var debtItemCharges400500: String =
    s""",    ,    {
       |          "debtId": "Debt400",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt401",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt402",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt403",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt404",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt405",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt406",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt407",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt408",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt409",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt410",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt411",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt412",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt413",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt414",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt415",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt416",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt417",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt418",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt419",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt420",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt421",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt422",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt423",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt424",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt425",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt426",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt427",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt428",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt429",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt430",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt431",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt432",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt433",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt434",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt435",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt436",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt437",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt438",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt439",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt440",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt441",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt442",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt443",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt444",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt445",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt446",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt447",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt448",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt449",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt450",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt451",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt452",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt453",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt454",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt455",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt456",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt457",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt458",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt459",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt460",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt461",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt462",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt463",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt464",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt465",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt466",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt467",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt468",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt469",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt470",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt471",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt472",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt473",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt474",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt475",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt476",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt477",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt478",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt479",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt480",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt481",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt482",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt483",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt484",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt485",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt486",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt487",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt488",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt489",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt490",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt491",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt492",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt493",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt494",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt495",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt496",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt497",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt498",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt499",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt500",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt501",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt502",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt503",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt504",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt505",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt506",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt507",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt508",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt509",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt510",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt511",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt512",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt513",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt514",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt515",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt516",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt517",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt518",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt519",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt520",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt521",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt522",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt523",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt524",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt525",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt526",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt527",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt528",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt529",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt530",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt531",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt532",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt533",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt534",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt535",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt536",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt537",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt538",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt539",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt540",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt541",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt542",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt543",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt544",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt545",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt546",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt547",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt548",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt549",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt550",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt551",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt552",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt553",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt554",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt555",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt556",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt557",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt558",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt559",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt560",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt561",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt562",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt563",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt564",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt565",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt566",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt567",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt568",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt569",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt570",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt571",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt572",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt573",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt574",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt575",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt576",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt577",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt578",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt579",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt580",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt581",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt582",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt583",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt584",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt585",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt586",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt587",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt588",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt589",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt590",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt591",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt592",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt593",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt594",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt595",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt596",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt597",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt598",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt599",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt600",
       |          "debtAmount": 1667,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    }""".stripMargin

  val InitialPaymentInstalmentPlan: String =
    s"""{
       |	"debtItemCharges": [{
       |		"debtId": "1234",
       |		"debtAmount": 80000,
       |		"subTrans": "1000",
       |		"mainTrans": "1525"
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
       |	"debtItemCharges": [{
       |          "debtId": "Debt1",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt2",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt3",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt4",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt5",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt6",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt7",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt8",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt9",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt10",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt11",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt12",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt13",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt14",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt15",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt16",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt17",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt18",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt19",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt20",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt21",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt22",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt23",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt24",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt25",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt26",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt27",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt28",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt29",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt30",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt31",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt32",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt33",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt34",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt35",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt36",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt37",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt38",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt39",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt40",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt41",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt42",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt43",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt44",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt45",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt46",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt47",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt48",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt49",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt50",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt51",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt52",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt53",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt54",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt55",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt56",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt57",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt58",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt59",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt60",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt61",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt62",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt63",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt64",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt65",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt66",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt67",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt68",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt69",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt70",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt71",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt72",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt73",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt74",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt75",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt76",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt77",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt78",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt79",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt80",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt81",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt82",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt83",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt84",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt85",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt86",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt87",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt88",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt89",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt90",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt91",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt92",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt93",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt94",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt95",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt96",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt97",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt98",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt99",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1525"
       |
       |    },    {
       |          "debtId": "Debt100",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt101",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt102",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt103",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt104",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt105",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt106",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt107",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt108",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt109",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt110",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt111",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt112",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt113",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt114",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt115",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt116",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt117",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt118",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt119",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt120",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt121",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt122",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt123",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt124",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt125",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt126",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt127",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt128",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt129",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt130",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt131",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt132",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt133",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt134",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt135",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt136",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt137",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt138",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt139",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt140",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt141",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt142",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt143",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt144",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt145",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt146",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt147",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt148",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt149",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt150",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt151",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt152",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt153",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt154",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt155",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt156",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt157",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt158",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt159",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt160",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt161",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt162",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt163",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt164",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt165",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt166",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt167",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt168",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt169",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt170",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt171",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt172",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt173",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt174",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt175",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt176",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt177",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt178",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt179",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt180",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt181",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt182",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt183",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt184",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt185",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt186",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt187",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt188",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt189",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt190",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt191",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt192",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt193",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt194",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt195",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt196",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt197",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt198",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt199",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    },    {
       |          "debtId": "Debt200",
       |          "debtAmount": 2500,
       |          "subTrans": "1000",
       |          "mainTrans": "1530"
       |
       |    }$debtItemCharges200300 $debtItemCharges400500],
       |	"quoteDate": "$quoteDate",
       |    "quoteType": "instalmentAmount",
       |	"instalmentPaymentDate": "$instalmentDate",

       |	"paymentFrequency": "monthly",
       |	"duration":6 ,
       |	"customerPostCaodes": [
       |	],
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
       |		"subTrans": "1000",
       |		"mainTrans": "1525"
       |
       |	}, {
       |		"debtId": "Debt2",
       |		"debtAmount": 150000,
       |		"subTrans": "1000",
       |		"mainTrans": "1530"
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
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
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
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
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
       |}
                                             """.stripMargin

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
       |			"subTrans": "1000",
       |			"mainTrans": "1525",
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
       |}

       """.stripMargin

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
      |		"subTrans": "1000",
      |		"mainTrans": "1525",
      |		"interestStartDate": "2018-12-16",
      |		"interestRequestedTo": "2019-04-14",
      |		"paymentHistory": []
      |	}, {
      |		"debtID": "123",
      |		"originalAmount": 500000,
      |		"subTrans": "1000",
      |		"mainTrans": "1525",
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
