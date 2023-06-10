package com.example.ux_project_axforasset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.Vector;

public class ItemSliderAdapter extends PagerAdapter {

    private Vector<Integer> listImage;
    private Context context;

    public ItemSliderAdapter(Vector<Integer> listImage, Context context){
        this.listImage = listImage;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater =
                (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View sliderLayout = layoutInflater.inflate(R.layout.item_slider, null);

        ImageView featuredImage = sliderLayout.findViewById(R.id.feature_image);
        featuredImage.setImageResource(listImage.get(position));

        container.addView(sliderLayout);

        return sliderLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
