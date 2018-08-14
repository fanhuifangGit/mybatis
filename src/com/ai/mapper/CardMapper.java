package com.ai.mapper;

import java.util.List;

import com.ai.pojo.Card;


public interface CardMapper {
	public List<Card> selectAllCard() throws Exception;  
	public void insertCard() throws Exception;  
}
