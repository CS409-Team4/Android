package com.example.subin.softwareproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by subin on 2017. 4. 21..
 */

public class UserProfileActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        final EditText pwd = (EditText)findViewById(R.id.edit_pwd);
        final CheckBox check = (CheckBox) findViewById(R.id.checkbox_pwd);
        ImageView userimg = (ImageView) findViewById(R.id.userimg);
        TextView update = (TextView) findViewById(R.id.update_btn);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked())
                    pwd.setInputType(InputType.TYPE_CLASS_TEXT);

                else {
                    pwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        userimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserProfileActivity.this, "Change Image Tapped!", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserProfileActivity.this, "Update Tapped!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
