package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin;

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

public class BlogTahsinAdapter extends RecyclerView.Adapter<BlogTahsinAdapter.TahsinHolder> {

    private ArrayList<BlogTahsinItem> lists = new ArrayList<>();

    public void BlogTahsinAdapter(ArrayList<BlogTahsinItem> list) {
        lists.clear();
        lists.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogTahsinAdapter.TahsinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_blog_item,parent,false);

        return new TahsinHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogTahsinAdapter.TahsinHolder holder, int position) {
        holder.binds(lists.get(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class TahsinHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView imageView;

        public TahsinHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tlBlog);
            imageView = itemView.findViewById(R.id.imageblog);

            itemView.setOnClickListener(this);
        }

        void binds(BlogTahsinItem tahsinItem){
            title.setText(tahsinItem.getTlbTahsin());
            Document document = Jsoup.parse(tahsinItem.getCtbTahsin());
            Elements elements = document.select("img");
            Glide.with(itemView.getContext()).load(elements.get(0).attr("src")).into(imageView);
        }


        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            BlogTahsinItem item = lists.get(pos);

            item.setTlbTahsin(item.getTlbTahsin());

            Intent tahsin = new Intent(itemView.getContext(),BlogTahsinDetailActivity.class);
            tahsin.putExtra(BlogTahsinDetailActivity.EXTRA_TAHSIN,item);
            itemView.getContext().startActivity(tahsin);
        }
    }
}
