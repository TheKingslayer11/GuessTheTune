package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button guessButton;
    private Button giveUpButton;
    private EditText guessEditText;
    private int incorrectGuesses = 0;

    //{R.raw., R.drawable.}
    private Integer[][] tunes = {
            {R.raw.one_last_time, R.drawable.ariana},
            {R.raw.only_girl, R.drawable.ri},
            {R.raw.the_monster, R.drawable.eminem},
            {R.raw.afterlife, R.drawable.avenged},
            {R.raw.cry_me_a_river, R.drawable.justin},
            {R.raw.disturbia, R.drawable.rih},
            {R.raw.starboy, R.drawable.weeknd},
            {R.raw.stronger, R.drawable.kanye},
            {R.raw.easier, R.drawable.sos}
    };

    private int currentTuneIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.playButton);
        guessButton = findViewById(R.id.guessButton);
        guessEditText = findViewById(R.id.guessEditText);
        giveUpButton = findViewById(R.id.giveUpButton);

        // Shuffle the tunes array
        List<Integer[]> tunesList = Arrays.asList(tunes);
        Collections.shuffle(tunesList);
        tunes = tunesList.toArray(new Integer[0][0]);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playTune();
            }
        });

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        giveUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTuneIndex++;
                playTune();
            }
        });
    }

    private void playTune() {
        if (currentTuneIndex < tunes.length) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }

            int tuneResourceId = tunes[currentTuneIndex][0];
            mediaPlayer = MediaPlayer.create(this, tuneResourceId);
            mediaPlayer.start();
        }
    }

    private void checkGuess() {
        String userGuess = guessEditText.getText().toString().replace(" ", "_");
        if (!userGuess.isEmpty()) {
            Integer[] currentTuneResources = tunes[currentTuneIndex];
            int currentTuneResourceId = currentTuneResources[0];
            String currentTuneName = getResources().getResourceEntryName(currentTuneResourceId).replace(".mp3", "");
            if (userGuess.equalsIgnoreCase(currentTuneName)) {
                int artistImageResourceId = currentTuneResources[1];
                mediaPlayer.stop();
                currentTuneIndex++;
                showSuccessScreen(currentTuneName, artistImageResourceId);
            } else {
                Toast.makeText(this, "Incorrect, try again.", Toast.LENGTH_SHORT).show();
                handleIncorrectGuess();
            }
        } else {
            Toast.makeText(this, "Please enter a guess.", Toast.LENGTH_SHORT).show();
        }
    }


    private void showSuccessScreen(String songName, int artistImageResourceId) {
        Intent intent = new Intent(this, SuccessActivity.class);
        intent.putExtra("songName", songName);
        intent.putExtra("artistImageResourceId", artistImageResourceId);
        startActivity(intent);
    }





    private void handleIncorrectGuess() {

        if (incorrectGuesses < 2) {
            incorrectGuesses++;
        } else {
            showFailureScreen();
        }
    }



    private void showFailureScreen() {

        Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT).show();
    }




}

