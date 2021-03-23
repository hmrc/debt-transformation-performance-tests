package uk.gov.hmrc.perftests.debttransformation.feeders

import scala.util.Random

object StridePidGenerator {

  val reviewerPidGenerator: Iterator[Map[String, String]] = {
    Iterator.continually(Map("reviewerStridePID" -> Random.nextInt().toString))
  }
}
