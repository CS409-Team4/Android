package com.example.subin.softwareproject;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListAdapter adapter = new ListAdapter();
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        adapter.addItem("cat0", ContextCompat.getDrawable(this, R.drawable.cat0));
        adapter.addItem("cat1", ContextCompat.getDrawable(this, R.drawable.cat00));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;
                switch (position){

                    case 0 :{

                        i=new Intent(MainActivity.this,UserProfileActivity.class);
                        break;
                    }
                    case 1 : {
                        i=new Intent(MainActivity.this,ItemListActivity.class);
                        break;
                    }
                }
                startActivity(i);

            }});
    }
}
