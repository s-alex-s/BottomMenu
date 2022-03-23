package com.example.bottommenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragments.GameFragment;
import fragments.MovieFragment;
import fragments.MusicFragment;

public class MainActivity extends AppCompatActivity {
    GameFragment gameFragment;
    MovieFragment movieFragment;
    MusicFragment musicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameFragment = new GameFragment(getApplicationContext());
        movieFragment = new MovieFragment(getApplicationContext());
        musicFragment = new MusicFragment(getApplicationContext());

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, gameFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if (item.getItemId() == R.id.game_item) {
                    fragment = gameFragment;
                } else if (item.getItemId() == R.id.movie_item) {
                    fragment = movieFragment;
                } else if (item.getItemId() == R.id.music_item) {
                    fragment = musicFragment;
                }

                assert fragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();

                return true;
            }
        });
    }
}