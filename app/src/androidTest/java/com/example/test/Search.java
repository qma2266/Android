package com.example.test;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.BySelector;
import static org.junit.Assert.*;

import android.support.test.uiautomator.Until;
import android.view.KeyEvent;

public class Search extends KKPage {

    String Search_text_id= "com.skysoft.kkbox.android:id/search_src_text";
    String top_result_id= "com.skysoft.kkbox.android:id/layout_swipe";
    //String top_result_id= "com.skysoft.kkbox.android:id/recyclerview";
    String Artist_name_id = "android:id/text1";

    //String Artist_top_result= "com.skysoft.kkbox.android:id/layout_view";
    protected BySelector Song = By.text("歌曲");
    public Search(UiDevice mdevice) {
        super(mdevice);
    }
    public Search Enter_search_text (String text)throws UiObjectNotFoundException
    {   UiObject search_btn;
       /* search_btn = this.mDevice.findObject(new UiSelector().resourceId(Search_btn));
        search_btn.click();*/
        search_btn = this.mDevice.findObject(new UiSelector().resourceId(Search_text_id));
        search_btn.setText(text);
        this.mDevice.getInstance().pressKeyCode(KeyEvent.KEYCODE_ENTER);
        return  this;
    }
    public Search check_top_result(String except_result)throws UiObjectNotFoundException{
        UiObject top_result = mDevice.findObject(new UiSelector()
                .resourceId(top_result_id).index(1).childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(2).childSelector(new UiSelector().index(0)))));
        System.out.print("_______________________"+top_result.getText());
        assertEquals(top_result.getText(), except_result);
        return  this;
    }
    public Search check_Artist_name(String except_result)throws UiObjectNotFoundException{
        UiObject Artist_name = mDevice.findObject(new UiSelector()
                .resourceId(Artist_name_id).text("歌手"));
        Artist_name.click();
        BySelector selector = By.text(except_result);
        assertTrue(mDevice.wait(Until.hasObject(selector), TIMEOUT));
        return  this;
    }
    public Search check_Song_name(String except_result){
        mDevice.wait(Until.findObject(Song), TIMEOUT).click();
        BySelector selector = By.text(except_result);
        assertTrue(mDevice.wait(Until.hasObject(selector), TIMEOUT));
        return this;
    }
}
