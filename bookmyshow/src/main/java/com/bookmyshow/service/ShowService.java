package com.bookmyshow.service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Show;

import java.util.List;

public interface ShowService {

    List<Movie> getAllMoviesInCity(String cityName);

    List<Show> getAllShowsForMovie(String movieId, String cityName);


}
