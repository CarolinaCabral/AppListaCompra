package com.example.carolinacabral.listacompra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NewActivity extends Activity {
    private EditText product;
    private EditText quantity;
    private Button save;
    //private ListView listProduct;
    private GridView listProduct;

    private RadioButton opcionYes;
    private RadioButton opcionNo;
    private RadioGroup opcions;
    private RadioGroup opcionsCategory;
    private RadioButton opSup;
    private RadioButton opPharmacy;
    private RadioButton opBakery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intentt = getIntent();
        Bundle bundle = intentt.getExtras();

        String txt = bundle.getString("txt");
        TextView result = (TextView) findViewById(R.id.txtResult);
        result.setText(txt);

        product = (EditText) findViewById(R.id.edtProduct);
        quantity = (EditText) findViewById(R.id.edtQuantity);
        save = (Button) findViewById(R.id.btnSave);
        listProduct = (GridView) findViewById(R.id.gridId);
        opcions= (RadioGroup) findViewById(R.id.rgOpcions);
        opcionYes = (RadioButton) findViewById(R.id.rbOpYes);
        opcionNo = (RadioButton) findViewById(R.id.rbOpNo);
        opcionsCategory = (RadioGroup) findViewById(R.id.rgCategory);
        opSup = (RadioButton) findViewById(R.id.rbSupermarket);
        opPharmacy = (RadioButton) findViewById(R.id.rbpharmacy);
        opBakery = (RadioButton) findViewById(R.id.rbBakery);
        ArrayList<String> list = new ArrayList<String>();
        final ArrayAdapter <String>adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1);
        listProduct.setAdapter(adapter);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _product = product.getText().toString();
                String _quantity = quantity.getText().toString();
                String _radioButton = opcionYes.getText().toString();
                String _radioButtonNo = opcionNo.getText().toString();
                String _radioButtonSup = opSup.getText().toString();
                String _radioButtonPha = opPharmacy.getText().toString();
                String _radioButtoBa = opBakery.getText().toString();
                adapter.add(_product);
                adapter.add(_quantity);
                if(opcionYes.isChecked())
                {
                    adapter.add(_radioButton);
                }
                else
                {
                    adapter.add(_radioButtonNo);
                }
                if(opSup.isChecked())
                {
                    adapter.add(_radioButtonSup);
                }
                else if(opPharmacy.isChecked())
                {
                    adapter.add(_radioButtonPha);
                }
                else
                {
                    adapter.add(_radioButtoBa);
                }

                 _product = "";
                 _quantity = "";
            }
        });





    }


}
