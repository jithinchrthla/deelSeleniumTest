import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private static ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\IdeaProjects\\deelSeleniumTest\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void create_Contract(){

        System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.get("https://app.letsdeel.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.findElement(By.name("email")).sendKeys("jithinchrthla@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Banana@123");
        driver.findElement(By.xpath("//div[text()='log in']")).click();
        try{
            element = driver.findElement (By.xpath("//div[text()='JC']a"));
        }catch (Exception e){
        }
        driver.findElement(By.xpath("//div[text()='Create A Contract']")).click();
        driver.findElement(By.xpath("//h4[text()='Fixed Rate']")).click();
        driver.findElement(By.xpath("//div[@data-qa='contractor-tax-residence']/label")).click();
        driver.findElement(By.xpath("//div[text()='United States / Colorado']")).click();
        driver.findElement(By.xpath("//input[@name='jobTitle']")).click();
        driver.findElement(By.xpath("//p[text()='3D Artist']")).click();
        driver.findElement(By.xpath("//div[@data-qa='selector-seniority-level']//label")).click();
        driver.findElement(By.xpath("//div[text()='Not applicable']")).click();
        driver.findElement(By.name("scope")).sendKeys("Test");
        driver.findElement(By.xpath("(//button[contains(@class,'MuiPickersDay-today')]/../preceding-sibling::span)[1]")).click();





        //System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }

    @AfterClass
    public static void closeBrowser(){
        driver.quit();
    }
}