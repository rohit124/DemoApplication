package com.sws.demoapplication;


import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.MyViewHolder> {


    Activity activity;

    public MyPostAdapter(Activity activity, Object o) {
        this.activity = activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_post_item, viewGroup, false);

        return new MyViewHolder(v);
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position) {


    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView itemName;
        public TextView time;
        public TextView description;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            productImage = (ImageView) view.findViewById(R.id.feedPostNetworkImageView);
            itemName = (TextView) view.findViewById(R.id.item_name);
            time = (TextView) view.findViewById(R.id.time);
            description = (TextView) view.findViewById(R.id.description);

            cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}
