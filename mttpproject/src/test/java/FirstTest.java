
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FirstTest {
    public WebDriver driver;
    //Declare a test URL variable
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
        driver.manage().window().maximize();
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("arriva");
        searchTextBox.submit();
        WebElement newElement = driver.findElement(By.xpath("/html//div[@id='rso']/div[1]/div[@class='g']//a[@href='https://www.arriva.com.hr/hr-hr/naslovna']/h3[.='Arriva Hrvatska']"));
        newElement.click();
        WebElement newElement2 = driver.findElement(By.xpath("//nav[@class='navbar navbar-default']/div/div[3]/ul[2]//a[@role='button']/span[@class='flag-icon flag-icon-hr']"));
        newElement2.click();
        WebElement newElement3 = driver.findElement(By.xpath("//nav[@class='navbar navbar-default']/div/div[3]/ul[2]//ul[@role='menu']//a[@href='/it-it/home']"));
        newElement3.click();
        Thread.sleep(5000);
        WebElement testLink = driver.findElement(By.xpath("//body[@class='homepage homepage-hero']/div[@class='home-intro']/div[@class='container']//h1[.='Benvenuti sul sito Arriva']"));
        Assert.assertEquals(testLink.getText(), "Benvenuti sul sito Arriva");
        System.out.print(testLink.getText());
    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}
