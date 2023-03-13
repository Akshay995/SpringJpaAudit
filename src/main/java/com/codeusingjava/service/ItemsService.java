package com.codeusingjava.service;

import com.codeusingjava.dto.ItemsDto;
import com.codeusingjava.dto.ItemsResponse;
import com.codeusingjava.exception.EntityNotFoundException;
import com.codeusingjava.model.Items;
import com.codeusingjava.repo.ItemsRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//lombok annotation
@Slf4j
//spring annotation
@Service
public class ItemsService {

    @Autowired
    ItemsRepository repository;

    //save all itemss in the db
    public void saveAll(final List<Items> itemss) {
        repository.saveAll(itemss);
    }

    //get all itemss from the db
    public List<ItemsResponse> getAll() {
        log.info("Getting all itemss");
        return repository.findAll()
                .stream()
                .map(ItemsResponse::from)
                .collect(Collectors.toList());
    }

    //get items by id from the db
    public Items getItems(final int id) throws EntityNotFoundException {
        log.info("Getting items id = {}", id);
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Items %s not found", id)));
    }

    //update items in the db
    public void updateItems(final int id, final ItemsDto dto) throws EntityNotFoundException {
        log.info("Updating items id = {}", id);
        getItems(id);
        final Items p = Items.builder()
        		.id(id)
                .material(dto.getMaterial())
                .price(dto.getPrice())
                .promotionCode(dto.getPromotionCode())
                .build();
        repository.save(p);
    }
}
