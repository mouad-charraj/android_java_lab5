package com.example.lab5;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;

// C'est l'ecran principal de mon appli
public class MainActivity extends AppCompatActivity {

    // On declare nos trucs pour l'affichage
    private TabLayout tabLayout_mouad;
    private ViewPager2 viewPager_mouad;
    private ViewPagerAdapter adapter_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Pour que l'appli prenne tout l'ecran
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Petit reglage pour pas que les barres du tel cachent mon menu
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (maVue_mouad, sesBords_mouad) -> {
            Insets barres_mouad = sesBords_mouad.getInsets(WindowInsetsCompat.Type.systemBars());
            maVue_mouad.setPadding(barres_mouad.left, barres_mouad.top, barres_mouad.right, barres_mouad.bottom);
            return sesBords_mouad;
        });

        // Je recupere mes composants du design
        tabLayout_mouad = findViewById(R.id.tabLayout);
        viewPager_mouad = findViewById(R.id.viewPager);

        // On met l'adaptateur pour faire marcher les pages
        adapter_mouad = new ViewPagerAdapter(this);
        viewPager_mouad.setAdapter(adapter_mouad);

        // On donne un nom a chaque onglet
        new TabLayoutMediator(tabLayout_mouad, viewPager_mouad,
                (onglet_mouad, position_mouad) -> {
                    if (position_mouad == 0) {
                        onglet_mouad.setText("Température");
                    } else {
                        onglet_mouad.setText("Distance");
                    }
                }
        ).attach();

        // Le code pour le bouton retour (ca corrige le bug)
        OnBackPressedCallback retour_mouad = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Ma petite fenetre de confirmation
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Quitter ?")
                        .setMessage("Est-ce que tu veux vraiment sortir de l'app ?")
                        .setPositiveButton("Oui", (dialog_mouad, btn_mouad) -> finish())
                        .setNegativeButton("Non", null)
                        .show();
            }
        };
        // On active mon systeme de retour
        getOnBackPressedDispatcher().addCallback(this, retour_mouad);
    }
}

// realise par CHARRAJ Mouad aka ZERO-XR7
