package com.example.test;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;
import android.support.test.uiautomator.UiScrollable;
public class KKPage {
    public UiDevice mDevice;
    protected static String PACKAGE_name = "com.skysoft.kkbox.android";
    protected static final int LAUNCH_TIMEOUT = 5000;
    protected static final int TIMEOUT = 3000;
    protected static final int ShortTIMEOUT = 500;
    protected static String Online_Song_Page_collect_songlist_name;
    protected static String Online_Song_Page_song_list_num;
    protected static String Action_Page_Aritst_name;
    protected static String Action_Page_Albume_name;
    protected static String Action_Page_Song_name;
    protected static boolean delete_songlist ;

    //protected static String add_songlist_list;
    public static final BySelector SEARCH_BUTTON = By.res(PACKAGE_name, "menu_global_search");

    public KKPage(UiDevice mdevice) {
        this.mDevice=mdevice;
        this.mDevice.wait(Until.hasObject(By.pkg(PACKAGE_name).depth(0)), LAUNCH_TIMEOUT);
    }
    public HomePage Hompage(){
        return new HomePage(this.mDevice);
    }
    public Search Search_page(){
        this.mDevice.wait(Until.findObject(SEARCH_BUTTON),TIMEOUT).click();
        return  new Search(this.mDevice);
    }
    public Online_Song_Page Online_Song_Page(){

        return new Online_Song_Page(this.mDevice);
    }
    public login_test Login()
    {
        return  new login_test(this.mDevice);
    }
    public Drawer_Page Open_Drawer_page()
    {   //this.mDevice.waitForIdle(500);
        int StartX= 0, StartY= 200;
        int EndX=800, EndY=200;
        this.mDevice.swipe(StartX,StartY,EndX,EndY,20);
        return new Drawer_Page(mDevice);
    }
    public <T extends KKPage> T is(Class<T> type) {
        if (type.isInstance(this)) {
            return type.cast(this);
        } else {
            throw new InvalidPageException("Invalid page type. Expected: " + type.getSimpleName() + ", but got: " + this.getClass().getSimpleName());
        }
    }
    public static class InvalidPageException extends RuntimeException {

        public InvalidPageException(final String message) {
            super(message);
        }
    }
}
