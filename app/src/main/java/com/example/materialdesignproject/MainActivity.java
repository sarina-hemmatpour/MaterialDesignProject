package com.example.materialdesignproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

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


    }
}