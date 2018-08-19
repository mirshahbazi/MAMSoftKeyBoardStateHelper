# MAMSoftKeyBoardStateHelper
detect softkeyboard status

MAMSoftKeyBoardStateHelper help you to detect softkeyboard status and do your job in view.
enjoy it :D.

[[![](https://jitpack.io/v/mirshahbazi/MAMSoftKeyBoardStateHelper.svg)](https://jitpack.io/#mirshahbazi/MAMSoftKeyBoardStateHelper)



# Usage
See the sample app. Typical usage:
```java
MorphTransform.addExtras(intent, color, dialogCornerRadius);
ActivityOptions options =
        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, button,
                getString(R.string.morph_transition));
startActivity(intent, options.toBundle());
```
in the first activity, then:
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
