package uk.gov.hmrc.perftests.debttransformation.requests

import play.api.libs.json.Json
import scalaj.http.Http
import uk.gov.hmrc.perftests.debttransformation.utils.RandomValues

object BaseRequests extends RandomValues {

  def creatAuthorizationBearerToken(
    enrolments: Seq[String] = Seq(),
    userType: String = getRandomAffinityGroup,
    utr: String = "123456789012"
  ): String = {
    val json =
      Json.obj(
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

    val response        = Http("http://localhost:8585/government-gateway/session/login")
      .postData(Json.stringify(json))
      .header("Content-Type", "application/json")
    val (_, authHeader) = response.headers.filter(header => header._1.equalsIgnoreCase("Authorization")).head
    val authBearerToken = authHeader.replace("Bearer ", "")
    authBearerToken

    //    val response = Http("http://localhost:8585/government-gateway/session/login")
    //      .postData(
    //        s""" {
    //           |	"affinityGroup": "Individual",
    //           |	"Email": "user@test.com",
    //           |	"credentialStrength": "strong",
    //           |	"confidenceLevel": 50,
    //           |	"credId": "test",
    //           |	"enrolments": [{
    //           |		"key": "read:statement-of-liability",
    //           |		"identifiers": [{
    //           |			"key": "UTR",
    //           |			"value": "123456789012"
    //           |		}],
    //           |		"state": "Activated"
    //           |	}]
    //           |}
    //           |""".stripMargin).header("Content-Type", "application/json")
    //      .option(HttpOptions.readTimeout(10000))
    //      .asString
    //    val authHeader: (String, Seq[String]) = response.headers.filter(_._1.equalsIgnoreCase("Authorization")).head
    //    val authBearerToken = authHeader._2.head.replace("Bearer ", "")
    //    authBearerToken
  }

}
