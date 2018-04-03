package com.example.anti_theft;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        // 无title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        //全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ImageView baidu=(ImageView)findViewById(R.id.baidu_view);
        ImageView notepad=(ImageView) findViewById(R.id.notepad_view);
        ImageView contact=(ImageView) findViewById(R.id.contact_view);
        ImageView message=(ImageView) findViewById(R.id.message_view);
        ImageView phone=(ImageView) findViewById(R.id.phone_view);
        baidu.setOnClickListener(this);
        notepad.setOnClickListener(this);
        contact.setOnClickListener(this);
        message.setOnClickListener(this);
        phone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.baidu_view:
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.notepad_view:
                Intent intent1=new Intent(FirstActivity.this, notepadActivity.class);
                startActivity(intent1);
            case R.id.contact_view:
                Intent intent2=new Intent(FirstActivity.this, ContactActivity.class);
                startActivity(intent2);
            case R.id.message_view:
                Intent intent3=new Intent(FirstActivity.this, MessageActivity.class);
                startActivity(intent3);
            case R.id.phone_view:
                Intent intent4=new Intent(FirstActivity.this,PhoneActivity.class);
                startActivity(intent4);
            default:
                break;


        }
    }
}
