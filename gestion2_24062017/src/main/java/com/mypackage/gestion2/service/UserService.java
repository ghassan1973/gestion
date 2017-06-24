package com.mypackage.gestion2.service;

import com.mypackage.gestion2.model.User;

public interface UserService extends BaseService<User>
{
    public User findByEmail(String email);
    
    public void changePassword(Long userId, String password);

    public void signup(User user);
}
