package Cn.CartApp.service;

import Cn.CartApp.dal.ItemDAL;
import Cn.CartApp.entity.Item;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemDAL itemDAL;

    @Transactional
    public Item getItemById(int id) {
        return itemDAL.getById(id);
    }

    @Transactional
    public void addItem(Item item){
        itemDAL.addItem(item);
    }
}
