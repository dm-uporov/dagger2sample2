package ru.htc_cs.duporov.dagger2sample2.ui.recreating;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.disposables.Disposable;
import ru.htc_cs.duporov.dagger2sample2.App;

/**
 * Суть данной Activity в том, что при изменении состояния авторизации RecreatingFragment пересоздается
 * и обращается к акутальному компоненту
 */
public class RecreatingActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recreateFragment();
        disposable = App.getInstance().subscribeOnActualComponent(authDependentComponent -> recreateFragment());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unsubscribeFromActualComponent(disposable);
    }

    private void recreateFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, RecreatingFragment.newInstance())
                .commit();
    }
}
