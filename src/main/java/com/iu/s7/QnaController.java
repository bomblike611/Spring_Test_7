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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.file.FileDTO;
import com.iu.notice.NoticeDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaView")
	public ModelAndView selectOne(int num) throws Exception{
		
		return qnaService.selectOne(num);
	}
	
	
	@RequestMapping(value="qnaList")
	public ModelAndView selectList(ListData listData) throws Exception{
		ModelAndView mv=new ModelAndView();
		List<BoardDTO> ar=qnaService.selectList(listData);
		mv.addObject("page", listData);
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		return mv;	
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String noticeWrite(QnaDTO qnaDTO,RedirectAttributes ra,MultipartFile [] file,HttpSession session) throws Exception{
		ModelAndView mv=new ModelAndView();
		int result=qnaService.insert(qnaDTO,file,session);
		//2.boardList
		String message="Fail";
		if(result>0){
			message="Success";
		}
		ra.addFlashAttribute("message", message);
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="qnaWrite",method=RequestMethod.GET)
	public String noticeWrite(Model model) throws Exception{
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	
}
