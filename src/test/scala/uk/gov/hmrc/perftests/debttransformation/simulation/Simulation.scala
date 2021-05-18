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
    "hello-world-response-from-statement-of-liability-service",
    "hello world response from statement of liability service"
  )
    .withChainedActions(StatementOfLiabilityRequests.statementOfLiabilityHelloWorld(statementOfLiabilityApiBaseUrl))

  setup("request-Statement-of-Liability-for-single-debts", "request statement of liability for single debt")
    .withChainedActions(
      StatementOfLiabilityRequests.solAPIRequestWithSingleDebtRequest(statementOfLiabilityApiBaseUrl)
    )

  setup("request-Statement-of-Liability-for-multiple-debts", "request statement of liability for multiple debts")
    .withChainedActions(
      StatementOfLiabilityRequests.statementOfLiabilityRequestFormultipleDebts(statementOfLiabilityApiBaseUrl)
    )

  setup("Multiple-debt-items-with-payments", "Multiple debt items with payments")
    .withChainedActions(
      InterestForecastingRequests.InterestBearingForMultipleDebtsAndPayment(interestForecostingApiUrl)
    )

  setup(
    "debt-item-touching-two-leap-years-with-payment-history",
    "debt item touching two leap years with payment history"
  )
    .withChainedActions(
      InterestForecastingRequests.debtItemInterestRateChangeWithPaymentHistory(interestForecostingApiUrl)
    )

  setup("Debt-touching-two-leap-years-with-no-payment-history", "Debt touching two leap years with no payment history")
    .withChainedActions(
      InterestForecastingRequests.debtItemInterestRateChangeWithNoPaymentHistory(interestForecostingApiUrl)
    )

  runSimulation()
}
