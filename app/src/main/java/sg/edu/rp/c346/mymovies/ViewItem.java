package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewItem extends AppCompatActivity {

    TextView title;
    TextView year;
    ImageView rated;
    TextView genre;
    TextView watched_on;
    TextView in_theatre;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        title=findViewById(R.id.textViewTitle);
        year=findViewById(R.id.textViewYear);
        rated=findViewById(R.id.imageViewRating);
        genre=findViewById(R.id.textViewGenre);
        watched_on=findViewById(R.id.textViewDate);
        in_theatre=findViewById(R.id.textViewTheatre);
        description=findViewById(R.id.textViewDescription);

        ArrayList<Movies> movielist= MainActivity.MoviesList;

        Intent intentReceived = getIntent();
        Integer position =intentReceived.getIntExtra("position",0);

       title.setText(movielist.get(position).getTitle());
        year.setText(movielist.get(position).getYear());
        genre.setText(movielist.get(position).getGenre());
        watched_on.setText(movielist.get(position).getWatched_on());
        in_theatre.setText(movielist.get(position).getIn_theatre());
        description.setText(movielist.get(position).getDescription());

        if (movielist.get(position).getRated()=="pg") {
            rated.setImageResource(R.drawable.rating_pg);

        }else if (movielist.get(position).getRated()=="pg13"){
            rated.setImageResource(R.drawable.rating_pg13);
        }else if (movielist.get(position).getRated()=="g"){
            rated.setImageResource(R.drawable.rating_g);
        }else if (movielist.get(position).getRated()=="nc16"){
            rated.setImageResource(R.drawable.rating_nc16);
        }else if (movielist.get(position).getRated()=="m18"){
            rated.setImageResource(R.drawable.rating_m18);
        }else{
            rated.setImageResource(R.drawable.rating_r21);
        }



    }
}
