package com.example.wevviewwork;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://apps.gametube.mobi/video-streaming/wapsubscription/confirm.php";
        String url2 = "https://google.com";

        webview = findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);
        webview.getSettings().setJavaScriptEnabled(true);

        Ion.with(getApplicationContext()).load(url).asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                TextView textView = findViewById(R.id.textView);
                textView.setText(result);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()) webview.goBack();
        else super.onBackPressed();
    }
}