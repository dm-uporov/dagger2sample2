package ru.htc_cs.duporov.dagger2sample2.ui.reinjecting;

import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;

interface OnComponentChangedListener {

    void onComponentChanged(AuthDependentComponent authDependentComponent);
}
