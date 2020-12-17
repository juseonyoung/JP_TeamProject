package com.biz.big.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.mapper.DeptDao;
import com.biz.big.model.DeptVO;
import com.biz.big.service.DeptService;

@Service(value="deptServiceV1")
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<DeptVO> selectAll() {
		// TODO Auto-generated method stub
		return deptDao.selectAll();
	}

	@Override
	public DeptVO findById(String id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	@Override
	public int insert(DeptVO vo) {
		// TODO Auto-generated method stub
		return deptDao.insert(vo);
	}

	@Override
	public int update(DeptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDCode() {
		
		
		String retDCode = "D001";
		
		
		try {
			String maxCode = deptDao.maxDCode();
			String preCode = maxCode.substring(0, 1);
			int dcode = Integer.valueOf(maxCode.substring(1))+1;

			retDCode =String.format("%s%03d", preCode, dcode);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return retDCode;
		
	}

	
	
}
