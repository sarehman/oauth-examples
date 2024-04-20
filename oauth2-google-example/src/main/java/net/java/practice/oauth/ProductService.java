package net.java.practice.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public Product get(Long id) throws ProductNotFoundException{
        Optional<Product> product =
                productRepository.findById(id);
        if(product.isPresent())
            return product.get();
        else
            throw new ProductNotFoundException("Could not find product");
    }

    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }
}
