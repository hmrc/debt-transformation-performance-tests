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

package uk.gov.hmrc.perftests.debttransformation.utils

import uk.gov.hmrc.performance.conf.ServicesConfiguration

object BaseUrls extends ServicesConfiguration {
  val authLoginApiUri: String                = baseUrlFor("auth-login-api")
  val auth: String                           = baseUrlFor("auth")
  val authLoginStubUri: String               = baseUrlFor("auth-login-stub")
  val apiSubscriptionFieldsUri: String       = baseUrlFor("api-subscription-fields")
  val pushPullNotificationsUri: String       = baseUrlFor("push-pull-notifications-api")
  val strideIdpStubUrl: String               = baseUrlFor("stride-idp-stub")
  val strideAuthFrontendUrl: String          = baseUrlFor("stride-auth-frontend")
  val statementOfLiabilityApiBaseUrl: String = baseUrlFor("statement-of-liability")
  val timeToPayProxyBaseUrl: String = baseUrlFor("time-to-pay-proxy")
  val interestForecostingApiUrl: String      = baseUrlFor("interest-forecasting")
}
