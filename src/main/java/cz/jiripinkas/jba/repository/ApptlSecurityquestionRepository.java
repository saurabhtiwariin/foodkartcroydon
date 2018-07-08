package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.ApptlSecurityquestion;

public interface ApptlSecurityquestionRepository extends
		JpaRepository<ApptlSecurityquestion, Integer> {

	ApptlSecurityquestion findByCode(String string);

}
