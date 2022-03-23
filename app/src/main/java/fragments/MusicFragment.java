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

import adapters.MusicListAdapter;
import classes.Music;

public class MusicFragment extends Fragment {
    ArrayList<Music> music;
    MusicListAdapter adapter;
    Context context;
    ListView listView;

    public MusicFragment(Context context) {
        this.context = context;
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_music_list, container, false);

        listView = v.findViewById(R.id.listViewMusic);
        adapter = new MusicListAdapter(this.context, music);
        listView.setAdapter(adapter);

        return v;
    }

    public void init() {
        music = new ArrayList<>();
        music.add(new Music("Boulevard of broken dreams", 2004, "Green Day"));
        music.add(new Music("Apologize", 2007, "OneRepublic"));
        music.add(new Music("Destination feat. Nicco", 2009, "Leonid Rudenko"));
    }
}
