package com.lzu.homework_easy.homework_check;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TabHost;


/**
 * Created by Administrator on 2016/10/1.
 */
public class MessageCenter extends Activity{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);

        TabHost tabHost = (TabHost) findViewById(R.id.myTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("登录密码").setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("支付密码")
                .setContent(R.id.view2));
    }
}
