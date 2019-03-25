package com.example.timetolearn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MovieViewHolder> {

    List<MovieData> movies;

    RVAdapter(List<MovieData> movies) {
        this.movies = movies;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView movieName;
        TextView movieYear;
        ImageView movieImage;

        MovieViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            movieName = (TextView) itemView.findViewById(R.id.movie_name);
            movieYear = (TextView) itemView.findViewById(R.id.movie_year);
            movieImage = (ImageView) itemView.findViewById(R.id.movie_image);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        MovieViewHolder mvh = new MovieViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.movieName.setText(movies.get(i).nama);
        movieViewHolder.movieYear.setText(movies.get(i).year);
        new DownloadImageTask(movieViewHolder.movieImage).execute(movies.get(i).image_url);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;

            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage() );
                e.printStackTrace();
            }
            return mIcon11;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
