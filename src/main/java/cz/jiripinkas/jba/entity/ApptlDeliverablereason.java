package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the apptl__deliverablereasons database table.
 * 
 */
@Entity
@Table(name="apptl__deliverablereasons")
@NamedQuery(name="ApptlDeliverablereason.findAll", query="SELECT a FROM ApptlDeliverablereason a")
public class ApptlDeliverablereason implements Serializable {
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
	@OneToMany(mappedBy="apptlDeliverablereason1")
	private List<AppDeliverable> appDeliverables1;

	//bi-directional many-to-one association to AppDeliverable
	@OneToMany(mappedBy="apptlDeliverablereason2")
	private List<AppDeliverable> appDeliverables2;

	public ApptlDeliverablereason() {
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

	public List<AppDeliverable> getAppDeliverables1() {
		return this.appDeliverables1;
	}

	public void setAppDeliverables1(List<AppDeliverable> appDeliverables1) {
		this.appDeliverables1 = appDeliverables1;
	}

	public AppDeliverable addAppDeliverables1(AppDeliverable appDeliverables1) {
		getAppDeliverables1().add(appDeliverables1);
		appDeliverables1.setApptlDeliverablereason1(this);

		return appDeliverables1;
	}

	public AppDeliverable removeAppDeliverables1(AppDeliverable appDeliverables1) {
		getAppDeliverables1().remove(appDeliverables1);
		appDeliverables1.setApptlDeliverablereason1(null);

		return appDeliverables1;
	}

	public List<AppDeliverable> getAppDeliverables2() {
		return this.appDeliverables2;
	}

	public void setAppDeliverables2(List<AppDeliverable> appDeliverables2) {
		this.appDeliverables2 = appDeliverables2;
	}

	public AppDeliverable addAppDeliverables2(AppDeliverable appDeliverables2) {
		getAppDeliverables2().add(appDeliverables2);
		appDeliverables2.setApptlDeliverablereason2(this);

		return appDeliverables2;
	}

	public AppDeliverable removeAppDeliverables2(AppDeliverable appDeliverables2) {
		getAppDeliverables2().remove(appDeliverables2);
		appDeliverables2.setApptlDeliverablereason2(null);

		return appDeliverables2;
	}

}