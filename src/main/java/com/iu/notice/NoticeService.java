package com.iu.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.PageMaker;

public class NoticeService implements BoardService {
	
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	
	@Override
	public List<BoardDTO> selectList(ListData listData) throws Exception {
		int totalCount=noticeDAO.totalCount(listData);
		System.out.println(totalCount);
		PageMaker pageMaker=new PageMaker();
		pageMaker.pageMaker(totalCount, listData);
		return noticeDAO.selectList(listData);
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return noticeDAO.selectOne(num);
	}

	@Override
	public int insert(BoardDTO boardDTO, MultipartFile [] file, HttpSession session) throws Exception {
		int a=noticeDAO.insert(boardDTO);
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
		return a;
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
		return noticeDAO.update(boardDTO);
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
		return noticeDAO.delete(num);
	}

}
