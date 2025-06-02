package com.example.application11;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity {
	Button buttonPlay, buttonStop;
	MediaPlayer mediaPlayer;
	final String URL = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);

		buttonPlay = findViewById(R.id.button_play);
		buttonStop = findViewById(R.id.button_stop);
		buttonPlay.setEnabled(false);

		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(URL);
			mediaPlayer.setOnPreparedListener(mp -> {
				buttonPlay.setEnabled(true);
				Toast.makeText(this, "Готово к воспроизведению", Toast.LENGTH_SHORT).show();
			});
			mediaPlayer.prepareAsync();
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "Ошибка загрузки", Toast.LENGTH_SHORT).show();
		}

		buttonPlay.setOnClickListener(v -> {
			if (!mediaPlayer.isPlaying()) {
				mediaPlayer.start();
			}
		});

		buttonStop.setOnClickListener(v -> {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();
				mediaPlayer.seekTo(0);
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
			}
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}
