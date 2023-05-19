package com.ufmt.farmapro.item;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/item")
@RequiredArgsConstructor

public class ItemController {


    private final ItemRepository itemRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Item> findAll(){
        return itemRepository.findAll();
    }
    
}