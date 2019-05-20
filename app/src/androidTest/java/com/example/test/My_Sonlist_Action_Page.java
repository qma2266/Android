package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class My_Sonlist_Action_Page extends  KKPage{
    public  My_Sonlist_Action_Page(UiDevice mDevice)
    {
        super(mDevice);
    }
    public My_Library_Page Rename(String Rename_str) throws UiObjectNotFoundException{
        BySelector rename_btn = By.res(PACKAGE_name, "button_rename");
        BySelector clear_btn = By.res(PACKAGE_name, "button_clear_text");
        BySelector set_text = By.res(PACKAGE_name, "text_edit");
        BySelector confirm = By.text("確認");
        mDevice.wait(Until.findObject(rename_btn), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(clear_btn), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(set_text), ShortTIMEOUT).setText(Rename_str);
        mDevice.wait(Until.findObject(confirm), ShortTIMEOUT).click();
        return new My_Library_Page(mDevice);
    }
}
