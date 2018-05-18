package aptech.fpt.spring.model;

import aptech.fpt.spring.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductModel extends PagingAndSortingRepository<Product, Integer>{
}
