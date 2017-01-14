package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GetMoneyActivity extends Activity {

    private TextView getMoneyWay;
    private CharSequence currentWay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_money);


        getMoneyWay = (TextView) findViewById(R.id.get_money_way);
        currentWay = getMoneyWay.getText();


        //提现金额与提现密码
        final LinearLayout linearLayoutCount = (LinearLayout) findViewById(R.id.get_money1);
        final LinearLayout linearLayoutPassWord = (LinearLayout)findViewById(R.id.get_money2);
        EditText getMoneyCount = (EditText)findViewById(R.id.get_money_count);
        getMoneyCount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    linearLayoutCount.setBackgroundResource(R.drawable.bg_blue_white);
                    linearLayoutPassWord.setBackgroundResource(R.drawable.bg_gray_white);
                }
            }
        });
        EditText getMoneyPassWord = (EditText)findViewById(R.id.get_money_password);
        getMoneyPassWord.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){
                    linearLayoutPassWord.setBackgroundResource(R.drawable.bg_blue_white);
                    linearLayoutCount.setBackgroundResource(R.drawable.bg_gray_white);
                }
            }
        });


        //提现方式
        getMoneyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetMoneyActivity.this,GetMoneyWayActivity.class);
                intent.putExtra("currentWay",currentWay);
                startActivityForResult(intent,1);
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

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    currentWay = data.getCharSequenceExtra("way");
                    getMoneyWay.setText(currentWay);
                }
        }
    }
}
