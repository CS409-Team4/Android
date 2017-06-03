package com.example.jangyoungsoo.iui_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class NaverOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naverother);

        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        Intent intent = getIntent();
        String message = intent.getStringExtra(NaverHomeActivity.EXTRA_URL);

        WebView myWebView = (WebView) findViewById(R.id.nh_webViewOther);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl(message);

        Button button_back = (Button) findViewById(R.id.nh_button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaverHomeActivity.drawerLayout.closeDrawers();
                finish();
            }
        });
    }

}
