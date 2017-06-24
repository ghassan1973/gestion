package com.mypackage.gestion2.repo;

import com.mypackage.gestion2.model.ForgotPasswordRequest;

public interface ForgotPasswordRequestRepository extends BaseRepository<ForgotPasswordRequest> {

	public ForgotPasswordRequest findByToken(String token);
}
