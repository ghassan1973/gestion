package com.mypackage.gestion2.repo;

import com.mypackage.gestion2.model.User;

public interface UserRepository extends BaseRepository<User>
{
    public User findByEmail(String email);
}
