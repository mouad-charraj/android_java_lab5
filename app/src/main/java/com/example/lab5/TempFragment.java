package com.example.lab5;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Ici je gere la partie pour transformer les degres
public class TempFragment extends Fragment {

    // On prepare les variables avec mon nom
    private RadioGroup rgTemp_mouad;
    private RadioButton rbCtoF_mouad, rbFtoC_mouad;
    private EditText etTempInput_mouad;
    private Button btnConvertTemp_mouad;
    private TextView tvTempResult_mouad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Je charge le dessin xml de la page
        View view_mouad = inflater.inflate(R.layout.fragment_temp, container, false);

        // Je lie chaque bouton et texte a mon code
        rgTemp_mouad = view_mouad.findViewById(R.id.rgTemp);
        rbCtoF_mouad = view_mouad.findViewById(R.id.rbCtoF);
        rbFtoC_mouad = view_mouad.findViewById(R.id.rbFtoC);
        etTempInput_mouad = view_mouad.findViewById(R.id.etTempInput);
        btnConvertTemp_mouad = view_mouad.findViewById(R.id.btnConvertTemp);
        tvTempResult_mouad = view_mouad.findViewById(R.id.tvTempResult);

        // Ce qu'il se passe quand on clique sur le bouton de calcul
        btnConvertTemp_mouad.setOnClickListener(v_mouad -> {
            String texte_mouad = etTempInput_mouad.getText().toString();
            
            // Si c'est vide j'affiche un petit message d'erreur
            if (TextUtils.isEmpty(texte_mouad)) {
                Toast.makeText(getContext(), "Oublie pas de mettre un chiffre !", Toast.LENGTH_SHORT).show();
                return;
            }

            double chiffre_mouad = Double.parseDouble(texte_mouad);
            double resultat_mouad;

            // Je regarde quelle conversion est cochee
            if (rbCtoF_mouad.isChecked()) {
                // Formule pour passer en Fahrenheit
                resultat_mouad = (1.8 * chiffre_mouad) + 32;
            } else {
                // Formule pour passer en Celsius
                resultat_mouad = (chiffre_mouad - 32) / 1.8;
            }

            // J'affiche la reponse finale ici
            tvTempResult_mouad.setText("Le resultat est : " + String.format("%.2f", resultat_mouad));
        });

        return view_mouad;
    }
}

// realise par CHARRAJ Mouad aka ZERO-XR7
