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

// Ma page pour convertir les distances (Km et Miles)
public class DistanceFragment extends Fragment {

    // Mes variables avec _mouad
    private RadioGroup rgDist_mouad;
    private RadioButton rbKmToMiles_mouad, rbMilesToKm_mouad;
    private EditText etDistInput_mouad;
    private Button btnConvertDist_mouad;
    private TextView tvDistResult_mouad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        // Je recupere le design de la page
        View vue_mouad = inflater.inflate(R.layout.fragment_distance, container, false);

        // Je branche les elements du XML vers le code
        rgDist_mouad = vue_mouad.findViewById(R.id.rgDist);
        rbKmToMiles_mouad = vue_mouad.findViewById(R.id.rbKmToMiles);
        rbMilesToKm_mouad = vue_mouad.findViewById(R.id.rbMilesToKm);
        etDistInput_mouad = vue_mouad.findViewById(R.id.etDistInput);
        btnConvertDist_mouad = vue_mouad.findViewById(R.id.btnConvertDist);
        tvDistResult_mouad = vue_mouad.findViewById(R.id.tvDistResult);

        // Quand on clique sur le bouton de calcul
        btnConvertDist_mouad.setOnClickListener(v_mouad -> {
            String texte_mouad = etDistInput_mouad.getText().toString();
            
            // On verifie si la case n'est pas vide
            if (TextUtils.isEmpty(texte_mouad)) {
                Toast.makeText(getContext(), "Tape un nombre d'abord !", Toast.LENGTH_SHORT).show();
                return;
            }

            double valeur_mouad = Double.parseDouble(texte_mouad);
            double resultat_mouad;

            // On fait le calcul selon le choix de l'utilisateur
            if (rbKmToMiles_mouad.isChecked()) {
                // Km vers Miles
                resultat_mouad = valeur_mouad * 0.6214;
            } else {
                // Miles vers Km
                resultat_mouad = valeur_mouad / 0.6214;
            }

            // On affiche le resultat proprement
            tvDistResult_mouad.setText("Resultat : " + String.format("%.2f", resultat_mouad));
        });

        return vue_mouad;
    }
}

// realise par CHARRAJ Mouad aka ZERO-XR7
