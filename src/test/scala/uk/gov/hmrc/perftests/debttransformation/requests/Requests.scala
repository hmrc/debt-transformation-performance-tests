package uk.gov.hmrc.perftests.debttransformation

import io.gatling.core.action.builder.ActionBuilder
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.Configuration
import uk.gov.hmrc.performance.simulation.JourneyPart

package object requests extends Configuration {

  implicit def convertChainToActions(chain: ChainBuilder): Seq[ActionBuilder] = chain.actionBuilders

  implicit def convertHttpActionToSeq(act: HttpRequestBuilder): Seq[ActionBuilder] = Seq(HttpRequestBuilder.toActionBuilder(act))

  implicit def convertActionToSeq(act: ActionBuilder): Seq[ActionBuilder] = Seq(act)

  implicit class AugmentJourneyParts(j: JourneyPart) {
    def withChainedActions(builders: Seq[ActionBuilder]*): JourneyPart = j.withActions(builders.flatten: _*)
  }
}
