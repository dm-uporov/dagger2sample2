package ru.htc_cs.duporov.dagger2sample2.dagger.component;

import dagger.Subcomponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.FbModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.FbScope;

@FbScope
@Subcomponent(modules = FbModule.class)
public interface FbAuthComponent extends AuthDependentComponent {

}
