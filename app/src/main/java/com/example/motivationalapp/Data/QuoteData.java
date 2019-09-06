package com.example.motivationalapp.Data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.motivationalapp.Controller.AppController;
import com.example.motivationalapp.Model.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {

    ArrayList<Quote> mQuoteArrayList = new ArrayList<>();

    public void getQuotes(final QuoteListAsyncResponse callBack) {

        String url = "https://raw.githubusercontent.com/fortrabbit/quotes/master/quotes.json";

        String str;
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject quoteObject=response.getJSONObject(i);
                        Quote quote=new Quote();
                        quote.setQuote(quoteObject.getString("text"));
                        quote.setAuthor(quoteObject.getString("author"));

                        Log.d("Stufff", quoteObject.getString("text"));

                        mQuoteArrayList.add(quote);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                if (callBack != null) {
                    callBack.processFinished(mQuoteArrayList);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

}
