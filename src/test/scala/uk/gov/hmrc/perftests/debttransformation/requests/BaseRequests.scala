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

import play.api.libs.json.Json
import scalaj.http.Http
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls.authLoginApiUri
import uk.gov.hmrc.perftests.debttransformation.utils.RandomValues

object BaseRequests extends RandomValues{

  def creatAuthorizationBearerToken(
                                     enrolments: Seq[String] = Seq(),
                                     userType: String = getRandomAffinityGroup,
                                     utr: String = "123456789012"
                                   ): String = {
    val json =
      Json.obj(
        "affinityGroup" -> userType,
        "credentialStrength" -> "strong",
        "confidenceLevel" -> 50,
        "credId" -> "test",
        "enrolments" -> enrolments.map(key =>
          Json.obj(
            "key" -> key,
            "identifiers" -> Json.arr(
              Json.obj(
                "key" -> "UTRNumber",
                "value" -> utr
              )
            ),
            "state" -> "Activated"
          )
        )
      )
    val response = Http(s"$authLoginApiUri/government-gateway/session/login")
      .header("Content-Type", "application/json")
      .postData(Json.stringify(json))
      .execute()
    response.headers.filter(header => header._1.equalsIgnoreCase("Authorization")).values
      .flatMap(_.collect { case s if (s.contains("Bearer")) => s.replace("Bearer ", "") }).head
  }


}
