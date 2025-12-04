package Cn.CartApp.dal;

import Cn.CartApp.entity.Item;

public interface ItemDAL {
    public Item getById(int id);
    public void addItem(Item item);

}
