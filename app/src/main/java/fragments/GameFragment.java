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

import adapters.GamesListAdapter;
import classes.Games;

public class GameFragment extends Fragment {
    ArrayList<Games> games;
    GamesListAdapter adapter;
    Context context;
    ListView listView;

    public GameFragment(Context context) {
        this.context = context;
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_games_list, container, false);

        listView = v.findViewById(R.id.listViewGames);
        adapter = new GamesListAdapter(this.context, games);
        listView.setAdapter(adapter);

        return v;
    }

    public void init() {
        games = new ArrayList<>();
        games.add(new Games("Grand Theft Auto IV", 2008, "Action, Adventure"));
        games.add(new Games("Just Cause 2", 2010, "Action, Adventure"));
        games.add(new Games("Metro Exodus", 2019, "Action"));
        games.add(new Games("L.A Noire", 2011, "Adventure, Strategy"));
        games.add(new Games("Red Dead Redemption 2", 2019, "Action, Adventure"));
        games.add(new Games("Dying Light 2", 2022, "Action, Adventure, RPG"));
    }
}