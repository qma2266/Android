package com.example.test;
import android.content.Context;
import android.support.test.uiautomator.UiDevice;
import android.support.test.InstrumentationRegistry;
import android.app.Instrumentation;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.content.Intent;
import android.support.test.uiautomator.Until;
public class TestBuild {
    UiDevice mDevice;
    private String PACKAGE_name = "com.skysoft.kkbox.android";
    protected static final int LAUNCH_TIMEOUT = 10000;
    String Password;
    String email;
    boolean seteamil , mHasLogin;
    public TestBuild() {

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }
    public TestBuild givePassword(String email, String Password){
        this.Password = Password;
        this.email = email;
        seteamil= true;
        return this;
    }
    public TestBuild Pree_home(){
        mDevice.pressHome();
        return  this;
    }
    public KKPage launch() throws UiObjectNotFoundException{

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Context context = instrumentation.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_name);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        mHasLogin = mDevice.wait(Until.hasObject(KKPage.SEARCH_BUTTON), LAUNCH_TIMEOUT);
        if(seteamil == true&&mHasLogin==false)
        {
            new KKPage(mDevice).Login().login(email,Password);
        }

        return  new KKPage(mDevice);
    }

}
