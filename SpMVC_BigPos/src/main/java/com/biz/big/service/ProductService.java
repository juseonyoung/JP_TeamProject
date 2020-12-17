package com.biz.big.service;

import java.util.List;

import com.biz.big.model.ProductVO;

public interface ProductService extends GenericService<ProductVO, String>{

	public List<ProductVO> findByTitle(String title);
	
	public String getPCode();

}
