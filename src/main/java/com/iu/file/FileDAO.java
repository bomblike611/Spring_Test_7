package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.cglib.beans.FixedKeySet;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="FileMapper.";
	
	public int insert(FileDTO fileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"insert", fileDTO);
	}
	
	
	public List<FileDTO> selectList(int num) throws Exception{
		return sqlSession.selectList(NAMESPACE+"FileList", num);
	}
	
	public int delete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"Delete", num);
	}
	
	public int filedelete(int fnum) throws Exception{
		return sqlSession.delete(NAMESPACE+"FileDelete", fnum);
	}
	
}
