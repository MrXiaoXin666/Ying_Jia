package com.xiaoxin.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 充值面额管理
 */
@Entity(name="sys_recharge_price_config")
public class SysRechargePriceConfig {
	private Integer srpcId;
	/**
	 * 类型
	 * @return
	 */
	private String  srpcType;
	/**
	 * 金额
	 */
	private Float  marketPrice;
	/**
	 * 金额
	 */
	private Float sellPrice;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 修改时间
	 */
	private Date  updateDate ;
	@Id
	@SequenceGenerator(name="sys_recharge_price_config",sequenceName="sql_sys_recharge_price_config",allocationSize=1)
	@GeneratedValue(generator="sys_recharge_price_config",strategy=GenerationType.SEQUENCE)
	public Integer getSrpcId() {
		return srpcId;
	}
	public void setSrpcId(Integer srpcId) {
		this.srpcId = srpcId;
	}
	public String getSrpcType() {
		return srpcType;
	}
	public void setSrpcType(String srpcType) {
		this.srpcType = srpcType;
	}
	public Float getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Float marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Float getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Float sellPrice) {
		this.sellPrice = sellPrice;
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
