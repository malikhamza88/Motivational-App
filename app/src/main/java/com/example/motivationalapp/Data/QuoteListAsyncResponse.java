package com.example.motivationalapp.Data;

import com.example.motivationalapp.Model.Quote;

import java.util.ArrayList;
import java.util.List;

public interface QuoteListAsyncResponse {

    void processFinished(ArrayList<Quote> quotes);

}
