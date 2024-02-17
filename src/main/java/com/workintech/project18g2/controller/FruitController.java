package com.workintech.project18g2.controller;

import com.workintech.project18g2.dto.FruitResponse;
import com.workintech.project18g2.services.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import com.workintech.project18g2.entity.Fruit;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/workintech/fruits")
public class FruitController implements FruitService {


    @Override
    public Fruit getById(long id) {
        return null;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return null;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return null;
    }

    @Override
    public Fruit delete(long id) {
        return null;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return null;
    }

    @GetMapping("/{id}")
    public FruitResponse get(@PathVariable @Positive long id){
        return new FruitResponse("find by ıd succes", FruitService.getById(id) );
    }
}
