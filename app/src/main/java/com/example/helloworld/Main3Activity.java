package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("activity_return_3", "我是activity3回來的數據");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

   //按back键
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("activity_return_3", "我是activity3回來的數據");
        setResult(RESULT_OK, intent);
        finish();
    }
}
