package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NaverOtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naverother);

        WebView myWebView = (WebView) findViewById(R.id.nh_webViewOther);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("");
    }

}
