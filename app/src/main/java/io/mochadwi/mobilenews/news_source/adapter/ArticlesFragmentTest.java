package io.mochadwi.mobilenews.news_source.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import io.mochadwi.mobilenews.articles.ArticlesActivity;

/**
 * Created by mochadwi on 3/14/18.
 */

public class ArticlesFragmentTest extends AppCompatActivity {

//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    public static ArticlesFragmentTest newInstance(String param1, String param2) {
//        ArticlesFragmentTest fragment = new ArticlesFragmentTest();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, ArticlesActivity.class);
        i.putExtra("sources", new Gson().toJson(this));
        startActivity(i);
    }
}
