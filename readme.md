Appium is an open source, cross-platform test automation tool for native, hybrid and mobile web apps, tested on simulators (iOS), emulators (Android), and real devices (iOS, Android).

Hybrid Test framework is a concept where we are using advantage of both Keyword(stores the common Reusable functions) and Data driven framework(test data is generated from some external files like excel, csv, XML or some database table).

Page Object model is an object design pattern, where web pages are represented as classes, and the various elements on the page are defined as variables on the class. All possible user interactions can then be implemented as methods on the class.

Object Repository: A collection of key-value pairs, with the key being a logical name identifying the object and the value containing unique objects properties used to identify the object on a screen.

Project created is a combination of Maven Project + Testng + Appium.
The project created with a hybrid framework, supports page object pattern.

**List of TestCases Automated:**

TestSignup

TestMovieTicketBooking

TestOfferAndPromoCodes

TestReferrelEarn

TestSaveAddress

TestSetReminder

**Packages in framework:**

com.niki.common - Contains the class files that are common for all test class eg, reading data from excel, properties file.

com.niki.keyword - Collection of all keywords in Appium as methods in a class, that can be reused in code wherever required.

com.niki.test - Contains all the test classes.

com.niki.ui - Caontains class for all pages in application.

**Additional data provided as input data is available in input_data , properties, app_apk folders.**

**niki.xml - Testng suite which contains the list of test cases to be executed.**

**pom.xml - All dependency details and invokes the testng xml for execution.**

**Steps to follow before executing the script:**

1.Make sure Android device is connected, user device listed on running the comment 'adb devices'. Only one device should be connected, since grid configurations are different from single device execution.This code is executable only on single device.

2.Start Appium server under the port 4723.

3.Update the input data details in xlsx files available in 'input_data' in project.

4.Goto project and execute the pom.xml file.

**List of mobile features covered in automation:**

Switch between App

Read OTP value in runtime

Scroll

Swipe

Type 

Click

Take screenshot on every step
