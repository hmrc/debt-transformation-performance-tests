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

package uk.gov.hmrc.perftests.debttransformation.utils

import org.apache.pekko.actor.ActorSystem
import com.typesafe.scalalogging.LazyLogging
import org.apache.pekko.util.ByteString
import play.api.libs.json.{JsValue, Json}
import play.api.libs.ws._
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import scala.concurrent.Await
import scala.concurrent.duration._

object WsClient extends LazyLogging {
  val timeout: FiniteDuration = 60 seconds

  implicit val bodyWrites: BodyWritable[JsValue] =
    BodyWritable(a => InMemoryBody(ByteString.fromArrayUnsafe(Json.toBytes(a))), "application/json")
  private val asyncClient: StandaloneAhcWSClient = {
    implicit val system: ActorSystem = ActorSystem()
    StandaloneAhcWSClient()
  }

  def post(uri: String, headers: Map[String, String], json: JsValue): StandaloneWSResponse = {
    println("")
    logger.info(s"POST request URI: $uri")
    logger.debug(s"POST request headers: $headers")
    logger.debug(s"POST request body: $json")

    val client   = asyncClient
    val request  = client.url(uri)
    val response = Await.result(
      request
        .withHttpHeaders(headers.toSeq: _*)
        .withFollowRedirects(false)
        .post(json),
      timeout
    )

    println("")
    logger.debug(s"POST response status: ${response.status}")
    logger.debug(s"POST response headers: ${response.headers}")
    logger.debug(s"POST response body: ${response.body}")

    response
  }

  def delete(uri: String, headers: Map[String, String]): StandaloneWSResponse = {
    println("")
    logger.info(s"DELETE request URI: $uri")
    logger.debug(s"DELETE request headers: $headers")

    val client   = asyncClient
    val request  = client.url(uri)
    val response = Await.result(
      request
        .withHttpHeaders(headers.toSeq: _*)
        .withFollowRedirects(false)
        .delete(),
      timeout
    )

    println("")
    logger.debug(s"DELETE response status: ${response.status}")
    logger.debug(s"DELETE response headers: ${response.headers}")
    logger.debug(s"DELETE response body: ${response.body}")

    response
  }

}
