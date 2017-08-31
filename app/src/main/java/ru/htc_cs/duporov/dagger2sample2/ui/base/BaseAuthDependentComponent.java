package ru.htc_cs.duporov.dagger2sample2.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.htc_cs.duporov.dagger2sample2.R;
import ru.htc_cs.duporov.dagger2sample2.business.AuthManager;
import ru.htc_cs.duporov.dagger2sample2.business.function.HelloUserFunction;

public abstract class BaseAuthDependentComponent extends Fragment {

    @Inject
    HelloUserFunction helloUserFunction;

    @Inject
    AuthManager authManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth_dependent, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
    }

    protected abstract void inject();

    @OnClick(R.id.hello_button)
    void onHelloClick() {
        helloUserFunction.sayHello(getContext());
    }

    @OnClick(R.id.vk)
    void onVkClick() {
        authManager.logInUser(AuthManager.AuthState.VK, "Pavel Durov");
    }

    @OnClick(R.id.fb)
    void onFbClick() {
        authManager.logInUser(AuthManager.AuthState.FB, "Mark Zuckerberg");
    }

    @OnClick(R.id.gp)
    void onGpClick() {
        authManager.logInUser(AuthManager.AuthState.GP, "Larry Page");
    }

    @OnClick(R.id.logout)
    void onLogoutClick() {
        authManager.logOutUser();
    }
}
