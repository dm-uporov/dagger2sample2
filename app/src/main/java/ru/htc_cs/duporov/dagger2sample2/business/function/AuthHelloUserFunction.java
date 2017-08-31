package ru.htc_cs.duporov.dagger2sample2.business.function;

import android.content.Context;
import android.widget.Toast;

import ru.htc_cs.duporov.dagger2sample2.R;

public class AuthHelloUserFunction implements HelloUserFunction {

    private final String socialName;
    private final String userName;

    public AuthHelloUserFunction(String userName, String socialName) {
        this.userName = userName;
        this.socialName = socialName;
    }

    @Override
    public void sayHello(Context context) {
        Toast.makeText(context,
                context.getString(R.string.hello_user, userName, socialName),
                Toast.LENGTH_SHORT).show();
    }
}
