# logintest

System requirements: 
  1. Mac OS Catalina 10.16.1
  2. Eclipse
  3. java version "1.8.0_231"

Steps:
- Ensure that JDK, eclipse appropriate versions of chrome and firefox are installed
- Install TestNG and Maven from help options
- Clone/download repository
- Goto Java build path for project and import all external jar's from ./lib to the eclipse project
- Make following changes to ./scr/com/logintest/config/Browser.properties
  1. Specify location for chromedriver ex. chromelocation=/Users/Downloads/chromedriver
  2. Specify location for firefoxdriver ex. firefoxlocation=/Users/Downloads/geckodriver
  3. Specify browser to use on each test case at last column of testdata at testdata=./src/com/logintest/resources/LoginTestData.xlsx

- Right-click and run com.logintest.testscripts.LoginTest.java using TestNG
- After completion of test check following
  1. Failed screenshots at :   ./DDMMYYYY/****.png
  2. HTML log at           :   ./test-output/default test.html
