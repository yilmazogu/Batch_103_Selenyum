package day03_Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Proje_Can {
    public static void main(String[] args) {

        /*
1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  "username" yazdirin
4. Password alanine "password" yazdirin
5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
6. Online Banking menusunden Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina "2020-09-10" yazdirin
9. Pay buttonuna tiklayin
10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
*/

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        driver.manage().window().maximize();
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  "username" yazdirin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");

        //4. Password alanine "password" yazdirin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        List<WebElement>onlineBanking=driver.findElements(By.xpath("//*[.='Online Banking'] "));

        onlineBanking.get(0).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");

        // 8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        String actualTest=driver.findElement(By.xpath("//*[.='The payment was successfully submitted.'] ")).getText();

        if(actualTest.equalsIgnoreCase("The payment was successfully submitted.")){

        System.out.println("Test Nikelajj");

        }else System.out.println("Test Ambalaj");

}}
