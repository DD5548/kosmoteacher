package mobile.kosmo.mvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UploadDTO;
// byName
@Repository("upload")
public class UploadDao implements UploadDaoInter {
	@Autowired
	SqlSessionTemplate ss;

	@Override
	public void insert(UploadDTO vo) {
		// TODO Auto-generated method stub
		ss.insert("upload.insert", vo);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int cnt = ss.selectOne("upload.count");
		return cnt;
	}

	@Override
	public List<UploadDTO> list(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		List<UploadDTO> list = ss.selectList("upload.paginate", map);
		return list;
	}

	@Override
	public UploadDTO detail(int num) {
		// TODO Auto-generated method stub
		UploadDTO vo = ss.selectOne("upload.detail", num);
		return vo;
	}

	@Override
	public void update(UploadDTO vo) {
		// TODO Auto-generated method stub
		ss.update("upload.update", vo);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		ss.delete("upload.delete", num);
	}

}
