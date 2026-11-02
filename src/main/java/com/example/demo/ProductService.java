package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> findAll() { return repo.findAll(); }

    public Product findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product create(Product p) {
        p.setId(null);
        return repo.save(p);
    }

    public Product update(Long id, Product p) {
        Product existing = findById(id);
        existing.setName(p.getName());
        existing.setPrice(p.getPrice());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.delete(findById(id));
    }
}
