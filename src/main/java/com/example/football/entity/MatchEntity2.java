package com.example.football.entity;

public class MatchEntity2 {
//赛前赔率反置信息
private Double sqs=-99.00;
private Double sqf=-99.00;
private Double sqp=-99.00;
private String isFz="2";

private String three="3";

//基本信息
private String gameId="初始值";//比赛id
private String gameType="初始值";
private int fmp=-99;
private int fgp=-99;
private String mn="初始值";
private String gn="初始值";
//初盘
private Double ogp=-99.00;
private Double oml=-99.00;
private Double ogl=-99.00;
private Double obp=-99.00;
private Double obl=-99.00;
private Double osl=-99.00;
private Double os=-99.00;
private Double op=-99.00;
private Double of=-99.00;
private int ogn=-99;
private int obn=-99;

//中场基本信息
private int mmp=-99;//中场主队比分
private int mmg=-99;//中场客队比分
private boolean mr;//中场是否有红卡
private int mjq=-99;//中场进球数
//中场1
private Double mgp1=-99.00;
private Double mml1=-99.00;
private Double mgl1=-99.00;
private Double mbp1=-99.00;
private Double mbl1=-99.00;
private Double msl1=-99.00;
private Double ms1=-99.00;
private Double mp1=-99.00;
private Double mf1=-99.00;
private int mgn1=-99;
private int mbn1=-99;
//中场2
private Double mgp2=-99.00;
private Double mml2=-99.00;
private Double mgl2=-99.00;
private Double mbp2=-99.00;
private Double mbl2=-99.00;
private Double msl2=-99.00;
private Double ms2=-99.00;
private Double mp2=-99.00;
private Double mf2=-99.00;
private int mgn2=-99;
private int mbn2=-99;
//70分钟
private String lgt1="初始值";
private int lmp1=-99;//中场主队比分
private int lmg1=-99;//中场客队比分
private boolean lr1;//中场是否有红卡
private int ljq1=-99;//中场进球数
private Double lgp1=-99.00;
private Double lml1=-99.00;
private Double lgl1=-99.00;
private Double lbp1=-99.00;
private Double lbl1=-99.00;
private Double lsl1=-99.00;
private Double ls1=-99.00;
private Double lp1=-99.00;
private Double lf1=-99.00;

//80分钟
private String lgt2="初始值";
private int lmp2=-99;//中场主队比分
private int lmg2=-99;//中场客队比分
private boolean lr2;//中场是否有红卡
private int ljq2=-99;//中场进球数
private Double lgp2=-99.00;
private Double lml2=-99.00;
private Double lgl2=-99.00;
private Double lbp2=-99.00;
private Double lbl2=-99.00;
private Double lsl2=-99.00;
private Double ls2=-99.00;
private Double lp2=-99.00;
private Double lf2=-99.00;
private String rd="初始值";

private int cwi45=0;
private int cwi55=0;
private int cwi75=0;
private int cwo75=0;

private int lmp3=-99;
private int lmg3=-99;
private int time=-99;

public String getGameId() {
	return gameId;
}
public void setGameId(String gameId) {
	this.gameId = gameId;
}
public String getGameType() {
	return gameType;
}
public void setGameType(String gameType) {
	this.gameType = gameType;
}
public int getFmp() {
	return fmp;
}
public void setFmp(int fmp) {
	this.fmp = fmp;
}
public int getFgp() {
	return fgp;
}
public void setFgp(int fgp) {
	this.fgp = fgp;
}
public String getMn() {
	return mn;
}
public void setMn(String mn) {
	this.mn = mn;
}
public String getGn() {
	return gn;
}
public void setGn(String gn) {
	this.gn = gn;
}
public Double getOgp() {
	return ogp;
}
public void setOgp(Double ogp) {
	this.ogp = ogp;
}
public Double getOml() {
	return oml;
}
public void setOml(Double oml) {
	this.oml = oml;
}
public Double getOgl() {
	return ogl;
}
public void setOgl(Double ogl) {
	this.ogl = ogl;
}
public Double getObp() {
	return obp;
}
public void setObp(Double obp) {
	this.obp = obp;
}
public Double getObl() {
	return obl;
}
public void setObl(Double obl) {
	this.obl = obl;
}
public Double getOsl() {
	return osl;
}
public void setOsl(Double osl) {
	this.osl = osl;
}
public Double getOs() {
	return os;
}
public void setOs(Double os) {
	this.os = os;
}
public Double getOp() {
	return op;
}
public void setOp(Double op) {
	this.op = op;
}
public Double getOf() {
	return of;
}
public void setOf(Double of) {
	this.of = of;
}
public int getOgn() {
	return ogn;
}
public void setOgn(int ogn) {
	this.ogn = ogn;
}
public int getObn() {
	return obn;
}
public void setObn(int obn) {
	this.obn = obn;
}
public int getMmp() {
	return mmp;
}
public void setMmp(int mmp) {
	this.mmp = mmp;
}
public int getMmg() {
	return mmg;
}
public void setMmg(int mmg) {
	this.mmg = mmg;
}
public boolean isMr() {
	return mr;
}
public void setMr(boolean mr) {
	this.mr = mr;
}
public int getMjq() {
	return mjq;
}
public void setMjq(int mjq) {
	this.mjq = mjq;
}
public Double getMgp1() {
	return mgp1;
}
public void setMgp1(Double mgp1) {
	this.mgp1 = mgp1;
}
public Double getMml1() {
	return mml1;
}
public void setMml1(Double mml1) {
	this.mml1 = mml1;
}
public Double getMgl1() {
	return mgl1;
}
public void setMgl1(Double mgl1) {
	this.mgl1 = mgl1;
}
public Double getMbp1() {
	return mbp1;
}
public void setMbp1(Double mbp1) {
	this.mbp1 = mbp1;
}
public Double getMbl1() {
	return mbl1;
}
public void setMbl1(Double mbl1) {
	this.mbl1 = mbl1;
}
public Double getMsl1() {
	return msl1;
}
public void setMsl1(Double msl1) {
	this.msl1 = msl1;
}
public Double getMs1() {
	return ms1;
}
public void setMs1(Double ms1) {
	this.ms1 = ms1;
}
public Double getMp1() {
	return mp1;
}
public void setMp1(Double mp1) {
	this.mp1 = mp1;
}
public Double getMf1() {
	return mf1;
}
public void setMf1(Double mf1) {
	this.mf1 = mf1;
}
public int getMgn1() {
	return mgn1;
}
public void setMgn1(int mgn1) {
	this.mgn1 = mgn1;
}
public int getMbn1() {
	return mbn1;
}
public void setMbn1(int mbn1) {
	this.mbn1 = mbn1;
}
public Double getMgp2() {
	return mgp2;
}
public void setMgp2(Double mgp2) {
	this.mgp2 = mgp2;
}
public Double getMml2() {
	return mml2;
}
public void setMml2(Double mml2) {
	this.mml2 = mml2;
}
public Double getMgl2() {
	return mgl2;
}
public void setMgl2(Double mgl2) {
	this.mgl2 = mgl2;
}
public Double getMbp2() {
	return mbp2;
}
public void setMbp2(Double mbp2) {
	this.mbp2 = mbp2;
}
public Double getMbl2() {
	return mbl2;
}
public void setMbl2(Double mbl2) {
	this.mbl2 = mbl2;
}
public Double getMsl2() {
	return msl2;
}
public void setMsl2(Double msl2) {
	this.msl2 = msl2;
}
public Double getMs2() {
	return ms2;
}
public void setMs2(Double ms2) {
	this.ms2 = ms2;
}
public Double getMp2() {
	return mp2;
}
public void setMp2(Double mp2) {
	this.mp2 = mp2;
}
public Double getMf2() {
	return mf2;
}
public void setMf2(Double mf2) {
	this.mf2 = mf2;
}
public int getMgn2() {
	return mgn2;
}
public void setMgn2(int mgn2) {
	this.mgn2 = mgn2;
}
public int getMbn2() {
	return mbn2;
}
public void setMbn2(int mbn2) {
	this.mbn2 = mbn2;
}
public String getLgt1() {
	return lgt1;
}
public void setLgt1(String lgt1) {
	this.lgt1 = lgt1;
}
public int getLmp1() {
	return lmp1;
}
public void setLmp1(int lmp1) {
	this.lmp1 = lmp1;
}
public int getLmg1() {
	return lmg1;
}
public void setLmg1(int lmg1) {
	this.lmg1 = lmg1;
}
public boolean isLr1() {
	return lr1;
}
public void setLr1(boolean lr1) {
	this.lr1 = lr1;
}
public int getLjq1() {
	return ljq1;
}
public void setLjq1(int ljq1) {
	this.ljq1 = ljq1;
}
public Double getLgp1() {
	return lgp1;
}
public void setLgp1(Double lgp1) {
	this.lgp1 = lgp1;
}
public Double getLml1() {
	return lml1;
}
public void setLml1(Double lml1) {
	this.lml1 = lml1;
}
public Double getLgl1() {
	return lgl1;
}
public void setLgl1(Double lgl1) {
	this.lgl1 = lgl1;
}
public Double getLbp1() {
	return lbp1;
}
public void setLbp1(Double lbp1) {
	this.lbp1 = lbp1;
}
public Double getLbl1() {
	return lbl1;
}
public void setLbl1(Double lbl1) {
	this.lbl1 = lbl1;
}
public Double getLsl1() {
	return lsl1;
}
public void setLsl1(Double lsl1) {
	this.lsl1 = lsl1;
}
public Double getLs1() {
	return ls1;
}
public void setLs1(Double ls1) {
	this.ls1 = ls1;
}
public Double getLp1() {
	return lp1;
}
public void setLp1(Double lp1) {
	this.lp1 = lp1;
}
public Double getLf1() {
	return lf1;
}
public void setLf1(Double lf1) {
	this.lf1 = lf1;
}
public String getLgt2() {
	return lgt2;
}
public void setLgt2(String lgt2) {
	this.lgt2 = lgt2;
}
public int getLmp2() {
	return lmp2;
}
public void setLmp2(int lmp2) {
	this.lmp2 = lmp2;
}
public int getLmg2() {
	return lmg2;
}
public void setLmg2(int lmg2) {
	this.lmg2 = lmg2;
}
public boolean isLr2() {
	return lr2;
}
public void setLr2(boolean lr2) {
	this.lr2 = lr2;
}
public int getLjq2() {
	return ljq2;
}
public void setLjq2(int ljq2) {
	this.ljq2 = ljq2;
}
public Double getLgp2() {
	return lgp2;
}
public void setLgp2(Double lgp2) {
	this.lgp2 = lgp2;
}
public Double getLml2() {
	return lml2;
}
public void setLml2(Double lml2) {
	this.lml2 = lml2;
}
public Double getLgl2() {
	return lgl2;
}
public void setLgl2(Double lgl2) {
	this.lgl2 = lgl2;
}
public Double getLbp2() {
	return lbp2;
}
public void setLbp2(Double lbp2) {
	this.lbp2 = lbp2;
}
public Double getLbl2() {
	return lbl2;
}
public void setLbl2(Double lbl2) {
	this.lbl2 = lbl2;
}
public Double getLsl2() {
	return lsl2;
}
public void setLsl2(Double lsl2) {
	this.lsl2 = lsl2;
}
public Double getLs2() {
	return ls2;
}
public void setLs2(Double ls2) {
	this.ls2 = ls2;
}
public Double getLp2() {
	return lp2;
}
public void setLp2(Double lp2) {
	this.lp2 = lp2;
}
public Double getLf2() {
	return lf2;
}
public void setLf2(Double lf2) {
	this.lf2 = lf2;
}
public String getRd() {
	return rd;
}
public void setRd(String rd) {
	this.rd = rd;
}
public int getCwi45() {
	return cwi45;
}
public void setCwi45(int cwi45) {
	this.cwi45 = cwi45;
}
public int getCwi55() {
	return cwi55;
}
public void setCwi55(int cwi55) {
	this.cwi55 = cwi55;
}
public int getCwi75() {
	return cwi75;
}
public void setCwi75(int cwi75) {
	this.cwi75 = cwi75;
}
public int getCwo75() {
	return cwo75;
}
public void setCwo75(int cwo75) {
	this.cwo75 = cwo75;
}

public int getLmp3() {
	return lmp3;
}
public void setLmp3(int lmp3) {
	this.lmp3 = lmp3;
}
public int getLmg3() {
	return lmg3;
}
public void setLmg3(int lmg3) {
	this.lmg3 = lmg3;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public Double getSqs() {
	return sqs;
}
public void setSqs(Double sqs) {
	this.sqs = sqs;
}
public Double getSqf() {
	return sqf;
}
public void setSqf(Double sqf) {
	this.sqf = sqf;
}
public Double getSqp() {
	return sqp;
}
public void setSqp(Double sqp) {
	this.sqp = sqp;
}
public String getIsFz() {
	return isFz;
}
public void setIsFz(String isFz) {
	this.isFz = isFz;
}
public String getThree() {
	return three;
}
public void setThree(String three) {
	this.three = three;
}


}
