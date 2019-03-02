package gasolinaoualcool.androidapp.anselmo.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool= (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina= (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar= (Button) findViewById(R.id.botaoVerificarId);
        textoResultado= (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Valores digitados nos campos serão ultilizados

                String textoPrecoAlcool= precoAlcool.getText().toString();
                String textoPrecoGasolina= precoGasolina.getText().toString();

                //Converter valores Strings em valores decimais ou numericos

                Double valorAlcool=Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina=Double.parseDouble(textoPrecoGasolina);

                // alcool/gasolina=qual compensa mais
                double resultado=valorAlcool/valorGasolina;

                if(textoPrecoAlcool.isEmpty()  textoPrecoGasolina.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Sem valores para comparação",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (resultado >= 0.7) {
                        //Gasolina
                        textoResultado.setText("È melhor ultilizar gasolina");

                    } else {
                        //Alcool
                        textoResultado.setText("È melhor ultilizar alcool");
                    }
                }

            }
        });
    }
}
