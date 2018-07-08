package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppDeliverable;

public interface AppDeliverableRepository extends JpaRepository<AppDeliverable, Integer> {
/*
	PdOtp findByOtp(String otp);
*/
}