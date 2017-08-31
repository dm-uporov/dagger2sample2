package ru.htc_cs.duporov.dagger2sample2.dagger.component;

import dagger.Subcomponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.GpModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.GpScope;

@GpScope
@Subcomponent(modules = GpModule.class)
public interface GpAuthComponent extends AuthDependentComponent {

}
