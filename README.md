# GuessTheTune
# Android Music Guessing Game

This is an Android music guessing game where users listen to a snippet of a song and guess its title. The game features multiple tunes, each associated with an audio file and an artist image. Users can play the snippets, enter their guesses, and receive feedback on whether their guess is correct.

## Features

- Shuffle functionality to randomize the order of tunes for each gameplay session.
- Playback of audio snippets using the `MediaPlayer` class.
- Input validation for user guesses and handling incorrect guesses.
- Success screen displaying the correct song name and artist image when the user guesses correctly.
- Navigation between the main game activity and the success screen.
- Ability to continue playing the game or close the app from the success screen.

## Technologies Used

- Android Studio: The project is developed using the Android Studio IDE.
- Java: The main programming language for developing the Android application.
- XML: Used for defining the layout and views of the app screens.

## Getting Started

To run the project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/your-repo.git`
2. Open the project in Android Studio.
3. Build and run the project on an Android device or emulator.

## Screenshots

![Main Screen](https://github.com/TheKingslayer11/GuessTheTune/assets/93860728/0d3b323d-e527-4a11-ab8c-072a4c0d816d)

![Success Screen](https://github.com/TheKingslayer11/GuessTheTune/assets/93860728/a6b6bb43-0fd1-42c3-ae16-feeb55be8779)


## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

NOTE: I have added only a few songs to this application but feel free to add more songs based on your preference.
Keep in mind that the songs are fetched locally so the songs you wish to add should be downloaded on your device first and then added.
And modify the code accordingly,
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

To add the new song:
{R.raw.new_song_name,R.drawable.artist_name}
NOTE: The artist name doesnt need to be the actual name of the artist as it is just a reference to the Album/Artist image 
