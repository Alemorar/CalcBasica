package com.example.nahuel.calcbasica;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View boton = findViewById(R.id.btnCalcularSuma);
        boton.setOnClickListener(this);

        View boton2 = findViewById(R.id.btnCalcularResta);
        boton2.setOnClickListener(this);

        View boton3 = findViewById(R.id.btnCalcularProducto);
        boton3.setOnClickListener(this);

        View boton4 = findViewById(R.id.btnCalcularCociente);
        boton4.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        TextView temp;
        TextView resultado = (TextView) findViewById(R.id.textoResultado);
        temp = (TextView) findViewById(R.id.editText1);
        try {
            float a = Float.parseFloat(temp.getText().toString());
            temp = (TextView) findViewById(R.id.editText2);
            float b = Float.parseFloat(temp.getText().toString());

            switch (v.getId()){
                case R.id.btnCalcularSuma:
                    resultado.setText("resultado suma : " + (a + b));
                    break;
                case R.id.btnCalcularResta:
                    resultado.setText("resultado resta : " + (a - b));
                    break;
                case R.id.btnCalcularProducto:
                    resultado.setText("resultado producto : " + (a * b));
                    break;
                case R.id.btnCalcularCociente:
                    try {
                        resultado.setText("resultado cociente : " + (float)(a / b));
                    } catch (ArithmeticException ex){
                        resultado.setText("El divisor debe ser mayor a 0");
                    }
                    break;
            }
        } catch (NumberFormatException nfe) {
            resultado.setText("Se deben introducir solo numeros");
        }
    }
}
