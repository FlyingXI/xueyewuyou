package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class GetMoneyWayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_money_way);


        RadioGroup mRadioGroup= (RadioGroup)findViewById(R.id.mgroup);
        final RadioButton bt1 = (RadioButton)findViewById(R.id.button1);
        final RadioButton bt2 = (RadioButton)findViewById(R.id.button2);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == bt1.getId()){
                    bt1.setBackgroundResource(R.drawable.bg_gold_white);
                    bt2.setBackgroundResource(R.drawable.bg_gray_white);
                }
                else {
                    bt2.setBackgroundResource(R.drawable.bg_gold_white);
                    bt1.setBackgroundResource(R.drawable.bg_gray_white);}
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

//        ImageButton mImageButton = (ImageButton)findViewById(R.id.password_set);
//        mImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,PassWord.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton mImageButton1 = (ImageButton)findViewById(R.id.message_set);
//        mImageButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,MessageCenter.class);
//                startActivity(intent);
//            }
//        });
    }
}
