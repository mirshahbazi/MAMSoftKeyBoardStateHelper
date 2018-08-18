package com.mam.softkeyboardstatehelper.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.WindowManager;

import java.lang.reflect.Method;


/**
 * *
 * *          ____  ____ _____ ___   ____
 * *         | \ \ / / |/ _  || \ \ / / |
 * *         | |\ V /| | (_| || |\ V /| |
 * *         |_| \_/ |_|\__,_||_| \_/ |_|
 * *
 * Created by Mohammad Ali Mirshahbazi
 */
public class Utils {
    public static boolean checkDeviceHasNavigationBar(Activity activity) {
        boolean hasNavigationBar = false;
        Resources rs = activity.getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;
    }

    public static boolean checkDeviceHasStatusBar(Activity activity) {
        if ((activity.getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int dip2px(Context context, float dipValue) {
        if (context == null) {
            return (int) dipValue;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
