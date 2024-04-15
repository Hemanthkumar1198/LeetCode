package leetcode_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    boolean status;
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        status = driver.getCurrentUrl().contains("leetcode");
        if (status) {
            System.out.println("The URL of the Leetcode homepage contains \"leetcode\"");
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() {
        System.out.println("Start Test case: testCase02");
        driver.findElement(By.xpath("//a[@href='/problemset/']")).click();
        status = driver.getCurrentUrl().contains("problemset");
        if (status) {
            System.out.println("The URL of the Leetcode problemset contains \"problemset\"");
        }

        List<WebElement> problems = driver.findElements(By.xpath("//div[@class='truncate']"));
        for (int i = 1; i <= 5; i++) {
            // List<WebElement> problems = driver.findElements(By.xpath("(//div[@class='truncate']/a)["+i+"]"));
            String problemtexts = problems.get(i).getText();
            System.out.println(problemtexts);

            // System.out.println(problems);
            // problems.get(i).click();
            // status =driver.findElement(By.xpath("//a[contains(text(), '"+ problemtexts +"')]")).getText().contains(problemtexts);
            // if(status) {
            // System.out.println("testcase pass");
            // }
            // driver.navigate().back();
        }
        System.out.println("end Test case: testCase02");
    }

    public void testCase03() {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/problems/two-sum/");
        status = driver.getCurrentUrl().contains("two-sum");
        if (status) {
            System.out.println("The URL of the problem contains two-sum");
        }
        System.out.println("end Test case: testCase03");
    }

    public void testCase04() {
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/problems/two-sum/");
        driver.findElement(By.id("submissions_tab")).click();
        WebElement signinbtn = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String text = signinbtn.getText();
        if (text.contains("Register or Sign In")) {
            System.out.println("The message Register or Sign In is displayed when you click on the submissions tab");
        }
        System.out.println("end Test case: testCase04");
    }

}
