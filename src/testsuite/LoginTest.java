package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Write test for the login with valid and invalid credential
 * 1. Login with valid credential with method name userShouldLoginSuccessfullyWithValidCredentials
 *              * Enter “tomsmith” username
 *              * Enter “SuperSecretPassword!” password
 *              * Click on ‘LOGIN’ button
 *              * Verify the text “Secure Area”
 * 2. Login with invalid username with method name verifyTheUsernameErrorMessage
 *              * Enter “tomsmith1” username
 *              * Enter “SuperSecretPassword!” password
 *              * Click on ‘LOGIN’ button
 *              * Verify the error message “Your username is invalid!”
 * 3. Login with invalid password with method name verifyThePasswordErrorMessage
 *              * Enter “tomsmith” username
 *              * Enter “SuperSecretPassword” password
 *              * Click on ‘LOGIN’ button
 *              * Verify the error message “Your password is invalid!”
 */

public class LoginTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "http://the-internet.herokuapp.com/login";


    // Open Browser
    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }

    @Test
    // Method name userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Find Username field and enter username in the field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        // Find Password field and enter password in the field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Find Login button and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'radius']"));
        loginButton.click();

        // Expected text
        String expectedText = "Secure Area";

        // Actual text find and check equal or not
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    // Method name verifyTheUsernameErrorMessage
    public void verifyTheUsernameErrorMessage(){

        // Find Username field and enter username in the field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith1");

        // Find Password field and enter password in the field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Find Login button and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'radius']"));
        loginButton.click();

        // Expected text
        String expectedText = "Your username is invalid!";

        // Actual text find and check equal or not
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(), ' Your username is invalid!' )] "));
        String actualText = actualTextElement.getText().substring(0,25);
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    // Method name verifyThePasswordErrorMessage
    public void verifyThePasswordErrorMessage(){

        // Find Username field and enter username in the field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        // Find Password field and enter password in the field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");

        // Find Login button and click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'radius']"));
        loginButton.click();

        // Expected text
        String expectedText = "Your password is invalid!";

        // Actual text find and check equal or not
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText().substring(0,25);
        Assert.assertEquals(expectedText,actualText);

    }

    //Close browser
    @After
    public void tearDown(){
        closeBrowser();
    }

}
