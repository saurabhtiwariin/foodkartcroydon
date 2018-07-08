package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_role database table.
 * 
 */
@Entity
@Table(name="app_role")
@NamedQuery(name="AppRole.findAll", query="SELECT a FROM AppRole a")
public class AppRole implements Serializable {
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

	//bi-directional many-to-many association to AppContact
	@ManyToMany(mappedBy="appRoles")
	private List<AppContact> appContacts;

	//bi-directional many-to-one association to AppPermission
	@OneToMany(mappedBy="appRole")
	private List<AppPermission> appPermissions;

	public AppRole() {
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

	public List<AppContact> getAppContacts() {
		return this.appContacts;
	}

	public void setAppContacts(List<AppContact> appContacts) {
		this.appContacts = appContacts;
	}

	public List<AppPermission> getAppPermissions() {
		return this.appPermissions;
	}

	public void setAppPermissions(List<AppPermission> appPermissions) {
		this.appPermissions = appPermissions;
	}

	public AppPermission addAppPermission(AppPermission appPermission) {
		getAppPermissions().add(appPermission);
		appPermission.setAppRole(this);

		return appPermission;
	}

	public AppPermission removeAppPermission(AppPermission appPermission) {
		getAppPermissions().remove(appPermission);
		appPermission.setAppRole(null);

		return appPermission;
	}

}