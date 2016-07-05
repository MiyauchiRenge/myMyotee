package com.example.youwei.mymyotee;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AboutUsActivity extends AppCompatActivity {

    private GridView gridView;

    int[] imageIds = new int[] {
            R.drawable.pic_aboutus_ax, R.drawable.pic_aboutus_bd, R.drawable.pic_aboutus_fz,
            R.drawable.pic_aboutus_gl, R.drawable.pic_aboutus_jc, R.drawable.pic_aboutus_jf,
            R.drawable.pic_aboutus_lyh,R.drawable.pic_aboutus_ww, R.drawable.pic_aboutus_xfb
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle("团队介绍");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i< imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleadapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[] {R.id.image1});
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(simpleadapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        if(mi.isCheckable())
        {
            // 勾选该菜单项
            mi.setChecked(true);  // ②
        }
        switch (mi.getItemId())
        {
            case android.R.id.home:
                startActivity(new Intent(AboutUsActivity.this,MainActivity.class));
                return true;
        }
        return true;
    }
}
