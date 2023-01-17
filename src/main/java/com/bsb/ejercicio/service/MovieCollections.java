package com.bsb.ejercicio.service;
import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class MovieCollections {

    public List<Movie> addMovie(){
        List<Movie> listMovie=new ArrayList<>();
        List<Character> listCharacter=new ArrayList<>();
        listMovie.add(new Movie("oblivion (2012)", LocalDate.parse("2012-01-08"), 3,listCharacter));
        listMovie.add(new Movie("into the wild (2014)", LocalDate.parse("2014-08-15"), 3, listCharacter));
        listMovie.add(new Movie("BLADE RUNNER (2015)", LocalDate.parse("2015-02-15"), 3, listCharacter));
        listMovie.add(new Movie("MULHOLLAND PRIDE (2013)", LocalDate.parse("2013-10-15"), 3, listCharacter));
        return listMovie;
    }
}
