package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.lang.reflect.Field;

public class genericclass {

    public static Object getPageObject( String pageName,WebDriver driver, WebDriverWait wait) {
        Object pageObject;
        try {

            pageObject = Class.forName("com.page."+pageName)
                    .getConstructor(WebDriver.class, WebDriverWait.class).newInstance(driver, wait);

        } catch (Exception var5) {
            pageObject = null;
            System.out.print("Invalid file Name" + var5.fillInStackTrace());
        }

        return pageObject;
    }

    public static WebElement getWebElementFromPage(Object object, String elementName) {
        Class aClass = object.getClass();
        Field field = null;
        WebElement element = null;

        try {
            field = aClass.getField(elementName);
            element = (WebElement)field.get(object);
        } catch (NoSuchFieldException var6) {
           System.out.print(var6);
        } catch (IllegalAccessException var7) {
            System.out.print(var7);
        }

        return element;
    }


}

