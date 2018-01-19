package com.example.activityintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import static android.view.KeyEvent.KEYCODE_BACK;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView1;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
//        WebViewActivity
        webView1 = (WebView) findViewById(R.id.webview_1);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new WebViewClient());
//        webView1.loadUrl("http://10y.top");
        Intent intent = getIntent();
        webView1.loadUrl(intent.getStringExtra("url_data"));
    }

    /**
     *  重写方法 onKeyDown(); 当按下返回键时，WebView能前进、后退，而不是直接销毁整个WebView
     * @param keyCode keyCode
     * @param event event
     * @return true
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KEYCODE_BACK) && webView1.canGoBack()){
            webView1.goBack();
            return true;
        }
//        if ((keyCode == KEYCODE_FORWARD) && webView1.canGoForward()){
//            webView1.goForward();
//            return true;
//        }
        return super.onKeyDown(keyCode, event);
    }
    /**
     *  menu
     *  inflate a menu for WebView
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.webview_main, menu);
        return true;
    }
    /**
     *  menu event
     *  Control WebView goBack(); goForward();
     * @param item item
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Web_Back:
                webView1.goBack();
                break;
            case R.id.Web_Forward:
                webView1.goForward();
                break;
            default:
        }
        return true;
    }
}
