package com.computerbounce.webview_sample;

import android.graphics.Bitmap;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewSetting {

    WebviewSetting(WebView webView, String url) {

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);     //use javascript function //자바스크립트 사용
        webSettings.setSupportZoom(true);           //use zoom function //줌 기능 사용
        webSettings.setBuiltInZoomControls(true);   //use built zoom function // 내장 줌 기능 사용

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //First call at starting webview loading(only first time)
                // 로딩시 처음 호출
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
                // true - load new URL into webview
                // false - load new URL into another
                //새로운 URL 실행시 새로운 창 실행여부
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // First call at finishing webview loading(only first time)
                // webview 로딩 완료시 처음호출
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                // show current progress of the loading(express integer between 0 and 100)
                // 로딩 진행여부 표시
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
                // true - client handle js alertdialog
                // false - webview handle js alertdialog
                //자바스크립트 경고 대화 상자를 디스플레이한다고 클라이언트에게 알려줌
                // true : 클라이언트가 대화상자를 처리할수있음
                // false : webview계속 실행
            }
        });

        webView.loadUrl(url);
    }

}
