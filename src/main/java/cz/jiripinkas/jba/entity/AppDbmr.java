package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_dbmr database table.
 * 
 */
@Entity
@Table(name="app_dbmr")
@NamedQuery(name="AppDbmr.findAll", query="SELECT a FROM AppDbmr a")
public class AppDbmr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int amt;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private byte isPaid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date paiddate;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="fromaccount")
	private AppAccount appAccount;

	//bi-directional many-to-many association to AppDeliverable
	@ManyToMany(mappedBy="appDbmrs")
	private List<AppDeliverable> appDeliverables;

	public AppDbmr() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmt() {
		return this.amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public byte getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public Date getPaiddate() {
		return this.paiddate;
	}

	public void setPaiddate(Date paiddate) {
		this.paiddate = paiddate;
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

	public AppAccount getAppAccount() {
		return this.appAccount;
	}

	public void setAppAccount(AppAccount appAccount) {
		this.appAccount = appAccount;
	}

	public List<AppDeliverable> getAppDeliverables() {
		return this.appDeliverables;
	}

	public void setAppDeliverables(List<AppDeliverable> appDeliverables) {
		this.appDeliverables = appDeliverables;
	}

}