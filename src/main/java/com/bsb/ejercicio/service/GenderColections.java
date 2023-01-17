package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.model.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class GenderColections {
    public  List<Gender> addGender(){
        List<Gender> listGender=new ArrayList<>();
        List<Movie> listMovie=new ArrayList<>();
        listGender.add(new Gender("Suspenso", listMovie));
        listGender.add(new Gender("Terror", listMovie));
        listGender.add(new Gender("Suspenso", listMovie));
        listGender.add(new Gender("Comedia", listMovie));
        return listGender;
    }
}
