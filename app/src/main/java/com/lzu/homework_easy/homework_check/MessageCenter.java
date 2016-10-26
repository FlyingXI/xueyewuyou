package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * Created by Administrator on 2016/10/1.
 */
public class MessageCenter extends Activity{


    private String[] message_type = new String[]{"系统消息","学生消息","系统消息"};
    private String[] message_time = new String[]{"2016.09.27","2016.09.28","2016.09.29"};
    private String[] message_view = new String[]{"您有一条作业订单，请及时处理.....",
            "来自初一3班学生的作业反馈消息，请注意查看....",
            "系统已更新到V1.2版本，查看更新详情....."};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_center);

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>() {};
        for (int i = 0;i < 3;i++){
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("message_type",message_type[i]);
            listItem.put("message_time",message_time[i]);
            listItem.put("message_view",message_view[i]);
            listItems.add(listItem);
    }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.message,
                new String[]{"message_type","message_time","message_view"},
                new int[]{R.id.message_type,R.id.message_time,R.id.message_view});
        ListView list1 = (ListView) findViewById(R.id.list1);
        ListView list2 = (ListView) findViewById(R.id.list2);
        list1.setAdapter(simpleAdapter);
        list2.setAdapter(simpleAdapter);

        final TabHost tabHost = (TabHost) findViewById(R.id.messageTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("全部").setContent(R.id.message1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("未读")
                .setContent(R.id.message2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("已读")
                .setContent(R.id.message3));
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
            tv.setTextSize(16);
            tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格
            tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0); //取消文字底边对齐
            params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); //设置文字居中对齐
            if (tabHost.getCurrentTab() == i) {//选中
                view.setBackgroundResource(R.drawable.bg_blue_blue);//选中后的背景
            } else {//不选中
                view.setBackgroundResource(R.drawable.bg_blue_gray);//非选择的背景
            }
        }
    }
}
