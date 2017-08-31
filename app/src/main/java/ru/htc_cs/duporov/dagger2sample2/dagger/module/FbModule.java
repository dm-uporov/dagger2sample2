package ru.htc_cs.duporov.dagger2sample2.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample2.business.function.AuthHelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.business.function.HelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.FbScope;

@Module
public class FbModule {

    private final String userName;

    public FbModule(String userName) {
        this.userName = userName;
    }

    @FbScope
    @Provides
    HelloUserFunction provideHelloUserFunction() {
        return new AuthHelloUserFunction(userName, "FB");
    }
}
