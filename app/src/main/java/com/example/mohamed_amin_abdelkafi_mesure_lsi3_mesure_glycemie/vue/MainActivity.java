package com.example.mohamed_amin_abdelkafi_mesure_lsi3_mesure_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed_amin_abdelkafi_mesure_lsi3_mesure_glycemie.R;

public class MainActivity extends AppCompatActivity {
    private TextView tvAge,tvReponse;
    private SeekBar sbAge;
    private EditText etValeur;
    private Button btnConsulter;
    private RadioButton rbIsFasting,rbIsNotFasting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener() {


            public void onProgressChanged (SeekBar seekBar, int progress ,  boolean fromUser )
            {
                Log.i("Information", "onProgressChanged" + progress);
                tvAge.setText("Votre Age: " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }


    private void init()
    {
        rbIsFasting=findViewById(R.id.rbtOui);
        rbIsNotFasting=findViewById(R.id.rbtnon);
        etValeur=findViewById(R.id.rbtvaleur);
        btnConsulter=findViewById(R.id.btnconsulter);
        sbAge=findViewById(R.id.SbAge);
        tvAge=findViewById(R.id.ageid);

    }
    public void calculer (View view)
    {
        Log.i("Information", "button cliqué");
        int age;
        float valeurMesuree;
        boolean verifAge = false, verifValeur = false;
        if(sbAge.getProgress()!=0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",

                    Toast.LENGTH_SHORT).show();
        if(!etValeur.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();
        if(verifAge && verifValeur)
        {
            age = sbAge.getProgress();
            valeurMesuree = Float.valueOf(etValeur.getText().toString());
            boolean isFasting = rbIsFasting.isChecked();
            if (isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        tvReponse.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        tvReponse.setText("Niveau de glycémie est normale");
                    else
                        tvReponse.setText("Niveau de glycémie est trop élevé");
                }
            } else {
                if (valeurMesuree > 10.5)
                    tvReponse.setText("Niveau de glycémie est trop élevé");
                else
                    tvReponse.setText("Niveau de glycémie est normale");

            }
        }
    }

}