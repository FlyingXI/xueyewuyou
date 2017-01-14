package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyWalletActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wallet);

//收益记录
        TextView income_record = (TextView) findViewById(R.id.income_record);
        income_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyWalletActivity.this,IncomeActivity.class);
                startActivity(intent);
            }
        });
//马上提现
        Button moneyGet = (Button) findViewById(R.id.get_money);
        moneyGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyWalletActivity.this,GetMoneyActivity.class);
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
    }
}
