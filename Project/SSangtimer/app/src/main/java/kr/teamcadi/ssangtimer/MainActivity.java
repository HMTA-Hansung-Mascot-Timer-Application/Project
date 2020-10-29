package kr.teamcadi.ssangtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity  {
    private Button btn_start,btn_info,btn_setting,btn_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_enroll = (Button) findViewById(R.id.btn_confirm);
        btn_info = (Button) findViewById(R.id.btn_info);
        btn_setting = (Button) findViewById(R.id.btn_setting);

        ImageView reading = (ImageView) findViewById(R.id.reading);
        GlideDrawableImageViewTarget gifimage = new GlideDrawableImageViewTarget(reading);

//        Glide.with(this).load(R.drawable.reading).into(gifimage);
////
////        btn_start.setOnClickListener(this);
////        btn_enroll.setOnClickListener(this);
////        btn_info.setOnClickListener(this);
////        btn_setting.setOnClickListener(this);
////
////    }
////
////    @Override
////    public void onClick(View v) {
////        int id = v.getId();
////        switch (id){
////            case R.id.btn_start:{
////                Intent intent1 = new Intent(MainActivity.this,StartActivity.class);
////                startActivityForResult(intent1,1);
////                break;
////            }
////
////            case R.id.btn_setting:{
////                Intent intent1 = new Intent(MainActivity.this,SettingActivity.class);
////                startActivityForResult(intent1,2);
////                break;
////            }
////
//            case R.id.btn_confirm:{
//                Intent intent1 = new Intent(MainActivity.this,EnrollActivitiy.class);
//                startActivityForResult(intent1,3);
//                break;
//            }
//
//            case R.id.btn_info:{
//                Intent intent1 = new Intent(MainActivity.this,InfoActivity.class);
//                startActivityForResult(intent1,4);
//                break;
//            }
//        }

    }
}