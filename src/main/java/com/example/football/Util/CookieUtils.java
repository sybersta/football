package com.example.football.Util;

import com.example.football.entity.*;
public class CookieUtils {
public static String getCookie(int i,MatchEntity2 m){
String s[]=new String[10];
//s[0]="race_id="+m.getGameId()+"; ds_session=ev1kidbgs1kvvbpr20ge6fe820; Hm_lvt_a68414d98536efc52eeb879f984d8923=1598508886,1598511299,1598513858,1598514865; uid=R-590961-735e3c0805f47673bf29d0; Hm_lpvt_a68414d98536efc52eeb879f984d8923=1598514930";
s[1]="race_id="+m.getGameId()+"; Hm_lvt_a68414d98536efc52eeb879f984d8923=1598508886,1598511299,1598513858,1598514865; ds_session=navvcgvp6e45lcl7litanl5610; uid=R-608388-e34b9f9305f4767cd1a641; Hm_lpvt_a68414d98536efc52eeb879f984d8923=1598515070";
s[2]="ds_session=jtrsid1ci8n841v5fn2qng3uv5; Hm_lvt_ea7eaca9beb0e50422887c64e87c3b92=1598508123,1598513823,1598515326,1598515939; uid=608396-ec01fcc605f476b4212328; Hm_lpvt_ea7eaca9beb0e50422887c64e87c3b92=1598515967";
s[3]="ds_session=l4u8gr3qefpc65ilm3fo2t0p95; Hm_lvt_ea7eaca9beb0e50422887c64e87c3b92=1598531267; Hm_lvt_eaa57ca47dacb4ad4f5a257001a3457c=1598531273; uid=608424-3b67894405f47a85fccfa9; Hm_lpvt_ea7eaca9beb0e50422887c64e87c3b92=1598531757; Hm_lpvt_eaa57ca47dacb4ad4f5a257001a3457c=1598531763";
s[4]="race_id="+m.getGameId()+"; Hm_lvt_eaa57ca47dacb4ad4f5a257001a3457c=1597157472,1598359054,1598362585,1598458967; Hm_lvt_a68414d98536efc52eeb879f984d8923=1597157466,1598359048,1598458960,1598531872; ds_session=kv2g4g2a8o4co92b5cfl9chis0; uid=608426-6082b56705f47ac89624c6; Hm_lpvt_a68414d98536efc52eeb879f984d8923=1598532461; Hm_lpvt_eaa57ca47dacb4ad4f5a257001a3457c=1598532468";
s[0]="race_id="+m.getGameId()+"; ds_session=4fapg7ipq0ggmg8na2f6skagn7; Hm_lvt_a68414d98536efc52eeb879f984d8923=1598458960,1598531872,1598536155,1598545275; Hm_lvt_eaa57ca47dacb4ad4f5a257001a3457c=1598362585,1598458967,1598536161,1598545280; Hm_lpvt_eaa57ca47dacb4ad4f5a257001a3457c=1598545280; uid=R-608438-322d000205f47dee2ec39f; Hm_lpvt_a68414d98536efc52eeb879f984d8923=1598545339";
return s[i];
}

public static String getRefer(int i,MatchEntity2 m){
	String s[]=new String[10];
//	s[0]="https://www.dszuqiu.com/race/" + m.getGameId();
	s[1]="https://www.dszuqiu.com/race/" + m.getGameId();
	s[2]="https://www.dorics.com/race/" + m.getGameId();
	s[3]="https://www.dorics.com/race/" + m.getGameId();
	s[4]="https://www.dszuqiu.com/race/" + m.getGameId();
	s[0]="https://www.dszuqiu.com/race/" + m.getGameId();
	return s[i];
}


public static String zh(){
//	String zh0="sybersta@163.com"+"ds";
	String zh1="sss112"+"ds";
	String zh2="wx"+"dor";
	String zh3="sss001"+"dor";
	String zh4="sss001"+"ds";
	String zh0="sss002"+"ds";
//	String zh6="sss003"+"ds";
	
	return null;
}
}
