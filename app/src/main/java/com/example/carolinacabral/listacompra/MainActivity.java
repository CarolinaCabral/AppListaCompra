package com.example.carolinacabral.listacompra;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText name;
    private Button addName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edtList);
        addName = (Button) findViewById(R.id.btnAdd);


        addName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,NewActivity.class);

                String txt = "";
                txt = name.getText().toString();
                Bundle bundle = new Bundle();

                bundle.putString("txt", txt);
                it.putExtras(bundle);
                startActivity(it);

            }
        });

    }
}
