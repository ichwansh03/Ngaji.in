package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran;

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

public class BlogQuranAdapter extends RecyclerView.Adapter<BlogQuranAdapter.QuranHolder> {

    private ArrayList<BlogQuranItem> quranItems = new ArrayList<>();

    public void BlogQuranAdapter(ArrayList<BlogQuranItem> arrayList) {
        quranItems.clear();
        quranItems.addAll(arrayList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BlogQuranAdapter.QuranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_blog_item,parent,false);

        return new QuranHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogQuranAdapter.QuranHolder holder, int position) {
        holder.bind(quranItems.get(position));
    }

    @Override
    public int getItemCount() {
        return quranItems.size();
    }

    public class QuranHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titles;
        ImageView imageView;

        public QuranHolder(@NonNull View itemView) {
            super(itemView);

            titles = itemView.findViewById(R.id.tlBlog);
            imageView = itemView.findViewById(R.id.imageblog);

            itemView.setOnClickListener(this);
        }

        void bind(BlogQuranItem item){
            titles.setText(item.getTlquran());
            Document document = Jsoup.parse(item.getCnquran());
            Elements elements = document.select("img");
            Glide.with(itemView.getContext()).load(elements.get(0).attr("src")).into(imageView);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            BlogQuranItem blogQuranItem = quranItems.get(position);
            blogQuranItem.setTlquran(blogQuranItem.getTlquran());

            Intent quran = new Intent(itemView.getContext(),BlogQuranDetailActivity.class);
            quran.putExtra(BlogQuranDetailActivity.EXTRA_QURAN,blogQuranItem);
            itemView.getContext().startActivity(quran);
        }
    }
}
