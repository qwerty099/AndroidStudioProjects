package com.example.myapplication1;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.databinding.ActivityMainBinding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";



    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        })

        ;
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        initTextViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void openWindow2(View v) {
        //call window2
        setContentView(R.layout.calculadora);
        initTextViews();


    }


    private void initTextViews(){

        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue){

        workings = workings + givenValue;
        workingsTV.setText(workings);
    }
    public void IgualOnClick(View view) {
        Double result = null;

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(workings);
        } catch (ScriptException e)
        {
            Toast.makeText( this,"Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if (result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));

    }

    public void LimpaOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    parentesesEsquerdo = true;
    }

    boolean parentesesEsquerdo;

    public void ParentesesOnClick(View view) {
        if (parentesesEsquerdo)
        {
            setWorkings("(");
            parentesesEsquerdo = false;
        }
        else
            {
                setWorkings(")");
                parentesesEsquerdo = true;
            }

            }

    public void ElevadoOnClick(View view) {
        setWorkings("^");
    }

    public void DivididoOnClick(View view) {
        setWorkings("/");
    }

    public void SeteOnClick(View view) {
        setWorkings("7");
    }

    public void OitoOnClick(View view) {
        setWorkings("8");
    }

    public void NoveOnClick(View view) {
        setWorkings("9");
    }

    public void VezesOnClick(View view) {
        setWorkings("*");
    }

    public void QuatroOnClick(View view) {
        setWorkings("4");
    }

    public void CincoOnClick(View view) {
        setWorkings("5");
    }

    public void SeisOnClick(View view) {
        setWorkings("6");
    }

    public void MenosOnClick(View view) {
        setWorkings("-");
    }

    public void UmOnClick(View view) {
        setWorkings("1");
    }

    public void DoisOnClick(View view) {
        setWorkings("2");
    }

    public void TresOnClick(View view) {
        setWorkings("3");
    }

    public void MaisOnClick(View view) {
        setWorkings("+");
    }

    public void PontoOnClick(View view) {
        setWorkings(".");
    }

    public void ZeroOnClick(View view) {
        setWorkings("0");
    }


}