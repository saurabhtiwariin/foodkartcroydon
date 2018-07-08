package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the apptl__deliverablematerial database table.
 * 
 */
@Entity
@Table(name="apptl__deliverablematerial")
@NamedQuery(name="ApptlDeliverablematerial.findAll", query="SELECT a FROM ApptlDeliverablematerial a")
public class ApptlDeliverablematerial implements Serializable {
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
	@OneToMany(mappedBy="apptlDeliverablematerial")
	private List<AppDeliverable> appDeliverables;

	public ApptlDeliverablematerial() {
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
		appDeliverable.setApptlDeliverablematerial(this);

		return appDeliverable;
	}

	public AppDeliverable removeAppDeliverable(AppDeliverable appDeliverable) {
		getAppDeliverables().remove(appDeliverable);
		appDeliverable.setApptlDeliverablematerial(null);

		return appDeliverable;
	}

}