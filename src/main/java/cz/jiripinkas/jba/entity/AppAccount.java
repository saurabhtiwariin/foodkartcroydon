package cz.jiripinkas.jba.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the app_account database table.
 * 
 */
@Entity
@Table(name="app_account")
@NamedQuery(name="AppAccount.findAll", query="SELECT a FROM AppAccount a")
public class AppAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String accountnumber;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	@Lob
	private String password;

	private byte retired;

	private String securityAnswer;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updatetime;

	//bi-directional many-to-one association to ApptlSecurityquestion
	@ManyToOne
	@JoinColumn(name="securityquestionid")
	private ApptlSecurityquestion apptlSecurityquestion;

	//bi-directional many-to-one association to AppAddress
	@ManyToOne
	@JoinColumn(name="accountAddress")
	private AppAddress appAddress;

	//bi-directional many-to-many association to AppContact
	@ManyToMany(mappedBy="appAccounts")
	private List<AppContact> appContacts;

	//bi-directional many-to-one association to AppDbmr
	@OneToMany(mappedBy="appAccount")
	private List<AppDbmr> appDbmrs;

	//bi-directional many-to-one association to AppDeliverable
	@OneToMany(mappedBy="appAccount1")
	private List<AppDeliverable> appDeliverables1;

	//bi-directional many-to-one association to AppDeliverable
	@OneToMany(mappedBy="appAccount2")
	private List<AppDeliverable> appDeliverables2;

	//bi-directional many-to-one association to AppHistory
	@OneToMany(mappedBy="appAccount")
	private List<AppHistory> appHistories;

	//bi-directional many-to-one association to AppNote
	@OneToMany(mappedBy="appAccount")
	private List<AppNote> appNotes;

	//bi-directional many-to-one association to AppOtp
	@OneToMany(mappedBy="appAccount")
	private List<AppOtp> appOtps;

	//bi-directional many-to-one association to AppPasswordresettoken
	@OneToMany(mappedBy="appAccount")
	private List<AppPasswordresettoken> appPasswordresettokens;

	//bi-directional many-to-one association to AppTracker
	@OneToMany(mappedBy="appAccount1")
	private List<AppTracker> appTrackers1;

	//bi-directional many-to-one association to AppTracker
	@OneToMany(mappedBy="appAccount2")
	private List<AppTracker> appTrackers2;

	//bi-directional many-to-one association to AppVerificationtoken
	@OneToMany(mappedBy="appAccount")
	private List<AppVerificationtoken> appVerificationtokens;

	public AppAccount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return this.accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getRetired() {
		return this.retired;
	}

	public void setRetired(byte retired) {
		this.retired = retired;
	}

	public String getSecurityAnswer() {
		return this.securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public ApptlSecurityquestion getApptlSecurityquestion() {
		return this.apptlSecurityquestion;
	}

	public void setApptlSecurityquestion(ApptlSecurityquestion apptlSecurityquestion) {
		this.apptlSecurityquestion = apptlSecurityquestion;
	}

	public AppAddress getAppAddress() {
		return this.appAddress;
	}

	public void setAppAddress(AppAddress appAddress) {
		this.appAddress = appAddress;
	}

	public List<AppContact> getAppContacts() {
		return this.appContacts;
	}

	public void setAppContacts(List<AppContact> appContacts) {
		this.appContacts = appContacts;
	}

	public List<AppDbmr> getAppDbmrs() {
		return this.appDbmrs;
	}

	public void setAppDbmrs(List<AppDbmr> appDbmrs) {
		this.appDbmrs = appDbmrs;
	}

	public AppDbmr addAppDbmr(AppDbmr appDbmr) {
		getAppDbmrs().add(appDbmr);
		appDbmr.setAppAccount(this);

		return appDbmr;
	}

	public AppDbmr removeAppDbmr(AppDbmr appDbmr) {
		getAppDbmrs().remove(appDbmr);
		appDbmr.setAppAccount(null);

		return appDbmr;
	}

	public List<AppDeliverable> getAppDeliverables1() {
		return this.appDeliverables1;
	}

	public void setAppDeliverables1(List<AppDeliverable> appDeliverables1) {
		this.appDeliverables1 = appDeliverables1;
	}

	public AppDeliverable addAppDeliverables1(AppDeliverable appDeliverables1) {
		getAppDeliverables1().add(appDeliverables1);
		appDeliverables1.setAppAccount1(this);

		return appDeliverables1;
	}

	public AppDeliverable removeAppDeliverables1(AppDeliverable appDeliverables1) {
		getAppDeliverables1().remove(appDeliverables1);
		appDeliverables1.setAppAccount1(null);

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
		appDeliverables2.setAppAccount2(this);

		return appDeliverables2;
	}

	public AppDeliverable removeAppDeliverables2(AppDeliverable appDeliverables2) {
		getAppDeliverables2().remove(appDeliverables2);
		appDeliverables2.setAppAccount2(null);

		return appDeliverables2;
	}

	public List<AppHistory> getAppHistories() {
		return this.appHistories;
	}

	public void setAppHistories(List<AppHistory> appHistories) {
		this.appHistories = appHistories;
	}

	public AppHistory addAppHistory(AppHistory appHistory) {
		getAppHistories().add(appHistory);
		appHistory.setAppAccount(this);

		return appHistory;
	}

	public AppHistory removeAppHistory(AppHistory appHistory) {
		getAppHistories().remove(appHistory);
		appHistory.setAppAccount(null);

		return appHistory;
	}

	public List<AppNote> getAppNotes() {
		return this.appNotes;
	}

	public void setAppNotes(List<AppNote> appNotes) {
		this.appNotes = appNotes;
	}

	public AppNote addAppNote(AppNote appNote) {
		getAppNotes().add(appNote);
		appNote.setAppAccount(this);

		return appNote;
	}

	public AppNote removeAppNote(AppNote appNote) {
		getAppNotes().remove(appNote);
		appNote.setAppAccount(null);

		return appNote;
	}

	public List<AppOtp> getAppOtps() {
		return this.appOtps;
	}

	public void setAppOtps(List<AppOtp> appOtps) {
		this.appOtps = appOtps;
	}

	public AppOtp addAppOtp(AppOtp appOtp) {
		getAppOtps().add(appOtp);
		appOtp.setAppAccount(this);

		return appOtp;
	}

	public AppOtp removeAppOtp(AppOtp appOtp) {
		getAppOtps().remove(appOtp);
		appOtp.setAppAccount(null);

		return appOtp;
	}

	public List<AppPasswordresettoken> getAppPasswordresettokens() {
		return this.appPasswordresettokens;
	}

	public void setAppPasswordresettokens(List<AppPasswordresettoken> appPasswordresettokens) {
		this.appPasswordresettokens = appPasswordresettokens;
	}

	public AppPasswordresettoken addAppPasswordresettoken(AppPasswordresettoken appPasswordresettoken) {
		getAppPasswordresettokens().add(appPasswordresettoken);
		appPasswordresettoken.setAppAccount(this);

		return appPasswordresettoken;
	}

	public AppPasswordresettoken removeAppPasswordresettoken(AppPasswordresettoken appPasswordresettoken) {
		getAppPasswordresettokens().remove(appPasswordresettoken);
		appPasswordresettoken.setAppAccount(null);

		return appPasswordresettoken;
	}

	public List<AppTracker> getAppTrackers1() {
		return this.appTrackers1;
	}

	public void setAppTrackers1(List<AppTracker> appTrackers1) {
		this.appTrackers1 = appTrackers1;
	}

	public AppTracker addAppTrackers1(AppTracker appTrackers1) {
		getAppTrackers1().add(appTrackers1);
		appTrackers1.setAppAccount1(this);

		return appTrackers1;
	}

	public AppTracker removeAppTrackers1(AppTracker appTrackers1) {
		getAppTrackers1().remove(appTrackers1);
		appTrackers1.setAppAccount1(null);

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
		appTrackers2.setAppAccount2(this);

		return appTrackers2;
	}

	public AppTracker removeAppTrackers2(AppTracker appTrackers2) {
		getAppTrackers2().remove(appTrackers2);
		appTrackers2.setAppAccount2(null);

		return appTrackers2;
	}

	public List<AppVerificationtoken> getAppVerificationtokens() {
		return this.appVerificationtokens;
	}

	public void setAppVerificationtokens(List<AppVerificationtoken> appVerificationtokens) {
		this.appVerificationtokens = appVerificationtokens;
	}

	public AppVerificationtoken addAppVerificationtoken(AppVerificationtoken appVerificationtoken) {
		getAppVerificationtokens().add(appVerificationtoken);
		appVerificationtoken.setAppAccount(this);

		return appVerificationtoken;
	}

	public AppVerificationtoken removeAppVerificationtoken(AppVerificationtoken appVerificationtoken) {
		getAppVerificationtokens().remove(appVerificationtoken);
		appVerificationtoken.setAppAccount(null);

		return appVerificationtoken;
	}

}