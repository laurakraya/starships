package laukraya.starships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import laukraya.starships.post.Post;

public class StarshipListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewStarships;
    private ArrayList<Post> starships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship_list);

        starships = (ArrayList<Post>) getIntent().getSerializableExtra("posts");

        recyclerViewStarships = findViewById(R.id.recyclerViewStarships);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewStarships.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerViewStarships.addItemDecoration(dividerItemDecoration);

        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);
    }
}
