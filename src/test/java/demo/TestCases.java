package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v123.animation.Animation;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.logging.Level;

import demo.utils.ExcelDataProvider;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Assert;

public class TestCases extends ExcelDataProvider{ // Lets us read the data
        ChromeDriver driver;

        /*
         * TODO: Write your tests here with testng @Test annotation.
         * Follow `testCase01` `testCase02`... format or what is provided in
         * instructions
         */

        /*
         * Do not change the provided methods unless necessary, they will help in
         * automation and assessment
         */
        @BeforeTest
        public void startBrowser() {
                System.setProperty("java.util.logging.config.file", "logging.properties");

                // NOT NEEDED FOR SELENIUM MANAGER
                // WebDriverManager.chromedriver().timeout(30).setup();

                ChromeOptions options = new ChromeOptions();
                LoggingPreferences logs = new LoggingPreferences();

                logs.enable(LogType.BROWSER, Level.ALL);
                logs.enable(LogType.DRIVER, Level.ALL);
                options.setCapability("goog:loggingPrefs", logs);
                options.addArguments("--remote-allow-origins=*");

                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
        }

        @AfterTest
        public void endTest() {
                driver.close();
                driver.quit();

        }
        @Test
        public void testCase01() throws InterruptedException{
                System.out.println("Start testcase01....");
                String status = Wrappers.navigateToUrl(driver);
                Thread.sleep(5000);
                Wrappers.clickOnElement(driver, By.xpath("//a[text()='About']"));
                Thread.sleep(5000);
                Wrappers.PrintMsgInAbout(driver);
                org.testng.Assert.assertEquals(status, "https://www.youtube.com/");
                System.out.println("End testcase01....");

        }
        @Test
        public void testCase02() throws InterruptedException{
                System.out.println("Start testcase02....");
                Wrappers.navigateToUrl(driver);
                Thread.sleep(5000);
                Wrappers.clickOnElement(driver, By.xpath("//a[@title='Movies']"));
                Thread.sleep(5000);
                Wrappers.nextButton(driver,By.xpath("//button[@aria-label='Next']"));
                String status1 =Wrappers.veryfy(driver,By.xpath("//ytd-grid-movie-renderer[contains(@class,'horizontal')]/ytd-badge-supported-renderer/div[2]/p"));
                SoftAssert softAssert=new SoftAssert();
                softAssert.assertEquals(status1, "U");
                // org.testng.Assert.assertEquals(status1, "U");
                String status2 =Wrappers.veryfyType(driver, By.xpath("//ytd-grid-movie-renderer[contains(@class,'horizontal')]/a/span"));
                softAssert.assertEquals(status2, "Animation");
                // org.testng.Assert.assertEquals(status2, "Animation");
                System.out.println("End testcase02....");

        }
        @Test
        public void testCase03() throws InterruptedException{
                System.out.println("Start testcase03....");
                Wrappers.navigateToUrl(driver);
                Thread.sleep(5000);
                Wrappers.clickOnElement(driver, By.xpath("//a[@title='Music']"));
                Thread.sleep(5000);
                Wrappers.nextButton(driver,By.xpath("(//button[@aria-label='Next'])[1]"));
                Wrappers.printTitle(driver, By.xpath("(//yt-horizontal-list-renderer[contains(@class,'style-scope ytd-shelf-renderer')])[1]/div[2]/div/div/yt-lockup-view-model//div/div/yt-lockup-metadata-view-model/div/h3"));
                Thread.sleep(5000);
                Boolean status = Wrappers.musicTracks(driver, By.xpath("(//yt-horizontal-list-renderer[contains(@class,'style-scope ytd-shelf-renderer')])[1]/div[2]/div/div/yt-lockup-view-model/div/a/yt-collection-thumbnail-view-model/yt-collections-stack/div/div[3]/yt-thumbnail-view-model/yt-thumbnail-overlay-badge-view-model"));
                SoftAssert softAssert=new SoftAssert();
                softAssert.assertTrue(status);
                // org.testng.Assert.assertTrue(status);
                System.out.println("End testcase03....");

        }
        @Test
        public void testCase04() throws InterruptedException{
                System.out.println("Start testcase04....");
                Wrappers.navigateToUrl(driver);
                Thread.sleep(5000);
                Wrappers.clickOnElement(driver, By.xpath("//a[@title='News']"));
                Thread.sleep(5000);
                Wrappers.titleOfNews(driver, By.xpath("//span[text()='Latest news posts']/../../../../../following-sibling::div//ytd-rich-item-renderer/div/ytd-post-renderer/div[1]/div[1]/div[2]"));
                Wrappers.bodyOfNews(driver, By.xpath("//span[text()='Latest news posts']/../../../../../following-sibling::div//ytd-rich-item-renderer/div/ytd-post-renderer/div[1]/div[2]"));
                Wrappers.likeCountOfNews(driver, By.xpath("//span[text()='Latest news posts']/../../../../../following-sibling::div//ytd-rich-item-renderer/div/ytd-post-renderer/div[1]/div[3]"));


                System.out.println("End testcase04....");

        }
        @Test
        public void testCase05() throws InterruptedException{
                System.out.println("Start testcase05....");
                Wrappers.navigateToUrl(driver);
                Thread.sleep(5000);
                Wrappers.sendkeys(driver,"Movies");
                
                Wrappers.countview(driver, By.xpath("//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]"));
                Thread.sleep(8000);
                Wrappers.sendkeys(driver,"Music");
               
                Wrappers.countview(driver, By.xpath("//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]"));
                Thread.sleep(5000);
                Wrappers.sendkeys(driver,"Games");
                
                Wrappers.countview(driver, By.xpath("//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]"));
                Thread.sleep(5000);
                Wrappers.sendkeys(driver,"India");
                Thread.sleep(5000);
                Wrappers.countview(driver, By.xpath("//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]"));
                Thread.sleep(5000);
                Wrappers.sendkeys(driver,"UK");
                Thread.sleep(5000);
                Wrappers.countview(driver, By.xpath("//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]"));
                Thread.sleep(5000);
                System.out.println("End testcase05....");

        }
        // By.xpath("//ytd-grid-movie-renderer[contains(@class,'horizontal')]")
        //input[@id='search' and @placeholder='Search']
}