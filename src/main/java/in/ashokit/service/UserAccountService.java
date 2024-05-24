package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.UserAccount;

public interface UserAccountService {
	
	public String upsertUserAcc(UserAccount userAccount);
	
	public List<UserAccount> getAllUserAccounts();
	
	public UserAccount getUserAccount(Integer userId);
	
	public boolean deleteUserAcc(Integer userId);
	
	public boolean updateUserAccStatus(Integer userId, String status);
}
