package laukraya.starships;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import laukraya.starships.swapi.Starship;

public class RecyclerAdapterStarships extends RecyclerView.Adapter<RecyclerAdapterStarships.StarshipViewHolder> {

    private Context context;
    private List<Starship> starships;
    private OnClickListener onClickListener;

    public RecyclerAdapterStarships(Context context, List<Starship> starships, OnClickListener onClickListener) {
        this.context = context;
        this.starships = starships;
        this.onClickListener = onClickListener;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
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
        holder.textViewName.setText(starships.get(position).getName());
        holder.textViewModel.setText(starships.get(position).getModel());
        holder.textViewModel.setText(starships.get(position).getManufacturer());
    }
    //NECESITO DECIRLE LA CANTIDAD DE ITEMS AL RV
    @Override
    public int getItemCount() {
        if(starships != null){
            return starships.size();
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
