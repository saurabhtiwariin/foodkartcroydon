package cz.jiripinkas.jba.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.AppRole;
import cz.jiripinkas.jba.repository.AppRoleRepository;

@Service
@Transactional
public class RoleService {

	private static final Logger logger = Logger.getLogger(RoleService.class);

	@Autowired
	private AppRoleRepository roleRepository;

	public List<AppRole> getTableData(int page) {
		// TODO Auto-generated method stub
		logger.info("inside getTableData service");
		return roleRepository.findAll(
				new PageRequest(page, 10, Direction.ASC, "id")).getContent();
	}

	public void updateRoleTable(AppRole tmp) {
		logger.info("inside updateRoleTable service");

		Integer idtmp = tmp.getId();
		AppRole role = roleRepository.findOne(idtmp);

		role.setName(tmp.getName());

		roleRepository.save(role);
	}

	public List<AppRole> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	public AppRole findByName(String string) {
		// TODO Auto-generated method stub
		return roleRepository.findByName(string);
	}




}
