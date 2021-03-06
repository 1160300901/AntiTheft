package com.example.anti_theft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    private EditText numberText;
    private EditText contentText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        numberText=(EditText)findViewById(R.id.number);//获取第一个EditText，即输入电话号码的组件
        contentText=(EditText)findViewById(R.id.content);//获取第二个EditText，即输入短信内容的组件
        Button button1=(Button)findViewById(R.id.button1);//获取按钮组件，即发送按钮组件
        button1.setOnClickListener(new ButtonClickListener());//为发送短信添加一个单击监听器
    }
    private final class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            String number=numberText.getText().toString();//获取第一个文本编辑框里的输入内容，即输入什么电话号码
            String content=contentText.getText().toString();//获取第二个文本编辑框里的输入内容，即要发送的短信内容
            SmsManager manager=SmsManager.getDefault();//获得发送短信的管理器，使用的是android.telephony.SmsManager
            ArrayList<String> texts=manager.divideMessage(content);
            for(String text:texts){
                //使用短信管理器发送短信内容
                //参数一为短信接收者
                //参数三为短信内容
                //其他可以设为null
                manager.sendTextMessage(number, null, text, null, null);
            }
            //Toast.makeText(MessageActivity.this, R.string.success, Toast.LENGTH_LONG).show();//Toast，用来显示发送成功的提示
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
