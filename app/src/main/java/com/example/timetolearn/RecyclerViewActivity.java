package com.example.timetolearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initializeData();

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(movies);
        rv.setAdapter(adapter);
    }

    private List<MovieData> movies;

    private void initializeData() {
        movies = new ArrayList<>();
        movies.add(new MovieData("The Shawshank Redemtion","https://images-na.ssl-images-amazon.com/images/I/51B1ehfX4pL.jpg","1994"));
        movies.add(new MovieData("The GodFather","http://ia.media-imdb.com/images/M/MV5BMjEyMjcyNDI4MF5BMl5BanBnXkFtZTcwMDA5Mzg3OA@@._V1_.jpg","1972"));
        movies.add(new MovieData("Forrest Gump","http://ia.media-imdb.com/images/M/MV5BMTI1Nzk1MzQwMV5BMl5BanBnXkFtZTYwODkxOTA5._V1_.jpg","1994"));
    }
}
