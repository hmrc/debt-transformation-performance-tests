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
import uk.gov.hmrc.perftests.debttransformation.requests.ifs._
import uk.gov.hmrc.perftests.debttransformation.requests.sol.StatementOfLiabilityRequests
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls._
import uk.gov.hmrc.perftests.debttransformation.utils.FutureAwaits._

import scala.concurrent.duration._

class Simulation extends PerformanceTestRunner {

  implicit val patience: Patience = Patience(15.minutes)

  setup("request-Statement-of-Liability-for-single-debts", "request statement of liability for single debt")
    .withChainedActions(
      StatementOfLiabilityRequests.solAPIRequestWithSingleDebtRequest(statementOfLiabilityApiBaseUrl)
    )

  setup("request-Statement-of-Liability-for-multiple-debts", "request statement of liability for multiple debts")
    .withChainedActions(
      StatementOfLiabilityRequests.statementOfLiabilityRequestFormultipleDebts(statementOfLiabilityApiBaseUrl)
    )

  setup("Multiple-debt-items-with-no-payments-breathing-space", "Multiple debt items with no payments breathing space")
    .withChainedActions(InterestForecastingRequests.multipleDebtsWithNoPaymentHistory(interestForecostingApiUrl))

  setup("open-ended-breathingSpaces-for-a-single-debt-no-payments", "open ended breathingSpaces for a single debt no payments")
    .withChainedActions(InterestForecastingRequests.debtItemWithOpenEndedBreathingSpace(interestForecostingApiUrl))

  setup("breathing-space-applied-to-a-single-debt-with-no-payments", "Breathing Space applied to a single debt no payments")
    .withChainedActions(InterestForecastingRequests.breathingSpaceAppliedToAsingleDebtWithNoPayments(interestForecostingApiUrl))

  setup(
    "non-interest-bearing-debt-item-with-no-breathing-space",
    "non interest bearing debt item with no breathing space")
    .withChainedActions(InterestForecastingRequests.nonInterestBearingDebtItemWithNoBreathingSpace(interestForecostingApiUrl))

  setup("two-debt-items-with-Leap-year-payment-history", "debt Items With Leap Year PaymentHistory")
    .withChainedActions(InterestForecastingRequests.TwoDebtItemsWithLeapYearPaymentHistory(interestForecostingApiUrl))

  setup("debt-items-with-five-payments-on-one-debt", "debt items with payments one one debt")
    .withChainedActions(InterestForecastingRequests.TwoDebtItemsWithLeapYearPaymentHistory(interestForecostingApiUrl))

  setup("two-leap-year-debt-items-with-payment-history", "two leap year debt items with payment history")
    .withChainedActions(InterestForecastingRequests.LeapYearsdebtItemsWithPaymentHistory(interestForecostingApiUrl))

  setup("add-suppression-data", "add suppression data")
    .withChainedActions(
      SuppressionsRequests.deleteSuppressionData(interestForecostingApiUrl),
      SuppressionsRequests.addSuppressionData(interestForecostingApiUrl),
      SuppressionsRequests.getSuppressionData(interestForecostingApiUrl))


  setup("add-suppression-rules", "add suppression rules")
    .withChainedActions(
      SuppressionsRequests.deleteSuppressionRules(interestForecostingApiUrl),
      SuppressionsRequests.addSuppressionRules(interestForecostingApiUrl),
      SuppressionsRequests.retrieveSuppressionRules(interestForecostingApiUrl))


  setup("debt-items-with-suppression", "debt items with suppression")
    .withChainedActions(
      SuppressionsRequests.interestRateChangeBeforeSuppression(interestForecostingApiUrl),
      SuppressionsRequests.interestRateChangeAfterSuppression(interestForecostingApiUrl),
      SuppressionsRequests.interestRateChangeADuringSuppression(interestForecostingApiUrl),
      SuppressionsRequests.openEndedSuppression(interestForecostingApiUrl),
      SuppressionsRequests.paymentBeforeSuppression(interestForecostingApiUrl))

  setup("subTrans-applied-to-suppression-rules", "sunTrans applied to suppression rules")
    .withChainedActions(
      SuppressionsRequests.deleteSuppressionRules(interestForecostingApiUrl),
      SuppressionsRequests.sunTransAppliedToSuppressionRules(interestForecostingApiUrl))

  runSimulation()
}
