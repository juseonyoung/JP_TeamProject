package com.biz.big.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.biz.big.mapper.PosDao;
import com.biz.big.model.PosVO;
import com.biz.big.service.PosService;

@Service
@Qualifier("posServiceV1")
public class PosServiceImpl implements PosService{

	@Autowired
	private PosDao posDao;
	
	@Override
	public List<PosVO> selectAll() {
		
		List<PosVO> posList = posDao.selectAll();
		return posList;
	}

	@Override
	public PosVO findById(Long seq) {
		PosVO posVO = posDao.findById(seq);
		return posVO;
	}

	@Override
	public int insert(PosVO posVO) {
		int ret = posDao.insert(posVO);
		return ret;
	}

	@Override
	public int update(PosVO posVO) {
		int ret = posDao.update(posVO);
		return ret;
	}

	@Override
	public int delete(Long seq) {
		int ret = posDao.delete(seq);
		return ret;
	}

	@Override
	public PosVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
