package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.ApptlStatus;

public interface ApptlStatusRepository extends JpaRepository<ApptlStatus, Integer> {

	ApptlStatus findByName(String string);
	ApptlStatus findByCode(String string);

}
