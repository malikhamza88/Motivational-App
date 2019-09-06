package com.example.motivationalapp;


import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.concurrent.ThreadLocalRandom;


public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View quoteView=inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteTextView=quoteView.findViewById(R.id.quoteText);
        TextView authorTextView=quoteView.findViewById(R.id.byAuthor);
        CardView cardView=quoteView.findViewById(R.id.cardView);

        String quote=getArguments().getString("quote");
        String author=getArguments().getString("author");

        int colors[]=new int[]{
                R.color.md_red_A400,R.color.md_pink_400,
                R.color.md_pink_900,R.color.md_pink_A200,
                R.color.md_purple_500,R.color.md_purple_900,
                R.color.md_purple_A400,R.color.md_purple_A700,
                R.color.md_deep_purple_700,R.color.md_indigo_700,
                R.color.md_indigo_A700,R.color.md_blue_800,
                R.color.md_cyan_900,R.color.md_teal_700,
                R.color.md_green_900,R.color.md_lime_A700,
                R.color.md_yellow_900,R.color.md_amber_800,
                R.color.md_deep_orange_700,R.color.md_deep_orange_A400,
                R.color.md_brown_800,R.color.md_brown_900,
                R.color.md_grey_900,R.color.md_blue_grey_900
        };


        quoteTextView.setText(quote);
        authorTextView.setText("-"+author);
        cardView.setBackgroundResource(getRandomColor(colors));


        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote,String author){

        QuoteFragment fragment=new QuoteFragment();
        Bundle bundle=new Bundle();
        bundle.putString("quote",quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle);
        return fragment;


    }

    private int getRandomColor(int[] colorArray){

        int color;

        int lenght=colorArray.length;
        int randomNumber= ThreadLocalRandom.current().nextInt(lenght);

        color=colorArray[randomNumber];

        return color;
    }

}
