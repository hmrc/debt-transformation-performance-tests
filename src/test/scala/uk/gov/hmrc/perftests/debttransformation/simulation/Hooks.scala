package uk.gov.hmrc.perftests.debttransformation.simulation

import uk.gov.hmrc.perftests.debttransformation.requests._
import uk.gov.hmrc.perftests.debttransformation.requests.ifs.SuppressionsRequests
import uk.gov.hmrc.perftests.debttransformation.utils.BaseUrls.interestForecostingApiUrl

class Hooks extends Simulation {

  before {
    setup("add-suppression-data", "add suppression data")
      .withChainedActions(
        SuppressionsRequests.deleteSuppressionData(interestForecostingApiUrl),
        SuppressionsRequests.addSuppressionData("djdjd"),
        SuppressionsRequests.getSuppressionData(interestForecostingApiUrl)
      )

    setup("add-suppression-rules", "add suppression rules")
      .withChainedActions(
        SuppressionsRequests.deleteSuppressionRules(interestForecostingApiUrl),
        SuppressionsRequests.addSuppressionRules(interestForecostingApiUrl),
        SuppressionsRequests.retrieveSuppressionRules(interestForecostingApiUrl)
      )

  }
}
