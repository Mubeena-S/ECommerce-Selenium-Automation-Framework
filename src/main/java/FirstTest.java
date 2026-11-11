
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Test Case 1: Invalid username
        driver.findElement(By.id("user-name"))
              .sendKeys("wrong_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String error1 = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        if (error1.contains("Username and password do not match")) {
            System.out.println("TC01 Passed: Invalid username rejected");
        } else {
            System.out.println("TC01 Failed: " + error1);
        }

        // Test Case 2: Invalid password
        driver.navigate().refresh();

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("wrong_pass");

        driver.findElement(By.id("login-button")).click();

        String error2 = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        if (error2.contains("Username and password do not match")) {
            System.out.println("TC02 Passed: Invalid password rejected");
        } else {
            System.out.println("TC02 Failed: " + error2);
        }

        // Test Case 3: Empty fields
        driver.navigate().refresh();

        driver.findElement(By.id("login-button")).click();

        String error3 = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        if (error3.contains("Username is required")) {
            System.out.println("TC03 Passed: Empty fields validated");
        } else {
            System.out.println("TC03 Failed: " + error3);
        }

        driver.quit();
    }
}
