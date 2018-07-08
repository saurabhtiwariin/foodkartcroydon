package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppTracker;

public interface AppTrackerRepository extends JpaRepository<AppTracker, Integer> {

/*    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
*/
}