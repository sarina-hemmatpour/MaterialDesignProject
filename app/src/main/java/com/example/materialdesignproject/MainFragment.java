package com.example.materialdesignproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;

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

        super.onViewCreated(view, savedInstanceState);
    }
}
