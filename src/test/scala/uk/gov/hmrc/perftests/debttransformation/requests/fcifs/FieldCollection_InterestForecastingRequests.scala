package uk.gov.hmrc.perftests.debttransformation.requests.fcifs

import java.time.LocalDate

import io.gatling.core.Predef._
import io.gatling.http.Predef.{http, status, _}
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.debttransformation.requests.BaseRequests

object FieldCollection_InterestForecastingRequests extends ServicesConfiguration {
  var quoteDate = LocalDate.now().toString
  var instalmentDate = LocalDate.now().plusDays(1).toString
  var initialPaymentDate = LocalDate.now().plusDays(1).toString
  val bearerToken = BaseRequests.creatAuthorizationBearerToken(enrolments = Seq("read:interest-forecasting"))
  val requestHeaders = Map(
    "Authorization" -> s"Bearer $bearerToken",
    "Accept" -> "application/vnd.hmrc.1.0+json",
    "Content-Type" -> "application/json"
  )


  val SingleDebtItemWithPaymentHistory: String =
    s"""{
       |  "debtItems": [
       |         {
       |          "debtItemChargeId": "123",
       |          "originalAmount": 500000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "Y",
       |          "interestStartDate": "2020-12-16",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 500000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     }
       |
       |
       |  ],
       |
       |  "customerPostcodes": [
       |
       |  ],
       |
       |   "breathingSpaces": [
       |
       |    ]
       |}""".stripMargin

