package ru.htc_cs.duporov.dagger2sample2.dagger.component;

import dagger.Subcomponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.dagger.module.VkModule;
import ru.htc_cs.duporov.dagger2sample2.dagger.scope.VkScope;

@VkScope
@Subcomponent(modules = VkModule.class)
public interface VkAuthComponent extends AuthDependentComponent {

}
