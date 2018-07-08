package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppDbmr;

public interface AppDbmrRepository extends JpaRepository<AppDbmr, Integer>{

/*	List<Transaction> findByUser(User user);
	//Role findByName(String name);

	@Query("Select a from Transaction a where a.user = ?1 and a.remark = ?2")
	List<Transaction> findByUser(User userMe,String remark);
*/
}
