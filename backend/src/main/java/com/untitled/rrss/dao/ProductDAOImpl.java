package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Product;
import com.untitled.rrss.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;

    }
    @Override
    public List<Product> findAll() {

        TypedQuery<Product> theQuery = entityManager.createQuery("FROM Product", Product.class);

        List<Product> products = theQuery.getResultList();

        return products;
    }

    @Override
    public Product findById(int theId) {
        Product product = entityManager.find(Product.class, theId);
        return product;
    }

    @Override
    public Product save(Product theProduct) {
        Product dbProduct = entityManager.merge(theProduct);

        return dbProduct;
    }

    @Override
    public void deleteById(int theId) {
        Product theProduct = entityManager.find(Product.class, theId);

        entityManager.remove(theProduct);
    }
}
