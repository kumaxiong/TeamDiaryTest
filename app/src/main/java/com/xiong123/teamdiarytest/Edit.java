package com.xiong123.teamdiarytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.tablemanager.Connector;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final EditText diaryContent = (EditText)findViewById(R.id.yourDiary);
        Button saveDiary = (Button)findViewById(R.id.save_text);
        saveDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取安卓系统时间
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
                Date currentDate = new Date(System.currentTimeMillis());
                String dTime = formatter.format(currentDate);

                // 获取文本内容
                String dContent = diaryContent.getText().toString();

                // 创建数据库
                Connector.getDatabase();

                //添加数据
                Diary diary = new Diary();
                diary.setDiaryTime(dTime);
                diary.setDirayContent(dContent);
                diary.save();
                Intent intent = new Intent("com.xiong123.completeWrited");
                sendBroadcast(intent);
                finish();
            }
        });
    }
}
