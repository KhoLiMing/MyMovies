package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovies;
    static ArrayList<Movies> MoviesList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMovies = findViewById(R.id.listView);
        MoviesList=new ArrayList<>();
        Movies item1= new Movies("The Avengers","2012","pg13","Action|Sci-Fi",
               "15/11/2014" , "Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        MoviesList.add(item1);
        Movies item2 = new Movies("Planes","2013","pg","Animation|Comedy",
                "15/5/2015" , "Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        MoviesList.add(item2);


        caMovie=new CustomAdapter(this,R.layout.row,MoviesList);
        lvMovies.setAdapter(caMovie);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition = position;

                Integer itemValue = (Integer) lvMovies.getItemAtPosition(position);

                Intent intent=new Intent(getBaseContext(),ViewItem.class);

                intent.putExtra("position", itemValue);
                startActivity(intent);

            }
        });
    }
}
