//package com.example.test;
//
//import android.content.Context;
//import static org.junit.Assert.*;
//import android.os.health.UidHealthStats;
//import android.support.test.runner.AndroidJUnit4;
//import android.support.test.uiautomator.UiDevice;
//import android.support.test.InstrumentationRegistry;
//import android.app.Instrumentation;
//import android.support.test.uiautomator.UiSelector;
//import android.support.test.uiautomator.UiObject;
//import android.support.test.uiautomator.UiObject2;
//import android.support.test.uiautomator.UiObjectNotFoundException;
//import android.content.Intent;
//import org.junit.Before;
//
//import android.support.test.uiautomator.By;
//import android.support.test.uiautomator.Until;
//import android.util.Log;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//@RunWith(AndroidJUnit4.class)
//public class Alltest {
//    static  UiDevice mDevice;
//    static  String PACKAGE_name = "com.skysoft.kkbox.android";
//    @BeforeClass
//    public static void setup(){
//        //UiDevice uiDevice = UiDevice.getInstance(instrumentation);
//
//
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        Context context = instrumentation.getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_name);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        mDevice.pressHome();
//        context.startActivity(intent);
//    }
//    @Test
//    public void LoginKKBOX() throws UiObjectNotFoundException {
//   // login_test login = new login_test();
//  //  login.login_KKBOX(mDevice);
//    }
//    @Test
//    public void SearchKKBOX() throws UiObjectNotFoundException {
//       /*
//        String searchgoal = "Fade";
//        Search search = new Search();
//        search.Search_KKBOX(mDevice, searchgoal);
//        assertEquals(searchgoal, search.Get_top_result());
//        System.out.println(search.Get_top_result());
//        */
//    }
//
//
//}
