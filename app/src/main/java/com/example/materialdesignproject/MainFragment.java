package com.example.materialdesignproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        /* MaterialCardView materialCardView=getView().findViewById(R.id.materialCardView_item);
        materialCardView.setChecked(true);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialCardView.setChecked(!materialCardView.isChecked());
            }
        }); */

        /* MaterialCardView Features:
        app:cardElevation="4dp"
    app:cardCornerRadius="10dp"
    app:contentPadding="16dp"
    android:clickable="true"
    app:rippleColor="@color/purple_200"
    android:checkable="true"
    app:checkedIconTint="@color/green_500"
    app:strokeColor="@color/purple_200"
    app:strokeWidth="1dp"
    app:cardBackgroundColor="@color/purple_50"
         */

        /*toye fragment ha be getSupportActionBar() dastresi nadarim
        bayad ye instance az AppCompatActivity dashte bashim :
         */
        AppCompatActivity appCompatActivity=(AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar((Toolbar) getView().findViewById(R.id.toolbarMain));


        MaterialCardView materialCardView=getView().findViewById(R.id.materialCardView_item);
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction= requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.fragmentContainerView , new DetailFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        FloatingActionButton floatingActionButton=getView().findViewById(R.id.fabMain);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "FAB", Toast.LENGTH_SHORT).show();
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
