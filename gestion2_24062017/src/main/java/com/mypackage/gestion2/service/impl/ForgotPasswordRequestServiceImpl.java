package com.mypackage.gestion2.service.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mypackage.gestion2.model.ForgotPasswordRequest;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.repo.BaseRepository;
import com.mypackage.gestion2.repo.ForgotPasswordRequestRepository;
import com.mypackage.gestion2.service.ForgotPasswordRequestService;

@Service
public class ForgotPasswordRequestServiceImpl extends BaseServiceImpl<ForgotPasswordRequest>
		implements ForgotPasswordRequestService {
	@Resource
	private ForgotPasswordRequestRepository forgotPasswordRequestRepository;

	@Override
	protected BaseRepository<ForgotPasswordRequest> getRepository() {
		return forgotPasswordRequestRepository;
	}

	@Override
	public ForgotPasswordRequest findByToken(String token){
		return forgotPasswordRequestRepository.findByToken(token);
	}
	
	@Override
	public User validateUserToken(String token) {
		ForgotPasswordRequest req = forgotPasswordRequestRepository.findByToken(token);
		Date expiresOn = req.getExpiresOn();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(expiresOn);

		if (calendar.before(Calendar.getInstance())) {
			throw new RuntimeException("Expired token");
		}

		return req.getUser();
	}
}
