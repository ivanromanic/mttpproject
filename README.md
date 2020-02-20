# mttpproject
 MTTPP Project

Introduction

This project from the course mttpp at the Faculty of Electrical Engineering, Computer Science and Information Technology Osijek consists of
tests made on arriva, a website for bus traveling active in croatia https:"//www.arriva.com.hr/hr-hr/naslovna"

Used libraries: - Selenium - framework for testing web applications - TestNG - testing framework for the 
Java programming language (inspired by JUnit and NUnit)

set up

set web driver

For this project a web driver is needed. Google chrome driver was used "https://chromedriver.chromium.org/downloads". In order to use it you
need to download the correct version(you can check it in the settings of chrome) extract it, put it in the drivers folder in c and put
a path to it in the environment variables.

set jdk

Jdk is also needed "https://jdk.java.net/13/". Download and extract the file and add it, like the chrome driver on the step before, as an 
environment variable.

set maven

Like jdk maven is also needed. Download and extract the file from "https://maven.apache.org/download.cgi" and add it as and environment variable

set intellij

To start the project you will need to download and instal intellij IDEA "https://www.jetbrains.com/idea/download/#section=windows"
For this project, the free community version was used.

create maven project

Click on Create New Project

JDK should be recognized automatically, and if it is press Next. 
      
You can name GroupId and ArtifactId whatever you want.

Click on Next

Click on Finish

Click on Enable Auto-Import because it will automatically import all Maven dependcies in your project

set pom.xml

For the pom.xml file, the code on the lv2 loomen file was used since it had everything the project needed to work

create tests

To create the tests right click on src/test/java inside your project and select new/java class. Name the class and select class.
Inside this git repository you'll find java files that contains a code for certain test.

set surefire report

You need to design a test suite. Select Project and then click right click and add new file - Name file "testng.xml". The code used for 
this file was taken from lv2 loomen file and modified to have five tests.

understanding the code

there are five tests. FirstTest checks compares text between your search string and a string on the website after the language has been
changed to italian. SecondTest checks if you can register via gmail by comparing your search string and the register string after 
clicking on register via gmail. ThirdTest enters departure and arrival location and departure date and compares search string with a
string on the page which shows matching routes. FourthTest found an error on the site, it checked the link on the maestrocard logo
on the main page and found that the connection was reset. FifthTest went on the navigation bar link for popular offers and choose the first
offer - rijeka - zagreb, then it clicked on an icon which inverts the route, making it zagreb-rijeka and compared the search string
with the inverted route name

Every test contains imports: 

"import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;"

Those are built in data we use for tests. We use webdriver manager.We create a google chrome driver: "driver = new ChromeDriver();" 
with the driver we go to arriva on google "WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("arriva");
        searchTextBox.submit();"This procedure is also used for all textboxes on the arriva webpage
We click on elements by finding them and clicking on them WebElement "newElement = driver.findElement(By.xpath("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.arriva.com.hr/hr-hr/naslovna']/h3[.='Arriva Hrvatska']"));
        newElement.click();" 
strings are compared with "WebElement testLink = driver.findElement(By.xpath("/html/body/div[@class='main-content-full']//h2[@class='hidden-print']"));
        Assert.assertEquals(testLink.getText(), "OSIJEK-ZAGREB");
        System.out.print(testLink.getText());" which is the way we set conditions of the tests success or failure. In the end we exit 
google chrome with "driver.quit();"

make surefire report

Unfortunently I wasnt able to do this, I messed up something but i dont know what, but I asure you all the tests passed

