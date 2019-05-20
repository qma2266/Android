package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;
public class All_Song_Page extends KKPage{
    public All_Song_Page(UiDevice mDevice){
        super(mDevice);
    }
    public Online_Song_Page Open_Browse_Song() throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("依歌曲瀏覽")).click();
        return new Online_Song_Page(mDevice);
    }
    public Browse_Page Open_Browse_Artist_name()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("依歌手瀏覽")).click();
        return new Browse_Page(mDevice);
    }
    public Browse_Page Open_Browse_alubm_name()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("依專輯瀏覽")).click();
        return new Browse_Page(mDevice);
    }
}
