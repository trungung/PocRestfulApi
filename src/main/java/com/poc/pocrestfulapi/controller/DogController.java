package com.poc.pocrestfulapi.controller;

import com.poc.pocrestfulapi.model.Dog;
import com.poc.pocrestfulapi.repository.DogRepository;
import com.poc.pocrestfulapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    @Autowired
    private DogRepository dogrepository;

    @Autowired
    private DogService dogservice;

    private ArrayList dogModelList;

    private List dogrisklist = null;

    @GetMapping(value = "/")
    public String doghome(@RequestParam(value = "search", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date q,
            Model model) {
        if (q != null) {
            dogModelList = new ArrayList();
            System.out.println("q is = " + q);
            dogrisklist = dogservice.atriskdogs(q);
//            for (String name: dogrisklist) {
//                Dog doggy = dogrepository.findByName(name);
//                dogModelList.add(doggy);
//            }
        }
        model.addAttribute("search", dogModelList);

        model.addAttribute("dogs", dogrepository.findAll());

        return "index";

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Dog> getDogs() {
        return (List<Dog>) dogrepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Dog getDpg(@PathVariable("id") long id) {
        return dogrepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addDog(@RequestParam("name") String name,
                         @RequestParam("rescued") @DateTimeFormat(pattern = "yyyy-MM-dd") Date rescued,
                         @RequestParam("vaccinated") Boolean vaccinated) {
        dogservice.addADog(name, rescued, vaccinated);
        System.out.println("name = " + name + ",rescued = " + rescued + ", vaccinated = " + vaccinated);
    }

    @PostMapping(value = "/delete")
    public void deleteDog(@RequestParam("name") String name,
                            @RequestParam("id") Long id) {
        dogservice.deleteADOG(name, id);
        System.out.println("Dog named = " + name + "was removed from our database. Hopefully he or she was adopted.");
    }
}