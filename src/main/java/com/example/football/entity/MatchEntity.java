package com.example.football.entity;

public class MatchEntity {
private String gameId;
private int midMatchMaster;
private int midMatchGuest;
private boolean redCard;

private Double midMatchBigPosition;
private Double midMatchBigLevel;
private Double midMatchSmallLevel;
 
//赛前
private Double originGamePosition;
private Double originMasterLevel;
private Double originGuestLevel;
private Double originUpLevel;
private Double originDownLevel;

private Double originBigPosition;
private Double originBigLevel;
private Double originSmallLevel;

//即时
private Double instantGamePosition;
private Double instantMasterLevel;
private Double instantGuestLevel;
private Double instantUpLevel;
private Double instantDownLevel;

private Double instantMaster;
private Double instantDraw;
private Double instantGuest;

private Double instantBigPosition;
private Double instantBigLevel;
private Double instantSmallLevel;

private String masterName;
private String guestName;

private int gameTime;
private int masterPoint;
private int guestPoint;
private String leagueName;

private int masterAttack;
private int guestAttack;
private int masterDatk;
private int guestDatk;
private int masterSz;
private int masterSp;
private int guestSz;
private int guestSp;
private int masterQq;
private int guestQq;
private String score;

public String getGameId() {
	return gameId;
}
public void setGameId(String gameId) {
	this.gameId = gameId;
}
public int getMidMatchMaster() {
	return midMatchMaster;
}
public void setMidMatchMaster(int midMatchMaster) {
	this.midMatchMaster = midMatchMaster;
}
public int getMidMatchGuest() {
	return midMatchGuest;
}
public void setMidMatchGuest(int midMatchGuest) {
	this.midMatchGuest = midMatchGuest;
}
public Double getMidMatchBigPosition() {
	return midMatchBigPosition;
}
public void setMidMatchBigPosition(Double midMatchBigPosition) {
	this.midMatchBigPosition = midMatchBigPosition;
}
public Double getMidMatchBigLevel() {
	return midMatchBigLevel;
}
public void setMidMatchBigLevel(Double midMatchBigLevel) {
	this.midMatchBigLevel = midMatchBigLevel;
}
public Double getMidMatchSmallLevel() {
	return midMatchSmallLevel;
}
public void setMidMatchSmallLevel(Double midMatchSmallLevel) {
	this.midMatchSmallLevel = midMatchSmallLevel;
}
public Double getOriginGamePosition() {
	return originGamePosition;
}
public void setOriginGamePosition(Double originGamePosition) {
	this.originGamePosition = originGamePosition;
}
public Double getOriginMasterLevel() {
	return originMasterLevel;
}
public void setOriginMasterLevel(Double originMasterLevel) {
	this.originMasterLevel = originMasterLevel;
}
public Double getOriginGuestLevel() {
	return originGuestLevel;
}
public void setOriginGuestLevel(Double originGuestLevel) {
	this.originGuestLevel = originGuestLevel;
}
public Double getOriginUpLevel() {
	return originUpLevel;
}
public void setOriginUpLevel(Double originUpLevel) {
	this.originUpLevel = originUpLevel;
}
public Double getOriginDownLevel() {
	return originDownLevel;
}
public void setOriginDownLevel(Double originDownLevel) {
	this.originDownLevel = originDownLevel;
}
public Double getOriginBigPosition() {
	return originBigPosition;
}
public void setOriginBigPosition(Double originBigPosition) {
	this.originBigPosition = originBigPosition;
}
public Double getOriginBigLevel() {
	return originBigLevel;
}
public void setOriginBigLevel(Double originBigLevel) {
	this.originBigLevel = originBigLevel;
}
public Double getOriginSmallLevel() {
	return originSmallLevel;
}
public void setOriginSmallLevel(Double originSmallLevel) {
	this.originSmallLevel = originSmallLevel;
}
public Double getInstantGamePosition() {
	return instantGamePosition;
}
public void setInstantGamePosition(Double instantGamePosition) {
	this.instantGamePosition = instantGamePosition;
}
public Double getInstantMasterLevel() {
	return instantMasterLevel;
}
public void setInstantMasterLevel(Double instantMasterLevel) {
	this.instantMasterLevel = instantMasterLevel;
}
public Double getInstantGuestLevel() {
	return instantGuestLevel;
}
public void setInstantGuestLevel(Double instantGuestLevel) {
	this.instantGuestLevel = instantGuestLevel;
}
public Double getInstantUpLevel() {
	return instantUpLevel;
}
public void setInstantUpLevel(Double instantUpLevel) {
	this.instantUpLevel = instantUpLevel;
}
public Double getInstantDownLevel() {
	return instantDownLevel;
}
public void setInstantDownLevel(Double instantDownLevel) {
	this.instantDownLevel = instantDownLevel;
}
public Double getInstantBigPosition() {
	return instantBigPosition;
}
public void setInstantBigPosition(Double instantBigPosition) {
	this.instantBigPosition = instantBigPosition;
}
public Double getInstantBigLevel() {
	return instantBigLevel;
}
public void setInstantBigLevel(Double instantBigLevel) {
	this.instantBigLevel = instantBigLevel;
}
public Double getInstantSmallLevel() {
	return instantSmallLevel;
}
public void setInstantSmallLevel(Double instantSmallLevel) {
	this.instantSmallLevel = instantSmallLevel;
}
public String getMasterName() {
	return masterName;
}
public void setMasterName(String masterName) {
	this.masterName = masterName;
}
public String getGuestName() {
	return guestName;
}
public void setGuestName(String guestName) {
	this.guestName = guestName;
}
public int getGameTime() {
	return gameTime;
}
public void setGameTime(int gameTime) {
	this.gameTime = gameTime;
}
public int getMasterPoint() {
	return masterPoint;
}
public void setMasterPoint(int masterPoint) {
	this.masterPoint = masterPoint;
}
public int getGuestPoint() {
	return guestPoint;
}
public void setGuestPoint(int guestPoint) {
	this.guestPoint = guestPoint;
}
public String getLeagueName() {
	return leagueName;
}
public void setLeagueName(String leagueName) {
	this.leagueName = leagueName;
}
public int getMasterAttack() {
	return masterAttack;
}
public void setMasterAttack(int masterAttack) {
	this.masterAttack = masterAttack;
}
public int getGuestAttack() {
	return guestAttack;
}
public void setGuestAttack(int guestAttack) {
	this.guestAttack = guestAttack;
}
public int getMasterDatk() {
	return masterDatk;
}
public void setMasterDatk(int masterDatk) {
	this.masterDatk = masterDatk;
}
public int getGuestDatk() {
	return guestDatk;
}
public void setGuestDatk(int guestDatk) {
	this.guestDatk = guestDatk;
}
public int getMasterSz() {
	return masterSz;
}
public void setMasterSz(int masterSz) {
	this.masterSz = masterSz;
}
public int getMasterSp() {
	return masterSp;
}
public void setMasterSp(int masterSp) {
	this.masterSp = masterSp;
}
public int getGuestSz() {
	return guestSz;
}
public void setGuestSz(int guestSz) {
	this.guestSz = guestSz;
}
public int getGuestSp() {
	return guestSp;
}
public void setGuestSp(int guestSp) {
	this.guestSp = guestSp;
}
public int getMasterQq() {
	return masterQq;
}
public void setMasterQq(int masterQq) {
	this.masterQq = masterQq;
}
public int getGuestQq() {
	return guestQq;
}
public void setGuestQq(int guestQq) {
	this.guestQq = guestQq;
}
public String getScore() {
	return score;
}
public void setScore(String score) {
	this.score = score;
}
public boolean isRedCard() {
	return redCard;
}
public void setRedCard(boolean redCard) {
	this.redCard = redCard;
}
public Double getInstantMaster() {
	return instantMaster;
}
public void setInstantMaster(Double instantMaster) {
	this.instantMaster = instantMaster;
}
public Double getInstantDraw() {
	return instantDraw;
}
public void setInstantDraw(Double instantDraw) {
	this.instantDraw = instantDraw;
}
public Double getInstantGuest() {
	return instantGuest;
}
public void setInstantGuest(Double instantGuest) {
	this.instantGuest = instantGuest;
}
}
