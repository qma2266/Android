
./gradlew -q installDebug installDebugAndroidTest

adb uninstall com.skysoft.kkbox.android

cd apk && adb install -g kkbox_6.3.57(60357)_Build_2805_2019-05-15-11-09-48_debug.apk && cd -

## run test

sh "$ adb shell am instrument -w -r -e debug false -e class 'com.example.test.testtt#Check_Artist_name' com.example.test.test/android.support.test.runner.AndroidJUnitRunner"