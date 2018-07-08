package cz.jiripinkas.jba.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.ApptlStatus;
import cz.jiripinkas.jba.repository.ApptlStatusRepository;

@Service
public class StatusService {
	private static final Logger logger = Logger
			.getLogger(StatusService.class);

	@Autowired
	private ApptlStatusRepository statusRepository;
	
	public List<ApptlStatus> findAll() {
		logger.info("Inside findAll() service");
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

	public ApptlStatus findOne(Integer statusId) {
		// TODO Auto-generated method stub
		return statusRepository.findOne(statusId);
	}

	public List<ApptlStatus> getTableData(int page) {
		logger.info("inside getTableData service");
		return statusRepository.findAll(
				new PageRequest(page, 10, Direction.ASC, "id")).getContent();
		}
	
	public void updateStatusTable(ApptlStatus tmp) {
		// TODO Auto-generated method stub
		logger.info("inside updateStatusTable service");

		Integer idtmp = tmp.getId();
		ApptlStatus status = statusRepository.findOne(idtmp);

		status.setName(tmp.getName());

		statusRepository.save(status);
		
	}

	public ApptlStatus findByName(String string) {
		// TODO Auto-generated method stub
		return statusRepository.findByName(string);
	}

}
