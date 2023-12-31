package com.example.exp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView text2;

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(R.drawable.ic_launcher_background);
        setContentView(frameLayout);

        TextView text1 = new TextView(this);
        text1.setText("在代码中控制UI界面");
        text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        text1.setTextColor(Color.rgb(1, 1, 1));
        frameLayout.addView(text1); //添加到布局管理器中

        text2 = new TextView(this);
        text2.setText("单击进入游戏");
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        text2.setTextColor(Color.rgb(1, 1, 1));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //创建保存布局参数的对象
        params.gravity = Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL; //居中显示
        text2.setLayoutParams(params); //设置布局参数

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")
                        .setMessage("游戏有风险，进入需谨慎，真的要进入吗？")
                        .setPositiveButton("确定",       //为确定按钮添加单击事件
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Log.i("tang3.2", "进入游戏");   //输出消息日志，注意tang3.2
                                        Intent intent = new Intent(MainActivity.this,RabbitActivity.class);
                                        startActivity(intent);
                                    }
                                }).setNegativeButton("退出",   //为退出按钮添加单击事件
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Log.i("tang3.2", "退出游戏");
                                        finish();
                                    }
                                }).show();     //显示对话框
            }
        });
        frameLayout.addView(text2);     //将text2添加到布局管理器中
                                }
}