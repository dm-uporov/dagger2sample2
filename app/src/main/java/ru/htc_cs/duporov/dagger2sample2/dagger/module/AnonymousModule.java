package ru.htc_cs.duporov.dagger2sample2.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample2.business.function.AnonymousHelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.business.function.HelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.AnonymousScope;

@Module
public class AnonymousModule {

    @AnonymousScope
    @Provides
    HelloUserFunction provideHelloUserFunction() {
        return new AnonymousHelloUserFunction();
    }
}
