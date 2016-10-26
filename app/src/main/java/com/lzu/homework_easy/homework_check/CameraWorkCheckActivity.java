package com.lzu.homework_easy.homework_check;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/19.
 */
public class CameraWorkCheckActivity extends Activity{

    int[] workImage = new int[]{R.drawable.camerawork,R.drawable.camerawork1};
    int currentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_work_check);

        //下一张
        final ImageView mImage = (ImageView)findViewById(R.id.work_image);
        ImageButton mNext = (ImageButton)findViewById(R.id.right);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentImage<workImage.length&&currentImage>0)
                mImage.setImageResource(workImage[++currentImage]);
            }
        });
        //上一张
        ImageButton mPre = (ImageButton)findViewById(R.id.left);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentImage>0&&currentImage<workImage.length)
                    mImage.setImageResource(workImage[--currentImage]);
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
