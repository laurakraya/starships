package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import laukraya.starships.swapi.Starship;

public class StarshipListActivity extends AppCompatActivity implements RecyclerAdapterStarships.OnClickListener {

    private RecyclerView recyclerViewStarships;
    private ArrayList<Starship> starships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_list);

        starships = (ArrayList<Starship>) getIntent().getSerializableExtra("starships");

        recyclerViewStarships = findViewById(R.id.recyclerViewStarships);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStarships.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewStarships.addItemDecoration(dividerItemDecoration);

        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);

    }

    @Override
    public void onClick(int position) {

        Intent intentToStarshipDetailActivity = new Intent(this, StarshipDetailActivity.class);
        intentToStarshipDetailActivity .putExtra("starship", starships.get(position));
        startActivity(intentToStarshipDetailActivity );

    }

}
