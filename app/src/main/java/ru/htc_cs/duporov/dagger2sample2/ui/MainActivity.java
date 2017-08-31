package ru.htc_cs.duporov.dagger2sample2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.htc_cs.duporov.dagger2sample2.App;
import ru.htc_cs.duporov.dagger2sample2.R;
import ru.htc_cs.duporov.dagger2sample2.dagger.qualifier.RecreatingActivityIntent;
import ru.htc_cs.duporov.dagger2sample2.dagger.qualifier.ReinjectingActivityIntent;

public class MainActivity extends AppCompatActivity {

    @RecreatingActivityIntent
    @Inject
    Intent recreatingActivityIntent;

    @ReinjectingActivityIntent
    @Inject
    Intent reinjectingActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().getComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.recreating)
    void onRecreatingClick() {
        startActivity(recreatingActivityIntent);
    }

    @OnClick(R.id.reinjecting)
    void onReinjectingClick() {
        startActivity(reinjectingActivityIntent);
    }
}