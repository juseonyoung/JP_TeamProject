package com.biz.big.mapper;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.DeptVO;

public interface DeptDao extends GenericDao<DeptVO, String >{

	@Select("SELECT MAX(d_code) FROM tbl_depts")
	public String maxDCode();
}
