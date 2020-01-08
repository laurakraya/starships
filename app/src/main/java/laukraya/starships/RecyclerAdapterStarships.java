package laukraya.starships;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import laukraya.starships.post.Post;

public class RecyclerAdapterStarships extends RecyclerView.Adapter<RecyclerAdapterStarships.StarshipViewHolder> {

    private Context context;
    private List<Post> posts;
    private OnClickListener onClickListener;

    public RecyclerAdapterStarships(Context context, List<Post> posts, OnClickListener onClickListener) {
        this.context = context;
        this.posts = posts;
        this.onClickListener = onClickListener;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapterStarships.StarshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_starship_recycler_view, parent,false);
        return new StarshipViewHolder(view, onClickListener);
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

    public class StarshipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewModel;
        TextView textViewManufacturer;

        OnClickListener onClickListener;


        public StarshipViewHolder(View itemView, OnClickListener onClickListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewModel = itemView.findViewById(R.id.textViewModel);
            textViewManufacturer = itemView.findViewById(R.id.textViewManufacturer);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onClick(int position);
    }

}
