package com.example.football.Util;

import com.alibaba.fastjson.JSONObject;
import com.example.football.dto.QiRobotVo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2020 Asiainfo
 *
 * @ClassName: WeixinRoket
 * @Description: 描述
 * @version: v1.0.0
 * @author: xuxx3
 * @date: 10:17 2020/7/31
 * https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=b39ad384-08c9-4582-a45f-89d413f4f0a3
 * https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=7802adfd-db10-47ea-be47-71e60800a3f8
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 * 2020/7/31     xuxx3          v1.1.0
 */
public class WeixinRoket {


    public void sendMessage(String s) throws Exception{
    	QiRobotVo vo = new QiRobotVo();
        //机器人地址
        vo.setWebhookAddress("https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=b39ad384-08c9-4582-a45f-89d413f4f0a3");
        //1.第一种情况：发送文本消息
        //TODO  拼接满足条件的比赛信息
        vo.setContent(s.toString());
        List<String> memberList = new ArrayList<>();
//        memberList.add("xuxinxing");
        memberList.add("@all");
        vo.setMemberList(memberList);
        vo.setMsgType("text");
        this.testSendNews(vo);

    }

    public void testSendNews(QiRobotVo vo) throws Exception {
        List<String> memberList = vo.getMemberList();
        String jsonData = "";
        String mobileList = "";
        String strMember = "";
        if (vo.getMsgType().equals("text")) {
            if (null != vo.getMobileList() && vo.getMobileList().length() > 0) {
                mobileList = vo.getMobileList();
            } else {
                mobileList = "";
            }
            for (int i = 0; i < memberList.size(); i++) {
                if (i == memberList.size() - 1) {
                    strMember += "\"" + memberList.get(i) + "\"";
                } else {
                    strMember += "\"" + memberList.get(i) + "\"" + ",";
                }
            }
            String[] members = new String[memberList.size()];
            for (int i = 0; i < memberList.size(); i++) {
                members[i] = memberList.get(i);
            }
            jsonData = "{\n" +
                    "\t\"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"text\": {\n" +
                    "        \"content\": \"" + vo.getContent() + "\",\n" +
                    "        \"mentioned_list\":[" + strMember + "],\n" +
                    "        \"mentioned_mobile_list\":[\"" + mobileList + "\"]\n" +
                    "    }\n" +
                    "}";

        } else if (vo.getMsgType().equals("image")) {
            //图片base64加密的值
//            vo.setImageBase64Value(MessageUtil.getImageStr(vo.getSavePath()));
//            //图片md5加密的值
//            vo.setImageMd5Value(DigestUtils.md5Hex(new FileInputStream(vo.getSavePath())));
//            jsonData = "{\n" +
//                    "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
//                    "    \"image\": {\n" +
//                    "        \"base64\": \"" + vo.getImageBase64Value() + "\",\n" +
//                    "        \"md5\": \"" + vo.getImageMd5Value() + "\"\n" +
//                    "    }\n" +
//                    "}";
        } else if (vo.getMsgType().equals("news")) {
            //图文消息
            vo.setTitle((vo.getTitle() != null && vo.getTitle().length() > 0) ? vo.getTitle() : "");
            jsonData = "{\n" +
                    "    \"msgtype\": \"" + vo.getMsgType() + "\",\n" +
                    "    \"news\": {\n" +
                    "       \"articles\" : [\n" +
                    "           {\n" +
                    "               \"title\" : \"" + vo.getTitle() + "\",\n" +
                    "               \"description\" : \"" + vo.getDescription() + "\",\n" +
                    "               \"url\" : \"" + vo.getUrl() + "\",\n" +
                    "               \"picurl\" : \"" + vo.getImageUrl() + "\"\n" +
                    "           }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
        }
        this.sendPost(vo.getWebhookAddress(), jsonData);
    }



    public static JSONObject sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        JSONObject jsonObject = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
//            conn.addRequestProperty("Cookie", "stay_login=1 smid=DumpWzWQSaLmKlFY1PgAtURdV_u3W3beoei96zsXkdSABwjVCRrnnNBsnH1wGWI0-VIflgvMaZAfli9H2NGtJg id=EtEWf1XZRLIwk1770NZN047804");//设置获取的cookie
            // 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 获取请求返回数据（设置返回数据编码为UTF-8）
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            jsonObject = JSONObject.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return jsonObject;
    }

}
