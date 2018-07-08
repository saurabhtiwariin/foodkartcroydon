package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppVerificationtoken;

public interface AppVerificationtokenRepository extends JpaRepository<AppVerificationtoken, Integer> {

/*    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
*/
}