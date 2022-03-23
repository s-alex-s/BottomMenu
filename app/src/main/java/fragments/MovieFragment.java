package fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottommenu.R;

import java.util.ArrayList;

import adapters.MoviesListAdapter;
import classes.Movies;

public class MovieFragment extends Fragment {
    ArrayList<Movies> movies;
    MoviesListAdapter adapter;
    Context context;

    public MovieFragment(Context context) {
        this.context = context;
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_movies_list, container, false);

        ListView listView = v.findViewById(R.id.listViewMovies);
        adapter = new MoviesListAdapter(this.context, movies);
        listView.setAdapter(adapter);

        return v;
    }

    public void init() {
        movies = new ArrayList<>();
        movies.add(new Movies("Пираты Карибского моря: Проклятие Чёрной жемчужины", 2003,
                "2h 17m"));
        movies.add(new Movies("Форсаж 6", 2013, "130m"));
    }
}
