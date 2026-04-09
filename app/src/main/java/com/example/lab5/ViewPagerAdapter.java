package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// Cet adaptateur sert à faire le lien entre les pages et le ViewPager
public class ViewPagerAdapter extends FragmentStateAdapter {

    // Constructeur de l'adaptateur
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity_mouad) {
        super(fragmentActivity_mouad);
    }

    // Cette fonction crée le fragment correspondant à chaque onglet
    @NonNull
    @Override
    public Fragment createFragment(int position_mouad) {
        // On retourne le bon fragment selon l'index
        if (position_mouad == 0) {
            return new TempFragment(); // Page de température
        } else {
            return new DistanceFragment(); // Page de distance
        }
    }

    // On indique qu'il y a 2 onglets au total
    @Override
    public int getItemCount() {
        return 2;
    }
}

// realise par CHARRAJ Mouad aka ZERO-XR7
