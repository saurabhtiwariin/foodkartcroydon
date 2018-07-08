package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_tracker database table.
 * 
 */
@Entity
@Table(name="app_tracker")
@NamedQuery(name="AppTracker.findAll", query="SELECT a FROM AppTracker a")
public class AppTracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to AppDeliverable
	@OneToMany(mappedBy="appTracker")
	private List<AppDeliverable> appDeliverables;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="sourceaccount")
	private AppAccount appAccount1;

	//bi-directional many-to-one association to AppAddress
	@ManyToOne
	@JoinColumn(name="sourceAddress")
	private AppAddress appAddress1;

	//bi-directional many-to-one association to AppAddress
	@ManyToOne
	@JoinColumn(name="destinationAddress")
	private AppAddress appAddress2;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="destinationaccount")
	private AppAccount appAccount2;

	//bi-directional many-to-one association to AppTrackerwf
	@OneToMany(mappedBy="appTracker")
	private List<AppTrackerwf> appTrackerwfs;

	public AppTracker() {
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

	public List<AppDeliverable> getAppDeliverables() {
		return this.appDeliverables;
	}

	public void setAppDeliverables(List<AppDeliverable> appDeliverables) {
		this.appDeliverables = appDeliverables;
	}

	public AppDeliverable addAppDeliverable(AppDeliverable appDeliverable) {
		getAppDeliverables().add(appDeliverable);
		appDeliverable.setAppTracker(this);

		return appDeliverable;
	}

	public AppDeliverable removeAppDeliverable(AppDeliverable appDeliverable) {
		getAppDeliverables().remove(appDeliverable);
		appDeliverable.setAppTracker(null);

		return appDeliverable;
	}

	public AppAccount getAppAccount1() {
		return this.appAccount1;
	}

	public void setAppAccount1(AppAccount appAccount1) {
		this.appAccount1 = appAccount1;
	}

	public AppAddress getAppAddress1() {
		return this.appAddress1;
	}

	public void setAppAddress1(AppAddress appAddress1) {
		this.appAddress1 = appAddress1;
	}

	public AppAddress getAppAddress2() {
		return this.appAddress2;
	}

	public void setAppAddress2(AppAddress appAddress2) {
		this.appAddress2 = appAddress2;
	}

	public AppAccount getAppAccount2() {
		return this.appAccount2;
	}

	public void setAppAccount2(AppAccount appAccount2) {
		this.appAccount2 = appAccount2;
	}

	public List<AppTrackerwf> getAppTrackerwfs() {
		return this.appTrackerwfs;
	}

	public void setAppTrackerwfs(List<AppTrackerwf> appTrackerwfs) {
		this.appTrackerwfs = appTrackerwfs;
	}

	public AppTrackerwf addAppTrackerwf(AppTrackerwf appTrackerwf) {
		getAppTrackerwfs().add(appTrackerwf);
		appTrackerwf.setAppTracker(this);

		return appTrackerwf;
	}

	public AppTrackerwf removeAppTrackerwf(AppTrackerwf appTrackerwf) {
		getAppTrackerwfs().remove(appTrackerwf);
		appTrackerwf.setAppTracker(null);

		return appTrackerwf;
	}

}