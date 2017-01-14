package com.lzu.homework_easy.homework_check;

import android.app.Activity;

import com.zxinsight.Session;

/**
 * Created by Administrator on 2017/1/10.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onPause() {
        Session.onPause(this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Session.onResume(this);
        super.onResume();
    }
}
