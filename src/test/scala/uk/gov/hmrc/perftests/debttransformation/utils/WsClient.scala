package uk.gov.hmrc.perftests.debttransformation.utils

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.util.ByteString
import com.typesafe.scalalogging.LazyLogging
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
    implicit val system: ActorSystem             = ActorSystem()
    implicit val materializer: ActorMaterializer = ActorMaterializer()

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
