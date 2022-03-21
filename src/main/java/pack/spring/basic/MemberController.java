package pack.spring.basic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	
	// 입력양식 화면 시작
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create() {
		return new ModelAndView("member/create");
	}
	// 입력양식 화면 끝

	
	// 입력양식 데이터 전송 시작
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav  = new ModelAndView();
		
		String memberId = this.memberService.create(map);
		if (memberId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?memberId="+memberId);
		}		
		
		return mav;
	}
	// 입력양식 데이터 전송 끝
	
	//상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.memberService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String no = map.get("no").toString();
		mav.addObject("no", no);
		mav.setViewName("/member/detail");
		return mav;
		
	}
	
	// 목록 불러오기
	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		
		List<Map <String, Object>> list = this.memberService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		mav.setViewName("/member/list");
		return mav;
	}
	
	
	//인덱스 페이지 시작
	@RequestMapping(value = "/")
	public ModelAndView index() {
	 ModelAndView mav = new ModelAndView(); mav.setViewName("/index");
	 return mav;
	}
	//인덱스 페이지 끝

	

}
