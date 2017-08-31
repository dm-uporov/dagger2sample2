package ru.htc_cs.duporov.dagger2sample2.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.AppModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.FbModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.GpModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.VkModule;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    AnonymousComponent createAnonymousComponent();

    VkAuthComponent createVkAuthComponent(VkModule vkModule);

    FbAuthComponent createFbAuthComponent(FbModule fbModule);

    GpAuthComponent createGpAuthComponent(GpModule gpModule);

    void inject(App app);
}
