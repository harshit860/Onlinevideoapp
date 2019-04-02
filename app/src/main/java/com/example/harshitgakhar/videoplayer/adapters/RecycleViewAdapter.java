package com.example.harshitgakhar.videoplayer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.harshitgakhar.videoplayer.model.Anime;
import com.example.harshitgakhar.videoplayer.* ;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by harshit gakhar on 02-04-2019.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{


    private Context mContext;
    private List<Anime> mData;
    RequestOptions option;

    public RecycleViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option= new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_itemm,parent,false);

        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_desc.setText(mData.get(position).getDesc());

        /////


        Glide.with(mContext).load(mData.get(position).getThumbnail()).apply(option).into(holder.tv_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        TextView tv_desc;
        ImageView tv_thumbnail;
        TextView tv_url;






        public MyViewHolder(View itemView) {
            super(itemView);


            tv_title=itemView.findViewById(R.id.title1);
            tv_desc=itemView.findViewById(R.id.desc);
            tv_thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }
}
