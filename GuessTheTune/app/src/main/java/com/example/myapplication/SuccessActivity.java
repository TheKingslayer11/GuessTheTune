package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.commons.text.WordUtils;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    private TextView successMessageTextView;
    private TextView songNameTextView;
    private ImageView artistImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        successMessageTextView = findViewById(R.id.success_message_text_view);
        songNameTextView = findViewById(R.id.song_name_text_view);
        artistImageView = findViewById(R.id.artist_image_view);

        Intent intent = getIntent();
        String songName = intent.getStringExtra("songName");
        int artistImageResourceId = intent.getIntExtra("artistImageResourceId", 0);


        String formattedSongName = WordUtils.capitalizeFully(songName.replace("_", " "));

        String successMessage = "Woohoo! It was";

        successMessageTextView.setText(successMessage);
        songNameTextView.setText(formattedSongName);
        artistImageView.setImageResource(artistImageResourceId);

        Button continueButton = findViewById(R.id.continue_button);
        Button closeButton = findViewById(R.id.close_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the app
                finishAffinity();
            }
        });
    }


}



