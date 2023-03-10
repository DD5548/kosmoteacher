package kr.co.kosmo.mvc.vo;

import java.util.List;

public class DeptVO {
	private int deptno;
	private String dname, loc;
	// ResultMap - 부서(1:n 관계)
	private List<SawonVO> sawon;
	
	// ResultMap - 생성자로 저장하기.(Setter)
	public DeptVO(Integer deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	public int getDeptno() {
		return deptno;
	}
	/*
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	*/
	public String getDname() {
		return dname;
	}
	/*
	public void setDname(String dname) {
		this.dname = dname;
	}
	*/
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<SawonVO> getSawon() {
		return sawon;
	}
	public void setSawon(List<SawonVO> sawon) {
		this.sawon = sawon;
	}
	
}
