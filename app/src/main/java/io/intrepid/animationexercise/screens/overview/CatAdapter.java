package io.intrepid.animationexercise.screens.overview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.intrepid.animationexercise.R;
import io.intrepid.animationexercise.models.Cat;


class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<Cat> cats;
    private CatClickListener catClickListener;

    CatAdapter(List<Cat> cats, CatClickListener catClickListener) {
        this.cats = cats;
        this.catClickListener = catClickListener;
    }

    @Override
    public CatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatViewHolder(LayoutInflater.from(parent.getContext())
                                         .inflate(R.layout.cat_item, null), catClickListener);
    }

    @Override
    public void onBindViewHolder(CatViewHolder holder, int position) {
        Cat cat = cats.get(position);
        holder.setImage(cat.getUrl());
        holder.setCat(cat);
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cat_image)
        ImageView catImage;

        private Cat cat;
        private CatClickListener catClickListener;

        CatViewHolder(View itemView, CatClickListener catClickListener) {
            super(itemView);
            this.catClickListener = catClickListener;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cat_image)
        void onImageClick() {
            catClickListener.onCatClicked(cat);
        }

        void setImage(String imageUrl) {
            Picasso.with(itemView.getContext())
                    .load(imageUrl)
                    .noPlaceholder()
                    .into(catImage);
        }

        void setCat(Cat cat) {
            this.cat = cat;
        }
    }

    interface CatClickListener {
        void onCatClicked(Cat cat);
    }
}
