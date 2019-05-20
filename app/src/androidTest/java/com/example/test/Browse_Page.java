package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import java.util.logging.SocketHandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Browse_Page extends KKPage{
    public Browse_Page(UiDevice mDevice){
        super(mDevice);
    }
    public Browse_Page Check_collect_songlist_name(){
        assertTrue(mDevice.wait(Until.hasObject(By.text(KKPage.Online_Song_Page_collect_songlist_name)), TIMEOUT));
        return this;
    }
    public Browse_Page delet_songlist() throws  UiObjectNotFoundException{
        BySelector action_menu = By.res(PACKAGE_name,"menu_overflow");
        BySelector confirm = By.res(PACKAGE_name, "button_confirm");
        BySelector alumbe_text = By.res(PACKAGE_name, "view_recycler");
        BySelector delet = By.res(PACKAGE_name,"checkbox_select").depth(9);
        mDevice.wait(Until.findObject(action_menu), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(By.clazz("android.widget.ListView")),ShortTIMEOUT).click();
        KKPage.Action_Page_Aritst_name = mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/label_title").instance(0)).getText();
        KKPage.Action_Page_Albume_name = mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/label_sub_title").instance(0)).getText();
        //mDevice.wait(Until.findObjects(new UiSelector().className("android.widget.RelativeLayout").instance(0)), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(delet), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(confirm), ShortTIMEOUT).click();
        mDevice.wait(Until.findObject(alumbe_text),ShortTIMEOUT);
        return this;
    }
}
