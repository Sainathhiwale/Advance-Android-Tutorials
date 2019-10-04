package com.dorvis.mvvm.ui.login;

import android.hardware.usb.UsbRequest;

import com.dorvis.mvvm.data.model.User;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {
    private final LoginRepository loginRepository;

    private CompositeDisposable disposable;

    private final MutableLiveData<User> useDto = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
        disposable = new CompositeDisposable();
    }

    public MutableLiveData<User> getUseDto() {
        return useDto;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public MutableLiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public void callLoginUser(User user) {
         loading.setValue(true);
         disposable.add(loginRepository.getLoginInfo(user).subscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<User>(){

                     @Override
                     public void onSuccess(User user) {
                         repoLoadError.setValue(false);
                         useDto.setValue(user);
                         loading.setValue(false);
                     }

                     @Override
                     public void onError(Throwable e) {
                         repoLoadError.setValue(true);
                         loading.setValue(false);
                     }
                 }));
    }
}
