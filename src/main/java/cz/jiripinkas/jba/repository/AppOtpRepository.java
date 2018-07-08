package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppOtp;

public interface AppOtpRepository extends JpaRepository<AppOtp, Integer> {
/*
	PdOtp findByOtp(String otp);
*/
}