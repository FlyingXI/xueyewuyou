package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MessageSetActivity extends Activity {


    private boolean mRemindSwitch = true;
    private boolean mPushSwitch = true;

    public boolean ismRemindSwitch() {
        return mRemindSwitch;
    }

    public boolean ismPushSwitch() {
        return mPushSwitch;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_set);

//新作业提醒

        final ImageView newWorkRemind = (ImageView) findViewById(R.id.new_work_remind);
        newWorkRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRemindSwitch == true){
                    newWorkRemind.setImageResource(R.drawable.switch_on);
                    mRemindSwitch = false;
                }
                else {
                    newWorkRemind.setImageResource(R.drawable.switch_off);
                    mRemindSwitch = true;
                }
            }
        });

 //新作业推送

        final ImageView newWorkPush = (ImageView) findViewById(R.id.new_work_push);
        newWorkPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPushSwitch == true){
                    newWorkPush.setImageResource(R.drawable.switch_on);
                    mPushSwitch = false;
                }
                else {
                    newWorkPush.setImageResource(R.drawable.switch_off);
                    mPushSwitch = true;
                }
            }
        });


//返回键
        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
