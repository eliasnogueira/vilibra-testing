package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/add_lending_action_button")
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    MobileElement addLeading;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_name_text_view")
    @WithTimeout(time = 5, unit = TimeUnit.SECONDS)
    MobileElement bookName;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/book_author_text_view")
    MobileElement bookAuthor;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/empty_book_list_message_text_view")
    MobileElement emptyMessage;

    public MainPage(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickAddLeaging() {
        addLeading.click();
    }

    public String getBookName() {
        return bookName.getText();
    }

    public String getBookAuthor() {
        return bookAuthor.getText();
    }

    public void clickBookBorrowed() {
        bookAuthor.click();
    }

    public String getEmptyMessage() {
        return emptyMessage.getText();
    }

}
