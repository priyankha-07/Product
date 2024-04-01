package com.intern.pentafox.employee.repository;

import com.intern.pentafox.employee.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository <Product, Integer>{

    Product getByName(String name);
}
