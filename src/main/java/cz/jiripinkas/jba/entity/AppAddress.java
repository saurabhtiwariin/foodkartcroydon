package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_address database table.
 * 
 */
@Entity
@Table(name="app_address")
@NamedQuery(name="AppAddress.findAll", query="SELECT a FROM AppAddress a")
public class AppAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String addressline1;

	private String addressline2;

	private String city;

	private String country;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	private byte isPrimaryAddress;

	private int postcode;

	private byte retired;

	private String state;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to AppAccount
	@OneToMany(mappedBy="appAddress")
	private List<AppAccount> appAccounts;

	//bi-directional many-to-many association to AppContact
	@ManyToMany
	@JoinTable(
		name="app_contactaddress"
		, joinColumns={
			@JoinColumn(name="app_contact_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="app_address_id")
			}
		)
	private List<AppContact> appContacts;

	//bi-directional many-to-one association to AppTracker
	@OneToMany(mappedBy="appAddress1")
	private List<AppTracker> appTrackers1;

	//bi-directional many-to-one association to AppTracker
	@OneToMany(mappedBy="appAddress2")
	private List<AppTracker> appTrackers2;

	public AppAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public byte getIsPrimaryAddress() {
		return this.isPrimaryAddress;
	}

	public void setIsPrimaryAddress(byte isPrimaryAddress) {
		this.isPrimaryAddress = isPrimaryAddress;
	}

	public int getPostcode() {
		return this.postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public byte getRetired() {
		return this.retired;
	}

	public void setRetired(byte retired) {
		this.retired = retired;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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

	public AppAccount addAppAccount(AppAccount appAccount) {
		getAppAccounts().add(appAccount);
		appAccount.setAppAddress(this);

		return appAccount;
	}

	public AppAccount removeAppAccount(AppAccount appAccount) {
		getAppAccounts().remove(appAccount);
		appAccount.setAppAddress(null);

		return appAccount;
	}

	public List<AppContact> getAppContacts() {
		return this.appContacts;
	}

	public void setAppContacts(List<AppContact> appContacts) {
		this.appContacts = appContacts;
	}

	public List<AppTracker> getAppTrackers1() {
		return this.appTrackers1;
	}

	public void setAppTrackers1(List<AppTracker> appTrackers1) {
		this.appTrackers1 = appTrackers1;
	}

	public AppTracker addAppTrackers1(AppTracker appTrackers1) {
		getAppTrackers1().add(appTrackers1);
		appTrackers1.setAppAddress1(this);

		return appTrackers1;
	}

	public AppTracker removeAppTrackers1(AppTracker appTrackers1) {
		getAppTrackers1().remove(appTrackers1);
		appTrackers1.setAppAddress1(null);

		return appTrackers1;
	}

	public List<AppTracker> getAppTrackers2() {
		return this.appTrackers2;
	}

	public void setAppTrackers2(List<AppTracker> appTrackers2) {
		this.appTrackers2 = appTrackers2;
	}

	public AppTracker addAppTrackers2(AppTracker appTrackers2) {
		getAppTrackers2().add(appTrackers2);
		appTrackers2.setAppAddress2(this);

		return appTrackers2;
	}

	public AppTracker removeAppTrackers2(AppTracker appTrackers2) {
		getAppTrackers2().remove(appTrackers2);
		appTrackers2.setAppAddress2(null);

		return appTrackers2;
	}
	
	 public void setAllBasicDetails(String addressline1, String addressline2, String city,
				String country, byte isPrimaryAddress, int postcode, String state) {
			this.addressline1 = addressline1;
			this.addressline2 = addressline2;
			this.city = city;
			this.country = country;
			this.isPrimaryAddress = isPrimaryAddress;
			this.postcode = postcode;
			this.state = state;
		}

}