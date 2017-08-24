package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    @AndroidFindBy(id = "com.android.contacts:id/menu_search")
    MobileElement menuSearchIcon;

    @AndroidFindBy(id = "android:id/search_src_text")
    MobileElement menuSearchText;

    @AndroidFindBy(id = "com.android.contacts:id/cliv_name_textview")
    MobileElement nameListed;

    public ContactPage(AppiumDriver<?> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clickMenuSearchIcon() {
        menuSearchIcon.click();
    }

    public void fillSearchText(String contactName) {
        menuSearchText.sendKeys(contactName);
    }

    public void clickNameListed() {
        nameListed.click();
    }

}
