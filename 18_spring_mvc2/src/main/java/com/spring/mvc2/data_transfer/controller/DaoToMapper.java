package com.spring.mvc2.data_transfer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc2.data_transfer.dao.OrderDAO;
import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Controller
@RequestMapping("dTOm")
public class DaoToMapper {
	
	@Autowired
	private OrderDAO orderDAO;
	
	//DAO > Mapper 전송 예시 1) 단일 데이터 전송
	@RequestMapping(value="/insertData1")
	public String insertData1() {
		String productName = "장패드";
		orderDAO.insertOne(productName);
		return "redirect:/mTOd/orderList";
	}
	
	
	//DAO > Mapper 전송 예시 2) DTO 클래스 전송
	@RequestMapping(value = "/insertData2")
	public String insertData2() {
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMemberId("임시유저1");
		orderDTO.setProductCode("임시상품코드1");
		orderDTO.setProductName("임시상품명1");
		
		orderDAO.insertDTO(orderDTO);
		
		return "redirect:/mTOd/orderList";
		
	}
	
	//DAO > Mapper 전송 예시 3) Map 데이터전송
	@RequestMapping(value = "/insertData3")
	public String insertData3() {
		
		Map<String, String> orderMap = new HashMap<String, String>();
		
		orderMap.put("memberId"    , "임시유저2");
		orderMap.put("productCode" , "임시상품코드2");
		orderMap.put("productName" , "임시상품명2");
		
		orderDAO.insertMap(orderMap);
		
		return "redirect:/mTOd/orderList";
		
	}

}
