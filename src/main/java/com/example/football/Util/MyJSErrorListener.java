package com.example.football.Util;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.DefaultJavaScriptErrorListener;

import java.net.MalformedURLException;
import java.net.URL;

public class MyJSErrorListener extends DefaultJavaScriptErrorListener {
    @Override
    public void scriptException(HtmlPage page, ScriptException scriptException) {
    }
    @Override
    public void timeoutError(HtmlPage page, long allowedTime, long executionTime) {
    }
    @Override
    public void malformedScriptURL(HtmlPage page, String url, MalformedURLException malformedURLException) {
    }
    @Override
    public void loadScriptError(HtmlPage page, URL scriptUrl, Exception exception) {
    }
//    @Override
//    public void warn (String message,String sourceName,int line,String lineSource,int lineoffset){
//
//    }
}
