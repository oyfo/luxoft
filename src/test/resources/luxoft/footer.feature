Feature: Tests regarding footer section

	@skip_scenario
  Scenario Outline: Bottom footer is visible
   	Given I open "<page>" and verify header "<header>"
   	Then footer is available
 

    Examples: 
      | page  | header |
      | https://www.ubs.com/global/en/wealth-management/life-goals.html 						| Your life goals 			|
      | https://www.ubs.com/global/en/wealth-management/our-service.html 						| Our service 					|
      | https://www.ubs.com/global/en/wealth-management/our-approach.html 					| Our approach 					|
      | https://www.ubs.com/global/en/wealth-management/sustainable-investing.html 	| Invest for good 			|
      | https://www.ubs.com/global/en/wealth-management/about-us.html 							| About us 							|		
      | https://www.ubs.com/global/en/wealth-management/our-approach.html 					| Our approach 					|
      | https://www.ubs.com/global/en/wealth-management/international-banking.html 	| International banking |
      | https://www.ubs.com/global/en/wealth-management/asset-servicing.html 				| Asset Servicing 			|