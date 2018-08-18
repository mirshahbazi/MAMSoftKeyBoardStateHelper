package com.mam.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mam.softkeyboardstatehelper.SoftKeyBoardStateHelper;
import com.mam.softkeyboardstatehelper.SoftKeyBoardStateListener;
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
public class MainActivity extends AppCompatActivity {
    TextView mKeyboardStatus;

    EditText mTextField;

    SoftKeyBoardStateHelper softKeyBoardStateHelper;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        mKeyboardStatus = (TextView) findViewById(R.id.keyboard_status);
        mTextField = (EditText) findViewById(R.id.text_field);
        softKeyBoardStateHelper.addSoftKeyBoardStateListener(this, new SoftKeyBoardStateListener() {
            @Override
            public void onSoftKeyBoardOpened(int keyboardHeightInpx) {
                mKeyboardStatus.setText("SoftKeyBoard status is "+softKeyBoardStateHelper.isSoftKeyboardOpened()+" and height is "+keyboardHeightInpx);
            }

            @Override
            public void onSoftKeyBoardClosed() {
                mKeyboardStatus.setText("SoftKeyBoard status is "+softKeyBoardStateHelper.isSoftKeyboardOpened());
            }
        });

    }
}
