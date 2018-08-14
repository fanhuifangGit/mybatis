package com.ai.pojo;

import java.sql.Timestamp;

public class Card {
	
	//由JPA注解的方式换成Mybatis注解的方式
	    private String cardNo;
	    private String cardPwd;
	    private String cardState;
	    private String cardOperDate;
	    private String homeProv;
	    private String roamFlag;
	    private Timestamp effetiTime;
	    private Timestamp abateTime;
	    private String bindingNum;
	    private Integer cardPrice;
	    private Timestamp cardStoreTime;
	    private Timestamp cardActiveTime;
	    private String pkgId;
	    private Timestamp cardBindingTime;
	    private String cardOrderId;
	    private String fromProv;
	    private Timestamp transferDate;
	    private Timestamp cardLockTime;
	    private Timestamp cardExpTime;
	    private String idActivity;
	    private String idTwoLevel;
	    private String idOneLevel;

	    public String getCardNo() {
	        return cardNo;
	    }

	    public void setCardNo(String cardNo) {
	        this.cardNo = cardNo;
	    }

	    public String getCardPwd() {
	        return cardPwd;
	    }

	    public void setCardPwd(String cardPwd) {
	        this.cardPwd = cardPwd;
	    }

	    public String getCardState() {
	        return cardState;
	    }

	    public void setCardState(String cardState) {
	        this.cardState = cardState;
	    }

	    public String getCardOperDate() {
	        return cardOperDate;
	    }

	    public void setCardOperDate(String cardOperDate) {
	        this.cardOperDate = cardOperDate;
	    }

	    public String getHomeProv() {
	        return homeProv;
	    }

	    public void setHomeProv(String homeProv) {
	        this.homeProv = homeProv;
	    }

	    public String getRoamFlag() {
	        return roamFlag;
	    }

	    public void setRoamFlag(String roamFlag) {
	        this.roamFlag = roamFlag;
	    }

	    public Timestamp getEffetiTime() {
	        return effetiTime;
	    }

	    public void setEffetTime(Timestamp effetiTime) {
	        this.effetiTime = effetiTime;
	    }

	    public Timestamp getAbateTime() {
	        return abateTime;
	    }

	    public void setAbateTime(Timestamp abateTime) {
	        this.abateTime = abateTime;
	    }

	    public String getBindingNum() {
	        return bindingNum;
	    }

	    public void setBindingNum(String bindingNum) {
	        this.bindingNum = bindingNum;
	    }

	    public Integer getCardPrice() {
	        return cardPrice;
	    }

	    public void setCardPrice(Integer cardPrice) {
	        this.cardPrice = cardPrice;
	    }

	    public Timestamp getCardStoreTime() {
	        return cardStoreTime;
	    }

	    public void setCardStoreTime(Timestamp cardStoreTime) {
	        this.cardStoreTime = cardStoreTime;
	    }

	    public Timestamp getCardActiveTime() {
	        return cardActiveTime;
	    }

	    public void setCardActiveTime(Timestamp cardActiveTime) {
	        this.cardActiveTime = cardActiveTime;
	    }

	    public String getPkgId() {
	        return pkgId;
	    }

	    public void setPkgId(String pkgId) {
	        this.pkgId = pkgId;
	    }

	    public Timestamp getCardBindingTime() {
	        return cardBindingTime;
	    }

	    public void setCardBindingTime(Timestamp cardBindingTime) {
	        this.cardBindingTime = cardBindingTime;
	    }

	    public String getCardOrderId() {
	        return cardOrderId;
	    }

	    public void setCardOrderId(String cardOrderId) {
	        this.cardOrderId = cardOrderId;
	    }

	    public String getFromProv() {
	        return fromProv;
	    }

	    public void setFromProv(String fromProv) {
	        this.fromProv = fromProv;
	    }

	    public Timestamp getTransferDate() {
	        return transferDate;
	    }

	    public void setTransferDate(Timestamp transferDate) {
	        this.transferDate = transferDate;
	    }

	    public Timestamp getCardLockTime() {
	        return cardLockTime;
	    }

	    public void setCardLockTime(Timestamp cardLockTime) {
	        this.cardLockTime = cardLockTime;
	    }

	    public Timestamp getCardExpTime() {
	        return cardExpTime;
	    }

	    public void setCard_expTime(Timestamp cardExpTime) {
	        this.cardExpTime = cardExpTime;
	    }

	    public String getIdActivity() {
	        return idActivity;
	    }

	    public void setIdActivity(String idActivity) {
	        this.idActivity = idActivity;
	    }

	    public String getIdTwoLevel() {
	        return idTwoLevel;
	    }

	    public void setIdTwoLevel(String idTwoLevel) {
	        this.idTwoLevel = idTwoLevel;
	    }

	    public String getIdOneLevel() {
	        return idOneLevel;
	    }

	    public void setIdOneLevel(String idOneLevel) {
	        this.idOneLevel = idOneLevel;
	    }

		@Override
		public String toString() {
			return "Card [cardNo=" + cardNo + ", cardPwd=" + cardPwd
					+ ", cardState=" + cardState + ", cardOperDate="
					+ cardOperDate + ", homeProv=" + homeProv + ", roamFlag="
					+ roamFlag + ", effetiTime=" + effetiTime + ", abateTime="
					+ abateTime + ", bindingNum=" + bindingNum + ", cardPrice="
					+ cardPrice + ", cardStoreTime=" + cardStoreTime
					+ ", cardActiveTime=" + cardActiveTime + ", pkgId=" + pkgId
					+ ", cardBindingTime=" + cardBindingTime + ", cardOrderId="
					+ cardOrderId + ", fromProv=" + fromProv
					+ ", transferDate=" + transferDate + ", cardLockTime="
					+ cardLockTime + ", card_expTime=" + cardExpTime
					+ ", idActivity=" + idActivity + ", idTwoLevel="
					+ idTwoLevel + ", idOneLevel=" + idOneLevel + "]";
		}




	

}
