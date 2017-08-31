package ru.htc_cs.duporov.dagger2sample2.dagger.component.base;

import ru.htc_cs.duporov.dagger2sample2.ui.MainActivity;
import ru.htc_cs.duporov.dagger2sample2.ui.recreating.RecreatingFragment;
import ru.htc_cs.duporov.dagger2sample2.ui.reinjecting.ReinjectingFragment;

public interface AuthDependentComponent {

    void inject(MainActivity mainActivity);

    void inject(RecreatingFragment recreatingFragment);

    void inject(ReinjectingFragment reinjectingFragment);
}
