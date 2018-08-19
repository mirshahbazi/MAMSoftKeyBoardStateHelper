# MAMSoftKeyBoardStateHelper
detect softkeyboard status

MAMSoftKeyBoardStateHelper help you to detect softkeyboard status and do your job in view.
enjoy it :D.

[![](https://jitpack.io/v/mirshahbazi/MAMSoftKeyBoardStateHelper.svg)](https://jitpack.io/#mirshahbazi/MAMSoftKeyBoardStateHelper)

https://github.com/mirshahbazi/MAMSoftKeyBoardStateHelper/blob/master/.idea/demo/demoMAM.gif

# Usage
See the sample app. Typical usage:
in the activity:
```java
 SoftKeyBoardStateHelper softKeyBoardStateHelper;
       softKeyBoardStateHelper.addSoftKeyBoardStateListener(this, new SoftKeyBoardStateListener() {
            @Override
            public void onSoftKeyBoardOpened(int keyboardHeightInpx) {
              //do some thing keyboard is opened
            }

            @Override
            public void onSoftKeyBoardClosed() {
               //do some thing keyboard is closed
            }
        });
```

## Using with gradle
- Add the JitPack repository to your root build.gradle:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

- Add the dependency to your sub build.gradle:
```gradle
	dependencies {
	    implementation 'com.github.mirshahbazi:MAMSoftKeyBoardStateHelper:14b305e465'
	}


```


License
--------

    Copyright MAM
