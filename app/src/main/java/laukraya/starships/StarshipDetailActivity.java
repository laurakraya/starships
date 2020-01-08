package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import laukraya.starships.post.Post;

public class StarshipDetailActivity extends AppCompatActivity {

    private TextView textViewStarshipName;
    private Post starship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_detail);

        starship = (Post) getIntent().getSerializableExtra("starship");

        textViewStarshipName = findViewById(R.id.textViewStarshipName);

        textViewStarshipName.setText(starship.getName());
    }
}
