package com.sbk.MicroserviceBasedApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbk.MicroserviceBasedApplication.model.Resturant;
import com.sbk.MicroserviceBasedApplication.service.ResturantService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Resturant")
public class ResturantController {
    private ResturantService resturantService;

    public ResturantController(ResturantService resturantService) {
        this.resturantService = resturantService;
    }
    @PostMapping("/save")
    public ResponseEntity<Resturant> saveExpense(@RequestBody Resturant resturant){
        return new ResponseEntity<Resturant>(resturantService.save(resturant), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Resturant>> get(){
        return new ResponseEntity<List<Resturant>>(resturantService.getAllResturants(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Resturant> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Resturant>(resturantService.getResturantById(id), HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(resturantService.deleteResturantById(id), HttpStatus.OK);
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Resturant> updateExpenseById(@PathVariable("id") Long id, @RequestBody Resturant Resturant){
        return new ResponseEntity<Resturant>(resturantService.updateResturantById(id, Resturant), HttpStatus.OK);
    }

}
