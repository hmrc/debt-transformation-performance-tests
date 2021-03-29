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

package uk.gov.hmrc.perftests.debttransformation.simulation
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.debttransformation.requests._
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls._
import uk.gov.hmrc.perftests.debttransformation.utils.FutureAwaits._

import scala.concurrent.duration._

class Simulation extends PerformanceTestRunner {

  implicit val patience: Patience = Patience(15.minutes)



  setup(
    "back-end-processes-retrieve-hello-world-response-from-Statement-of-Liability-Service",
    "Back-end-processes for Statement of Liability Service Hello World test"
  )
    .withChainedActions(StatementOfLiabilityRequests.statementOfLiabilityHelloWorld(statementOfLiabilityApiBaseUrl))

  setup(
    "back-end-interest-bearing-drier-debt-MVP",
    "Back end interest bearing DRIER debt -MVP"
  )
    .withChainedActions(InterestForecastingRequests.InterestBearingdrierdebtForChargeTypeNino(interestForecostingApiUrl))

  setup(
    "backend-non-interest-bearing-drier-debt-MVP",
    "backend non interest bearing drier debt MVP"
  )
    .withChainedActions(InterestForecastingRequests.nonInterestBearingDrierdebtForChargeTypeHIPG(interestForecostingApiUrl))

  runSimulation()
}
