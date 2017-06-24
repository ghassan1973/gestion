package com.mypackage.gestion2.service;

import com.mypackage.gestion2.model.ForgotPasswordRequest;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.service.BaseService;

public interface ForgotPasswordRequestService extends BaseService<ForgotPasswordRequest> {
	public User validateUserToken(String token);

	public ForgotPasswordRequest findByToken(String token);

}
