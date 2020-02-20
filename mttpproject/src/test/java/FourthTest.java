import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FourthTest {
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
        WebElement newElement2 = driver.findElement(By.xpath("/html//button[@id='close-cookie-notification']"));
        newElement2.click();
        WebElement newElement3 = driver.findElement(By.xpath("//form[@id='shop-search-form']/div[2]//ul[@class='bank-card-logos list-inline visible-lg visible-md']//a[@href='http://www.maestrocard.com']/img[@src='/Main/Assets/images/bank-card-3.jpg']"));
        newElement3.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("//form[@id='shop-search-form']/div[2]//ul[@class='bank-card-logos list-inline visible-lg visible-md']//a[@href='http://www.maestrocard.com']/img[@src='/Main/Assets/images/bank-card-3.jpg']"));
        Assert.assertEquals(testLink.getText(), "");
        System.out.print(testLink.getText());
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}
