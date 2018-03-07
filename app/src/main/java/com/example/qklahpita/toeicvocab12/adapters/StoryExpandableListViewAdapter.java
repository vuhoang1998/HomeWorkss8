package com.example.qklahpita.toeicvocab12.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qklahpita.toeicvocab12.R;
import com.example.qklahpita.toeicvocab12.databases.models.CategoryModel;
import com.example.qklahpita.toeicvocab12.databases.models.TopicModel;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hoang on 3/8/2018.
 */

public class StoryExpandableListViewAdapter extends BaseAdapter {
    List<CategoryModel> categoryModelList;
    HashMap<String, List<TopicModel>> topicModelHashMap;

    public StoryExpandableListViewAdapter(List<CategoryModel> categoryModelList, HashMap<String, List<TopicModel>> topicModelHashMap) {
        this.categoryModelList = categoryModelList;
        this.topicModelHashMap = topicModelHashMap;
    }
    Context context;

    @Override
    public int getCount() {
        return categoryModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater.inflate(R.layout.item_list_category,parent,false);

        CategoryModel  categoryModel = (CategoryModel) getItem(position);
        TextView tvtitle = view.findViewById(R.id.tv_title);
        TextView tvauthor = view.findViewById(R.id.tv_author);
        ImageView ivimage = view.findViewById(R.id.iv_image);
        CardView cvCategory = view.findViewById(R.id.cv_category);
        cvCategory.setCardBackgroundColor(Color.parseColor("#FFFF0000"));


        Picasso.with(context).load(categoryModelList.get(position).imageURL).into(ivimage);

        tvtitle.setText(categoryModel.title);
        tvauthor.setText(categoryModel.author);
        return view;
    }
}
