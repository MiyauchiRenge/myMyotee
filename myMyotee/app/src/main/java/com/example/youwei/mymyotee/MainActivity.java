package com.example.youwei.mymyotee;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.GridHolder;
import com.orhanobut.dialogplus.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView pic_startpage_logo_faceq_imageView;
    private ImageButton bt_homepage_sound_on;
    private ImageButton bt_homepage_share_up;
    private ImageButton bt_yijianfankui_up;
    private ImageButton bt_man_up;
    private ImageButton bt_woman_up;
    private ImageButton bt_double_up;
    private ImageButton bt_history_up;
    private ImageButton bt_more_up;
    private ImageButton pic_startpage_joinus;
    private ImageButton pic_startpage_team;

    private SoundPool boysoundPool;

    private SoundPool girlsoundPool;

    boolean sound_btn = true;

    int[] share_tools = new int[] {
           R.drawable.share_bt_qqhaoyou_up, R.drawable.share_bt_qzone_up, R.drawable.share_bt_sinaweibo_up, R.drawable.share_bt_pyq_up
    };

    String[] share_names = new String[] {
            "    QQ", " QZone", " WeiBo", "Wechat"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);
        setTitle("脸萌");
        pic_startpage_logo_faceq_imageView = (ImageView) findViewById(R.id.pic_startpage_logo_faceq_imageView);
        pic_startpage_logo_faceq_imageView.setImageResource(R.drawable.pic_startpage_logo_faceq);

        bt_homepage_sound_on = (ImageButton) findViewById(R.id.bt_homepage_sound_on);
        bt_homepage_sound_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound_btn == true) {
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_homepage_sound_off));
                    sound_btn = false;
                } else {
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_homepage_sound_on));
                    sound_btn = true;
                }
            }
        });

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i< share_tools.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("share", share_tools[i]);
            listItem.put("share_names", share_names[i]);
            listItems.add(listItem);
        }

        final SimpleAdapter simpleadapter = new SimpleAdapter(this, listItems, R.layout.share_tools, new String[]{"share", "share_names"}, new int[] {R.id.share_tools, R.id.share_names});
        bt_homepage_share_up = (ImageButton) findViewById(R.id.bt_homepage_share_up);
        bt_homepage_share_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_homepage_share_down));
                final DialogPlus dialog = DialogPlus.newDialog(MainActivity.this)
                        .setAdapter(simpleadapter)
                        .setContentHolder(new GridHolder(2))
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "已点击"+share_names[position], Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                            }
                        })
                        .setHeader(R.layout.header)
                        .setFooter(R.layout.footer)
                        .setInAnimation(R.anim.abc_fade_in)
                        .setOutAnimation(R.anim.abc_fade_out)
                        .setGravity(Gravity.CENTER)
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();
                dialog.getFooterView().findViewById(R.id.sharedialog_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        bt_yijianfankui_up = (ImageButton) findViewById(R.id.bt_yijianfankui_up);
        bt_yijianfankui_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt_yijianfankui_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_yijianfankui_down));
                startActivity(new Intent(MainActivity.this, ConversationActivity.class));
            }
        });

        boysoundPool= new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        boysoundPool.load(this,R.raw.boy,1);

        bt_man_up = (ImageButton) findViewById(R.id.bt_man_up);
        bt_man_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sound_btn==true) {
                    boysoundPool.play(1, 1, 1, 0, 0, 1);
                }
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_man_down));
                     startActivity(new Intent(MainActivity.this, EditorActivity.class));
            }
        });

        girlsoundPool= new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        girlsoundPool.load(this,R.raw.girl,1);

        bt_woman_up = (ImageButton) findViewById(R.id.bt_woman_up);
        bt_woman_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound_btn == true) {
                    girlsoundPool.play(1, 1, 1, 0, 0, 1);
                }
                    ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_woman_down));
                    startActivity(new Intent(MainActivity.this, EditorActivity.class));
            }
        });

        bt_double_up = (ImageButton) findViewById(R.id.bt_double_up);
        bt_double_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_double_down));
                startActivity(new Intent(MainActivity.this, ChooseDoubleModeActivity.class));
            }
        });

        bt_history_up = (ImageButton) findViewById(R.id.bt_history_up);
        bt_history_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageButton)v).setImageDrawable(getResources().getDrawable(R.drawable.bt_history_down));
                startActivity(new Intent(MainActivity.this, HistroyActivity.class));
            }
        });

        bt_more_up = (ImageButton) findViewById(R.id.bt_more_up);
        bt_more_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(MainActivity.this)
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                Uri uri= Uri.parse("http://www.coolapk.com/apk/com.lemon.faceu");
                                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                                startActivity(intent);
                            }
                        })
                        .title("Faceu")
                        .content("脸萌新品,Faceu-最萌的特效相机，呱呱上线，_(:3 」∠)_ ")
                        .positiveText("抢先玩")
                        .negativeText("关闭")
                        .icon(getResources().getDrawable(R.drawable.btnfun_newproducts_tag))
                        .show();
            }
        });

        pic_startpage_joinus = (ImageButton) findViewById(R.id.pic_startpage_joinus);
        pic_startpage_joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JoinUsActivity.class));
            }
        });

        pic_startpage_team = (ImageButton) findViewById(R.id.pic_startpage_team);
        pic_startpage_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        bt_man_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_man_up));
        bt_woman_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_woman_up));
        bt_double_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_double_up));
        bt_history_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_history_up));
        bt_yijianfankui_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_yijianfankui_up));
       // bt_homepage_share_up.setImageDrawable(getResources().getDrawable(R.drawable.bt_homepage_share_up));
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    //persmission method.
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }



}
