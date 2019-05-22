package com.example.test;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class testtt {
    static  UiDevice mDevice;

    static  String PACKAGE_name = "com.skysoft.kkbox.android";
    static KKPage kkPage ;
    @BeforeClass
    public static void login() throws UiObjectNotFoundException{
        kkPage = new TestBuild().givePassword("demo1938@kkbox.com","1938test").Pree_home().launch();
    }
    @Before
    public void setup()throws UiObjectNotFoundException{
        //UiDevice uiDevice = UiDevice.getInstance(instrumentation);
        kkPage = new TestBuild().launch();

    }

    @Test
    public void Search_top_result() throws UiObjectNotFoundException {
        //kkPage.Hompage().Open_Search_Page().Enter_search_text("fade").check_top_result("Fade");
        //kkPage.Open_Search_page().Enter_search_text("周杰倫").check_Artist_name("周杰倫 (Jay Chou)");
        kkPage.Search_page().Enter_search_text("darkside").check_Artist_name("Darkside");
    }
    /*
    @Test
    public void Open_today_Song()throws UiObjectNotFoundException{
        //kkPage.Hompage().Open_Today_Song("R&B歷年冠軍神曲1990-1999");
        kkPage.Hompage().Open_for_you_list("日語 每日特調");
        //kkPage.Hompage().Open_Today_Song().set_Songlist_name("Test1").Add_song_list();
        //kkPage.Online_Song_Page().Download_song_list();
    }
    @Test
    public void Check_Artist_name()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Search_Page().Enter_search_text("周杰倫").check_Artist_name("周杰倫 (Jay Chou)");
    }
    @Test
    public void Check_Song_naem()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Search_Page().Enter_search_text("小情歌").check_Song_name("小情歌");
    }
    @Test
    public void Open_Browse_All_Song()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Drawer().Open_My_Library().Opne_All_Song().Open_Browse_Song();
    }
    @Test
    public void Open_Browse_Artist()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Drawer().Open_My_Library().Opne_All_Song().Open_Browse_Artist_name();
    }
    @Test
    public void Open_Browse_Alubm()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Drawer().Open_My_Library().Opne_All_Song().Open_Browse_alubm_name();
    }
    @Test
    public void Open_profile()throws UiObjectNotFoundException{
        kkPage.Hompage().Open_Drawer().Open_Profile();
        kkPage.Open_Drawer_page();
    }
    @Test
    public void check_collect_songlist()throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Today_Song("cool")
                .is(Online_Song_Page.class).Collect_song_list();

        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).Opne_collect_songlist()
                .is(Browse_Page.class).Check_collect_songlist_name();
    }
    @Test
    public void check_add_song_list()throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Today_Song("test")
                .is(Online_Song_Page.class).set_Songlist_name("test2")
                .is(Online_Song_Page.class).Add_song_list();

        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).check_add_song_list_name("test2");
    }
    @Test
    public void check_add_songlist_number()throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Today_Song("no")
                .is(Online_Song_Page.class).set_Songlist_name("test2")
                .is(Online_Song_Page.class).Add_song_list()
                .is(Online_Song_Page.class).get_songlist_num();

        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).open_song_list("test2")
                .is(Online_Song_Page.class).check_songlist_num();

    }
    @Test
    public void check_collect_song()throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Today_Song("d")
                .is(Online_Song_Page.class).Open_Song_Action_Menu()
                .is(Action_Page.class).collect_song();

        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).Open_collect_song()
                .is(Online_Song_Page.class).check_collect_song();
    }
    @Test
    public void check_allsong_add_mylibrary() throws  UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).Opne_All_Song()
                .is(All_Song_Page.class).Open_Browse_Song()
                .is(Online_Song_Page.class).check_add_song_list();
    }
    @Test
    public void delete_alumbe_brose()throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Hompage()
                .is(HomePage.class).Open_Drawer()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).Opne_All_Song()
                .is(All_Song_Page.class).Open_Browse_alubm_name()
                .is(Browse_Page.class).delet_songlist();

        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).Opne_All_Song()
                .is(All_Song_Page.class).Open_Browse_Song()
                .is(Online_Song_Page.class).check_delet_alubm();
    }
    @Test
    public  void check_Rename_songlist() throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).open_action_my_songlist()
                .is(My_Sonlist_Action_Page.class).Rename("New")
                .is(My_Library_Page.class).check_add_song_list_name("New");

    }
    @Test
    public void check_delet_song() throws UiObjectNotFoundException{
        kkPage.is(KKPage.class).Open_Drawer_page()
                .is(Drawer_Page.class).Open_My_Library()
                .is(My_Library_Page.class).open_song_list("New")
                .is(Online_Song_Page.class).get_songlist_num()
                .is(Online_Song_Page.class).Open_Songlist_Action_Menu_edit()
                .is(Songlist_Action_Page.class).delete_song()
                .is(Online_Song_Page.class).check_songlist_num()
                .is(Online_Song_Page.class).check_delet_song();
    }
*/
}
