package com.codeusingjava.controller;

import com.codeusingjava.dto.ItemsDto;
import com.codeusingjava.dto.ItemsResponse;
import com.codeusingjava.exception.EntityNotFoundException;
import com.codeusingjava.model.Items;
import com.codeusingjava.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//spring web annotations
@RestController
@RequestMapping("/api")
public class ItemsController {

    @Autowired
    ItemsService service;

    //get all itemss
    //URL - http://localhost:9800/api/itemss
    @GetMapping("/itemss")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ItemsResponse> getItemss() {
        return service.getAll();
    }

    //get items by id
    //URL - http://localhost:9800/api/items-by-id?id=1
    @GetMapping("/items-by-id")
    @ResponseStatus(code = HttpStatus.OK)
    public ItemsResponse getItems(@RequestParam(name = "id") final int id)
            throws EntityNotFoundException {
        final Items p = service.getItems(id);
        return ItemsResponse.from(p);
    }

    @PutMapping("/items-by-id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateItems(@RequestParam(name = "id") final int id,
                              @RequestBody final ItemsDto dto) throws EntityNotFoundException {
        service.updateItems(id, dto);
    }
}
