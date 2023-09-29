package com.mini.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.entity.UserAccounts;
import com.mini.repo.UserAccountRepo;
import com.mini.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccounts userAccounts) {
		// TODO Auto-generated method stub
		Integer userId = userAccounts.getUserId();
		//For the first time when the inserting the record Active status set to "Y" .
		if(userId==null) {
			userAccounts.setActiveSW("Y");
		}

		userAccRepo.save(userAccounts);
		if(userId==null) {
			return "User Record Saved";
		}
		else {
			return "User Record Updated";
		}
	}

	@Override
	public List<UserAccounts> getAllUserAccounts() {
		// TODO Auto-generated method stub
		List<UserAccounts> findAll = userAccRepo.findAll();
		return findAll;
	}

	@Override
	public UserAccounts getUserAccount(Integer userId) {
		// TODO Auto-generated method stub
		Optional<UserAccounts> userRecord = userAccRepo.findById(userId);
		if(userRecord.isPresent()) {
			return userRecord.get();
		}
		return null;
	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		// TODO Auto-generated method stub
		boolean existsById = userAccRepo.existsById(userId);
		if(existsById) {
			userAccRepo.deleteById(userId);
			return true;
		}
		return false;		
	}

	@Override
	public boolean updateUserAccountStatus(Integer userId, String status) {
		// TODO Auto-generated method stub
		userAccRepo.updateUserAccStatus(userId, status);
		return false;
	}


}
