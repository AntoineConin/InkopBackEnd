package com.coding.projetweb.controllers;

import java.sql.SQLException;
import java.util.List;


import com.coding.models.Item;
import com.coding.services.ItemDAO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemsController {
    private final ItemDAO dao = new ItemDAO();

    @GetMapping
    public List<Item> getItems() throws SQLException {
        return dao.getItems();
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable(value="itemId") Integer itemId) throws SQLException{
        return dao.getItemById(itemId);
    }

    @PostMapping("/create")
    public void createItem(@RequestBody Item item) throws SQLException{
        //Item test = new Item();
        //test.setId(12);
        //test.setName("yaourth");
        //test.setDescription("hhh");
        //test.setQuantity(2);
        //dao.add(test);
        dao.add(item);
    }

    @PutMapping("/put/{itemId}")
    public void updateItem(@PathVariable(value="itemId") Integer itemId, @RequestBody Item item) throws SQLException{
        dao.update(itemId, item);
    }

    @DeleteMapping("/delete/{itemId}")
    public void updateItem(@PathVariable(value="itemId") Integer itemId) throws SQLException{
        dao.delete(itemId);
    }

}