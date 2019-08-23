package org.paleozogt.openmptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();

    Foo _foo;
    Bar _bar;
    final static String ENV_VAR = "KMP_DUPLICATE_LIB_OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _foo = new Foo();
        _bar = new Bar();

        Button fooButton = (Button)findViewById(R.id.foo_btn);
        fooButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFoo();
            }
        });

        Button barButton = (Button)findViewById(R.id.bar_btn);
        barButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBar();
            }
        });

        final Spinner envSpinner = (Spinner)findViewById(R.id.env_spinner);

        Button envButton = (Button)findViewById(R.id.env_btn);
        envButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEnv(envSpinner.getSelectedItem().toString());
            }
        });
    }
    void onFoo() {
        int foo = _foo.doFoo();
        Log.d(TAG, "foo " + foo);
    }

    void onBar() {
        int bar = _bar.doBar();
        Log.d(TAG, "bar " + bar);
    }

    void onEnv(String val) {
        try {
            Log.d(TAG, "setting env " + ENV_VAR + " to " + val);
            Os.setenv(ENV_VAR, val, true);
        } catch (ErrnoException e) {
            throw new RuntimeException(e);
        }
    }
}
