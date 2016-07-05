package com.example.youwei.mymyotee;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class ChooseDoubleModeActivity extends AppCompatActivity {

    private ImageButton bt_dmode0_up;
    private ImageButton bt_dmode1_up;
    private ImageButton bt_dmode2_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_double_mode);
        setTitle("双人模式");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        bt_dmode0_up = (ImageButton) findViewById(R.id.bt_dmode0_up);
        bt_dmode0_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode0_down));
                startActivity(new Intent(ChooseDoubleModeActivity.this, EditorActivity2.class));
            }
        });

        bt_dmode1_up = (ImageButton) findViewById(R.id.bt_dmode1_up);
        bt_dmode1_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode1_down));
                startActivity(new Intent(ChooseDoubleModeActivity.this, EditorActivity2.class));
            }
        });

        bt_dmode2_up = (ImageButton) findViewById(R.id.bt_dmode2_up);
        bt_dmode2_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode2_down));
                startActivity(new Intent(ChooseDoubleModeActivity.this, EditorActivity2.class));
            }
        });
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
                startActivity(new Intent(ChooseDoubleModeActivity.this,MainActivity.class));
                return true;
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        bt_dmode0_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode0_up));
        bt_dmode1_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode1_up));
        bt_dmode2_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_dmode2_up));
    }

}
