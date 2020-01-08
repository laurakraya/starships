package laukraya.starships;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;

import java.util.ArrayList;

import laukraya.starships.post.Post;

public class StarshipListActivity extends AppCompatActivity implements RecyclerAdapterStarships.OnClickListener {

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

        RecyclerAdapterStarships recyclerAdapterStarships = new RecyclerAdapterStarships(this, starships, this);
        recyclerViewStarships.setAdapter(recyclerAdapterStarships);

    }

    @Override
    public void onClick(int position) {

        Intent intent = new Intent(this, StarshipDetailActivity.class);
        intent.putExtra("starship", starships.get(position));
        startActivity(intent);

    }

}
