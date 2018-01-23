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
	public BoardDTO selectOne(int num) throws Exception {
		
		return qnaDAO.selectOne(num);
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
	public int update(BoardDTO boardDTO,HttpSession session,MultipartFile [] file) throws Exception {
		FileSaver fileSaver = new FileSaver();
		String filepath = session.getServletContext().getRealPath("resources/upload");
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
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num,HttpSession session) throws Exception {
		List<FileDTO> ar=fileDAO.selectList(num);
		String filepath = session.getServletContext().getRealPath("resources/upload");
		FileSaver fileSaver=new FileSaver();
		for(FileDTO fileDTO: ar){
		fileSaver.fileDelete(filepath, fileDTO.getFname());
		}
		int result=fileDAO.delete(num);
		return qnaDAO.delete(num);
	}
	
	public int reply(BoardDTO boardDTO) throws Exception{
		qnaDAO.replyUpdate(boardDTO);
		return qnaDAO.replyInsert(boardDTO, boardDTO);
	}

}
