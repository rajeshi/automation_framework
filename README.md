# Test Automation Framework
This document talks about how to use the Test Automation Framework for testing the ZipGo Web, Mobile and API application.

## Introduction
The Test Automation Framework allows you to create the tests for:
* Web Applications which can be run on following browsers:
  * Chrome
  * Firefox
  * Edge Driver
  * Internet Explorer 11
* Mobile Apps including:
  * Native Android
  * Android Web
  * Native iOS (Need to be tested)
  * iOS Web
* RESTFul APIs

## Framework Block Diagram
## ---TODO---

## Pre-requisite Tools and Technologies
* Java JDK 1.8 Above
* Java IDE like Eclipse, Netbeans or IntelliJ IDEA
* Maven Environment (Should be present in Netbeans and IntelliJ IDEA out of the box. For Eclipse, plugin might be required to be installed)
* GIT SCM for pull and pushing the code

## Technology Stack
* Java JDK 1.8 above
* Maven 3.5 above
* TestNG 6.11
* Rest-Assured 3.0.3
* Appium 4.1.2
* Mongo Driver 2.14.3
* Selenium WebDriver 3.4

## Setup Info
* Clone the project from the following repository: https://github.com/zipgo/autoscripts.git
* Download the Web Drivers for Chrome, Firefox and IE in the following path:
 * Chrome:	https://sites.google.com/a/chromium.org/chromedriver/downloads
 * Edge:	https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
 * Firefox:	https://github.com/mozilla/geckodriver/releases
* Place these exe's on the D: of your machine (If you are using Linux, this won't work, I am going to make this path configurable in the next framework release)
* Run the command:
```
mvn clean install
```
* This should generate run the test and create a har file and create a test.har file in E:(If you do not have a E Drive, then the test will fail) (Will be fixed in my next release)

## How to create you scripts
## --- TODO ---
