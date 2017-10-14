package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String activity_1_data = intent.getStringExtra("activity_1_data");

        Toast.makeText(Main2Activity.this, activity_1_data,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(Main2Activity.this, "点到我AddMenu了,我要跳转到第一个activity",
                        Toast.LENGTH_SHORT).show();
                //不带数据
                /*Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);*/

                break;
            case R.id.remove_item:
                Toast.makeText(Main2Activity.this, "点到我removeMenu了",
                        Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
                //不带数据 直接销毁
                //finish();
                break;

            default:
        }

        return true;
    }
}
