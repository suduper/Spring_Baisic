package pack.spring.basic;

import java.util.List;
import java.util.Map;

public interface MemberService {

	String create(Map<String, Object> map);
	// 입력양식 페이지 및 데이터 입력처리
	
	Map<String, Object> detail(Map<String, Object> map);
	// 내용 상세보기 페이지
	
	List<Map<String, Object>> list(Map<String, Object> map);
	// 목록보기
	
	String index();

}
