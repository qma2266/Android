package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.support.test.uiautomator.BySelector;
import static org.junit.Assert.*;
public class HomePage extends KKPage{

    String Search_btn = "com.skysoft.kkbox.android:id/menu_global_search";
    String Today_Song = "com.skysoft.kkbox.android:id/label_title";
    public HomePage(UiDevice mdevice){
        super(mdevice);
    }
    public Search Open_Search_Page()throws UiObjectNotFoundException
    {   UiObject search_btn;
        search_btn = this.mDevice.findObject(new UiSelector().resourceId(Search_btn));
        search_btn.click();
        return new Search(mDevice);
    }
    public Online_Song_Page Open_Today_Song( String except)throws UiObjectNotFoundException{
        //int StartX= 50, StartY= 2000;
        //int EndX=50, EndY=500;
        //this.mDevice.swipe(StartX,StartY,EndX,EndY,100);
        this.mDevice.wait(Until.findObject(By.res(KKPage.PACKAGE_name, ":id/viewpager")), TIMEOUT);
        go_to_song_list("today_song");
        //UiSelector viewpage = new UiSelector().description("playlist_of_the_day").childSelector(new UiSelector().className("android.support.v7.widget.RecyclerView"));
        //UiScrollable move = new UiScrollable(viewpage);
        //move.setAsHorizontalList();
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/layout_cover")).click();
        return  new Online_Song_Page(mDevice);
    }
    public Online_Song_Page Open_for_you_list(String except)throws UiObjectNotFoundException{
        this.mDevice.wait(Until.findObject(By.res(KKPage.PACKAGE_name, ":id/viewpager")), LAUNCH_TIMEOUT);
        go_to_song_list("for_you_list");
        //UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/recycler_sub_item_list").instance(1);
        //UiSelector viewpage = new UiSelector().description("category_playlist").childSelector(new UiSelector().className("android.support.v7.widget.RecyclerView"));
        //UiScrollable move = new UiScrollable(viewpage);

        //move.setAsHorizontalList();
        mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/layout_cover")).click();
        //move.scrollTextIntoView(except);
        return  new Online_Song_Page(mDevice);
    }
    public Drawer_Page Open_Drawer()throws UiObjectNotFoundException{
        this.mDevice.findObject(new UiSelector().className("android.widget.ImageButton")).click();
        return new Drawer_Page(mDevice);
    }



    private  void go_to_song_list(String page) throws UiObjectNotFoundException
    {   UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/viewpager");
        UiSelector category_playlist;
        UiScrollable move = new UiScrollable(viewpage);
        if (page == "for_you_list")
        {
            category_playlist = new UiSelector().descriptionContains("category_playlist");
            move.scrollIntoView(category_playlist);
        }
        else if (page =="today_song") {

            category_playlist = new UiSelector().descriptionContains("category_playlist");
            move.scrollIntoView(category_playlist);
        }
    }
}
