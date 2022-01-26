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
import scala.concurrent.duration._
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.debttransformation.requests._
import uk.gov.hmrc.perftests.debttransformation.requests.ifs.{FieldCollection_InterestForecastingRequests, SuppressionsRequests, _}
import uk.gov.hmrc.perftests.debttransformation.requests.sol.{FCStatementOfLiabilityRequests, StatementOfLiabilityRequests}
import uk.gov.hmrc.perftests.debttransformation.requests.ttp.TimeToPayProxyRequests
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls._
import uk.gov.hmrc.perftests.debttransformation.utils.FutureAwaits._

class Simulation extends PerformanceTestRunner {

  implicit val patience: Patience = Patience(15.minutes)

  setup("ttp-proxy-generate-quote", "ttp proxy generate quote")
    .withChainedActions(
      TimeToPayProxyRequests.ttpGenerateAnnualFrequencyQuote(timeToPayProxyBaseUrl)
    )

  setup("ttp-proxy-update-quote-plan", "ttp proxy update quote plan")
    .withChainedActions(
      TimeToPayProxyRequests.updatePlan(timeToPayProxyBaseUrl)
    )

  setup("ttp-proxy-create-plan", "ttp proxy create plan")
    .withChainedActions(TimeToPayProxyRequests.createPlan(timeToPayProxyBaseUrl)
    )

  setup("ttp-proxy-view-quote-plan", "ttp-proxy view quote plan")
    .withChainedActions(
      TimeToPayProxyRequests.viewQuotePlan(timeToPayProxyBaseUrl)
    )

  setup("request-Statement-of-Liability-for-single-debts", "request statement of liability for single debt")
    .withChainedActions(
      StatementOfLiabilityRequests.solAPIRequestWithSingleDebtRequest(statementOfLiabilityApiBaseUrl)
    )

  setup("request-Statement-of-Liability-for-multiple-debts", "request statement of liability for multiple debts")
    .withChainedActions(
      StatementOfLiabilityRequests.statementOfLiabilityRequestFormultipleDebts(statementOfLiabilityApiBaseUrl)
    )

  setup("request-fc-sol-for-single-debts", "request statement of liability for single debt")
    .withChainedActions(
      FCStatementOfLiabilityRequests.fcSolAPIRequestWithSingleDebtRequest(statementOfLiabilityApiBaseUrl)
    )
  setup("request-fc-sol-for-multiple-debts", "request statement of liability for multiple debt")
    .withChainedActions(
      FCStatementOfLiabilityRequests.fcSolRequestFormultipleDebts(statementOfLiabilityApiBaseUrl)
    )
  setup("request-fc-sol-for-single-debt-with-no-payment-history", "request statement of liability for single debt with no payment history")
    .withChainedActions(
      FCStatementOfLiabilityRequests.fcSolAPIRequestWithNoPaymentHistory(statementOfLiabilityApiBaseUrl)
    )

  setup("Multiple-debt-items-with-one-payments-no-breathing-space", "Multiple debt items with one payments breathing space")
    .withChainedActions(InterestForecastingRequests.multipleDebtsWithOnePaymentHistory(interestForecostingApiUrl))

  setup(
    "non-interest-bearing-debt-item-with-no-breathing-space",
    "non interest bearing debt item with no breathing space")
    .withChainedActions(InterestForecastingRequests.nonInterestBearingDebtItemWithNoBreathingSpace(interestForecostingApiUrl)
    )

  setup(
    "single-debt-item-with-payment-history",
    "single debt item with single payment history")
    .withChainedActions(FieldCollection_InterestForecastingRequests.singleDebtItem(interestForecostingApiUrl)
    )

  setup(
    "multiple-debt-item-with-multiple-payment-history",
    "multiple debt item with multiple payment history")
    .withChainedActions(FieldCollection_InterestForecastingRequests.multipleDebtItems(interestForecostingApiUrl)
    )

  setup(
    "multiple-debt-item-with-single-payment-history",
    "multiple debt item with single payment history")
    .withChainedActions(FieldCollection_InterestForecastingRequests.multipleDebtItemsWithSinglePaymentHistory(interestForecostingApiUrl)
    )

  setup(
    "single-debt-item-with-no-interest-indicator",
    "single debt item with no interest indicator")
    .withChainedActions(FieldCollection_InterestForecastingRequests.singleDebtItemWithNoInterestIndicator(interestForecostingApiUrl)
    )

  setup(
    "single-debt-item-with-no-payment-history",
    "single debt item with no payment history")
    .withChainedActions(FieldCollection_InterestForecastingRequests.singleDebtItemWithNoPaymentHistory(interestForecostingApiUrl)
    )

  setup(
    "multiple-debt-item-with-leap-year-payment-history",
    "multiple debt item with single leap year payment history")
    .withChainedActions(FieldCollection_InterestForecastingRequests.multipleDebtItemWithLeapYearPaymentHistory(interestForecostingApiUrl)
    )

  setup(
    "multiple-debt-item-with-all-fields-happy-path",
    "multiple debt item with all fields in the request")
    .withChainedActions(FieldCollection_InterestForecastingRequests.happyPathmultipleDebtItemWithAllFields(interestForecostingApiUrl)
    )

  setup(
    "single-vat-debt-item-with-single-payment",
    "Single Vat Debt Item with single payment")
    .withChainedActions(FieldCollection_Vat_InterestForecastingRequests.singleDebtItem(interestForecostingApiUrl)
    )

  setup(
    "multiple-vat-debt-item-with-payment-history",
    "Multiple Vat Debt Item with Payment History")
    .withChainedActions(FieldCollection_Vat_InterestForecastingRequests.multipleDebtItems(interestForecostingApiUrl)
    )

  setup(
    "multiple-vat-debt-item-with-single-payment-history",
    "Multiple VAT Debt Item with Single Payment History")
    .withChainedActions(FieldCollection_Vat_InterestForecastingRequests.multipleDebtItemsWithSinglePaymentHistory(interestForecostingApiUrl)
    )

  setup(
    "single-vat-debt-item-with-payment-history-and-no-interest-indicator",
    "Single Vat Debt Item with Payment History and No interest indicator")
    .withChainedActions(FieldCollection_Vat_InterestForecastingRequests.singleVatDebtItemWithNoInterestIndicator(interestForecostingApiUrl)
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
