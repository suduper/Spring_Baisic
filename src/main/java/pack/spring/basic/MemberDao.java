package pack.spring.basic;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository //데이터 접근용 클래스 (Date Bean)
public class MemberDao {

	@Autowired //DB 접속정보와 매퍼파일 위치 지정해줌
	SqlSessionTemplate sqlSessionTemplate;
		
	public int insert(Map<String, Object> map) {		
		return this.sqlSessionTemplate.insert("member.insert", map);
	}
	// return this.sqlSessionTemplate.insert("namespace.id값", map); **_SQL.xml 참조
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		
		return this.sqlSessionTemplate.selectOne("member.select_detail", map);
		
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("member.select_list", map);
	}
}
