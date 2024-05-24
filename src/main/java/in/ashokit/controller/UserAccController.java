package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entity.UserAccount;
import in.ashokit.service.UserAccountService;

@Controller
public class UserAccController {
	
	@Autowired
	private UserAccountService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user",new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
	public String handleSubmitButton(@ModelAttribute("user") UserAccount account,Model model) {
		
		String msg = userService.upsertUserAcc(account);
		
		
		model.addAttribute("msg",msg);
		model.addAttribute("user",new UserAccount());
		return "index";
	}
	
	@GetMapping("/users")
	public String getUserAccounts(Model model){
		List<UserAccount> usersList = userService.getAllUserAccounts();
		
		model.addAttribute("users",usersList);
		return "view-users";
	}
	
	@GetMapping("/edit")
	public String updateUserAccount(@RequestParam("id") Integer id,Model model) {
		UserAccount account = userService.getUserAccount(id);
		model.addAttribute("user",account);
		
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteUserAccount(@RequestParam("id") Integer userId, Model model) {
		boolean deleteAccount = userService.deleteUserAcc(userId);	
		
		model.addAttribute("msg","User record deleted ");
		return "forward:/users";
	}
	
	@GetMapping("/update")
	public String statusUpdate(@RequestParam("id") Integer userId,
							   @RequestParam("status")String status,Model model) {
		userService.updateUserAccStatus(userId, status);
		
		if("Y".equals(status)) {
			model.addAttribute("msg", "User Account activated");
		}else {
			model.addAttribute("msg","User Account Deactivated ");
		}
		
		return "forward:/users";
	}
	
}
