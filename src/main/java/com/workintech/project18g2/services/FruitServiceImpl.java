package com.workintech.project18g2.services;

import com.workintech.project18g2.dao.FruitRepository;
import com.workintech.project18g2.entity.Fruit;
import com.workintech.project18g2.exceptions.FruitException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class FruitServiceImpl implements FruitService{

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit getById(long id) {
       Optional<Fruit> fruitOptional=  fruitRepository.findById(id);

        return fruitOptional.orElseThrow(()-> new FruitException("fruit id not", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getbyPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = getById(id);  // fruit içinde getbyıd ile id yi cagır yoka yukarda exception alır varsa getir.
        fruitRepository.delete(fruit); // getirleni sil
        return fruit;  //silineni dön
    }

    @Override
    public List<Fruit> searchByName(String name) {

        return fruitRepository.searchByName(name); //name getir dön.
    }
}
