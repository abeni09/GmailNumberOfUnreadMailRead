package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class GmailNewMailReader {


        public static void main(String[] args) throws InterruptedException {
// Create a new instance of the Firefox driver
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            WebDriver driver;
            ChromeOptions chromeOptions= new ChromeOptions();
            driver=new ChromeDriver(chromeOptions);;
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");

            String url="https://mail.google.com/";
//Launch the some site
            driver.get(url);
            //Provide Email
            var username= "abenij09";
            //Provide password
            var password= "gmailayaskm";
            driver.findElement(By.xpath("//*[@type=\"email\"]")).clear();
            driver.findElement(By.xpath("//*[@type=\"email\"]")).sendKeys(username,Keys.ENTER);
            System.out.println("Username entered");
            //Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).clear();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys(username,Keys.ENTER);
            System.out.println("Password entered");

            String Inbox=driver.findElement(By.xpath("//*[@class=\":bsU\"]/div/div[2]/div")).getText();
            System.out.println("Number of unread inbox mails is: "+Inbox);

            driver.findElement(By.xpath("//*[@id=\":48\"]/div/div[2]/span/a")).sendKeys(Keys.ENTER);
            List<WebElement> InboxRows=   driver.findElements(By.xpath("//table[@class='F cf zt']//tr"));
            for (WebElement row : InboxRows) {
                WebElement key = row.findElement(By.xpath("//*[@id=\":ow\"]/tbody[1]"));
                System.out.println(key.getText());
                break;

            }
            System.out.println("All unread inbox mails are printed");

// Print a Log In message to the screen
            //System.out.println("Successfully Logged In");

            driver.quit();
        }
    }

