package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class GetMoneyWayActivity extends Activity {

    private CharSequence currentWay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_money_way);

        Intent intent = getIntent();
        currentWay = intent.getCharSequenceExtra("currentWay");

        RadioGroup mRadioGroup= (RadioGroup)findViewById(R.id.mgroup);
        final RadioButton bt1 = (RadioButton)findViewById(R.id.button1);
        final RadioButton bt2 = (RadioButton)findViewById(R.id.button2);

        if(bt1.getText().equals(currentWay) )
        {
            bt1.setChecked(true);
            bt2.setChecked(false);
            bt1.setBackgroundResource(R.drawable.bg_gold_white);
            bt2.setBackgroundResource(R.drawable.bg_gray_white);
        }else
        {
            bt1.setChecked(false);
            bt2.setChecked(true);
            bt1.setBackgroundResource(R.drawable.bg_gray_white);
            bt2.setBackgroundResource(R.drawable.bg_gold_white);
        }

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == bt1.getId()){
                    bt1.setBackgroundResource(R.drawable.bg_gold_white);
                    bt2.setBackgroundResource(R.drawable.bg_gray_white);
                    currentWay = bt1.getText();
                    Log.d("GetMoneyWayActivity", currentWay.toString());
                }
                else {
                    bt2.setBackgroundResource(R.drawable.bg_gold_white);
                    bt1.setBackgroundResource(R.drawable.bg_gray_white);
                    currentWay = bt2.getText();
                    Log.d("GetMoneyWayActivity", currentWay.toString());
                }
            }
        });

        //添加银行卡或支付宝
        Button addGetMoneyWay = (Button) findViewById(R.id.add_get_monet_way);
        addGetMoneyWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetMoneyWayActivity.this,AddBankCard.class);
                startActivity(intent);
            }
        });

        //返回键
        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("way",currentWay);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}
