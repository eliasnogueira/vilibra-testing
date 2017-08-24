package e2e;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.BookDetailsPage;
import pageobjects.BookScanPage;
import pageobjects.ContactPage;
import pageobjects.MainPage;
import utils.Utils;

import static org.junit.Assert.*;

public class LendABookTest {

    private AppiumDriver<?> driver;

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @Test
    @Parameters( {"udid", "platformVersion"} )
    public void leandABook(String udid, String version) throws Exception {
        driver = Utils.returnDriver(udid, version);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddLeaging();

        BookScanPage scan = new BookScanPage(driver);
        scan.fillISBN("8575224638");
        scan.clickInConfirm();

        BookDetailsPage details = new BookDetailsPage(driver);
        assertEquals("Dominando o Android 2ª edição", details.getBookTitle());
        assertEquals("Do básico ao avançado", details.getBookSubtitle());
        assertEquals("Nelson Glauber", details.getBookAuthor());
        assertEquals("Novatec Editora", details.getBookPublisher());
        assertEquals("952 pages", details.getBookPageCount());
        assertEquals("ISBN-10: 8575224638", details.getBookISBN10());
        assertEquals("ISBN-13: 9788575224632", details.getBookISBN13());
        assertEquals("Book not lended.", details.getLeadingMessage());

        details.clickLeandThisBook();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.clickMenuSearchIcon();
        contactPage.fillSearchText("Elias");
        contactPage.clickNameListed();

        mainPage = new MainPage(driver);
        assertEquals("Dominando o Android 2ª edição", mainPage.getBookName());
        assertEquals("Nelson Glauber", mainPage.getBookAuthor());

    }

}
