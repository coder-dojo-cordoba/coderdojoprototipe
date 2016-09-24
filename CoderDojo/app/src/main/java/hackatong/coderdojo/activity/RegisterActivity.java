package hackatong.coderdojo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import hackatong.coderdojo.R;


public class RegisterActivity extends AppCompatActivity {

    private Spinner spTipoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spTipoUsuario = (Spinner) findViewById(R.id.sp_tipo_usuario);
        String [] tipoUsuario = {"Hijo, Padre"};
        SpinnerAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.support_simple_spinner_dropdown_item,tipoUsuario);
    }
}
