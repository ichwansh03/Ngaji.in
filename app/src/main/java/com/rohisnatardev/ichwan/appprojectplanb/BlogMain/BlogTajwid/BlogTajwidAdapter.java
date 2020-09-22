package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class BlogTajwidAdapter extends RecyclerView.Adapter<BlogTajwidAdapter.TajwidHolder> {

    private ArrayList<BlogTajwidItem> mItems = new ArrayList<>();

    public void BlogTajwidAdapter(ArrayList<BlogTajwidItem> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogTajwidAdapter.TajwidHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_blog_item,parent,false);

        return new TajwidHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogTajwidAdapter.TajwidHolder holder, int position) {
        holder.binds(mItems.get(position));

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class TajwidHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTajwid;
        ImageView imageTajwid;

        public TajwidHolder(@NonNull View itemView) {
            super(itemView);

            titleTajwid = itemView.findViewById(R.id.tlBlog);
            imageTajwid = itemView.findViewById(R.id.imageblog);

            itemView.setOnClickListener(this);
        }

        void binds(BlogTajwidItem tajwidItem){
            titleTajwid.setText(tajwidItem.getTlptTajwid());
            Document document = Jsoup.parse(tajwidItem.getDsptTajwid());
            Elements elements = document.select("img");
            Glide.with(itemView.getContext()).load(elements.get(0).attr("src")).into(imageTajwid);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            BlogTajwidItem blogTajwidItem = mItems.get(position);

            blogTajwidItem.setTlptTajwid(blogTajwidItem.getTlptTajwid());

            Intent intents = new Intent(itemView.getContext(),BlogTajwidDetailActivity.class);
            intents.putExtra(BlogTajwidDetailActivity.EXTRA_TAJWID,blogTajwidItem);
            itemView.getContext().startActivity(intents);
        }
    }
}
