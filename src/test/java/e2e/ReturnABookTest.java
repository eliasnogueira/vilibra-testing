package e2e;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.BookDetailsPage;
import pageobjects.MainPage;
import utils.Utils;

import static org.junit.Assert.*;

public class ReturnABookTest {

    private AppiumDriver<?> driver;

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Parameters( {"udid", "platformVersion"} )
    public void returnABookl(String udid, String version) throws Exception {
        driver = Utils.returnDriver(udid, version);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBookBorrowed();

        BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);
        bookDetailsPage.clickReturnThisBook();

        mainPage = new MainPage(driver);
        assertEquals("Your list of lended books is empty", mainPage.getEmptyMessage());

    }
}
