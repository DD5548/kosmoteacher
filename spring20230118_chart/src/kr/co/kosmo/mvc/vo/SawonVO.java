package kr.co.kosmo.mvc.vo;
/*
 * SABUN	NUMBER(10,0)
SANAME	VARCHAR2(15 BYTE)
DEPTNO	NUMBER(10,0)
SAJOB	VARCHAR2(20 BYTE)
SAPAY	NUMBER(10,0)
SAHIRE	DATE
GENDER	VARCHAR2(8 BYTE)
SAMGR	NUMBER(10,0)
 */
public class SawonVO {
	private int sabun, deptno, sapay, samgr;
	private String saname, sajob, sahire, gender;
	// Has-one 관계
	private SawonPhoneVO spvo;
	
	public SawonPhoneVO getSpvo() {
		return spvo;
	}
	public void setSpvo(SawonPhoneVO spvo) {
		this.spvo = spvo;
	}
	// Has-one(1:1): 사원 한 명당 phone을 가지는 관계
	// ResulMap의 Association의 예
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSapay() {
		return sapay;
	}
	public void setSapay(int sapay) {
		this.sapay = sapay;
	}
	public int getSamgr() {
		return samgr;
	}
	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSajob() {
		return sajob;
	}
	public void setSajob(String sajob) {
		this.sajob = sajob;
	}
	public String getSahire() {
		return sahire;
	}
	public void setSahire(String sahire) {
		this.sahire = sahire;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
