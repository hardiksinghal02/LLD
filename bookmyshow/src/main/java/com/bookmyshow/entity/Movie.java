package com.bookmyshow.entity;

import com.lld.entity.AbstractEntity;
import lombok.Getter;

import java.util.List;

@Getter
public class Movie extends AbstractEntity<Movie> {
    private String name;
    private String description;
    private List<String> genres;
    private String language;
    private Integer durationInSec;


    @Override
    public Movie clone() {
        // TODO
        return null;
    }
}
