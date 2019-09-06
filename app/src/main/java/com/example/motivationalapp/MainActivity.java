package com.example.motivationalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;

import com.example.motivationalapp.Data.QuoteData;
import com.example.motivationalapp.Data.QuoteListAsyncResponse;
import com.example.motivationalapp.Data.QuoteViewPagerAdapter;
import com.example.motivationalapp.Model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private QuoteViewPagerAdapter mAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter=new QuoteViewPagerAdapter(getSupportFragmentManager(),getFragments());
        mViewPager=findViewById(R.id.viewPager);
        mViewPager.setAdapter(mAdapter);


    }

    private List<Fragment> getFragments(){

        final List<Fragment> fragmentList=new ArrayList<>();

       new QuoteData().getQuotes(new QuoteListAsyncResponse() {
           @Override
           public void processFinished(ArrayList<Quote> quotes) {
               for (int i = 0; i < quotes.size(); i++) {

                   QuoteFragment quoteFragment=QuoteFragment.newInstance(quotes.get(i).getQuote(),
                           quotes.get(i).getAuthor());

                   fragmentList.add(quoteFragment);

               }
               mAdapter.notifyDataSetChanged();
           }
       });

        return fragmentList;
    }

}
