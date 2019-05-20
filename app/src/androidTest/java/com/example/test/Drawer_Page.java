package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

public class Drawer_Page extends KKPage{
    String My_Library_id = "com.skysoft.kkbox.android:id/drawerItem_layout";
    String Profile_id = "com.skysoft.kkbox.android:id/label_profile_title";
    String Collect_id= "com.skysoft.kkbox.android:id/myLibSubTitleItem_contentLayout";
    public Drawer_Page(UiDevice mDevice){
        super(mDevice);
    }
    public My_Library_Page Open_My_Library()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().resourceId(My_Library_id)).click();
        return new My_Library_Page(mDevice);
    }
    public Profile_Page Open_Profile()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().resourceId(Profile_id)).click();
        return  new Profile_Page(mDevice);
    }
}
