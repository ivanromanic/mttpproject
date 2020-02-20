import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {
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
        WebElement newElement2 = driver.findElement(By.xpath("/html//input[@id='search-from']"));
        newElement2.click();
        WebElement searchTextBox2 = driver.findElement(By.xpath("/html//input[@id='search-from']"));
        searchTextBox2.sendKeys("Osijek");
        searchTextBox2.submit();
        WebElement searchTextBox3 = driver.findElement(By.xpath("/html//input[@id='search-to']"));
        searchTextBox3.sendKeys("Zagreb");
        searchTextBox3.submit();
        WebElement newElement3 = driver.findElement(By.xpath("/html//input[@id='datetimepicker']"));
        newElement3.click();
        WebElement newElement4 = driver.findElement(By.xpath("//form[@id='shop-search-form']/div[@class='row']/div[@class='col-lg-5 col-md-6']/div/div[@class='tab-content']/div[1]//div[@class='input-group input-group-lg']/div[2]/ul[@class='list-unstyled']//div[@class='datepicker-days']/table[@class='table-condensed']/tbody/tr[4]/td[4]"));
        newElement4.click();
        WebElement newElement5 = driver.findElement(By.xpath("//form[@id='shop-search-form']/div[2]//button[@type='submit']"));
        newElement5.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[@class='main-content-full']//h2[@class='hidden-print']"));
        Assert.assertEquals(testLink.getText(), "OSIJEK-ZAGREB");
        System.out.print(testLink.getText());
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}
