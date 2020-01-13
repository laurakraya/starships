package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import laukraya.starships.swapi.Starship;

public class StarshipDetailActivity extends AppCompatActivity {

    private Starship starship;
    private TextView textViewName;
    private TextView textViewModel;
    private TextView textViewManufacturer;
    private TextView textViewCost;
    private TextView textViewSpeed;
    private TextView textViewCrew;
    private TextView textViewPassengers;
    private TextView textViewCargo;
    private TextView textViewClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_detail);

        starship = (Starship) getIntent().getSerializableExtra("starship");

        textViewName = findViewById(R.id.textViewName);
        textViewModel = findViewById(R.id.textViewModel);
        textViewManufacturer = findViewById(R.id.textViewManufacturer);
        textViewCost = findViewById(R.id.textViewCost);
        textViewSpeed = findViewById(R.id.textViewSpeed);
        textViewCrew = findViewById(R.id.textViewCrew);
        textViewPassengers = findViewById(R.id.textViewPassengers);
        textViewCargo = findViewById(R.id.textViewCargo);
        textViewClass = findViewById(R.id.textViewClass);

        textViewName.setText(starship.getName());
        textViewModel.setText(starship.getModel());
        textViewManufacturer.setText(starship.getManufacturer());
        textViewCost.setText(starship.getCost());
        textViewSpeed.setText(starship.getSpeed());
        textViewCrew.setText(starship.getCrew());
        textViewPassengers.setText(starship.getPassengers());
        textViewCargo.setText(starship.getCargo());
        textViewClass.setText(starship.getStarship_class());

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
