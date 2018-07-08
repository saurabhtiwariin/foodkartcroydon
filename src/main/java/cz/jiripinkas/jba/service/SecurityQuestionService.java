package cz.jiripinkas.jba.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.AppAccount;
import cz.jiripinkas.jba.entity.ApptlSecurityquestion;
import cz.jiripinkas.jba.repository.AppAccountRepository;
import cz.jiripinkas.jba.repository.ApptlSecurityquestionRepository;

@Service
@Transactional
public class SecurityQuestionService {

	private static final Logger logger = Logger
			.getLogger(SecurityQuestionService.class);

	@Autowired
	private ApptlSecurityquestionRepository securityQuestionRepository;

	@Autowired
	private AppAccountRepository accountRepository;

	public List<ApptlSecurityquestion> findAll() {
		// TODO Auto-generated method stub
		List<ApptlSecurityquestion> securityQuestion = securityQuestionRepository
				.findAll();
		return securityQuestion;
	}

	public ApptlSecurityquestion findOne(String accountnumber) {
		// TODO Auto-generated method stub
		AppAccount account = accountRepository.findByAccountnumber(accountnumber);

		return account.getApptlSecurityquestion();
	}

	public List<ApptlSecurityquestion> getTableData(int page) {
		// TODO Auto-generated method stub
		logger.info("inside getTableData service");
		return securityQuestionRepository.findAll(
				new PageRequest(page, 10, Direction.ASC, "id")).getContent();
	}

	public void updateSecurityQuestionTable(ApptlSecurityquestion tmp) {
		// TODO Auto-generated method stub
		logger.info("inside updateFileUploadTable service");

		Integer idtmp = tmp.getId();
		ApptlSecurityquestion question = securityQuestionRepository.findOne(idtmp);
		question.setName(tmp.getName());
		securityQuestionRepository.save(question);

	}

}
