package com.example.exp3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class RabbitActivity extends AppCompatActivity {
    public String name = "Judy";
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                name = (String) radbtn.getText();
                Toast.makeText(getApplicationContext(), "角色改变,你选了" + radbtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mylayout);//创建帧布局管理器
        final RabbitView2 rabbit = new RabbitView2(RabbitActivity.this);

        final PenguinView2 penguin = new PenguinView2(RabbitActivity.this);

        final TomView2 tom = new TomView2(RabbitActivity.this);

        penguin.setOnTouchListener(new View.OnTouchListener() { //为小兔子添加触摸事件监听器
            @SuppressLint("SuspiciousIndentation")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Objects.equals(name, "Skipper")){
                    penguin.bitmapX = event.getX()-96;  //设置小兔子显示的X坐标
                    penguin.bitmapY = event.getY()-96;
                    penguin.invalidate();}  //重绘rabbit组件
                else if (Objects.equals(name, "Judy")){
                    rabbit.bitmapX = event.getX()-36;  //设置小兔子显示的X坐标
                    rabbit.bitmapY = event.getY()-36;
                    rabbit.invalidate();}  //重绘rabbit组件
                else if (Objects.equals(name, "Tom and Jerry")){
                    tom.bitmapX = event.getX()-120;  //设置小兔子显示的X坐标
                    tom.bitmapY = event.getY()-120;
                    tom.invalidate();}  //重绘rabbit组件

                return true;

            }
        });

        frameLayout.addView(rabbit); //将rabbit添加到布局管理器

        frameLayout.addView(penguin); //将rabbit添加到布局管理器

        frameLayout.addView(tom);
    }
}