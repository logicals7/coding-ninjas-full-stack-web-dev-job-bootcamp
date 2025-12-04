package Cn.CartApp.controller;

import Cn.CartApp.entity.Item;
import Cn.CartApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/id/{id}")
    public Item getItem(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @PostMapping("/addItem")
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

}
