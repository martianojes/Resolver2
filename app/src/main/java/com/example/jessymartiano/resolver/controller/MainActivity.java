package com.example.jessymartiano.resolver.controller;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.app.ListActivity;

import com.example.jessymartiano.resolver.R;
import com.example.jessymartiano.resolver.CustomListViewAdapter;
import com.example.jessymartiano.resolver.backend.AcademyContract;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SimpleCursorAdapter adapter = new SimpleCursorAdapter
                (
                        this,
                        R.layout.list_row,
                        null,
                        new String[]{AcademyContract.Activity.ACTIVITY_TYPE, AcademyContract.Activity.ACTIVITY_ID},
                        new int[]{R.id.typeActivity, R.id.country}
                );

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected Cursor doInBackground(Void... params) {
                Cursor cursor = getContentResolver().query(AcademyContract.Activity.ACTIVITY_URI, null, null, null, null);
                return cursor;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                adapter.changeCursor(cursor);
            }
        }.execute();
        this.setListAdapter(adapter);
    }


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final String[] bookTitles = new String[]{
                "The Alchemist",
                "The Giver",
                "How to Kill a Mockingbird",
                "Lost in Paradise",
                "The Complete Android and Java Developer...",
                "Titanic",
                "The Kite Runner",
                "Lord of the Rings",
                "The Hobbit",
                "Java in a Nutshell",
                "The Social Network",
                "Game Programming All in One"

        };

        final String[] bookPages = new String[]{
                "300 pages",
                "350 pages",
                "900 pages",
                "230 pages",
                "1200 pages",
                "450 pages",
                "350 pages",
                "120 pages",
                "2300 pages",
                "2100 pages",
                "329 pages",
                "1978 pages"

        };

        final String[] authors = new String[]{

                "Paulo Coelho",
                "Lois Lowry",
                "Harper Lee",
                "Somell Author!",
                "Paulo and Fahd",
                "Simon Adams",
                "Khaled Hosseini",
                "J. R. R. Tolkien",
                "J. R. R. Tolkien",
                "Flannagan",
                "Ben Mezrich",
                "Harbour"

        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            HashMap<String, String> data = new HashMap<>();
            data.put("typeActivity", bookTitles[i]);
            data.put("Country", bookPages[i]);
            data.put("Price", authors[i]);


            authorList.add(data);

        }

        listView = (ListView) findViewById(R.id.listview);

        //Setup adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int myPosition = position;

                String itemClickedId = listView.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(), "Id Clicked: " +itemClickedId, Toast.LENGTH_LONG).show();




            }
        });





    } */




}
