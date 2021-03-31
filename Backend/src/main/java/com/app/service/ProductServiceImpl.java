package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custome.excs.ProductNotFoundException;
import com.app.dao.ProductRepository;
import com.app.dto.ProductDTO;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	//dependencies : productDao
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductDTO> list=new ArrayList<ProductDTO>();
		productRepo.findAll().forEach(p ->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(p, dto);
			list.add(dto);
		});
		return list;
	}	
	
	@Override
	public ProductDTO getProductDetails(int pid) {
		// TODO Auto-generated method stub
		Product p=productRepo.findById(pid).orElseThrow(() -> new ProductNotFoundException("Invalid Product Id "+pid));
		ProductDTO dto=new ProductDTO();
		BeanUtils.copyProperties(p, dto);
		System.out.println("Product "+p);
		System.out.println("Product dto "+dto);
		return dto;
	}

	@Override
	public List<Product> getProductDetails(String state) {
		// TODO Auto-generated method stub
		List<Product> p=productRepo.findByProductState(state);
		List<ProductDTO> dto=new ArrayList<ProductDTO>();
		BeanUtils.copyProperties(p,dto);
		System.out.println("product "+p);
		System.out.println("Product DTO "+dto);
		return p;
	}
	
	@Override
	public ProductDTO saveProductDetails(Product p) {
		// TODO Auto-generated method stub
		Product persistentUser = productRepo.save(p);
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(persistentUser, dto);
		return dto;
	}

	@Override
	public ProductDTO updateProductDetails(int pid, ProductDTO p) {
		System.out.println(" in update "+p);
		Product product=productRepo.findById(pid).get();
		BeanUtils.copyProperties(p, product);
		return p;
	}

	@Override
	public String deleteProductDetails(int pid) {
		// validate if product exists
		Optional<Product> optionalProduct=productRepo.findById(pid);
		Product product=optionalProduct.orElseThrow(() -> new ProductNotFoundException("Invalid Product Id "+pid));
		productRepo.deleteById(pid);		
		return "Product Details For ID"+pid+" deleted...";
	}

	@Override
	public Long getProductsCount() {
		System.out.println("Count product class" + productRepo.getClass().getName());
		return productRepo.count();
	}
	
	

}
