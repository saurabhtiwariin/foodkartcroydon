package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppNote;

public interface AppNoteRepository extends JpaRepository<AppNote, Integer> {

/*    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
*/
}