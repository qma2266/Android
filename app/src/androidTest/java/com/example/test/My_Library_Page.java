package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import static org.junit.Assert.assertTrue;

public class My_Library_Page extends KKPage{
    public My_Library_Page(UiDevice mDevice){
        super(mDevice);
    }
    public All_Song_Page Opne_All_Song()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("全部歌曲")).click();
        return new All_Song_Page(mDevice);
    }
    public Browse_Page Opne_collect_songlist()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("收藏歌單")).click();
        return new Browse_Page(mDevice);
    }
    public Online_Song_Page Open_collect_song()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().text("收藏歌曲")).click();
        return new Online_Song_Page(mDevice);
    }

    public Online_Song_Page open_song_list(String song_list_name) throws UiObjectNotFoundException
    {   BySelector add_song_list_name = By.text(song_list_name);
        UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/view_recycler");
        UiSelector category_playlist;
        UiScrollable move = new UiScrollable(viewpage);
        move.scrollTextIntoView(song_list_name);
        mDevice.findObject(add_song_list_name).click();

        return new Online_Song_Page(mDevice);
    }
    public My_Sonlist_Action_Page open_action_my_songlist() throws UiObjectNotFoundException
    {   BySelector action_menu = By.res(PACKAGE_name, "myLibPlaylistItem_overflowIcon");
        mDevice.wait(Until.findObject(action_menu), ShortTIMEOUT).click();

        return new My_Sonlist_Action_Page(mDevice);
    }
    public My_Library_Page check_add_song_list_name(String song_list_name)throws UiObjectNotFoundException{
        BySelector add_song_list_name = By.text(song_list_name);
        UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/view_recycler");
        UiSelector category_playlist;
        UiScrollable move = new UiScrollable(viewpage);
        move.scrollTextIntoView(song_list_name);
        assertTrue(mDevice.wait(Until.hasObject(add_song_list_name), TIMEOUT));
        return this;
    }
}
