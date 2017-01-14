package com.lzu.homework_easy.homework_check;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyAdapter extends SimpleAdapter {

    Context context;
    public MyAdapter(Context context,
                     List<? extends Map<String, ?>> data, int resource,
                     String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        // TODO Auto-generated constructor stub
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        final int mPosition = position;
        convertView = super.getView(position, convertView, parent);
        final TextView bt1 = (TextView) convertView
                .findViewById(R.id.swork_bt);// id为你自定义布局中按钮的id
        bt1.setTag(position);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                    bt1.setTextColor(Color.WHITE);
                    bt1.setBackgroundResource(R.drawable.bg_gray_gray);
                    Toast.makeText(context, "该作业订单已添加", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,CameraWorkCheckActivity.class);
//                context.startActivity(intent);


            }
        });

        return convertView;
    }

}


