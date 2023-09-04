# Global Blue Homework - Calkoo Vat Calculator Test Automation

## This is my solution for automating tests for Calkoo's Vat calulator (https://www.calkoo.com/en/vat-calculator)

For this project, I used Page-Object Model (POM), I separated the elements and Selenium code from the test cases.
+ Used singleton pattern for Webdriver to make sure only one instance is invoked during test runs
+ I made a test case to check if the webpage is loaded
+ And several test cases for a randomly selected country to test it's functioning correctly

## Prerequisites
+ Maven

## Technologies used
+ Java 17
+ Selenium with Webdrivermanager (Chromedriver)
+ Junit5

## Challenges & Issues

1. This website has a lot of intrusive ads, which was a challenge to resolve, as it blocked other elements I needed to access for automation. 
2. The radio buttons were tricky to interact with, I kept getting "Element not interactable" error with normal Selenium code, so I had to use JavaScriptExecutor to resolve this.
3. I wanted to use dynamic selection for VAT percent radio buttons, in which I wanted to provide a number as an argument in a single method. I tried multiple solutions, but the elements never got found this way.

## Bugs
+ I provided bug reports in "Global-Blue-Homework-Calkoo-BRreka/src/test/java/bugReports/" directory

## Example for manual test only
+ The pie chart has no reliable way of selection, I would only test this manually.

## Update
I re-checked the tests a few hours after the link was sent, and noticed there was a pop-up for data-usage consent
for cookies, which I've never seen during working on this project. This might have been some sort of bug for me, 
or something new, I will never know. I included the Selenium code to deal with the issue, which might make 
the bug report of the Element Interception Error not actual anymore, as the test cases ran without any issue.