package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/10/1.
 */
public class ErrorCorrelation extends Activity {

    private String[] chapter = new String[]{"第一章","第二章","第三章"};
    private String[] sections = new String[]{"第1节","第2节","第4节"};
    private String[] title = new String[]{"拼音","句子","成语"};
    private String[] content = new String[]{"算法的空间复杂度","算法的空间复杂度","算法的空间复杂度"};
    private int[] order_number = new int[]{1,2,3};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error_correlation);
//错题关联添加
        List<Map<String,Object>> listItem1 = new ArrayList<Map<String,Object>>() {};
        setItem(chapter,sections,title,content,order_number,listItem1);

        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this,listItem1,
                R.layout.error_correlation_item,
                new String[]{"chapter","sections","title"
                        ,"content","order_number"},
                new int[]{R.id.chapter,R.id.sections,R.id.title,
                        R.id.content,R.id.order_number});
        final ListView list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(simpleAdapter1);


//        list1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(WorkCheck.this,"test",Toast.LENGTH_LONG).show();
//            }
//        });
    }


//错题关联Item添加
    private List<Map<String,Object>> setItem(String chapter,String sections,
                                 String title, String content,int order_number,
                                             List<Map<String,Object>> listItems){
        Map<String,Object> listItem = new HashMap<String,Object>(){};
        listItem.put("chapter",chapter);
        listItem.put("sections",sections);
        listItem.put("title",title);
        listItem.put("content",content);
        listItem.put("order_number",order_number);
        listItems.add(listItem);
        return listItems;
    }

    private List<Map<String,Object>> setItem(String[] chapter,String[] sections,
                                             String[] title, String[] content,int[] order_number,
                                             List<Map<String,Object>> listItems){
        for (int i = 0; i < chapter.length; i++) {
            Map<String,Object> listItem = new HashMap<String,Object>(){};
            listItem.put("chapter",chapter[i]);
            listItem.put("sections",sections[i]);
            listItem.put("title",title[i]);
            listItem.put("content",content[i]);
            listItem.put("order_number",order_number[i]);
            listItems.add(listItem);}
            return listItems;
    }

}
