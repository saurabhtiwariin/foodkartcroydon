package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


/**
 * The persistent class for the app_fileupload database table.
 * 
 */
@Entity
@Table(name="app_fileupload")
@NamedQuery(name="AppFileupload.findAll", query="SELECT a FROM AppFileupload a")
public class AppFileupload implements Serializable {
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

	private String url;

	//bi-directional many-to-one association to AppDeliverable
	@ManyToOne
	@JoinColumn(name="app_deliverable_id")
	private AppDeliverable appDeliverable;

	public AppFileupload() {
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public AppDeliverable getAppDeliverable() {
		return this.appDeliverable;
	}

	public void setAppDeliverable(AppDeliverable appDeliverable) {
		this.appDeliverable = appDeliverable;
	}

}