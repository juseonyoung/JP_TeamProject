package com.biz.big.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.ProductVO;

public interface ProductDao extends GenericDao<ProductVO, String>{

	@Select(" SELECT * FROM tbl_products WHERE p_not_use IS NULL")
	@Override
	public List<ProductVO> selectAll();
	
	public List<ProductVO> findByTitle(String title);
	
	@Select("SELECT MAX(p_code) FROM tbl_products")
	public String maxPCode();

	@Select(" SELECT * FROM tbl_products WHERE p_not_use IS NULL AND p_code =RPAD(#{id},6,' ') ")
	
	@Override
	public ProductVO findById(String id);
}
