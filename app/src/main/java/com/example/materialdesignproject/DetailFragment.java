package com.example.materialdesignproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail , container , false);

        /* height ro bar asase width taghir mide =>
        android:adjustViewBounds="true"
        (tu imageView)
         */

        /* baraye inke collapsing toolbar layout scroll va collapse beshe bayad in ro behesh ezafe konim=>
        app:layout_scrollFlags="scroll|exitUntilCollapsed"
         */

        /* baraye moshakhas kardan raftar ImageView =>
        (animation sorate scroll shoadane imageView)
        app:layout_collapseMode="parallax"

        baraye toolbar=>
        (vaghti matn scroll shod toolbar bayad be bala pin beshe)
        app:layout_collapseMode="pin"
         */

        /* baaye dadane rang be toolbar ino be collapsingLayout ezafe mikonim =>
        app:contentScrim="@color/colorPrimary"
         */
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar((Toolbar) getView().findViewById(R.id.toolbarDetail));

        //activate backHome button
        appCompatActivity.getSupportActionBar().setHomeButtonEnabled(true);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //its a bug that the title of the toolbar doesn't show
        //we have to change the height of the toolbar to 56dp instead of wrapContent

        CollapsingToolbarLayout collapsingToolbarLayout=getView().findViewById(R.id.collapsingToolbar_detail);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getContext(),android.R.color.transparent));

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            getActivity().onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
