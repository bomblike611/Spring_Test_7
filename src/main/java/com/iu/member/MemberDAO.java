package com.iu.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="MemberMapper.";

	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"insert", memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne", memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", memberDTO);
	}
	public String memberidcheck(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"idcheck", id);
	}
	
}
