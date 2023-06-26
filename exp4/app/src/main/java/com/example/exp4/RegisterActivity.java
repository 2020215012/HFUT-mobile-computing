package com.example.exp4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends Activity {

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);	//设置该Activity中要显示的内容视图
        Intent intent=getIntent();	//获取Intent对象
        Bundle bundle=intent.getExtras();	//获取传递的数据包
        TextView user=(TextView)findViewById(R.id.user);		//获取显示用户名的TextView组件
        user.setText("用户名："+bundle.getString("user"));		//获取输入的用户名并显示到TextView组件中

        TextView pwd=(TextView)findViewById(R.id.pwd);		//获取显示密码的TextView组件
        pwd.setText("密码："+bundle.getString("pwd"));		//获取输入的密码并显示到TextView组件中

        TextView email=(TextView)findViewById(R.id.email);		//获取显示E-mail的TextView组件
        email.setText("E-mail："+bundle.getString("email"));		//获取输入的E-mail并显示到TextView组件中

        TextView url= (TextView) findViewById(R.id.url);		//获取显示E-mail的TextView组件
        url.setText("URL："+bundle.getString("url"));		//获取输入的E-mail并显示到TextView组件中

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();// 创建Intent对象
                intent.setAction(Intent.ACTION_MAIN);// 设置Intent动作
                intent.addCategory(Intent.CATEGORY_HOME);// 设置Intent种类
                startActivity(intent);// 将Intent传递给Activity
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();// 创建Intent对象
                intent.setAction(Intent.ACTION_VIEW);// 为Intent设置动作
                intent.setData(Uri.parse(url.getText().toString()));// 为Intent设置数据
                startActivity(intent);// 将Intent传递给Activity
            }
        });
    }
}

