package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {

	AppRole findByName(String name);

	AppRole findByCode(String code);

}