  def singleDebtItem(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with Payment History and No customer postcodes and breathing spaces")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(SingleDebtItemWithPaymentHistory))
      .check(status.is(200))

  val MultipleDebtItemWithPaymentHistory: String =
    s"""
       |{
       |  "debtItems": [
       |         {
       |          "debtItemChargeId": "123",
       |          "originalAmount": 500000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "Y",
       |          "interestStartDate": "2020-12-16",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 200000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     },
       |     {
       |          "debtItemChargeId": "456",
       |          "originalAmount": 100000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "Y",
       |          "interestStartDate": "2020-12-16",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 5000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     }
       |
       |
       |  ],
       |
       |  "customerPostcodes": [
       |
       |  ],
       |
       |   "breathingSpaces": [
       |
       |    ]
       |
       |}
       |
       |""".stripMargin

  def multipleDebtItems(baseUri: String): HttpRequestBuilder =
    http("Multiple Debt Item with Payment History and No customer postcodes and breathing spaces")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtItemWithPaymentHistory))
      .check(status.is(200))

  val MultipleDebtItemWithSinglePaymentHistory: String =
    s"""
       |{
       |  "debtItems": [
       |         {
       |          "debtItemChargeId": "123",
       |          "originalAmount": 500000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "Y",
       |          "interestStartDate": "2020-12-16",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 200000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     },
       |     {
       |          "debtItemChargeId": "456",
       |          "originalAmount": 100000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "Y",
       |          "interestStartDate": "2020-12-16",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |
       |          ]
       |     }
       |
       |
       |  ],
       |
       |  "customerPostcodes": [
       |
       |  ],
       |
       |   "breathingSpaces": [
       |
       |    ]
       |
       |}
       |
       |""".stripMargin

  def multipleDebtItemsWithSinglePaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Multiple Debt Item with Single Payment History and No customer postcodes and breathing spaces")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtItemWithSinglePaymentHistory))
      .check(status.is(200))


  val SingleDebtItemWithNoInterestIndicator: String =
    s"""{
       |  "debtItems": [
       |         {
       |          "debtItemChargeId": "123",
       |          "originalAmount": 500000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "N",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 500000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     }
       |
       |
       |  ],
       |
       |  "customerPostcodes": [
       |
       |  ],
       |
       |   "breathingSpaces": [
       |
       |    ]
       |}""".stripMargin

  def singleDebtItemWithNoInterestIndicator(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with Payment History and No interest indicator")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(SingleDebtItemWithNoInterestIndicator))
      .check(status.is(200))

  val SingleDebtItemWithNoPaymentHistory: String =
    s"""{
       |  "debtItems": [
       |         {
       |          "debtItemChargeId": "123",
       |          "originalAmount": 500000,
       |          "workItemType": "1520",
       |          "subType": "1090",
       |          "interestIndicator": "N",
       |          "interestRequestedTo": "2021-04-14",
       |
       |          "paymentHistory": [
       |          		         {
       |      		  "paymentAmount": 500000,
       |      		  "paymentDate" :"2019-02-03"
       |      	}
       |
       |          ]
       |     }
       |
       |
       |  ],
       |
       |  "customerPostcodes": [
       |
       |  ],
       |
       |   "breathingSpaces": [
       |
       |    ]
       |}""".stripMargin

  def singleDebtItemWithNoPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with No Payment History")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(SingleDebtItemWithNoPaymentHistory))
      .check(status.is(200))


  val MultipleDebtItemsWithLeapYearPaymentHistory: String =
    s"""
       |{
       |   "debtItems":[
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestStartDate":"2018-06-01",
       |         "interestRequestedTo":"2021-03-31",
       |         "paymentHistory":[
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2019-03-15"
       |            },
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2020-04-15"
       |            }
       |         ]
       |      },
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestStartDate":"2009-01-01",
       |         "interestRequestedTo":"2010-01-01",
       |         "paymentHistory":[
       |
       |         ]
       |      }
       |   ],
       |   "customerPostcodes":[
       |
       |   ],
       |   "breathingSpaces":[
       |
       |   ]
       |}
       |""".stripMargin

  def multipleDebtItemWithLeapYearPaymentHistory(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with No Payment History")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtItemsWithLeapYearPaymentHistory))
      .check(status.is(200))


  val MultipleDebtItemsWithAllFieldsHappyPathTest: String =
    s"""
      {
       |   "debtItems":[
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestStartDate":"2018-06-01",
       |         "interestRequestedTo":"2021-03-31",
       |         "paymentHistory":[
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2019-03-15"
       |            },
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2020-04-15"
       |            }
       |         ]
       |      },
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestStartDate":"2009-01-01",
       |         "interestRequestedTo":"2010-01-01",
       |         "paymentHistory":[
       |
       |         ]
       |      }
       |   ],
       |   "customerPostCodes":[
       |      {
       |         "addressPostcode":"NW9 5XW",
       |         "postcodeDate":"2021-04-06"
       |      }
       |   ],
       |   "breathingSpaces":[
       |      {
       |         "debtRespiteFrom":"2020-04-06",
       |         "debtRespiteTo":"2021-04-06"
       |      }
       |   ]
       |}""".stripMargin

  def happyPathmultipleDebtItemWithAllFields(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with No Payment History")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtItemsWithAllFieldsHappyPathTest))
      .check(status.is(200))

  val MultipleDebtItemsWithMissingInterestStartDate: String =
    s"""
      {
       |   "debtItems":[
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestRequestedTo":"2021-03-31",
       |         "paymentHistory":[
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2019-03-15"
       |            },
       |            {
       |               "paymentAmount":100000,
       |               "paymentDate":"2020-04-15"
       |            }
       |         ]
       |      },
       |      {
       |         "debtItemChargeId":"123",
       |         "originalAmount":500000,
       |         "workItemType":"1520",
       |         "subType":"1090",
       |         "interestIndicator":"Y",
       |         "interestStartDate":"2009-01-01",
       |         "interestRequestedTo":"2010-01-01",
       |         "paymentHistory":[
       |
       |         ]
       |      }
       |   ],
       |   "customerPostCodes":[
       |      {
       |         "addressPostcode":"NW9 5XW",
       |         "postcodeDate":"2021-04-06"
       |      }
       |   ],
       |   "breathingSpaces":[
       |      {
       |         "debtRespiteFrom":"2020-04-06",
       |         "debtRespiteTo":"2021-04-06"
       |      }
       |   ]
       |}""".stripMargin

  def multipleDebtItemWithMissingInterestStartDate(baseUri: String): HttpRequestBuilder =
    http("Single Debt Item with No Payment History")
      .post(s"$baseUri/fc-debt-calculation")
      .headers(requestHeaders)
      .body(StringBody(MultipleDebtItemsWithMissingInterestStartDate))
      .check(status.is(400))


}