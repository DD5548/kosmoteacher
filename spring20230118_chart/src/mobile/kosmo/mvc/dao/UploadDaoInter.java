package mobile.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UploadDTO;

public interface UploadDaoInter {
	public void insert(UploadDTO vo);
	public int count();
	public List<UploadDTO> list(Map<String, Integer> map);
	
	public UploadDTO detail(int num);
	public void update(UploadDTO vo);
	public void delete(int num);
}
