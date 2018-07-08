package cz.jiripinkas.jba.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.AppAccount;
import cz.jiripinkas.jba.entity.AppAddress;
import cz.jiripinkas.jba.entity.AppContact;
import cz.jiripinkas.jba.entity.AppRole;
import cz.jiripinkas.jba.entity.ApptlSecurityquestion;
import cz.jiripinkas.jba.entity.ApptlStatus;
import cz.jiripinkas.jba.repository.AppAccountRepository;
import cz.jiripinkas.jba.repository.AppAddressRepository;
import cz.jiripinkas.jba.repository.AppContactRepository;
import cz.jiripinkas.jba.repository.AppHistoryRepository;
import cz.jiripinkas.jba.repository.AppRoleRepository;
import cz.jiripinkas.jba.repository.ApptlSecurityquestionRepository;
import cz.jiripinkas.jba.repository.ApptlStatusRepository;
import cz.jiripinkas.jba.util.EntityFactory;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private AppRoleRepository roleRepository;

	@Autowired
	private AppAccountRepository accountRepository;

	@Autowired
	private AppContactRepository contactRepository;

	@Autowired
	private AppAddressRepository addressRepository;

	@Autowired
	private ApptlSecurityquestionRepository securityRepository;

	@Autowired
	private ApptlStatusRepository statusRepository;

	@Autowired
	private AppHistoryRepository transactionRepository;

	@PostConstruct
	public void init() throws InstantiationException, IllegalAccessException {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if (roleRepository.findByCode("ROLE_ADMIN") == null) {

			/* Helper table value setting */

			/* Initializing Status table */
			HashMap map = new HashMap<String,String>();
			map.put("SAVED", "SAVED");
			map.put("AWAITING_SUBMISSION", "AWAITING_SUBMISSION");
			map.put("SUBMITTEDSUBMISSION", "SUBMITTEDSUBMISSION");
			map.put("ACCEPTED", "ACCEPTED");
			map.put("PROCESSED", "PROCESSED");
			map.put("REJECTED", "REJECTED");
			map.put("SAVED", "SAVED");
			map.put("ACTIVE", "ACTIVE");
			map.put("INACTIVE", "INACTIVE");
			map.put("CREDITED", "CREDITED");
			map.put("DEBITED", "DEBITED");
			
			
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				ApptlStatus a = EntityFactory.getEntity(ApptlStatus.class);
				a.setName(key);
				a.setCode((String)map.get(key));
				statusRepository.saveAndFlush(a);
			}
			/* Initializing Status table */
			
			/* Initializing SecurityQuestion Table */
			map = new HashMap<String,String>();
			map.put("Name of your favourite childhood teacher?", "question1");
			map.put("Name of your first pet?", "question2");
			map.put("Name of your fiance?", "question3");
			map.put("What you want to become?", "question4");
			map.put("City in which you where born?", "question5");
			map.put("Your mother's surname?", "question6");

			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				ApptlSecurityquestion a = EntityFactory.getEntity(ApptlSecurityquestion.class);
				a.setName(key);
				a.setCode((String)map.get(key));
				securityRepository.saveAndFlush(a);
			}
			/* Initializing SecurityQuestion Table END */

			/* Initializing Role table */
			map = new HashMap<String,String>();
			map.put("ROLE_USER", "ROLE_USER");
			map.put("ROLE_ADMIN", "ROLE_ADMIN");
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
				String key = (String) iterator.next();
				AppRole a = EntityFactory.getEntity(AppRole.class);
				a.setName(key);
				a.setCode((String)map.get(key));
				roleRepository.saveAndFlush(a);
			}
			/* Initializing Role table END */
			/* Helper table value setting END */

			/* Saving admin to database by default */

			AppAccount adminAccount = EntityFactory.getEntity(AppAccount.class);
			adminAccount.setAccountnumber("su");
			adminAccount.setPassword(encoder.encode("gw"));

			List<AppRole> adminRoles = new ArrayList<AppRole>();
			adminRoles.add(roleRepository.findByCode("ROLE_USER"));
			adminRoles.add(roleRepository.findByCode("ROLE_ADMIN"));

			List<AppContact> adminContacts = new ArrayList<AppContact>();
			AppContact adminContact = EntityFactory.getEntity(AppContact.class);
			adminContact.setAllBasicDetails("saurabhtiwari.in@gmail.com",
					"Saurabh", "Tiwari", "7358373594");
			adminContact.setAppRoles(adminRoles);

			List<AppAddress> adminPdAddresses = new ArrayList<AppAddress>();
			AppAddress adminPdAddress = EntityFactory.getEntity(AppAddress.class);
			adminPdAddress.setAllBasicDetails("addressline1", "addressline2",
					"addressline2", "country", (byte) 1, 226012, "state");
			adminPdAddresses.add(adminPdAddress);
			addressRepository.save(adminPdAddress);
			adminContact.setAppAddresses(adminPdAddresses);

			contactRepository.save(adminContact);
			
			adminContacts.add(adminContact);

			adminAccount.setAppContacts(adminContacts);

			adminAccount.setApptlSecurityquestion(securityRepository
					.findByCode("question1"));

			adminAccount.setSecurityAnswer(encoder.encode("patrick"));
			adminAccount.setAppAddress(adminPdAddress);

			accountRepository.save(adminAccount);

		}
	}

}
