package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppHistory;

public interface AppHistoryRepository extends JpaRepository<AppHistory, Integer> {

/*    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
*/
}