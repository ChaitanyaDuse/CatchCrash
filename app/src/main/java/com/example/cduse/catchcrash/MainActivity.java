package com.example.cduse.catchcrash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends CrashHandlingActivity {

    Button btn_divide_by_zero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn_divide_by_zero = (Button) findViewById(R.id.btn_divide_by_zero);
        btn_divide_by_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throw new ArithmeticException("Divide by zero guys!!");
            }
        });

    }
}
