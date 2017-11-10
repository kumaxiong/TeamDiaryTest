package com.xiong123.teamdiarytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;


public class ReadDiaryLow extends AppCompatActivity  implements View.OnClickListener{

    private ProgressBar prograssBar;
    private TextView eachContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_diary_low);
        Button lookEach = (Button)findViewById(R.id.next_diary);
        prograssBar = (ProgressBar)findViewById(R.id.prograss_bar);
        lookEach.setOnClickListener(this);
        eachContent = (TextView)findViewById(R.id.each_content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next_diary:
                List<Diary> diaries = DataSupport.findAll(Diary.class);
                prograssBar.setMax(diaries.size());
                int progress = prograssBar.getProgress();
                if(progress < diaries.size() ){
                    Toast.makeText(this, "日记内容是" + diaries.get(progress).getDirayContent(), Toast.LENGTH_SHORT).show();
                    eachContent.setText(diaries.get(progress).getDirayContent());
                    progress = progress+1;
                    if(progress <= prograssBar.getMax()){prograssBar.setProgress(progress);}

                }else {
                    Toast.makeText(this, "已经看完所有的日记了", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
    }
}
