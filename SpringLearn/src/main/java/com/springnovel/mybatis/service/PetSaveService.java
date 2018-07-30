package com.springnovel.mybatis.service;

import com.springnovel.mybatis.mapper.PetMapper;
import com.springnovel.mybatis.model.Pet;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public class PetSaveService {
    private PetMapper petMapper;

    public PetMapper getPetMapper() {
        return petMapper;
    }

    public void setPetMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUsingRequireNew(Pet pet){
        petMapper.save(pet);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void saveUsingNested(Pet pet){
        petMapper.save(pet);
    }
}
