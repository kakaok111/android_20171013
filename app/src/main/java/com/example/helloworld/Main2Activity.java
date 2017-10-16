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
import android.view.View.OnClickListener;

public class Main2Activity extends AppCompatActivity implements OnClickListener {


    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        if ( savedInstanceState != null ){
            //当这个活动被销毁时 再次创建这个活动拿到这个活动的数据
            String data = savedInstanceState.getString("xx");
            Log.d(TAG, "onCreate: "+data);
        }

        Intent intent = getIntent();
        String activity_1_data = intent.getStringExtra("activity_1_data");

        Toast.makeText(Main2Activity.this, activity_1_data,
                Toast.LENGTH_SHORT).show();


        Button button_1 = (Button) findViewById(R.id.button_1);
        Button button_2 = (Button) findViewById(R.id.button_2);
        Button button_3 = (Button) findViewById(R.id.button_3);

        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data  = "我是这个activity的数据，当目前这个消失时，我就会在被创建时拿到";
        outState.putString("xx",data);
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
                intent1.setAction(Intent.ACTION_CALL);
                intent1.setData(Uri.parse("tel:10086"));
                startActivity(intent1);
                //不带数据 直接销毁
                //finish();
                break;

            default:
        }

        return true;
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.button_1 :
              Toast.makeText(Main2Activity.this, "1"+R.id.button_1,
                      Toast.LENGTH_SHORT).show();
              break;
          case R.id.button_2 :
              Toast.makeText(Main2Activity.this, "2",
                      Toast.LENGTH_SHORT).show();
              break;
          case R.id.button_3 :
              Toast.makeText(Main2Activity.this, "3",
                      Toast.LENGTH_SHORT).show();
              break;
      }

    }


    public void button3(View v){
        Toast.makeText(Main2Activity.this, "5",
                Toast.LENGTH_SHORT).show();
    }
}
