package com.computerbounce.webview_sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String URL = "https://github.com/";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_back = findViewById(R.id.iv_back);
        ImageView iv_forward = findViewById(R.id.iv_forward);
        ImageView iv_refresh = findViewById(R.id.iv_refresh);
        webView = findViewById(R.id.webview);

        iv_back.setOnClickListener(btnClickListener);
        iv_forward.setOnClickListener(btnClickListener);
        iv_refresh.setOnClickListener(btnClickListener);

        new WebviewSetting(webView, URL);

    }

    public Button.OnClickListener btnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_back:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    }
                    break;
                case R.id.iv_forward:
                    if (webView.canGoForward()) {
                        webView.goForward();
                    }
                    break;
                case R.id.iv_refresh:
                    webView.reload();
                    break;
            }
        }
    };
}
