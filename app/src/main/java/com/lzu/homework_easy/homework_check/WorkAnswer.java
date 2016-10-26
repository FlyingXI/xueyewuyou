package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
public class WorkAnswer extends Activity {

    private String[] selected_answer = new String[]{"选择题","1. A","2. B","3. C","4. C"};
    private String[] question_answer = new String[]{"解答题","5.  ①依法治国的目标：建设社会主义法治国家\n" +
            "②社会主义法律和社会主义道德共同的目标：巩固社会主义制度，维护良好的社会秩序，" +
            "促进和保证社会主义现代化建设事业向前发展","6  国家的本质：在阶级社会，国家是阶级统治的工具\n" +
            "  奴隶制国家的本质：奴隶主阶级统治奴隶阶级的工具\n" +
            "  封建制国家的本质：地主阶级统治农民阶级的工具"};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_answer);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.work_answer_item
        ,selected_answer);
        ListView list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.work_answer_item
                ,question_answer);
        ListView list2 = (ListView) findViewById(R.id.list2);
        list2.setAdapter(adapter2);


//        list1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(WorkCheck.this,"test",Toast.LENGTH_LONG).show();
//            }
//        });
    }

}
