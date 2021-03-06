package com.iu.s7;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.ls.LSException;

import com.iu.board.BoardDTO;
import com.iu.file.FileDTO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeView")
	public ModelAndView selectOne(int num) throws Exception{
		ModelAndView mv=new ModelAndView();
		BoardDTO boardDTO=noticeService.selectOne(num);
		mv.addObject("view", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardView");
		return mv;
	}
	
	@RequestMapping(value="noticeList")
	public ModelAndView selectList(ListData listData) throws Exception{
		/*System.out.println("search:"+listData.getSearch());
		System.out.println("kind :"+listData.getKind());
		System.out.println("curPage :"+listData.getCurPage());*/
		ModelAndView mv=new ModelAndView();
		List<BoardDTO> ar=noticeService.selectList(listData);
		mv.addObject("page", listData);
		mv.addObject("list", ar);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO,MultipartFile [] file,HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		
		
		int result=noticeService.insert(noticeDTO,file,session);
		if(result>0){
		mv.addObject("message", "Success");
		}else{
		mv.addObject("message", "fail");
		}
		mv.addObject("path", "noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public String noticeWrite(Model model) throws Exception{
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	@RequestMapping(value="noticeDelete")
	public ModelAndView noticeDelete(int num,HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		String s="Fail";
		int result=noticeService.delete(num, session);
		if(result>0){
			s="Success";
		}
		mv.addObject("message", s);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String noticeUpdate(int num,Model model) throws Exception{
		BoardDTO boardDTO=noticeService.selectOne(num);
		model.addAttribute("board", "notice");
		model.addAttribute("nupdate", boardDTO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO,MultipartFile [] file,HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		int result=noticeService.update(noticeDTO, session, file);
		String s="Fail";
		if(result>0){
			s="Success";
		}
		mv.addObject("message", s);
		mv.addObject("path", "noticeView?num="+noticeDTO.getNum());
		mv.setViewName("common/result");
		return mv;
		
	}
	
}
