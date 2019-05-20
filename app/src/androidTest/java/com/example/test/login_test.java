package com.example.test;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;

public class login_test extends KKPage {
    private String Login_id_btn = "com.skysoft.kkbox.android:id/button_login";
    private String Loing_id_other_btn = "com.google.android.gms:id/cancel";
    private String Loing_id_email_btn = "com.skysoft.kkbox.android:id/button_login_with_email";
    private String set_password = "com.skysoft.kkbox.android:id/text_password";
    private String set_email = "com.skysoft.kkbox.android:id/text_uid";
    private String login = "com.skysoft.kkbox.android:id/button_login";

    public login_test(UiDevice mdevice) {
        super(mdevice);
    }

    public login_test login(String email, String password) throws UiObjectNotFoundException {
        this.mDevice.findObject(new UiSelector().resourceId(Login_id_btn)).click();
        boolean jud_other_btn;
        jud_other_btn = this.mDevice.wait(Until.hasObject(By.text("其他")), TIMEOUT);
        if (jud_other_btn == true) {
            this.mDevice.findObject(new UiSelector().resourceId(Loing_id_other_btn)).click();
        }
        this.mDevice.findObject(new UiSelector().resourceId(Loing_id_email_btn)).click();
        //this.mDevice.findObject(new UiSelector().resourceId(set_email)).click();
        this.mDevice.findObject(new UiSelector().resourceId(set_email)).setText(email);
        this.mDevice.findObject(new UiSelector().resourceId(set_password)).setText(password);
        this.mDevice.findObject(new UiSelector().resourceId(login)).click();
        return this;
    }
}

