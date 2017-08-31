package ru.htc_cs.duporov.dagger2sample2;

import android.app.Application;
import android.support.v4.util.Pair;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.htc_cs.duporov.dagger2sample2.business.AuthManager;
import ru.htc_cs.duporov.dagger2sample2.business.RxRouter;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.AppComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.DaggerAppComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.AppModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.FbModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.GpModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.VkModule;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private AppComponent appComponent;
    private RxRouter<AuthDependentComponent> authDependentComponentRouter;

    @Inject
    AuthManager authManager;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDagger();

        appComponent.inject(this);
        authManager.subscribeOnAuthState(this::onAuthStateChanged);
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        initAuthDepComponentRouter(appComponent);
    }

    public AuthDependentComponent getComponent() {
        return authDependentComponentRouter.getData();
    }

    public Disposable subscribeOnActualComponent(Consumer<AuthDependentComponent> observer) {
        return authDependentComponentRouter.subscribeOnData(observer);
    }

    public void unsubscribeFromActualComponent(Disposable disposable) {
        authDependentComponentRouter.unsubscribe(disposable);
    }

    private void initAuthDepComponentRouter(AppComponent appComponent) {
        authDependentComponentRouter = new RxRouter<>(appComponent.createAnonymousComponent());
    }

    private void onAuthStateChanged(Pair<AuthManager.AuthState, String> authState) {
        AuthDependentComponent newAuthDependentComponent;
        String userName = authState.second;
        switch (authState.first) {
            case VK:
                newAuthDependentComponent = appComponent.createVkAuthComponent(new VkModule(userName));
                break;
            case FB:
                newAuthDependentComponent = appComponent.createFbAuthComponent(new FbModule(userName));
                break;
            case GP:
                newAuthDependentComponent = appComponent.createGpAuthComponent(new GpModule(userName));
                break;
            case ANONYMOUS:
            default:
                newAuthDependentComponent = appComponent.createAnonymousComponent();
                break;
        }
        authDependentComponentRouter.setData(newAuthDependentComponent);
    }
}
