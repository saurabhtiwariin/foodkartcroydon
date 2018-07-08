package cz.jiripinkas.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.jiripinkas.jba.entity.AppAddress;

public interface AppAddressRepository extends JpaRepository<AppAddress, Integer>{

	/*List<Commit> findByUser(User user);

	List<Commit> findByUser_IdAndStatus_Id(Integer integer, Integer integer2);

	@Query("Select a from Commit a where a.user = ?1 and a.status = ?2")
	List<Commit> findByUserAndStatus(User commitor, Status status);

	List<Commit> findByAccept(Accept accept);

	List<Commit> findAllByOrderByUserAsc();

*//*	List<Commit> findAllBySortByUserAsc();*/


}
