package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/17.
 */
public class PersonalCenterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center);

//作业订单查看
        View workLook = (View) findViewById(R.id.work_look);
        workLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this,MyWorkActivity.class);
                startActivity(intent);
            }
        });



//资料设置
        View manage = (View) findViewById(R.id.account_manage);
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this,AccountManageActivity.class);
                startActivity(intent);
        }
        });
//我的钱包
        View myWallet = (View) findViewById(R.id.my_wallet);
        myWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this,MyWalletActivity.class);
                startActivity(intent);
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



 //设置
        ImageView setting = (ImageView) findViewById(R.id.set);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalCenterActivity.this,SetActivity.class);
                startActivity(intent);
            }
        });


    }
}
