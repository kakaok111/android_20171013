package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点到我activity2了",
                        Toast.LENGTH_SHORT).show();
                String activity_1_data =  "我是activityMain来的数据，看到别说话";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("activity_1_data",activity_1_data);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate: ");
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
               Toast.makeText(MainActivity.this, "点到我AddMenu了,我要跳转到第二个activity",
                       Toast.LENGTH_SHORT).show();
               //显示intent调用 切换至另一个activity
              /* Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);*/

               //隐士intent调用 默认走所用的http
               /*Intent intent = new Intent(Intent.ACTION_VIEW);
               startActivity(intent);*/

               //显示显示intent调用 调用其他程序 如：电话
               /*Intent intent1 = new Intent(Intent.ACTION_DIAL);
               intent1.setData(Uri.parse("tel:10086"));
               startActivity(intent1);*/
               break;
           case R.id.remove_item:
               Toast.makeText(MainActivity.this, "点到我removeMenu了",
                       Toast.LENGTH_SHORT).show();

                finish();

               break;

           default:
       }

        return true;
    }
}
