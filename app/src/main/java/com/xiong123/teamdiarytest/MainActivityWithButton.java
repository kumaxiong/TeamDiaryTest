package com.xiong123.teamdiarytest;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.vivan.timeline1.ItemDecoration;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivityWithButton extends AppCompatActivity {
    private List<Diary> diaryList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onResume() {
        super.onResume();
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.addItemDecoration(new ItemDecoration(this,100));
        DiaryAdapter adapter = new DiaryAdapter(diaryList);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "现在的日记篇数为： " + adapter.getItemCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        diaryList = DataSupport.findAll(Diary.class);
        DiaryAdapter adapter = new DiaryAdapter(diaryList);
        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_button);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityWithButton.this,Edit.class);
                startActivity(intent);
            }
        });
        // 初始化数据
        diaryList = DataSupport.findAll(Diary.class);

        // recyclerView 的标准用法，必须添加一个LayoutManager，然后设置适配器来驱动数据
        recyclerView = (RecyclerView)findViewById(R.id.diary_recyclerView);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemDecoration(this,100));
        DiaryAdapter adapter = new DiaryAdapter(diaryList);
        recyclerView.setAdapter(adapter);
        Toast.makeText(this, "现在的日记篇数为： " + adapter.getItemCount(), Toast.LENGTH_SHORT).show();


    }

    /*public void initDiary() {
        List<Diary> diaries = DataSupport.findAll(Diary.class);
        for (Diary diary : diaries) {
            diaryList.add(diary);
        }
    }*/
}
