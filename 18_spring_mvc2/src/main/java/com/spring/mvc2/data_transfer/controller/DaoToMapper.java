package com.spring.mvc2.data_transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc2.data_transfer.dao.OrderDAO;

@Controller
@RequestMapping("dTOm")
public class DaoToMapper {
	
	@Autowired
	private OrderDAO orderDAO;
	
	//DAO > Mapper 전송 예시 1) 단일 데이터 전송
	@RequestMapping(value="/insertData1")
	public String insertData1() {
		String productName = "기계식 키보드";
		orderDAO.insertOne(productName);
		return "redirect:/mTOd/orderList";
	}
	//DAO > Mapper 전송 예시 2) DTO 클래스 전송
	//DAO > Mapper 전송 예시 3) Map 데이터전송

}
