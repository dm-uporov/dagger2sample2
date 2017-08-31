package ru.htc_cs.duporov.dagger2sample2.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample2.business.function.AuthHelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.business.function.HelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.GpScope;

@Module
public class GpModule {

    private final String userName;

    public GpModule(String userName) {
        this.userName = userName;
    }

    @GpScope
    @Provides
    HelloUserFunction provideHelloUserFunction() {
        return new AuthHelloUserFunction(userName, "GP");
    }
}
