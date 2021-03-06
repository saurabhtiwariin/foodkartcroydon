package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the apptl__deliverablepriority database table.
 * 
 */
@Entity
@Table(name="apptl__deliverablepriority")
@NamedQuery(name="ApptlDeliverablepriority.findAll", query="SELECT a FROM ApptlDeliverablepriority a")
public class ApptlDeliverablepriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private String name;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to AppDeliverable
	@OneToMany(mappedBy="apptlDeliverablepriority")
	private List<AppDeliverable> appDeliverables;

	public ApptlDeliverablepriority() {
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

	public List<AppDeliverable> getAppDeliverables() {
		return this.appDeliverables;
	}

	public void setAppDeliverables(List<AppDeliverable> appDeliverables) {
		this.appDeliverables = appDeliverables;
	}

	public AppDeliverable addAppDeliverable(AppDeliverable appDeliverable) {
		getAppDeliverables().add(appDeliverable);
		appDeliverable.setApptlDeliverablepriority(this);

		return appDeliverable;
	}

	public AppDeliverable removeAppDeliverable(AppDeliverable appDeliverable) {
		getAppDeliverables().remove(appDeliverable);
		appDeliverable.setApptlDeliverablepriority(null);

		return appDeliverable;
	}

}