package com.sbk.MicroserviceBasedApplication.service;

import java.util.List;

import com.sbk.MicroserviceBasedApplication.model.Resturant;

public interface ResturantService {
    public Resturant save(Resturant resturant);
    public List<Resturant> getAllResturants();
    public Resturant getResturantById(long id);
    public Resturant updateResturantById(long id, Resturant resturant);
    public boolean deleteResturantById(long id);
    public List<Resturant> getResturantsByRating(int min, int max);
}
