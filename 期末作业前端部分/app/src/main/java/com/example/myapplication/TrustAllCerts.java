package com.example.myapplication;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

 class TrustAllCerts implements X509TrustManager {

    //checkServerTrusted和checkClientTrusted 这两个方法好像是用于，server和client双向验证
    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) {
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }}
