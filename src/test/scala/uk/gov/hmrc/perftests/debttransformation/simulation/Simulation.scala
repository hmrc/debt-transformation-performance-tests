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

package uk.gov.hmrc.perftests.debttransformation.simulation
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.debttransformation.requests.*
import uk.gov.hmrc.perftests.debttransformation.requests.ifs.*
import uk.gov.hmrc.perftests.debttransformation.requests.sol.StatementOfLiabilityRequests
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls.*
import uk.gov.hmrc.perftests.debttransformation.utils.FutureAwaits.*

import scala.concurrent.duration.DurationInt

class Simulation extends PerformanceTestRunner {

  if (runLocal) {
    before(
      BaseRequests.createLocalInternalAuthToken()
    )
  }

  implicit val patience: Patience = Patience(15.minutes)

  setup("request-Statement-of-Liability-for-single-debts", "request statement of liability for single debt")
    .withChainedActions(
      StatementOfLiabilityRequests.solAPIRequestWithSingleDebtRequest(statementOfLiabilityApiBaseUrl)
    )

  setup("request-Statement-of-Liability-for-multiple-debts", "request statement of liability for multiple debts")
    .withChainedActions(
      StatementOfLiabilityRequests.statementOfLiabilityRequestFormultipleDebts(statementOfLiabilityApiBaseUrl)
    )

  setup(
    "Multiple-debt-items-with-one-payments-no-breathing-space",
    "Multiple debt items with one payments breathing space"
  )
    .withChainedActions(InterestForecastingRequests.multipleDebtsWithOnePaymentHistory(interestForecostingApiUrl))

  setup(
    "non-interest-bearing-debt-item-with-no-breathing-space",
    "non interest bearing debt item with no breathing space"
  )
    .withChainedActions(
      InterestForecastingRequests.nonInterestBearingDebtItemWithNoBreathingSpace(interestForecostingApiUrl)
    )

  setup(
    "multiple-sa-debt-items-with-payments-and-breathing-spaces",
    "multiple SA debt item with payments and breathing spaces"
  )
    .withChainedActions(
      InterestForecastingRequests.multipleDebtItemsWithPaymentsAndBreathingSpaces(interestForecostingApiUrl)
    )

  setup(
    "multiple-sa-debt-items-with-payments-and-breathing-spaces",
    "multiple sa debt item with payments and breathing spaces"
  )
    .withChainedActions(
      InterestForecastingRequests.multipleDebtItemsWithPaymentsAndBreathingSpaces(interestForecostingApiUrl)
    )

  setup("two-debt-items-with-Leap-year-payment-history", "debt Items With Leap Year PaymentHistory")
    .withChainedActions(InterestForecastingRequests.TwoDebtItemsWithLeapYearPaymentHistory(interestForecostingApiUrl))

  setup("debt-items-with-five-payments-on-one-debt", "debt items with payments one one debt")
    .withChainedActions(InterestForecastingRequests.TwoDebtItemsWithLeapYearPaymentHistory(interestForecostingApiUrl))

  setup("single-debt-instalment-plan-with-initial-payment", "single debt instalment plan with initial payment")
    .withChainedActions(
      InterestForecastingRequests.instalmentPlanWithInitialPayment(interestForecostingApiUrl)
    )

  setup("multiple-debt-instalment-plan", "Multiple debt instalment plan")
    .withChainedActions(
      InterestForecastingRequests.instalmentPlanWithMultipleDebts(interestForecostingApiUrl)
    )

  setup("single-debt-instalment-plan-with-no-initial-payment", "single debt instalment plan with no initial payment")
    .withChainedActions(
      InterestForecastingRequests.instalmentPlanWithNoInitialPayment(interestForecostingApiUrl)
    )
  setup("debt-interest-type", "debt interest type")
    .withChainedActions(InterestForecastingRequests.debtInterestTypeRequest(interestForecostingApiUrl))

  setup("debt-items-with-suppression", "debt items with suppression")
    .withChainedActions(
      SuppressionsRequests.twoOverlappingSuppression(interestForecostingApiUrl),
      SuppressionsRequests.twoPaymentsDuringSuppression(interestForecostingApiUrl),
      SuppressionsRequests.interestRateChangeADuringSuppression(interestForecostingApiUrl),
      SuppressionsRequests.openEndedSuppression(interestForecostingApiUrl),
      SuppressionsRequests.TwoDutiesTwoPaymentsOnSameDaySuppression(interestForecostingApiUrl)
    )

  setup("mainTrans-applied-to-suppression-rules", "subTrans applied to suppression rules")
    .withChainedActions(SuppressionsRequests.mainTransAppliedToSuppressionRules(interestForecostingApiUrl))

  before {
    SuppressionsRequests.deleteSuppressionData()
    SuppressionsRequests.postSuppressionData()
    SuppressionsRequests.postOpenEndedSuppressionData()
    SuppressionsRequests.deleteSuppressionRules()
    SuppressionsRequests.postSuppressionRules()
  }
  runSimulation()
}
