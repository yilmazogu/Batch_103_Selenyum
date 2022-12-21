package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

//        2- Browseri tam sayfa yapin
        driver.manage().window().maximize();

//        3- Sayfayi "refresh" yapin
        driver.navigate().refresh();

//        4- Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actualTitel = driver.getTitle();
        String arananKelime = "Spend less";
        if (actualTitel.contains("Spend less")) {
            System.out.println("Titel Test PASSED");
        } else {
            System.out.println("Titel Test FAILED");
        }
//        5- Gift Cards sekmesine basin
        driver.findElement(By.cssSelector("a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc']")).click();
//
//        6- Birthday butonuna basin
        driver.findElement(By.cssSelector("img[src='https://images-na.ssl-images-amazon.com/images/G/01/gift-certificates/consumer/2021/GCLP/Support/2x/Occ_Birthday_346x130.png']")).click();

//        7- Best Seller bolumunden ilk urunu tiklayin
        List<WebElement> bestSellerB = driver.findElements(By.cssSelector("img[alt='Amazon.com eGift Card']"));
        bestSellerB.get(0).click();

//        8- Gift card details'den 25 $'i secin
        driver.findElement(By.cssSelector("span[id='a-autoid-28']")).click();

//        9-Urun ucretinin 25$ oldugunu test edin
        Thread.sleep(3000);
        WebElement urunUcreti = driver.findElement(By.cssSelector("span[id='gc-live-preview-amount']"));
        if (urunUcreti.getText().equals("$25.00")) {
            System.out.println("Ucret Testi PASSED");
        } else {
            System.out.println("Ucret Testi FAIlED");
        }
//        10-Sayfayi kapatin
        driver.close();

    }}