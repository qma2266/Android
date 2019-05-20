package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class Songlist_Action_Page extends KKPage{
    public Songlist_Action_Page(UiDevice mDevice)
    {
        super(mDevice);
    }
    public Online_Song_Page delete_song() throws UiObjectNotFoundException{
        BySelector chose = By.res(PACKAGE_name, "checkbox_track_select");
        BySelector delet = By.res(PACKAGE_name, "button_delete");
        BySelector up = By.clazz("android.widget.ImageButton");
        mDevice.wait(Until.findObject(chose), ShortTIMEOUT).click();
        KKPage.Action_Page_Song_name = mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/label_track_title").instance(0)).getText();
        mDevice.wait(Until.findObject(delet), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(up), ShortTIMEOUT).click();
        KKPage.delete_songlist=true;
        // che
        return new Online_Song_Page(mDevice);
    }

}
