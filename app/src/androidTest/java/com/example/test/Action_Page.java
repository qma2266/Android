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
public class Action_Page extends  KKPage{
    public  Action_Page(UiDevice mDevice)
    {
        super(mDevice);
    }
    public Action_Page collect_song()throws UiObjectNotFoundException
    {   BySelector collect = By.res(PACKAGE_name,"button_collect_this_song");
        BySelector Albume_name = By.res(PACKAGE_name, "label_album_name");
        BySelector Aritst_name = By.res(PACKAGE_name, "label_artist_name");
        KKPage.Action_Page_Albume_name = this.mDevice.wait(Until.findObject(Albume_name), ShortTIMEOUT).getText();
        KKPage.Action_Page_Aritst_name = this.mDevice.wait(Until.findObject(Aritst_name), ShortTIMEOUT).getText();
        this.mDevice.wait(Until.findObject(collect), TIMEOUT).click();
        // 等待收藏動畫跑完
        mDevice.wait(Until.hasObject(By.res("com.skysoft.kkbox.android:id/label_playlist_name")),TIMEOUT);
        //mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/button_collect_this_song")).click();
        return this;
    }
}
