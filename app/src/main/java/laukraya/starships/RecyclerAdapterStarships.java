package laukraya.starships;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import laukraya.starships.post.Post;

public class RecyclerAdapterStarships extends RecyclerView.Adapter<RecyclerAdapterStarships.StarshipViewHolder> {

    private Context context;
    private List<Post> posts;

    public RecyclerAdapterStarships(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapterStarships.StarshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_starship_recycler_view, parent,false);
        return new StarshipViewHolder(view);
    }

    //DATA BINDING
    @Override
    public void onBindViewHolder(RecyclerAdapterStarships.StarshipViewHolder holder, int position) {
        holder.textViewName.setText(posts.get(position).getName());
        holder.textViewModel.setText(posts.get(position).getModel());
        holder.textViewModel.setText(posts.get(position).getManufacturer());
    }
    //NECESITO DECIRLE LA CANTIDAD DE ITEMS AL RV
    @Override
    public int getItemCount() {
        if(posts != null){
            return posts.size();
        }
        return 0;

    }

    public class StarshipViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewModel;
        TextView textViewManufacturer;

        public StarshipViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            textViewManufacturer = itemView.findViewById(R.id.textViewManufacturer);
        }
    }
}
