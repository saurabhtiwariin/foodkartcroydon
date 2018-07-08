package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppAccount;

public interface AppAccountRepository extends JpaRepository<AppAccount, Integer>{

	
	AppAccount findByAccountnumber(String accountnumber);
/*	@Query("Select a from Accept a where a.user = ?1")
	List<Accept> getHelpData(User userMe);
	
	@Query("Select a from Accept a where a.user = ?1 and a.status = ?2")
	List<Accept> getHelpDataCompleted(User acceptor, Status status);
	
	@Query("Select a from Accept a where a.commit = ?1")
	Accept giveHelpData(Commit commit);
	
	@Query("Select a from Accept a where a.commit = ?1 and a.status = ?2")
	Accept giveHelpDataCompleted(Commit commit, Status status);

	
	List<Accept> findByUser(User user);

	@Query("Select a from Accept a where a.user = ?1 and a.status = ?2")
	List<Accept> findByUserAndStatus(User user, Status status);


*/	

//	public List<Accept> findAllByUserAndStatus(User acceptor, Status status);
//	
//	@Query("update User u set u.firstname = ?1 where u.lastname = ?2")
//	int setFixedFirstnameFor(String firstname, String lastname);


}
