package com.mypackage.gestion2.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.SignupRequest;
import com.mypackage.gestion2.service.SignupRequestService;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.service.UserService;
import com.mypackage.gestion2.repo.UserRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService
{
	@Resource
	private UserRepository userRepository;

    @Resource
    private SignupRequestService signupRequestService;


	@Override
	protected BaseRepository<User> getRepository() {
		return userRepository;
	}

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Transactional
    @Override
    public void changePassword(Long userId, String password) {
        User one = userRepository.getOne(userId);
        one.setPassword(password);
        userRepository.saveDomain(one);
    }

    @Transactional
    @Override
    public void signup(User user) {
        saveDomain(user);
        SignupRequest req = new SignupRequest();
        req.setTokenId(UUID.randomUUID().toString());
        req.setCreatedOn(new Date());
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.DATE, 1);
        req.setExpiresOn(expiry.getTime());
        req.setUser(user);
        signupRequestService.saveDomain(req);
    }
}
