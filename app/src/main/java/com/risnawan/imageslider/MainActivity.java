package com.risnawan.imageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.risnawan.imagevideoslider.events.OnPosterClickListener;
import com.risnawan.imagevideoslider.posters.DrawableImage;
import com.risnawan.imagevideoslider.posters.Poster;
import com.risnawan.imagevideoslider.posters.RawVideo;
import com.risnawan.imagevideoslider.views.PosterSlider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PosterSlider posterSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posterSlider = findViewById(R.id.poster_slider);
        List<Poster> posters = new ArrayList<>();
        posters.add(new DrawableImage(R.drawable.advert));
        posters.add(new RawVideo(R.raw.videodummy));
        posterSlider.setPosters(posters);
        posterSlider.setLoopSlides(true);
        posterSlider.setOnPosterClickListener(new OnPosterClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
