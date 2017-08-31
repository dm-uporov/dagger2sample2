package ru.htc_cs.duporov.dagger2sample2.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.htc_cs.duporov.dagger2sample2.business.function.AuthHelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.business.function.HelloUserFunction;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.VkScope;

@Module
public class VkModule {

    private final String userName;

    public VkModule(String userName) {
        this.userName = userName;
    }

    @VkScope
    @Provides
    HelloUserFunction provideHelloUserFunction() {
        return new AuthHelloUserFunction(userName, "VK");
    }
}
