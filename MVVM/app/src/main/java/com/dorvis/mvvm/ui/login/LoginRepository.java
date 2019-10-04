package com.dorvis.mvvm.ui.login;

import com.dorvis.mvvm.data.model.User;
import com.dorvis.mvvm.data.network.RepoService;

import javax.inject.Inject;

import io.reactivex.Single;

public class LoginRepository {

    private final RepoService repoService;
    @Inject
    public LoginRepository(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<User>getLoginInfo(User user){
        return  repoService.registerUser(user);
    }
}
