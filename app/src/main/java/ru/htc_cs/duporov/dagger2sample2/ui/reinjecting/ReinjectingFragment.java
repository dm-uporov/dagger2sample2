package ru.htc_cs.duporov.dagger2sample2.ui.reinjecting;

import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;
import ru.htc_cs.duporov.dagger2sample2.ui.base.BaseAuthDependentComponent;

public class ReinjectingFragment extends BaseAuthDependentComponent implements OnComponentChangedListener {

    public static ReinjectingFragment newInstance() {
        return new ReinjectingFragment();
    }

    @Override
    protected void inject() {
        inject(App.getInstance().getComponent());
    }

    @Override
    public void onComponentChanged(AuthDependentComponent authDependentComponent) {
        inject(authDependentComponent);
    }

    public void inject(AuthDependentComponent authDependentComponent) {
        authDependentComponent.inject(this);
    }
}
