package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BookDetailsPage {

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_title_text_view")
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    MobileElement bookTitle;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_subtitle_text_view")
    MobileElement bookSubTitle;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_authors_text_view")
    MobileElement bookAuthors;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_publisher_edition_text_view")
    MobileElement bookPublisher;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_page_count_text_view")
    MobileElement bookPageCount;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_isbn10_text_view")
    MobileElement bookISBN10;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_isbn13_text_view")
    MobileElement bookISBN13;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/lending_message_text_view")
    MobileElement lendingMessage;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/lend_book_button")
    MobileElement lendBookButton;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/return_book_button")
    MobileElement returnBookButton;

    public BookDetailsPage(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickLeandThisBook() {
        lendBookButton.click();
    }

    public void clickReturnThisBook() {
        returnBookButton.click();
    }

    public String getBookTitle() {
        return bookTitle.getText();
    }

    public String getBookSubtitle() {
        return bookSubTitle.getText();
    }

    public String getBookAuthor() {
        return bookAuthors.getText();
    }

    public String getBookPublisher() {
        return bookPublisher.getText();
    }

    public String getBookPageCount() {
        return bookPageCount.getText();
    }

    public String getBookISBN10() {
        return bookISBN10.getText();
    }

    public String getBookISBN13() {
        return bookISBN13.getText();
    }

    public String getLeadingMessage() {
        return lendingMessage.getText();
    }


}
