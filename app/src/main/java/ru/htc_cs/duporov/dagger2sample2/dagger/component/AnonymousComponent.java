package ru.htc_cs.duporov.dagger2sample2.dagger.component;

import dagger.Subcomponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.AnonymousModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.AnonymousScope;

@AnonymousScope
@Subcomponent(modules = AnonymousModule.class)
public interface AnonymousComponent extends AuthDependentComponent {

}
