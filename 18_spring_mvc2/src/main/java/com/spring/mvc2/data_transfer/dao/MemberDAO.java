package com.spring.mvc2.data_transfer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.data_transfer.domain.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired // = @Inject (주최자에 따라 다르나 동일함)
	private SqlSession sqlSession;
	    //ArrayList 사용해도 상관 없음
	public List<MemberDTO> selectAllMember() {
		return sqlSession.selectList("member.selectAllMember");
	}
}
