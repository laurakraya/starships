package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import laukraya.starships.swapi.Starship;

public class StarshipDetailActivity extends AppCompatActivity {

    private TextView textViewStarshipName;
    private Starship starship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_detail);

        starship = (Starship) getIntent().getSerializableExtra("starship");

        textViewStarshipName = findViewById(R.id.textViewStarshipName);

        textViewStarshipName.setText(starship.getName());

        Toolbar toolbar = findViewById(R.id.toolbarStarshipDetail);

        toolbar.setTitle("Starships List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
