package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/10/1.
 */
public class IncomeActivity extends Activity{


    private String money_constant = "+ ¥ ";
    private String[] income_time = new String[]{"2016.09.27","2016.09.28","2016.09.29"};
    private String[] income_type = new String[]{"批改张三的数学作业","批改李四的语文作业",
            "批改黄二的英语作业"};
    private String[] income_count = new String[]{money_constant+"20.00",
            money_constant+"30.00", money_constant+"10.00"};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);

        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>() {};
        for (int i = 0;i < 3;i++){
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("income_time",income_time[i]);
            listItem.put("income_type",income_type[i]);
            listItem.put("income_count",income_count[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.income_intem,
                new String[]{"income_time","income_type","income_count"},
                new int[]{R.id.income_time,R.id.income_type,R.id.income_count});
        ListView list1 = (ListView) findViewById(R.id.list1);
        ListView list2 = (ListView) findViewById(R.id.list2);
        list1.setAdapter(simpleAdapter);
        list2.setAdapter(simpleAdapter);

        final TabHost tabHost = (TabHost) findViewById(R.id.incomeTabHost);

        // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
        tabHost.setup();

        // 这里content的设置采用了布局文件中的view
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("学校作业").setContent(R.id.income1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("家庭作业")
                .setContent(R.id.income2));

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
            tv.setTypeface(Typeface.SERIF, 2); // 设置字体和风格
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
