package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DebitCardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }



    @Test
    void shouldTest(){
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Генадий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7905735935");
        driver.findElement(By.cssSelector("[data-test-id=agreement")).click();
        driver.findElement(By.cssSelector("[button__text]")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=rder-success]")).getText().trim();
        assertEquals(expected, actual);
    }
}