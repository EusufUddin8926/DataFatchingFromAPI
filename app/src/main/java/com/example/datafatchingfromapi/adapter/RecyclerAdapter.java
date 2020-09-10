package com.example.datafatchingfromapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datafatchingfromapi.R;
import com.example.datafatchingfromapi.model.ItemClass;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    LayoutInflater inflater;
    private Context mContext;
    List<ItemClass> itemClassArrayList;



    public RecyclerAdapter(Context mcontext, List<ItemClass> itemClassArrayList) {
        this.mContext = mcontext;
        this.inflater = LayoutInflater.from(mcontext);
        this.itemClassArrayList = itemClassArrayList;

    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_layout,parent,false);
        return new RecyclerviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {


        holder.mId.setText("ID:"+Integer.toString(itemClassArrayList.get(position).getId()));
        holder.malbum.setText("AlbumID: "+Integer.toString(itemClassArrayList.get(position).getAlbumID()));
        holder.mtittle.setText(itemClassArrayList.get(position).getMtittle());
       // Picasso.with(mContext).load(itemClassArrayList.get(position).getFirstimgURL()).into(holder.mFimageView);
       // Picasso.with(mContext).load(itemClassArrayList.get(position).getSecoundimgURL()).into(holder.mSimageView);

        Picasso.get().load(itemClassArrayList.get(position).getFirstimgURL()).into(holder.mFimageView);
        Picasso.get().load(itemClassArrayList.get(position).getSecoundimgURL()).into(holder.mSimageView);

    }

    @Override
    public int getItemCount() {
        return itemClassArrayList.size();
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder{

        private TextView mId;
        private TextView malbum;
        private ImageView mFimageView;
        private ImageView mSimageView;
        private TextView mtittle;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.ID);
            malbum = itemView.findViewById(R.id.albumID);
            mFimageView = itemView.findViewById(R.id.Firstimg_view);
            mSimageView = itemView.findViewById(R.id.Secoundimg_view);
            mtittle = itemView.findViewById(R.id.mTittle);
        }
    }
}
