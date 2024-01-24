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

package uk.gov.hmrc.perftests.debttransformation.requests
import org.apache.pekko.actor.ActorSystem
import play.api.libs.json.Json
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls.authLoginApiUri
import uk.gov.hmrc.perftests.debttransformation.utils.RandomValues
import uk.gov.hmrc.perftests.debttransformation.utils.WsClient._

import scala.concurrent.Await

object BaseRequests extends RandomValues {
  private val asyncClient: StandaloneAhcWSClient = {
    implicit val system: ActorSystem = ActorSystem()
    StandaloneAhcWSClient()
  }
    def creatAuthorizationBearerToken(
    enrolments: Seq[String] = Seq(),
    userType: String = getRandomAffinityGroup,
    utr: String = "123456789012"): String = {
      val json =
        Json.obj(
          "affinityGroup" -> userType,
          "excludeGnapToken" -> true,
          "credentialStrength" -> "strong",
          "confidenceLevel" -> 50,
        "affinityGroup"      -> userType,
        "credentialStrength" -> "strong",
        "confidenceLevel"    -> 50,
        "credId"             -> "test",
        "enrolments"         -> enrolments.map(key =>
          Json.obj(
            "key"         -> key,
            "identifiers" -> Json.arr(
              Json.obj(
                "key"   -> "UTRNumber",
                "value" -> utr
              )
            ),
            "state"       -> "Activated"
          )
        )
      )
      val client = asyncClient

      val request = client.url(s"$authLoginApiUri/government-gateway/session/login")
      val response = Await.result(
        request.withHttpHeaders("Content-Type" -> "application/json")
          .withFollowRedirects(false)
          .post(json),
        timeout
      )

      response.headers
        .filter(header => header._1.equalsIgnoreCase("Authorization"))
        .values
        .flatMap(_.collect { case s if s.contains("Bearer") => s.replace("Bearer ", "") })
        .head
    }
  }
