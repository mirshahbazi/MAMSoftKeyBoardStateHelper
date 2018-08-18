package com.mam.softkeyboardstatehelper;


/**
 * *
 * *          ____  ____ _____ ___   ____
 * *         | \ \ / / |/ _  || \ \ / / |
 * *         | |\ V /| | (_| || |\ V /| |
 * *         |_| \_/ |_|\__,_||_| \_/ |_|
 * *
 * Created by Mohammad Ali Mirshahbazi
 */
public interface SoftKeyBoardStateListener {
    void onSoftKeyBoardOpened(int keyboardHeightInpx);
    void onSoftKeyBoardClosed();
}
