package com.xiong123.teamdiarytest;

import org.litepal.crud.DataSupport;

/**
 * Created by YOOY on 2017/10/16.
 */

public class Diary  extends DataSupport{
    private int id;
    private String diaryTime;
    private String dirayContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaryTime() {
        return diaryTime;
    }

     public void setDiaryTime(String diaryTime) {
        this.diaryTime = diaryTime;
    }

    public String getDirayContent() {
        return dirayContent;
    }

    public void setDirayContent(String dirayContent) {
        this.dirayContent = dirayContent;
    }
}
