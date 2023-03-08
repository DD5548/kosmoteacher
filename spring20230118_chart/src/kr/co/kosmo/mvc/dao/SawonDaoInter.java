package kr.co.kosmo.mvc.dao;

import java.util.List;

import kr.co.kosmo.mvc.vo.DeptVO;
import kr.co.kosmo.mvc.vo.SawonVO;

public interface SawonDaoInter {
	// deptList -> getDeptList
	// sawonPhone -> getSawonPhoneList
	public DeptVO getDeptList(int deptno);
	public List<SawonVO> getSawonList();
}
