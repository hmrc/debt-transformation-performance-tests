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
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt301",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt302",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt303",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt304",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt305",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt306",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt307",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt308",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt309",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt310",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt311",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt312",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt313",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt314",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt315",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt316",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt317",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt318",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt319",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt320",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt321",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt322",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt323",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt324",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt325",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt326",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt327",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt328",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt329",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt330",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt331",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt332",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt333",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt334",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt335",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt336",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt337",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt338",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt339",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt340",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt341",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt342",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt343",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt344",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt345",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt346",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt347",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt348",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt349",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt350",
       |          "debtAmount": 2857,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    }""".stripMargin

  var debtItemCharges400600: String =
    s""",    {
       |          "debtId": "Debt400",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt401",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt402",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt403",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt404",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt405",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt406",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt407",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt408",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt409",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt410",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt411",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt412",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt413",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt414",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt415",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt416",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt417",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt418",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt419",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt420",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt421",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt422",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt423",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt424",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt425",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt426",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt427",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt428",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt429",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt430",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt431",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt432",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt433",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt434",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt435",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt436",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt437",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt438",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt439",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt440",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt441",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt442",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt443",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt444",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt445",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt446",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt447",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt448",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt449",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt450",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt451",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt452",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt453",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt454",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt455",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt456",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt457",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt458",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt459",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt460",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt461",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt462",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt463",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt464",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt465",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt466",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt467",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt468",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt469",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt470",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt471",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt472",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt473",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt474",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt475",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt476",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt477",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt478",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt479",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt480",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt481",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt482",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt483",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt484",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt485",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt486",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt487",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt488",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt489",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt490",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt491",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt492",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt493",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt494",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt495",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt496",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt497",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt498",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt499",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt500",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt501",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt502",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt503",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt504",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt505",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt506",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt507",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt508",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt509",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt510",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt511",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt512",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt513",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt514",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt515",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt516",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt517",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt518",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt519",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt520",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt521",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt522",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt523",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt524",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt525",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt526",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt527",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt528",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt529",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt530",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt531",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt532",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt533",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt534",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt535",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt536",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt537",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt538",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt539",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt540",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt541",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt542",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt543",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt544",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt545",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt546",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt547",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt548",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt549",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt550",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt551",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt552",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt553",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt554",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt555",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt556",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt557",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt558",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt559",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt560",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt561",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt562",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt563",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt564",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt565",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt566",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt567",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt568",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt569",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt570",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt571",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt572",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt573",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt574",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt575",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt576",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt577",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt578",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt579",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt580",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt581",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt582",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt583",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt584",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt585",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt586",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt587",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt588",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt589",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt590",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt591",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt592",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt593",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt594",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt595",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt596",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt597",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt598",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt599",
       |          "debtAmount": 1667,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt600",
       |          "debtAmount": 1667,
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
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt2",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt3",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt4",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt5",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt6",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt7",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt8",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt9",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt10",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt11",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt12",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt13",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt14",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt15",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt16",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt17",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt18",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt19",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt20",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt21",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt22",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt23",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt24",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt25",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt26",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt27",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt28",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt29",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt30",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt31",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt32",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt33",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt34",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt35",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt36",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt37",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt38",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt39",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt40",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt41",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt42",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt43",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt44",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt45",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt46",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt47",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt48",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt49",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt50",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt51",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt52",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt53",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt54",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt55",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt56",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt57",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt58",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt59",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt60",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt61",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt62",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt63",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt64",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt65",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt66",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt67",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt68",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt69",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt70",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt71",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt72",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt73",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt74",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt75",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt76",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt77",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt78",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt79",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt80",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt81",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt82",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt83",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt84",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt85",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt86",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt87",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt88",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt89",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt90",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt91",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt92",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt93",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt94",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt95",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt96",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt97",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt98",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt99",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt100",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt101",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt102",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt103",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt104",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt105",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt106",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt107",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt108",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt109",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt110",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt111",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt112",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt113",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt114",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt115",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt116",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt117",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt118",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt119",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt120",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt121",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt122",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt123",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt124",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt125",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt126",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt127",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt128",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt129",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt130",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt131",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt132",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt133",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt134",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt135",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt136",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt137",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt138",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt139",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt140",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt141",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt142",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |          },    {
       |          "debtId": "Debt143",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt144",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt145",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt146",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt147",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt148",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt149",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt150",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt151",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt152",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt153",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt154",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt155",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt156",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt157",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt158",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt159",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt160",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt161",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt162",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt163",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt164",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt165",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt166",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt167",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt168",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt169",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt170",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt171",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt172",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt173",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt174",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt175",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt176",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt177",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt178",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt179",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt180",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt181",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt182",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt183",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt184",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt185",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt186",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt187",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt188",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt189",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt190",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt191",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt192",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt193",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt194",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt195",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt196",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt197",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt198",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt199",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt200",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt201",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt202",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt203",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt204",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt205",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt206",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt207",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt208",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt209",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt210",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt211",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt212",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt213",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt214",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt215",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt216",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt217",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt218",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt219",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt220",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt221",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt222",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt223",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt224",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt225",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt226",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt227",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt228",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt229",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt230",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt231",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt232",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt233",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt234",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt235",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt236",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt237",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt238",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt239",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt240",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt241",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt242",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt243",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt244",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt245",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt246",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt247",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt248",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt249",
       |          "debtAmount": 4000,
       |          "subTrans": "1553",
       |          "mainTrans": "4910"
       |
       |    },    {
       |          "debtId": "Debt250",
       |          "debtAmount": 4000,
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