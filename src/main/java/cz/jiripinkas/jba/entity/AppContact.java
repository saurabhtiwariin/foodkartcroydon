package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_contact database table.
 * 
 */
@Entity
@Table(name="app_contact")
@NamedQuery(name="AppContact.findAll", query="SELECT a FROM AppContact a")
public class AppContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private String emailid;

	private String firstname;

	private String lastname;

	private String mobilenumber;

	private byte retired;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-many association to AppAccount
	@ManyToMany
	@JoinTable(
		name="app_accountcontact"
		, joinColumns={
			@JoinColumn(name="app_contact_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="app_account_id")
			}
		)
	private List<AppAccount> appAccounts;

	//bi-directional many-to-many association to AppRole
	@ManyToMany
	@JoinTable(
		name="app_contact_role"
		, joinColumns={
			@JoinColumn(name="app_contact_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="app_role_id")
			}
		)
	private List<AppRole> appRoles;

	//bi-directional many-to-many association to AppAddress
	@ManyToMany(mappedBy="appContacts")
	private List<AppAddress> appAddresses;

	public AppContact() {
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

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
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

	public List<AppAccount> getAppAccounts() {
		return this.appAccounts;
	}

	public void setAppAccounts(List<AppAccount> appAccounts) {
		this.appAccounts = appAccounts;
	}

	public List<AppRole> getAppRoles() {
		return this.appRoles;
	}

	public void setAppRoles(List<AppRole> appRoles) {
		this.appRoles = appRoles;
	}

	public List<AppAddress> getAppAddresses() {
		return this.appAddresses;
	}

	public void setAppAddresses(List<AppAddress> appAddresses) {
		this.appAddresses = appAddresses;
	}

	public void setAllBasicDetails(String emailid, String firstname, String lastname,
			String mobilenumber) {
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
	}
}