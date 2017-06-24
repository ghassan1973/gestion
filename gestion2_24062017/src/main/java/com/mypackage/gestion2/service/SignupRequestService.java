package com.mypackage.gestion2.service;

import com.mypackage.gestion2.model.SignupRequest;

public interface SignupRequestService extends BaseService<SignupRequest> {
	public SignupRequest findByToken(String token);

}
