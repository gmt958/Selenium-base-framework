package stepdefinitions;


//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




public class baseclass {

    private WebDriver driver;
    private WebDriverWait wait;


    @Given("Launch chrome browser")
    public void launchchromebrowser() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmt\\selenium-base-framework\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @And("^User navigate to \"([^\"]*)\"$")
    public void User_navigate_to(String url) {
        try {
            driver.get(url);
            String target = driver.getCurrentUrl();
            System.out.println(target);
            assertEquals(target, url);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @And("^Choose the close banner$")
    public void Closetheregionalbanner() {
        WebElement close = driver.findElement(By.xpath("//a[contains(text(),'Continue to United States')]"));
        close.click();

    }

    private void assertEquals(String target, String source) {

        if (source.equals(target)) {
            System.out.println("Loaded with correct url");
        } else {
            System.out.println("Loaded with incorrect url");

        }
    }

    @And("^User closes the browser$")
    public void Userclosesthebrowser() {
        driver.close();
    }

    @And("^User wait for (\\d+) milliseconds$")
    public void user_wait(int milliseconds) throws Exception {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User login with username \"([^\"]*)\" and password \"([^\"]*)\" in a page$")
    public void user_login_page(String username, String password) throws Exception {
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.xpath("//button[@data-id='EmailPage-ContinueButton']")).click();
        this.user_wait(1000);
        driver.findElement(By.xpath("//div[@class='PasswordField']//input")).sendKeys(password);
        driver.findElement(By.xpath("//button[@data-id='PasswordPage-ContinueButton']")).click();
    }


    @And("^Assert the element is displayed \"([^\"]*)\" on \"([^\"]*)\"$")
    public void Element_displayed_on_page(String element, String pagename) {

        try {
            Assert.assertTrue(genericclass.getWebElementFromPage(genericclass.getPageObject(pagename, driver, wait), element).isDisplayed());

        } catch (Exception e) {
            System.out.print(e.fillInStackTrace());
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }


}




