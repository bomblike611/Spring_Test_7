package com.iu.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.ListData;

public class NoticeDAO implements BoardDAO {
	
	private SqlSession sqlsession;
	private final String NAMESPACE="NoticeMapper.";
	
	@Override
	public int totalCount(ListData listData) throws Exception {
		
		return sqlsession.selectOne(NAMESPACE+"totalCount",listData);
	}
	
	public NoticeDAO(SqlSession sqlSession) {
		this.sqlsession=sqlSession;
	}
	
	@Override
	public List<BoardDTO> selectList(ListData listData) throws Exception {
		return sqlsession.selectList(NAMESPACE+"selectList",listData);
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return sqlsession.selectOne(NAMESPACE+"selectOne", num);
	}
	
	
	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlsession.insert(NAMESPACE+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlsession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlsession.delete(NAMESPACE+"delete",num);
	}

}
