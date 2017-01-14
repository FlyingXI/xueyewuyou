package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lzu.homework_easy.homework_check.*;
import com.zxinsight.MLink;
import com.zxinsight.MWConfiguration;
import com.zxinsight.MagicWindowSDK;


/**
 * Created by Administrator on 2016/10/1.
 */
public class WorkCheck extends BaseActivity {

    private boolean selected = false;

    private int[] header = new int[]{R.drawable.header1, R.drawable.header2, R.drawable.imagehead};
    private String[] name = new String[]{"张三", "李四", "黄二"};
    private String[] school = new String[]{"北京实验中学", "南京实验中学", "天津实验中学"};
    private String[] subject = new String[]{"语文", "数学", "英语"};
    private String[] count = new String[]{"40", "50", "47"};
    private String[] time_day = new String[]{"2016.09.27", "2016.09.28", "2016.09.29"};
    private String[] time = new String[]{"09：27", "09：28", "09：29"};
    private String[] sh_work_type = new String[]{"学校作业", "家庭作业", "学校作业"};
    private String[] work_type = new String[]{"电子作业", "电子作业", "拍照作业"};
    private String[] reward = new String[]{"10.00", "5.00", "1.00"};

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_work);
        initMu();
        //跳转router调用
        if (getIntent().getData() != null) {
            MLink.getInstance(this).router(getIntent().getData());
            //跳转后结束当前activity
        }


//学校作业

            List<Map<String, Object>> listItem1 = new ArrayList<Map<String, Object>>() {
            };
            setItem(school, subject, count, time_day, time, listItem1);

            final MyAdapter simpleAdapter1 = new MyAdapter(this, listItem1,
                    R.layout.study_swork_item,
                    new String[]{"school", "subject", "count"
                            , "time_day", "time"},
                    new int[]{R.id.swork_school, R.id.swork_subject, R.id.swork_count,
                            R.id.swork_time_day, R.id.swork_time});
            final ListView list1 = (ListView) findViewById(R.id.list1);
            list1.setAdapter(simpleAdapter1);
            list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (!selected) {
                        simpleAdapter1.getView(position, view, list1);
                        selected = true;
                    }
                }
            });
            //家庭作业
            List<Map<String, Object>> listItem2 = new ArrayList<Map<String, Object>>() {
            };
            setItem(header, name, school, subject, time_day, time, listItem2);
            SimpleAdapter simpleAdapter2 = new MyAdapterH(this, listItem2,
                    R.layout.study_hwork_item,
                    new String[]{"header", "name", "school", "subject"
                            , "time_day", "time"},
                    new int[]{R.id.hwork_header, R.id.hwork_name, R.id.hwork_school,
                            R.id.hwork_subject, R.id.hwork_time_day, R.id.hwork_time});
            final ListView list2 = (ListView) findViewById(R.id.list2);
            list2.setAdapter(simpleAdapter2);
            list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (!selected) {
                        simpleAdapter1.getView(position, view, list2);
                        selected = true;
                    }
                }
            });


//未批改作业
            List<Map<String, Object>> listItem3 = new ArrayList<Map<String, Object>>() {
            };
            setItem(header, name, school, subject, time_day, time, sh_work_type, work_type, reward, listItem3);
            SimpleAdapter simpleAdapter3 = new MyAdapterN(this, listItem3,
                    R.layout.study_ncheck_item,
                    new String[]{"header", "name", "school", "subject"
                            , "time_day", "time", "sh_type", "work_type", "reward"},
                    new int[]{R.id.ncheck_header, R.id.ncheck_name, R.id.ncheck_school,
                            R.id.ncheck_subject, R.id.ncheck_time_day, R.id.ncheck_time,
                            R.id.ncheck_sh_type, R.id.ncheck_work_type, R.id.ncheck_reward});
            final ListView list3 = (ListView) findViewById(R.id.list3);
            list3.setAdapter(simpleAdapter3);
            list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    simpleAdapter1.getView(position, view, list3);
                }
            });


//        list1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(WorkCheck.this,"test",Toast.LENGTH_LONG).show();
//            }
//        });

            final TabHost tabHost = (TabHost) findViewById(R.id.messageTabHost);

            // 如果不是继承TabActivity，则必须在得到tabHost之后，添加标签之前调用tabHost.setup()
            tabHost.setup();

            // 这里content的设置采用了布局文件中的view
            tabHost.addTab(tabHost.newTabSpec("tab1")
                    .setIndicator("学校作业").setContent(R.id.message1));
            tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("家庭作业")
                    .setContent(R.id.message2));
            tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("待批改")
                    .setContent(R.id.message3));
            setTab(tabHost);


//        标签页的设置
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    setTab(tabHost);
                }
            });

            //个人中心
            View personCenter = (View) findViewById(R.id.person_center);
            personCenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WorkCheck.this, PersonalCenterActivity.class);
                    startActivity(intent);
                }
            });
