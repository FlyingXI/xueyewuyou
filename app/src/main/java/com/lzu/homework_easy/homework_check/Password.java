package com.lzu.homework_easy.homework_check;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zxinsight.mlink.annotation.MLinkDefaultRouter;
import com.zxinsight.mlink.annotation.MLinkRouter;


/**
 * Created by Administrator on 2016/10/1.
 */
@MLinkDefaultRouter
public class PassWord extends Activity{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        EditText user = (EditText)findViewById(R.id.password);
        String name = getIntent().getStringExtra("name");
        if(name!=null){
            user.setText(name);
        }

        final TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("登录密码").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("支付密码")
                .setContent(R.id.view2));
        setTab(tabHost);
        //标签页的设置
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                setTab(tabHost);
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

    private void setTab (TabHost tabHost){
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            View view = tabHost.getTabWidget().getChildAt(i);
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
//            tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();
            params.width = RelativeLayout.LayoutParams.MATCH_PARENT;
            params.height = RelativeLayout.LayoutParams.MATCH_PARENT;
//            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            tv.setLayoutParams(params);
            tv.setGravity(Gravity.CENTER);
            if (tabHost.getCurrentTab() == i) {//选中
                view.setBackgroundResource(R.drawable.bg_blue_blue);//选中后的背景
            } else {//不选中
                view.setBackgroundResource(R.drawable.bg_blue_gray);//非选择的背景
            }
        }
    }
}
