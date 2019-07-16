package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> MovieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects){
        super(context, resource, objects);
        parent_context=context;
        layout_id=resource;
        MovieList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=(LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent, false);

       ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        Movies currentItem = MovieList.get(position);

         if (currentItem.getRated()=="pg") {
             ivRating.setImageResource(R.drawable.rating_pg);

            }else if (currentItem.getRated()=="pg13"){
             ivRating.setImageResource(R.drawable.rating_pg13);
            }else if (currentItem.getRated()=="g"){
             ivRating.setImageResource(R.drawable.rating_g);
         }else if (currentItem.getRated()=="nc16"){
             ivRating.setImageResource(R.drawable.rating_nc16);
         }else if (currentItem.getRated()=="m18"){
             ivRating.setImageResource(R.drawable.rating_m18);
         }else{
             ivRating.setImageResource(R.drawable.rating_r21);
         }
        return rowView;
    }

}