import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FifthTest {
    public WebDriver driver;
    //Declare a test URL variable
    public String gText;
    public String testURL = "http://www.google.com";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);

    }



    @Test
    public void googleSearchTest() throws InterruptedException {
// driver.manage().window().maximize();
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("arriva");
        searchTextBox.submit();
        WebElement newElement = driver.findElement(By.xpath("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.arriva.com.hr/hr-hr/naslovna']/h3[.='Arriva Hrvatska']"));
        newElement.click();
        WebElement newElement2 = driver.findElement(By.xpath("//nav[@class='navbar navbar-default']/div/div[3]/ul[@class='nav navbar-nav navbar-right']//a[@href='/hr-hr/posebne-ponude']"));
        newElement2.click();
        WebElement newElement3 = driver.findElement(By.xpath("//body[@class='inner']/div[@class='container inner-content']//a[@href='/hr-hr/bus-rijeka-zagreb']/span[@class='float-left']"));
        newElement3.click();
        WebElement newElement4 = driver.findElement(By.xpath("/html/body[@class='inner']//a[@title='vidi Bus Zagreb – Rijeka']/i[@class='fa fa-exchange']"));
        newElement4.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html//div[@id='route-time-table-description']//h2[.='Red vožnje za autobus iz Zagreba za Rijeku']"));
        Assert.assertEquals(testLink.getText(), "Red vožnje za autobus iz Zagreba za Rijeku");
        System.out.print(testLink.getText());
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}

