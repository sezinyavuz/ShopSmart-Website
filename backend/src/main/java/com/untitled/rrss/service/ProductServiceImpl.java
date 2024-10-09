package com.untitled.rrss.service;

import com.untitled.rrss.dao.ProductDAO;
import com.untitled.rrss.entity.Product;
import com.untitled.rrss.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO theProductDAO) {
        productDAO = theProductDAO;
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int theId) {
        return productDAO.findById(theId);
    }

    @Transactional
    @Override
    public Product save(Product theProduct) {
        return productDAO.save(theProduct);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        productDAO.deleteById(theId);
    }
}
