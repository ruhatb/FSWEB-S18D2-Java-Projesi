package com.workintech.project18g2.dao;

import com.workintech.project18g2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    @Query(value = "SELECT v.id,v.name,v.price,v.is_grown_on_tree FROM fsweb.vegetable as v ORDER BY v price DESC", nativeQuery = true)
    List<Vegetable> getByPriceDesc();

    @Query(value = "SELECT v.id,v.name,v.price,v.is_grown_on_tree FROM fsweb.vegetable as v ORDER BY v price ASC", nativeQuery = true)
    List<Vegetable> getByPriceAsc();

    @Query(value = "SELECT v FROM Vegetable v.where,v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
