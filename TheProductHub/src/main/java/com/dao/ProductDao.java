package com.dao;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductDao {
    @Autowired
     HibernateTemplate hibernateTemplate;
    @Transactional
    public void createProduct(Product product){
        this.hibernateTemplate.saveOrUpdate(product);
    }

    public List<Product> getProducts(){
        List<Product> products=this.hibernateTemplate.loadAll(Product.class);
         return products;
    }
    @Transactional
    public void deleteProduct(int pid){
       Product product=this.hibernateTemplate.load(Product.class,pid);
       this.hibernateTemplate.delete(product);
    }

    public Product getProducts(int pid){

        return this.hibernateTemplate.get(Product.class,pid);

    }
}
