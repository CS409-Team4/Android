package com.example.jangyoungsoo.iui_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class NHFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_naverhome, container, false);

//        WebView myWebView = (WebView) view.findViewById(R.id.nh_webView);
//        myWebView.loadUrl("http://m.naver.com");

        return view;
    }
}
