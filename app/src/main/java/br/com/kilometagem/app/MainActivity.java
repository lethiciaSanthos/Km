package br.com.kilometagem.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    EditText txtKm;
    Spinner meses;
    SpinnerAdapter mesAdapter;
    VerRegistrosActivity.RegistroAdapter adapter;

    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesAdapter = ArrayAdapter.createFromResource(this, R.array.meses_km, R.layout.support_simple_spinner_dropdown_item);
        meses = (Spinner) findViewById(R.id.spMeses);
        meses.setAdapter(mesAdapter);
        txtKm = (EditText) findViewById(R.id.txtKm);
    }

    public void InserirRegistro(View view) {
        String mes = meses.getSelectedItem().toString();
        Float kms = Float.parseFloat(String.valueOf(txtKm.getText().toString()));

        Registro R = new Registro(mes, kms);

        if (txtKm == null) {
            return;
        }

        R.save();
        txtKm.setText(null);

        Intent intent = new Intent(this, VerRegistrosActivity.class);
        startActivity(intent);
        finish();
    }

    //PARTE DO MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.calculo) {
            startActivity(new Intent(getApplicationContext(), VerRegistrosActivity.class));
        }


        return false;
    }
}
