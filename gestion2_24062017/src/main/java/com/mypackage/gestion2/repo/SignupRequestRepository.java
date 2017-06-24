package com.mypackage.gestion2.repo;

import com.mypackage.gestion2.model.SignupRequest;

public interface SignupRequestRepository extends BaseRepository<SignupRequest> {

	SignupRequest findByToken(String token);
}
