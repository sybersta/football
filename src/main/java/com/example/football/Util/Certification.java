package com.example.football.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * GET请求类
 */
public class Certification {
    private String url = "https://www.dszuqiu.com/diary/20200101/p.1";
    private Logger logger;

 public static void main (String[] args){
     Certification  c=new Certification();
     c.getData("111");
 }
    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }
    public  void getData(String id) {
//        this.url = url + id;
        BufferedReader in = null;
        HttpURLConnection conn = null;
        String result = "";
        try {
//该部分必须在获取connection前调用
            trustAllHttpsCertificates();
            HostnameVerifier hv = new HostnameVerifier() {
                public boolean verify(String urlHostName, SSLSession session) {
                    logger.info("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
            conn = (HttpURLConnection)new URL(url).openConnection();
            // 发送GET请求必须设置如下两行
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
            // flush输出流的缓冲
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String tempLine;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                while ((tempLine = in.readLine()) != null) {
                    result += tempLine;
                }
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {// 使用finally块来关闭输出流、输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                logger.error("关闭数据流出错了！\n"+ex.getMessage()+"\n");
            }
        }
        Document doc = Jsoup.parse(result);
        System.out.println("sss");
        // 获得相应结果result,可以直接处理......

    }
    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}