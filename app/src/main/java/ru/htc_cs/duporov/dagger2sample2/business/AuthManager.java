package ru.htc_cs.duporov.dagger2sample2.business;


import android.support.v4.util.Pair;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AuthManager {

    private static final String ANONYMOUS_NAME = "";

    private final RxRouter<Pair<AuthState, String>> router =
            new RxRouter<>(new Pair<>(AuthState.ANONYMOUS, ANONYMOUS_NAME));

    public Disposable subscribeOnAuthState(Consumer<Pair<AuthState, String>> observer) {
        return router.subscribeOnData(observer);
    }

    public void logInUser(AuthState authState, String userName) {
        router.setData(new Pair<>(authState, userName));
    }

    public void logOutUser() {
        router.setData(new Pair<>(AuthState.ANONYMOUS, ANONYMOUS_NAME));
    }

    public enum AuthState {
        ANONYMOUS,
        VK,
        FB,
        GP
    }
}
