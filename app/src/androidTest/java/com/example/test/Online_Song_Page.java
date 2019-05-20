package com.example.test;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.Until;

import javax.xml.validation.TypeInfoProvider;

import static org.junit.Assert.*;
public class Online_Song_Page extends KKPage{
    String add_all_song_list = "com.skysoft.kkbox.android:id/button_add";
    String add_new_songlist = "com.skysoft.kkbox.android:id/button_add_to_new_playlist";
    String yes= "com.skysoft.kkbox.android:id/button_done";
    String SetText= "com.skysoft.kkbox.android:id/text_playlist_name";
    String DownloadAll = "com.skysoft.kkbox.android:id/button_download_all";
    String Download_yes= "android:id/button1";
    String collect_id = "com.skysoft.kkbox.android:id/button_collect_playlist";
    String Songlist_name_id = "com.skysoft.kkbox.android:id/label_playlist_name";
    String setSonglist_name;
    boolean Set_boolen;
    public Online_Song_Page(UiDevice mdevice){
        super(mdevice);
    }
    public Online_Song_Page set_Songlist_name(String Songlist_name){
        Set_boolen=true;
        this.setSonglist_name=Songlist_name;
        return  this;
    }
    public Online_Song_Page Add_song_list() throws  UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().resourceId(add_all_song_list)).click();
        mDevice.findObject(new UiSelector().resourceId(add_new_songlist)).click();
        if(Set_boolen == true)
        {
            mDevice.findObject(new UiSelector().resourceId(SetText)).setText(this.setSonglist_name);
        }
        mDevice.findObject(new UiSelector().resourceId(yes)).click();
        mDevice.wait(Until.hasObject(By.res(collect_id)),TIMEOUT);
        return this;
    }
    public Online_Song_Page Download_song_list()throws UiObjectNotFoundException{
        boolean playsong;
        mDevice.findObject(new UiSelector().resourceId(DownloadAll)).click();
        mDevice.wait(Until.findObject(By.text("下載")), TIMEOUT).click();
        playsong=mDevice.wait(Until.hasObject(By.text("確認")), TIMEOUT);
        if(playsong==true)
        {
            mDevice.findObject(new UiSelector().text("確認")).click();
        }

        return this;
    }
    public Online_Song_Page Collect_song_list()throws UiObjectNotFoundException{
        mDevice.findObject(new UiSelector().resourceId(collect_id)).click();
       KKPage.Online_Song_Page_collect_songlist_name=mDevice.findObject(new UiSelector().resourceId(Songlist_name_id)).getText();

        return this;
    }
    public Action_Page Open_Song_Action_Menu()throws UiObjectNotFoundException
    {   mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/button_track_overflow").instance(0)).click();
        return new Action_Page(mDevice);
    }
    public Songlist_Action_Page Open_Songlist_Action_Menu_edit()throws UiObjectNotFoundException
    {
        mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/menu_overflow")).click();
        BySelector edit = By.res(PACKAGE_name, "button_edit");
        mDevice.wait(Until.findObject(edit), ShortTIMEOUT).click();
        return new Songlist_Action_Page(mDevice);
    }
    public Online_Song_Page get_songlist_num()throws UiObjectNotFoundException{

        UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/recyclerview");
        UiSelector category_playlist;
        UiScrollable move = new UiScrollable(viewpage);
        UiSelector songlist_num = new UiSelector().resourceId("com.skysoft.kkbox.android:id/layout_footer_title").childSelector(new UiSelector().className("android.widget.TextView"));
        move.scrollIntoView(songlist_num);
        KKPage.Online_Song_Page_song_list_num = mDevice.findObject(songlist_num).getText();
        return this;
    }
    public Online_Song_Page check_songlist_num()throws UiObjectNotFoundException {

            UiSelector viewpage = new UiSelector().resourceId("com.skysoft.kkbox.android:id/recyclerview");
            UiSelector category_playlist;
            UiScrollable move = new UiScrollable(viewpage);
            UiSelector songlist_num = new UiSelector().resourceId("com.skysoft.kkbox.android:id/layout_footer_title").childSelector(new UiSelector().className("android.widget.TextView"));
            move.scrollIntoView(songlist_num);
            System.out.println("---------------------" + mDevice.findObject(songlist_num).getText());
        if (KKPage.delete_songlist == true) {

            assertNotEquals(mDevice.findObject(songlist_num).getText(), KKPage.Online_Song_Page_song_list_num);
        }
        else {
            assertEquals(mDevice.findObject(songlist_num).getText(), KKPage.Online_Song_Page_song_list_num);
        }
        return this;
    }
    public Online_Song_Page check_collect_song()throws UiObjectNotFoundException {

        String alumbe = KKPage.Action_Page_Aritst_name + " - "+KKPage.Action_Page_Albume_name;
        String get_alumbe = mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/label_track_subtitle").instance(0)).getText();
        //BySelector albume = By.text(alumbe);
        System.out.println("-----------"+alumbe);
        //System.out.println(mDevice.findObject(new UiSelector().resourceId("com.skysoft.kkbox.android:id/label_track_subtitle").instance(0)).getText());
        assertEquals(get_alumbe, alumbe);

        return this;
    }
    public  Online_Song_Page check_delet_alubm()throws UiObjectNotFoundException {
        String alumbe = KKPage.Action_Page_Aritst_name + " - "+KKPage.Action_Page_Albume_name;
        BySelector text = By.text(alumbe);
        assertFalse(mDevice.wait(Until.hasObject(text), ShortTIMEOUT));
        //assertTrue(mDevice.wait(Until.hasObject(selector), TIMEOUT));
        return  this;
    }
    public Online_Song_Page check_delet_song()throws UiObjectNotFoundException{
        BySelector text = By.text(KKPage.Action_Page_Song_name);
        assertFalse(mDevice.wait(Until.hasObject(text), ShortTIMEOUT));
        return this;
    }
    public Online_Song_Page check_add_song_list() throws UiObjectNotFoundException{
        BySelector add_page = By.res(PACKAGE_name, "sub_fragment");
        mDevice.findObject(new UiSelector().resourceId(add_all_song_list)).click();
        assertTrue(mDevice.wait(Until.hasObject(add_page), TIMEOUT));
        return this;
    }


}
