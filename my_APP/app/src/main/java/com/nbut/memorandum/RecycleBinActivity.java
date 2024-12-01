//package com.nbut.memorandum;
//
//
//import java.util.List; // 导入 List
//import java.util.ArrayList; // 导入 ArrayList
//
//import android.os.Bundle;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class RecycleBinActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycle_bin);
//
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        // Initialize your adapter and set it
//        RecycleBinAdapter adapter = new RecycleBinAdapter(getDeletedNotes());
//        recyclerView.setAdapter(adapter);
//    }
//
//    // Example method to fetch deleted notes
//    private List<Note> getDeletedNotes() {
//        // Fetch data from database or other sources
//        return new ArrayList<>();
//    }
//
//
//}

package com.nbut.memorandum;

import java.util.List; // 导入 List
import java.util.ArrayList; // 导入 ArrayList

import android.os.Bundle;
import android.view.MenuItem; // 导入 MenuItem
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar; // 导入 Toolbar
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleBinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_bin);

        // 设置 Toolbar
        Toolbar toolbar = findViewById(R.id.edit_toolbar);
        setSupportActionBar(toolbar);

        // 启用返回键
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle("回收站");
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize your adapter and set it
        RecycleBinAdapter adapter = new RecycleBinAdapter(getDeletedNotes());
        recyclerView.setAdapter(adapter);
    }

    // 监听返回按钮
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // 结束当前 Activity，返回上一界面
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Example method to fetch deleted notes
    private List<Note> getDeletedNotes() {
        // Fetch data from database or other sources
        return new ArrayList<>();
    }
}

