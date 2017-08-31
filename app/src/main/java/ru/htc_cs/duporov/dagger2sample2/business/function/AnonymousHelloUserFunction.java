package ru.htc_cs.duporov.dagger2sample2.business.function;

import android.content.Context;
import android.widget.Toast;

import ru.htc_cs.duporov.dagger2sample2.R;

public class AnonymousHelloUserFunction implements HelloUserFunction {

    @Override
    public void sayHello(Context context) {
        Toast.makeText(context, R.string.hello_anonymous, Toast.LENGTH_SHORT).show();
    }
}
