package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_deliverable database table.
 * 
 */
@Entity
@Table(name="app_deliverable")
@NamedQuery(name="AppDeliverable.findAll", query="SELECT a FROM AppDeliverable a")
public class AppDeliverable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private byte inTransit;

	private byte isDelivered;

	private String name;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	private int weghtingrams;

	//bi-directional many-to-one association to ApptlDeliverablepriority
	@ManyToOne
	@JoinColumn(name="deliverablepriority")
	private ApptlDeliverablepriority apptlDeliverablepriority;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="sourceaccount")
	private AppAccount appAccount1;

	//bi-directional many-to-one association to ApptlDeliverablematerial
	@ManyToOne
	@JoinColumn(name="deliverablematerial")
	private ApptlDeliverablematerial apptlDeliverablematerial;

	//bi-directional many-to-one association to ApptlDeliverable
	@ManyToOne
	@JoinColumn(name="subtype")
	private ApptlDeliverable apptlDeliverable;

	//bi-directional many-to-one association to ApptlDeliverablereason
	@ManyToOne
	@JoinColumn(name="returnReason")
	private ApptlDeliverablereason apptlDeliverablereason1;

	//bi-directional many-to-one association to AppAccount
	@ManyToOne
	@JoinColumn(name="destinationaccount")
	private AppAccount appAccount2;

	//bi-directional many-to-one association to ApptlDeliverablereason
	@ManyToOne
	@JoinColumn(name="undeliveredReason")
	private ApptlDeliverablereason apptlDeliverablereason2;

	//bi-directional many-to-one association to AppTracker
	@ManyToOne
	@JoinColumn(name="app_tracker_id")
	private AppTracker appTracker;

	//bi-directional many-to-many association to AppDbmr
	@ManyToMany
	@JoinTable(
		name="app_deliverable_has_app_dbmr"
		, joinColumns={
			@JoinColumn(name="app_deliverable_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="app_dbmr_id")
			}
		)
	private List<AppDbmr> appDbmrs;

	//bi-directional many-to-one association to AppFileupload
	@OneToMany(mappedBy="appDeliverable")
	private List<AppFileupload> appFileuploads;

	public AppDeliverable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public byte getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(byte inTransit) {
		this.inTransit = inTransit;
	}

	public byte getIsDelivered() {
		return this.isDelivered;
	}

	public void setIsDelivered(byte isDelivered) {
		this.isDelivered = isDelivered;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getWeghtingrams() {
		return this.weghtingrams;
	}

	public void setWeghtingrams(int weghtingrams) {
		this.weghtingrams = weghtingrams;
	}

	public ApptlDeliverablepriority getApptlDeliverablepriority() {
		return this.apptlDeliverablepriority;
	}

	public void setApptlDeliverablepriority(ApptlDeliverablepriority apptlDeliverablepriority) {
		this.apptlDeliverablepriority = apptlDeliverablepriority;
	}

	public AppAccount getAppAccount1() {
		return this.appAccount1;
	}

	public void setAppAccount1(AppAccount appAccount1) {
		this.appAccount1 = appAccount1;
	}

	public ApptlDeliverablematerial getApptlDeliverablematerial() {
		return this.apptlDeliverablematerial;
	}

	public void setApptlDeliverablematerial(ApptlDeliverablematerial apptlDeliverablematerial) {
		this.apptlDeliverablematerial = apptlDeliverablematerial;
	}

	public ApptlDeliverable getApptlDeliverable() {
		return this.apptlDeliverable;
	}

	public void setApptlDeliverable(ApptlDeliverable apptlDeliverable) {
		this.apptlDeliverable = apptlDeliverable;
	}

	public ApptlDeliverablereason getApptlDeliverablereason1() {
		return this.apptlDeliverablereason1;
	}

	public void setApptlDeliverablereason1(ApptlDeliverablereason apptlDeliverablereason1) {
		this.apptlDeliverablereason1 = apptlDeliverablereason1;
	}

	public AppAccount getAppAccount2() {
		return this.appAccount2;
	}

	public void setAppAccount2(AppAccount appAccount2) {
		this.appAccount2 = appAccount2;
	}

	public ApptlDeliverablereason getApptlDeliverablereason2() {
		return this.apptlDeliverablereason2;
	}

	public void setApptlDeliverablereason2(ApptlDeliverablereason apptlDeliverablereason2) {
		this.apptlDeliverablereason2 = apptlDeliverablereason2;
	}

	public AppTracker getAppTracker() {
		return this.appTracker;
	}

	public void setAppTracker(AppTracker appTracker) {
		this.appTracker = appTracker;
	}

	public List<AppDbmr> getAppDbmrs() {
		return this.appDbmrs;
	}

	public void setAppDbmrs(List<AppDbmr> appDbmrs) {
		this.appDbmrs = appDbmrs;
	}

	public List<AppFileupload> getAppFileuploads() {
		return this.appFileuploads;
	}

	public void setAppFileuploads(List<AppFileupload> appFileuploads) {
		this.appFileuploads = appFileuploads;
	}

	public AppFileupload addAppFileupload(AppFileupload appFileupload) {
		getAppFileuploads().add(appFileupload);
		appFileupload.setAppDeliverable(this);

		return appFileupload;
	}

	public AppFileupload removeAppFileupload(AppFileupload appFileupload) {
		getAppFileuploads().remove(appFileupload);
		appFileupload.setAppDeliverable(null);

		return appFileupload;
	}

}