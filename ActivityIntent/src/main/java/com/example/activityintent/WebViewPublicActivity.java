package com.example.activityintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewPublicActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewpublic_layout);
        // WebView
        WebView webView2 = (WebView) findViewById(R.id.webview_public);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        String str = intent.getData().toString();
//        String str = intent.getDataString();
        Log.d("WebViewPublicActivity",str);
        Log.d("WebViewPublicActivity","My log: intent.getData().toString();");
        webView2.loadUrl(str);
    }
}
