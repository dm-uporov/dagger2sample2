package ru.htc_cs.duporov.dagger2sample2.ui.reinjecting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.reactivex.disposables.Disposable;
import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.dagger.component.base.AuthDependentComponent;

/**
 * Суть данной Activity в том, что при изменении состояния авторизации ReinjectingFragment
 * вызывает inject() для актуального компонента. Т.о. происходит reinject зависимостей
 */
public class ReinjectingActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        disposable = App.getInstance().subscribeOnActualComponent(this::onComponentChanged);
        createFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unsubscribeFromActualComponent(disposable);
    }

    private void createFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, ReinjectingFragment.newInstance())
                .commit();
    }

    private void onComponentChanged(AuthDependentComponent component) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments == null) {
            return;
        }
        for (Fragment fragment : fragments) {
            if (fragment instanceof OnComponentChangedListener) {
                ((OnComponentChangedListener) fragment).onComponentChanged(component);
            }
        }
    }
}