package com.biz.big.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.mapper.ProductDao;
import com.biz.big.model.ProductVO;
import com.biz.big.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value="proServiceV1")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao proDao;
	
	public List<ProductVO> selectAll() {
		// TODO Auto-generated method stub
		return proDao.selectAll();
	}

	@Override
	public ProductVO findById(String id) {
		// TODO Auto-generated method stub
		return proDao.findById(id);
	}

	@Override
	public int insert(ProductVO vo) {
		// TODO Auto-generated method stub
		return proDao.insert(vo);
	}

	@Override
	public int update(ProductVO vo) {
		// TODO Auto-generated method stub
		return proDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		ProductVO proVO = proDao.findById(id);
		
		int ret =0;
		if(proVO!=null) {
			proVO.setP_not_use((byte)1);
			ret = proDao.update(proVO);
		}
		return ret;
	}

	@Override
	public List<ProductVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPCode() {
		
		
		String strMaxPCode = proDao.maxPCode();
		log.debug("조회한 상품코드:{}", strMaxPCode);
		
		String retPCode = "P00001";
		try {
			String preCode= strMaxPCode.substring(0,1);
			String pCode = strMaxPCode.substring(1);
			
			log.debug("분리된 상품코드 {},{}",preCode, pCode);
			retPCode= String.format("%s%05d", preCode, Integer.valueOf(pCode)+1);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		log.debug("새로 생성된 상품코드 {}", retPCode);
	
	
		return retPCode;
	}

	
}
