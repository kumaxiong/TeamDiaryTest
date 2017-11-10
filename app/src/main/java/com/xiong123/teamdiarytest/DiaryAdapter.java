package com.xiong123.teamdiarytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by YOOY on 2017/10/25.
 */

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder>{

    private List<Diary>mDiaryList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView diaryTime;
        private TextView diaryContent;
        public ViewHolder(View view){
            super(view);
            diaryTime = (TextView)view.findViewById(R.id.diary_item_time);
            diaryContent = (TextView)view.findViewById(R.id.diary_item_content);
        }
    }

    public DiaryAdapter(List<Diary> diaryList){
        mDiaryList = diaryList;
    }

    // 创建ViewHolder,的onCreate函数
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.diary_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Diary diary = mDiaryList.get(position);
        holder.diaryTime.setText(diary.getDiaryTime());
        holder.diaryContent.setText(diary.getDirayContent());
    }

    @Override
    public int getItemCount() {
        return mDiaryList.size();
    }
}
