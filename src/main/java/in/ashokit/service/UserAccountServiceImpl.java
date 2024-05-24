package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.UserAccount;
import in.ashokit.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	private UserAccountRepo userRepo;

	@Override
	public String upsertUserAcc(UserAccount userAccount) {
		
		Integer id = userAccount.getUserId();
		userRepo.save(userAccount);
		if(id==null) {
			return "User created successfully";
		}else {
			return "User updated successfully";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userRepo.findAll();
	}

	@Override
	public UserAccount getUserAccount(Integer userId) {
		Optional<UserAccount> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		boolean existsById = userRepo.existsById(userId);
		
		if(existsById) {
			userRepo.deleteById(userId);
		}
		
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userRepo.updateActiveSwitch(userId, status);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
