package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


/**
 * The persistent class for the app_passwordresettoken database table.
 * 
 */
@Entity
@Table(name="app_passwordresettoken")
@NamedQuery(name="AppPasswordresettoken.findAll", query="SELECT a FROM AppPasswordresettoken a")
public class AppPasswordresettoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expirayDate;

	private byte retired;

	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="accountid")
	private AppAccount appAccount;

	public AppPasswordresettoken() {
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

	public byte getRetired() {
		return this.retired;
	}

	public void setRetired(byte retired) {
		this.retired = retired;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public AppAccount getAppAccount() {
		return this.appAccount;
	}

	public void setAppAccount(AppAccount appAccount) {
		this.appAccount = appAccount;
	}

}