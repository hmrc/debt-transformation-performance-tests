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
import uk.gov.hmrc.perftests.debttransformation.requests.{InterestForecastingRequests, _}
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls._
import uk.gov.hmrc.perftests.debttransformation.utils.FutureAwaits._

import scala.concurrent.duration._

class Simulation extends PerformanceTestRunner {

  implicit val patience: Patience = Patience(15.minutes)

  setup(
    "back-end-processes-retrieve-hello-world-response-from-Statement-of-Liability-Service",
    "Back-end-processes for Statement of Liability Service Hello World test")
    .withChainedActions(StatementOfLiabilityRequests.statementOfLiabilityHelloWorld(statementOfLiabilityApiBaseUrl))


  setup(
    "request-Statement-of-Liability-for-multiple-debts",
    "request statement of liability for multiple debts")
    .withChainedActions(StatementOfLiabilityRequests.statementOfLiabilityRequestFormultipleDebts(statementOfLiabilityApiBaseUrl))


  setup(
    "Interest-start-date-before-debt-created-multiple-payment-for-a-debt",
    "Interest start date before debt created multiple payment for a debt"
  )
    .withChainedActions(
      InterestForecastingRequests.InterestBearingDebtCalculationForMultiplePayment(interestForecostingApiUrl))
  setup(
    "interest-bearing-with-multiple-debt-item-calcultions-and-breathing-space",
    "interest bearing with multiple debt item calculation and breathing space")
    .withChainedActions(
      InterestForecastingRequests.debtItemInterestRateChangeWithPaymentHistory(interestForecostingApiUrl),
      InterestForecastingRequests.debtItemInterestrateChangeWithNoPaymentHistory(interestForecostingApiUrl))

  setup(
    "reference-data-interest-bearing-tpss-maintrans-subtrans",
    "reference data interest bearing tpss maintrans subtran")
    .withChainedActions(
      InterestForecastingRequests.referenceDataInterestBearingTPSSMainTrans1530SubTrans1000(interestForecostingApiUrl),
      InterestForecastingRequests.referenceDataInterestBearingTPSSMainTrans1535SubTrans1000(interestForecostingApiUrl),
      InterestForecastingRequests.referenceDataInterestBearingTPSSMainTrans1540SubTrans1000(interestForecostingApiUrl))

  runSimulation()
}
