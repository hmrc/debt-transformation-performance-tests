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
