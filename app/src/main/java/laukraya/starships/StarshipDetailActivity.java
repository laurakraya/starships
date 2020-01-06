package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StarshipDetailActivity extends AppCompatActivity {

    private TextView textViewStarshipName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_detail);

        textViewStarshipName = findViewById(R.id.textViewStarshipName);

        String name = getIntent().getStringExtra("name");
        textViewStarshipName.setText(name);
    }
}
