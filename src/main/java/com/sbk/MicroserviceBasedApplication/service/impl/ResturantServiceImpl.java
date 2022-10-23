package com.sbk.MicroserviceBasedApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbk.MicroserviceBasedApplication.exception.ResourceNotFoundException;
import com.sbk.MicroserviceBasedApplication.model.Resturant;
import com.sbk.MicroserviceBasedApplication.repository.ResturantRepository;
import com.sbk.MicroserviceBasedApplication.service.ResturantService;

@Service
public class ResturantServiceImpl implements ResturantService{
    private ResturantRepository resturantRepository;
    public ResturantServiceImpl(ResturantRepository resturantRepository) {
        this.resturantRepository = resturantRepository;
    }

    @Override
    public Resturant save(Resturant resturant) {
        // TODO Auto-generated method stub
        return resturantRepository.save(resturant);
    }

    @Override
    public List<Resturant> getAllResturants() {
        // TODO Auto-generated method stub
        return resturantRepository.findAll();
    }

    @Override
    public Resturant getResturantById(long id) {
        // TODO Auto-generated method stub
        return resturantRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Resturant", "Id", resturantRepository));
    }

    @Override
    public Resturant updateResturantById(long id, Resturant resturant) {
        // TODO Auto-generated method stub
        resturant.setId(id);
        return resturantRepository.save(resturant);
    }

    @Override
    public boolean deleteResturantById(long id) {
        // TODO Auto-generated method stub
        Resturant resturant = getResturantById(id);
        resturantRepository.delete(resturant);
        if(resturantRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<Resturant> getResturantsByRating(double min, double max) {
        // TODO Auto-generated method stub
        return resturantRepository.findAllResturantByRating(min, max);
    }
    
}
