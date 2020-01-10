package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import laukraya.starships.swapi.Starship;

public class StarshipListActivity extends AppCompatActivity implements RecyclerAdapterStarships.OnClickListener {

    private RecyclerView recyclerViewStarships;
    private ArrayList<Starship> starships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_list);

        Toolbar toolbar = findViewById(R.id.toolbarStarships);

        toolbar.setTitle("Starships List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        starships = (ArrayList<Starship>) getIntent().getSerializableExtra("starships");

        recyclerViewStarships = findViewById(R.id.recyclerViewStarships);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStarships.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        dividerItemDecoration.setDrawable(this.getResources().getDrawable(R.drawable.rv_line_divider));
        recyclerViewStarships.addItemDecoration(dividerItemDecoration);

        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);

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

    @Override
    public void onClick(int position) {

        Intent intentToStarshipDetailActivity = new Intent(this, StarshipDetailActivity.class);
        intentToStarshipDetailActivity .putExtra("starship", starships.get(position));
        startActivity(intentToStarshipDetailActivity );

    }

}
