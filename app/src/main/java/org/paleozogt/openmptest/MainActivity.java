package org.paleozogt.openmptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();

    Foo _foo;
    Bar _bar;

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
    }
    void onFoo() {
        int foo = _foo.doFoo();
        Log.d(TAG, "foo " + foo);
    }

    void onBar() {
        int bar = _bar.doBar();
        Log.d(TAG, "bar " + bar);
    }
}
