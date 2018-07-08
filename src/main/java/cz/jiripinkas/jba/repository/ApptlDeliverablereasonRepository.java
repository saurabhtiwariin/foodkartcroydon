package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.ApptlDeliverablereason;

public interface ApptlDeliverablereasonRepository extends JpaRepository<ApptlDeliverablereason, Integer> {

/*    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
*/
}