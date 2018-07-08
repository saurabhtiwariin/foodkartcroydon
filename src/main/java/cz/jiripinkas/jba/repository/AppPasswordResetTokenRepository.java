package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppPasswordresettoken;

public interface AppPasswordResetTokenRepository extends JpaRepository<AppPasswordresettoken, Integer> {

/*    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);
*/
}
