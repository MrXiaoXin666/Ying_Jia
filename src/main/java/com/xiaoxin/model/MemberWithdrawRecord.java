package com.xiaoxin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 提现记录表
 */
@Entity(name="member_withdraw_record")
public class MemberWithdrawRecord {
	private Integer mwrId ;//主键
	private  String serialNumber ;//流水号',
	private  Integer memberId ;//用户id',
	private Float  amount  ;//'提现金额',
	private String bankName  ;//'银行名称',
	private String  bankCard  ;//卡号',
	private  Integer status ;//提现状态(0:待审核;1:已打款;2打款中;3:打款失败);',
	private  Integer delFlag ;
	private String cardaddress  ;// '开户银行所在地',
	private String channelName  ;// '打款通道（富友,贝付）',
	private Date createDate ;
	private  Date updateDate  ;
	
	@Id
	@SequenceGenerator(name="MemberWithdrawRecord _seq",sequenceName="sql_member_withdraw_record",allocationSize=1)
	@GeneratedValue(generator="MemberWithdrawRecord _seq",strategy=GenerationType.SEQUENCE)
	
	
	public Integer getMwrId() {
		return mwrId;
	}
	public void setMwrId(Integer mwrId) {
		this.mwrId = mwrId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public String getCardaddress() {
		return cardaddress;
	}
	public void setCardaddress(String cardaddress) {
		this.cardaddress = cardaddress;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	

}
