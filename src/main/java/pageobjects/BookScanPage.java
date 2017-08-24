package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BookScanPage {

    private AppiumDriver<?> driver;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/isbn_edit_text")
    MobileElement isbn;

    @AndroidFindBy(id = "br.eng.ecarrara.vilibra:id/confirm_button")
    MobileElement confirm;

    public BookScanPage(AppiumDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void fillISBN(String isbnText) {
        isbn.sendKeys(isbnText);
        driver.hideKeyboard();
    }


    public void clickInConfirm() {
        confirm.click();
    }


}
