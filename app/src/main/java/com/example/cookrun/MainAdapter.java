package com.example.cookrun;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    private LayoutInflater inflater;
    private String[] mNames;
    private String[] mDesc;

    public MainAdapter(Context context, String[] mNames, String[] mDesc) {
        this.inflater = LayoutInflater.from(context);
        this.mNames = mNames;
        this.mDesc = mDesc;
    }

    @NonNull
    @Override
    public MainAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        String title = mNames[position];
        String desc = mDesc[position];
        holder.recipeName.setText(title);


    }

    @Override
    public int getItemCount() {
        return mNames.length;
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView recipeName;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),RecipeActivity.class);
                    i.putExtra("name",mNames[getAdapterPosition()]);
                    i.putExtra("desc",mDesc[getAdapterPosition()]);
                    v.getContext().startActivity(i);

                }
            });

            recipeName = itemView.findViewById(R.id.customName);

        }
    }
}
