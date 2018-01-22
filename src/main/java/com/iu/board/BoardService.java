package com.iu.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.util.ListData;

public interface BoardService {
	//lsit
	public List<BoardDTO> selectList(ListData listData) throws Exception;
	//One
	public BoardDTO selectOne(int num) throws Exception;
	//insert
	public int insert(BoardDTO boardDTO,MultipartFile [] file,HttpSession session) throws Exception;
	//update
	public int update(BoardDTO boardDTO,HttpSession session,MultipartFile [] file) throws Exception;
	//delete
	public int delete(int num,HttpSession session) throws Exception;
}
