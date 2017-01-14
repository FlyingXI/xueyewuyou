package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
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
public class MyWorkActivity extends Activity {


    private View view1, view2, view3;
    private ViewPager viewPager;  //对应的viewPager
    private List<View> viewList;//view数组

    private int[] header = new int[]{R.drawable.header1,R.drawable.header2,R.drawable.imagehead};
    private String[] name = new String[]{"张三","李四","黄二"};
    private String[] school = new String[]{"北京实验中学","南京实验中学","天津实验中学"};
    private String[] subject = new String[]{"语文","数学","英语"};
    private String[] count = new String[]{"40","50","47"};
    private String[] time_day = new String[]{"2016.09.27","2016.09.28","2016.09.29"};
    private String[] time = new String[]{"09：27","09：28","09：29"};
    private String[] sh_work_type = new String[]{"学校作业","家庭作业","学校作业"};
    private String[] work_type = new String[]{"电子作业","电子作业","拍照作业"};
    private String[] reward = new String[]{"10.00","5.00","1.00"};

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_work);

        final TextView total= (TextView)findViewById(R.id.total);
        final TextView noCheck= (TextView)findViewById(R.id.noCheck);
        final TextView checked= (TextView)findViewById(R.id.checked);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.my_work_total, null);
        view2 = inflater.inflate(R.layout.my_work_total,null);
        view3 = inflater.inflate(R.layout.my_work_total, null);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        final ListView list1 = (ListView) view1.findViewById(R.id.list1);
        final ListView list2 = (ListView) view2.findViewById(R.id.list1);



        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                switch (arg0){
                    case 0:total.setTextColor(Color.parseColor("#0cd6d6"));
                        noCheck.setTextColor(Color.parseColor("#716c6c"));
                        checked.setTextColor(Color.parseColor("#716c6c"));break;
                    case 1:total.setTextColor(Color.parseColor("#716c6c"));
                        noCheck.setTextColor(Color.parseColor("#0cd6d6"));
                        checked.setTextColor(Color.parseColor("#716c6c"));break;
                    case 2:total.setTextColor(Color.parseColor("#716c6c"));
                        noCheck.setTextColor(Color.parseColor("#716c6c"));
                        checked.setTextColor(Color.parseColor("#0cd6d6"));break;
                    default:break;
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });


    //家庭作业
//        List<Map<String,Object>> listItem1 = new ArrayList<Map<String,Object>>() {};
//        setItem(header,name,school,subject,time_day,time,listItem1);
//        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this,listItem1,
//                R.layout.study_hwork_item,
//                new String[]{"header","name","school","subject"
//                        ,"time_day","time"},
//                new int[]{R.id.hwork_header,R.id.hwork_name,R.id.hwork_school,
//                        R.id.hwork_subject,R.id.hwork_time_day,R.id.hwork_time});
//        list1.setAdapter(simpleAdapter1);


//未批改作业
        List<Map<String,Object>> listItem1 = new ArrayList<Map<String,Object>>() {};
        setItem(header,name,school,subject,time_day,time,sh_work_type,work_type,reward,listItem1);
        final MyAdapterN simpleAdapter2 = new MyAdapterN(this,listItem1,
                R.layout.study_ncheck_item,
                new String[]{"header","name","school","subject"
                        ,"time_day","time","sh_type","work_type", "reward"},
                new int[]{R.id.ncheck_header,R.id.ncheck_name,R.id.ncheck_school,
                        R.id.ncheck_subject,R.id.ncheck_time_day,R.id.ncheck_time,
                        R.id.ncheck_sh_type,R.id.ncheck_work_type,R.id.ncheck_reward});
        list1.setAdapter(simpleAdapter2);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                simpleAdapter2.getView(position, view, list1);
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


//学校作业详情Item添加
    private List<Map<String,Object>> setItem(String swork_school,String swork_subject,
                                 String swork_count, String swork_time_day,
                                 String swork_time,List<Map<String,Object>> listItems){
        Map<String,Object> listItem = new HashMap<String,Object>(){};
        listItem.put("swork_school",swork_school);
        listItem.put("swork_subject",swork_subject);
        listItem.put("swork_count",swork_count);
        listItem.put("swork_time_day",swork_time_day);
        listItem.put("swork_time",swork_time);
        listItems.add(listItem);
        return listItems;
    }

    private List<Map<String,Object>> setItem(String[] school,String[] subject,
                                                  String[] count,
                                                  String[] time_day,String[] time,
                                                  List<Map<String,Object>> listItems){
        for (int i = 0;i < school.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("school",school[i]);
            listItem.put("subject",subject[i]);
            listItem.put("count",count[i]);
            listItem.put("time_day",time_day[i]);
            listItem.put("time",time[i]);
            listItems.add(listItem);
        }
        return listItems;
    }
    //家庭作业Item
    private List<Map<String,Object>> setItem(int header,String name,String school,String subject,
                                                   String time_day,
                                                   String time,List<Map<String,Object>> listItems){
        Map<String,Object> listItem = new HashMap<String,Object>(){};
        listItem.put("header",header);
        listItem.put("name",name);
        listItem.put("school",school);
        listItem.put("subject",subject);
        listItem.put("time_day",time_day);
        listItem.put("time",time);
        listItems.add(listItem);
        return listItems;
    }
    private List<Map<String,Object>> setItem(int[] header,String[] name,
                                             String[] hschool, String[] subject,
                                             String[] time_day,
                                             String[] time,List<Map<String,Object>> listItems){
        for (int i = 0; i < header.length; i++) {
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("header",header[i]);
            listItem.put("name",name[i]);
            listItem.put("school",school[i]);
            listItem.put("subject",subject[i]);
            listItem.put("time_day",time_day[i]);
            listItem.put("time",time[i]);
            listItems.add(listItem);
        }
        return listItems;
    }
    //未批改作业Item
    private List<Map<String,Object>> setItem(int header,String name,String school,
                                             String subject, String time_day,
                                             String time, String sh_type,
                                             String work_type,String reward,
                                             List<Map<String,Object>> listItems){
        Map<String,Object> listItem = new HashMap<String,Object>(){};
        listItem.put("header",header);
        listItem.put("name",name);
        listItem.put("school",school);
        listItem.put("subject",subject);
        listItem.put("time_day",time_day);
        listItem.put("time",time);
        listItem.put("sh_type",sh_type);
        listItem.put("work_type",work_type);
        listItem.put("reward","¥"+reward);
        listItems.add(listItem);
        return listItems;
    }
    private List<Map<String,Object>> setItem(int[] header,String[]name,
                                             String[] school, String[] subject,
                                             String[] time_day, String[] time,
                                             String[] sh_type,
                                             String[] work_type,String[] reward,
                                             List<Map<String,Object>> listItems){
        for (int i = 0; i < header.length; i++) {
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("header",header[i]);
            listItem.put("name",name[i]);
            listItem.put("school",school[i]);
            listItem.put("subject",subject[i]);
            listItem.put("time_day",time_day[i]);
            listItem.put("time",time[i]);
            listItem.put("sh_type",sh_type[i]);
            listItem.put("work_type",work_type[i]);
            listItem.put("reward","¥"+reward[i]);
            listItems.add(listItem);
        }
        return listItems;
    }

}
