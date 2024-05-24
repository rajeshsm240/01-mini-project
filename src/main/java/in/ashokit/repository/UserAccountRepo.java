package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.UserAccount;
import jakarta.transaction.Transactional;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount,Integer>{
	@Modifying
	@Transactional
	@Query("update UserAccount set activeSwitch=:status where userId=:userId")
	public void updateActiveSwitch(Integer userId, String status); 
}
