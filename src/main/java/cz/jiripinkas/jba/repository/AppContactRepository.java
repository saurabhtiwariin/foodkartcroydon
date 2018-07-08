package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppContact;

public interface AppContactRepository extends JpaRepository<AppContact, Integer>{

}
