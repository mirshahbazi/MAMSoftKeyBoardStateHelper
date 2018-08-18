package com.mam.softkeyboardstatehelper;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.mam.softkeyboardstatehelper.utils.Utils;


/**
 * *
 * *          ____  ____ _____ ___   ____
 * *         | \ \ / / |/ _  || \ \ / / |
 * *         | |\ V /| | (_| || |\ V /| |
 * *         |_| \_/ |_|\__,_||_| \_/ |_|
 * *
 * Created by Mohammad Ali Mirshahbazi
 */

public class SoftKeyBoardStateHelper {
    private static boolean isSoftKeyboardOpened;
    private static final float MIN_KEYBOARD_HEIGHT=100;

    public static void addSoftKeyBoardStateListener(final Activity activity, final SoftKeyBoardStateListener listener) {
        if (activity == null) {
            throw new NullPointerException("activity must not be null");
        }
        int softInputMethod = activity.getWindow().getAttributes().softInputMode;
        if (softInputMethod == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING) {
            throw new IllegalArgumentException("window SoftInputMethod is  SOFT_INPUT_ADJUST_NOTHING");
        }
        if (listener == null) {
            throw new NullPointerException("Parameter:listener must not be null");
        }
        final View activityRoot = ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener=new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int navigationBarHeight = 0;

                int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
                if (resourceId > 0 && Utils.checkDeviceHasNavigationBar(activity)) {
                    navigationBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
                }

                int statusBarHeight = 0;
                resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (resourceId > 0 && Utils.checkDeviceHasStatusBar(activity)) {
                    statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
                }
                Rect rect = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int keyboardHeight = activity.getWindow().getDecorView().getRootView().getHeight() - (statusBarHeight + navigationBarHeight + rect.height());

                if (keyboardHeight > Utils.dip2px(activity,MIN_KEYBOARD_HEIGHT) && !isSoftKeyboardOpened) {
                    isSoftKeyboardOpened = true;
                    listener.onSoftKeyBoardOpened(keyboardHeight);

                } else if (keyboardHeight < Utils.dip2px(activity,MIN_KEYBOARD_HEIGHT) && isSoftKeyboardOpened) {
                    isSoftKeyboardOpened = false;
                    listener.onSoftKeyBoardClosed();
                }
            }
        };
        activityRoot.getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
        activity.getApplication().registerActivityLifecycleCallbacks(new AutoActivityLifeCycleCallback(activity) {
            @Override
            protected void onCurrentActivityDestroyed() {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                    activityRoot.getViewTreeObserver().removeOnGlobalLayoutListener(globalLayoutListener);
                }else {
                    activityRoot.getViewTreeObserver()
                            .removeGlobalOnLayoutListener(globalLayoutListener);
                }
            }
        });
    }




    public static boolean isSoftKeyboardOpened() {
        return isSoftKeyboardOpened;
    }


}
