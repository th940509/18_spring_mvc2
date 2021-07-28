package com.spring.mvc2.data_transfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Repository
public class OrderDAO {
	@Autowired // OrderDAO 클래스 안에 rootcontext.xml에서 만든 sqlSession이라는 것을 주입 
	private SqlSession sqlSession;
	
	public List<OrderDTO> selectAll() {
		return sqlSession.selectList("order.selectAll");
	}
	
	// Mapper > DAO 전송 예시 1) 단일 데이터 전송
	public int selectData1() { // mapper의 resultType과 리턴타입이 동일해야함.
		return sqlSession.selectOne("order.select1");
	}
	
	// Mapper > DAO 전송 예시 2) DTO 클래스 리스트 전송
	public List<OrderDTO> selectData2() {
		return sqlSession.selectList("order.select2");
		
	}
	
	// Mapper > DAO 전송 예시 3) Map리스트 전송
	                  //Object로 처리하면 String,int 등 모두 받을 수 있음.
	 				  //Map의 String은 property
	public List<Map<String , Object>> selectData3() {
		return sqlSession.selectList("order.select3");
	}
	
	// Mapper > DAO 전송 예시 4) Map리스트 전송
	//Object로 처리하면 String,int 등 모두 받을 수 있음.
	//Map의 String은 property
	public List<Map<String , Object>> selectData4() {
		return sqlSession.selectList("order.select4");
	}
	
	//------------------------------------------------------------------------------//
	
	// DAO > Mapper전송 예시 1) 단일 데이터 전송
	public void insertOne(String productName) {
		sqlSession.insert("order.insertOneData" , productName);
	}
	
	// DAO > Mapper전송 예시 2) DTO 클래스 전송
	
		
	// DAO > Mapper전송 예시 3) Map 데이터 전송
 
}