//消息中心
            View messageCenter = (View) findViewById(R.id.message_center);
            messageCenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WorkCheck.this, MessageCenter.class);
                    startActivity(intent);
                }
            });
        }


    private void initMu() {
        MWConfiguration config = new MWConfiguration(this);
//设置渠道，非必须（渠道推荐在AndroidManifest.xml内填写）
        config.setDebugModel(true)
                //设置分享方式，如果之前有集成sharesdk，可在此开启
                .setSharePlatform(MWConfiguration.ORIGINAL);
        MagicWindowSDK.initSDK(config);
        MLink.getInstance(this).registerWithAnnotation(this);
    }

    private void setTab(final TabHost mTabHost) {
        TabWidget tabWidget = mTabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getChildCount(); i++) {
            View tabView = mTabHost.getTabWidget().getChildAt(i);

            TextView text = (TextView) tabWidget.getChildAt(i).findViewById(android.R.id.title);

            // 文字居中
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) text.getLayoutParams();
            params.width = RelativeLayout.LayoutParams.MATCH_PARENT;
            params.height = RelativeLayout.LayoutParams.MATCH_PARENT;
//            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            text.setLayoutParams(params);
            text.setGravity(Gravity.CENTER);

            if (mTabHost.getCurrentTab() == i) {
                // 选中
                tabView.setBackgroundResource(R.drawable.bg_blue_blue);
            } else {
                // 未选中
                tabView.setBackgroundResource(R.drawable.bg_blue_gray);
            }
        }
    }


    //学校作业详情Item添加
    private List<Map<String, Object>> setItem(String swork_school, String swork_subject,
                                              String swork_count, String swork_time_day,
                                              String swork_time, List<Map<String, Object>> listItems) {
        Map<String, Object> listItem = new HashMap<String, Object>() {
        };
        listItem.put("swork_school", swork_school);
        listItem.put("swork_subject", swork_subject);
        listItem.put("swork_count", swork_count);
        listItem.put("swork_time_day", swork_time_day);
        listItem.put("swork_time", swork_time);
        listItems.add(listItem);
        return listItems;
    }

    private List<Map<String, Object>> setItem(String[] school, String[] subject,
                                              String[] count,
                                              String[] time_day, String[] time,
                                              List<Map<String, Object>> listItems) {
        for (int i = 0; i < school.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>() {
            };
            listItem.put("school", school[i]);
            listItem.put("subject", subject[i]);
            listItem.put("count", count[i]);
            listItem.put("time_day", time_day[i]);
            listItem.put("time", time[i]);
            listItems.add(listItem);
        }
        return listItems;
    }

    //家庭作业Item
    private List<Map<String, Object>> setItem(int header, String name, String school, String subject,
                                              String time_day,
                                              String time, List<Map<String, Object>> listItems) {
        Map<String, Object> listItem = new HashMap<String, Object>() {
        };
        listItem.put("header", header);
        listItem.put("name", name);
        listItem.put("school", school);
        listItem.put("subject", subject);
        listItem.put("time_day", time_day);
        listItem.put("time", time);
        listItems.add(listItem);
        return listItems;
    }

    private List<Map<String, Object>> setItem(int[] header, String[] name,
                                              String[] hschool, String[] subject,
                                              String[] time_day,
                                              String[] time, List<Map<String, Object>> listItems) {
        for (int i = 0; i < header.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>() {
            };
            listItem.put("header", header[i]);
            listItem.put("name", name[i]);
            listItem.put("school", school[i]);
            listItem.put("subject", subject[i]);
            listItem.put("time_day", time_day[i]);
            listItem.put("time", time[i]);
            listItems.add(listItem);
        }
        return listItems;
    }

    //未批改作业Item
    private List<Map<String, Object>> setItem(int header, String name, String school,
                                              String subject, String time_day,
                                              String time, String sh_type,
                                              String work_type, String reward,
                                              List<Map<String, Object>> listItems) {
        Map<String, Object> listItem = new HashMap<String, Object>() {
        };
        listItem.put("header", header);
        listItem.put("name", name);
        listItem.put("school", school);
        listItem.put("subject", subject);
        listItem.put("time_day", time_day);
        listItem.put("time", time);
        listItem.put("sh_type", sh_type);
        listItem.put("work_type", work_type);
        listItem.put("reward", "¥" + reward);
        listItems.add(listItem);
        return listItems;
    }

    private List<Map<String, Object>> setItem(int[] header, String[] name,
                                              String[] school, String[] subject,
                                              String[] time_day, String[] time,
                                              String[] sh_type,
                                              String[] work_type, String[] reward,
                                              List<Map<String, Object>> listItems) {
        for (int i = 0; i < header.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>() {
            };
            listItem.put("header", header[i]);
            listItem.put("name", name[i]);
            listItem.put("school", school[i]);
            listItem.put("subject", subject[i]);
            listItem.put("time_day", time_day[i]);
            listItem.put("time", time[i]);
            listItem.put("sh_type", sh_type[i]);
            listItem.put("work_type", work_type[i]);
            listItem.put("reward", "¥" + reward[i]);
            listItems.add(listItem);
        }
        return listItems;
    }
}
