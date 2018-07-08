package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


/**
 * The persistent class for the app_otp database table.
 * 
 */
@Entity
@Table(name="app_otp")
@NamedQuery(name="AppOtp.findAll", query="SELECT a FROM AppOtp a")
public class AppOtp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirayDate;

	private String otp;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	private byte verified;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="app_account_id")
	private AppAccount appAccount;

	public AppOtp() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getExpirayDate() {
		return this.expirayDate;
	}

	public void setExpirayDate(Date expirayDate) {
		this.expirayDate = expirayDate;
	}

	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public byte getRetired() {
		return this.retired;
	}

	public void setRetired(byte retired) {
		this.retired = retired;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public byte getVerified() {
		return this.verified;
	}

	public void setVerified(byte verified) {
		this.verified = verified;
	}

	public AppAccount getAppAccount() {
		return this.appAccount;
	}

	public void setAppAccount(AppAccount appAccount) {
		this.appAccount = appAccount;
	}

}