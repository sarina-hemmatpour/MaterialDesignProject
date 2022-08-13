package com.example.materialdesignproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

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
        Toolbar toolbar=(Toolbar) getView().findViewById(R.id.toolbarMain);

        AppCompatActivity appCompatActivity=(AppCompatActivity)getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        //baraye drawer toggle e navigation view :
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        DrawerLayout drawerLayoutMain=getView().findViewById(R.id.drawerLayout_main);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(
                getActivity(),drawerLayoutMain , toolbar,
                R.string.openDrawer , R.string.closeDrawer
        );
        drawerLayoutMain.addDrawerListener(actionBarDrawerToggle);

        NavigationView navigationView=getView().findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //inja ham mishe switch gozasht o ....
                return true;
            }
        });
        //baraye dastresi be header
        /* baraye navigtion view mishe tu code chandin header add kard
        (na tu xml)
        inja ham index headeri ke mikhaym ro behesh midim
         */
        View headerView=navigationView.getHeaderView(0);
        TextView textView=headerView.findViewById(R.id.textView);
        textView.setText(R.string.app_name);




        // ////////////////////////////////////////////////////////////////////////////////////////


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
//                Toast.makeText(view.getContext(), "FAB", Toast.LENGTH_SHORT).show();
                //snackBar: (Use it with CoordinatorLayout)
                Snackbar snackbar=Snackbar.make(getView(),"Material Design SnackBar" , BaseTransientBottomBar.LENGTH_INDEFINITE);
                snackbar.setAction("dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
