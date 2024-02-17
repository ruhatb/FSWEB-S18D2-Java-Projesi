package com.workintech.project18g2.dao;

import com.workintech.project18g2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository                                //CRUD islemlerini jparepostoyden alıyor
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type from fsweb.fruit asf ORDER BY f.price DESC", nativeQuery = true)
    List<Fruit> getbyPriceDesc();

    @Query(value = "SELECT f.id, f.name, f.price, f.fruit_type from fsweb.fruit asf ORDER BY f.price ASC", nativeQuery = true)
    List<Fruit> getByPriceAsc();

    @Query(value = "SELECT f FROM f WHERE ILIKE &:name%")
    List<Fruit> searchByName(String name);
}
