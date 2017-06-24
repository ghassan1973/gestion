package com.mypackage.gestion2.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypackage.gestion2.model.SignupRequest;
import com.mypackage.gestion2.repo.BaseRepository;
import com.mypackage.gestion2.repo.SignupRequestRepository;
import com.mypackage.gestion2.service.SignupRequestService;

@Service
public class SignupRequestServiceImpl extends BaseServiceImpl<SignupRequest> implements SignupRequestService {
	@Resource
	private SignupRequestRepository signupRequestRepository;

	@Override
	protected BaseRepository<SignupRequest> getRepository() {
		return signupRequestRepository;
	}

	@Transactional
	@Override
	public SignupRequest findByToken(String token) {
		return signupRequestRepository.findByToken(token);
	}
}
