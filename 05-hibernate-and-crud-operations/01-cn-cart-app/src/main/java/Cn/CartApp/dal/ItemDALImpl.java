package Cn.CartApp.dal;

import Cn.CartApp.entity.Item;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDALImpl implements ItemDAL {

    //We need entity manager to create the sessions
    //we need sessions to interact with db
    @Autowired
    EntityManager entityManager;

    @Override
    public Item getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        //fetching the item based on id from db
        Item item = session.get(Item.class, id);
        return item;
    }
}
