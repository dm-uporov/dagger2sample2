package ru.htc_cs.duporov.dagger2sample2.ui.recreating;

import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.ui.base.BaseAuthDependentComponent;

public class RecreatingFragment extends BaseAuthDependentComponent {

    public static RecreatingFragment newInstance() {
        return new RecreatingFragment();
    }

    @Override
    protected void inject() {
        App.getInstance().getComponent().inject(this);
    }
}
