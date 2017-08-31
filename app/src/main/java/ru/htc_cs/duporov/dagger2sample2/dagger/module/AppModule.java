package ru.htc_cs.duporov.dagger2sample2.dagger.module;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.business.AuthManager;
import ru.htc_cs.duporov.dagger2sample2.dagger.qualifier.RecreatingActivityIntent;
import ru.htc_cs.duporov.dagger2sample2.dagger.qualifier.ReinjectingActivityIntent;
import ru.htc_cs.duporov.dagger2sample2.ui.recreating.RecreatingActivity;
import ru.htc_cs.duporov.dagger2sample2.ui.reinjecting.ReinjectingActivity;

@Module
public class AppModule {

    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return app;
    }

    @Singleton
    @Provides
    LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(app);
    }

    @RecreatingActivityIntent
    @Singleton
    @Provides
    Intent provideRecreatingActivityIntent() {
        return new Intent(app, RecreatingActivity.class);
    }

    @ReinjectingActivityIntent
    @Singleton
    @Provides
    Intent provideReinjectingActivityIntent() {
        return new Intent(app, ReinjectingActivity.class);
    }

    @Singleton
    @Provides
    AuthManager provideAuthManager() {
        return new AuthManager();
    }
}
