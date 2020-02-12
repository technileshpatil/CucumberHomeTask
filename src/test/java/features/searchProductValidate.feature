#Author: NILESH PATIL
#Feature Reviewer: JANNE AND TIMO
#Date: 2020-02-12
#Keywords Summary : Create Selenium Web browser test using cucumber scenarios for amazon.com 
#Feature: Search Nikon products on Amazon Website
#Scenario: Search the product and verify the availability of expected product
#Given: Amazon.com
#When: Search Nikon and sort results from highest price to lowest.
#Then: Select second product and click it for details.
#And,But: From details check (verify with assert) that product topic contains text “Nikon D3X”
#Background: User is on Amazon home page
@searchProductValidate
Feature: Open Amazon Shopping Website and Search Nikon Products
  As a user of Amazon
  I want to be able to search for product using keywords

  Scenario Outline: Search Product Details which is present
  	Given Initialize the browser with chrome
  	And Navigate to "http://www.amazon.com" Site
  	Then I should see Search box
    When I fill in search input as <searchkeyword> and press Search button
    And I get List of <searchkeyword> Products
    And I Select Option 'Price: High to Low'
    And I Select Second Product in List
    Then I can see Product Title Containing 'Nikon D3X'
    And close browsers

    Examples:
    |searchkeyword|
    |Nikon|