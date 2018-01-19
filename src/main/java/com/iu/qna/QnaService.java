package com.iu.qna;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.PageMaker;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;

	@Override
	public List<BoardDTO> selectList(ListData listData) throws Exception {
		int totalCount=qnaDAO.totalCount(listData);
		PageMaker pageMaker=new PageMaker();
		pageMaker.pageMaker(totalCount, listData);
		return qnaDAO.selectList(listData);
	}

	@Override
	public ModelAndView selectOne(int num) throws Exception {
		ModelAndView mv=new ModelAndView();
		BoardDTO boardDTO=qnaDAO.selectOne(num);
		List<FileDTO> ar=fileDAO.selectList(num);
		mv.addObject("file", ar);
		mv.addObject("view",boardDTO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardView");
		return mv;
	}

	@Override
	public int insert(BoardDTO boardDTO,MultipartFile[] file,HttpSession session) throws Exception {
		int result=qnaDAO.insert(boardDTO);
		FileSaver fileSaver = new FileSaver();
		String filepath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filepath);
		File f = new File(filepath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		List<String> names=fileSaver.saver(file, filepath);
		for(int i=0;i<names.size();i++){
			FileDTO fileDTO=new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(names.get(i));
			fileDTO.setOname(file[i].getOriginalFilename());
			fileDAO.insert(fileDTO);
			System.out.println(names.get(i));
		}
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(num);
	}
	
	public int reply(BoardDTO boardDTO) throws Exception{
		qnaDAO.replyUpdate(boardDTO);
		return qnaDAO.replyInsert(boardDTO, boardDTO);
	}

}
