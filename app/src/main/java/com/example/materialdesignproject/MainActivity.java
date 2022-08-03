package com.example.materialdesignproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* visit =>
        https://guides.codepath.com/android/using-the-app-toolbar#:~:text=The%20key%20differences%20that%20distinguish,defined%20within%20a%20single%20activity
        for toolbar and actionbar
         */
        //to use toolbars an action bar we have to set it as an action bar:
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbarMain));

        /*har zaman karbar scroll kard tool bar ham scroll she:

        app:layout_scrollFlags="scroll" => ezafe she be toolbar

        va item haye scroll shodani be jaye scrollView tuye NestedScrollView gharar begiran
        (ScrollView ba component haye MaterialDesign sazegari nadare)
         */

        /* baraye inke har moghee karbar scroll back kard toolbar namayesh dade beshe
        bayad in flag be tool bar ezafe she =>

        app:layout_scrollFlags="enterAlways"
         */

        /*appbar be surate pishfarz 4dp elevation ya shadow dare
        standard ine ke vaghti toolbar dar balaye safhe hastesh hich shadow i nadashte bashe
        va vaghti karbar yekam scroll kard shadow begire
        baraye in kar az attribute e liftOnScroll estefade mikonim
        va un ro be AppBarLayout ezafe mikonim =>

        app:liftOnScroll="true"
         */


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menuItem_home:
                        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentContainerView , new MainFragment());
                        transaction.commit();
                        break;
                    case R.id.menuItem_recent:
                        FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.fragmentContainerView , new RecentFragment());
                        transaction1.commit();
                        break;
                    case R.id.menuItem_nearby:
                        FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                        transaction2.replace(R.id.fragmentContainerView , new NearbyFragment());
                        transaction2.commit();

                }

                //true: means that the item should get selected
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuItem_home:
                        NestedScrollView nestedScrollView=findViewById(R.id.nestedScrollView);
                        nestedScrollView.smoothScrollTo( 0, nestedScrollView.getTop()); //there's a bug here
                }
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.menuItem_home);
        /* style=> (vaghti toolbar white e)
        style="@style/Widget.MaterialComponents.BottomNavigationView.Colored"
         */

    }
}