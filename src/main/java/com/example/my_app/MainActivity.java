package com.example.my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_SCALE_TWO_ID = 3;
    final int MENU_TRANSLATE_ID = 4;
    final int MENU_ROTATE_ID = 5;
    final int MENU_COMBO_ID = 6;

    TextView tv;

    private String selectedTopic = "";

    private ProfileFragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFragment = new ProfileFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.navigation_home, new ProfileFragment())
                .commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        tv = findViewById(R.id.chooseTopic);
        registerForContextMenu(tv);

        final LinearLayout history = findViewById(R.id.history);
        final LinearLayout literature = findViewById(R.id.literature);
        final LinearLayout geography = findViewById(R.id.geography);
        final LinearLayout art = findViewById(R.id.art);

        final Button startQuizBtn = findViewById(R.id.startQuizBtn);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopic = "history";
                history.setBackgroundResource(R.drawable.round_back_white_sroke10);

            }
        });

        literature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopic = "literature";
                literature.setBackgroundResource(R.drawable.round_back_white_sroke10);

            }
        });

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopic = "geography";
                geography.setBackgroundResource(R.drawable.round_back_white_sroke10);

            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopic = "art";
                art.setBackgroundResource(R.drawable.round_back_white_sroke10);

            }
        });

        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectedTopic.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Виберіть вікторину", Toast.LENGTH_SHORT).show();
                } else  {
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopic);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    int itemId = item.getItemId();

                    if (itemId == R.id.navigation_home) {
                        transaction.replace(R.id.fragment_main, selectedFragment);
                        setContentView(R.layout.fragment_home);
                        return true;
                    } else if (itemId == R.id.navigation_second) {
                        transaction.replace(R.id.fragment_container, selectedFragment);
                        setContentView(R.layout.fragment_profile);
                        return true;
                    } else if (itemId == R.id.navigation_third) {
                        transaction.replace(R.id.fragment_email, selectedFragment);
                        setContentView(R.layout.fragment_message);

                        return true;
                    }
                    return false;
                }
            };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.chooseTopic) {
            menu.add(0, MENU_ALPHA_ID, 0, "alpha");
            menu.add(0, MENU_SCALE_ID, 0, "scale");
            menu.add(0, MENU_SCALE_TWO_ID, 0, "scale-two");
            menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
            menu.add(0, MENU_ROTATE_ID, 0, "rotate");
            menu.add(0, MENU_COMBO_ID, 0, "combo");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()) {
            case MENU_ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case MENU_SCALE_TWO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscaletwo);
                break;
            case MENU_TRANSLATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }

}

