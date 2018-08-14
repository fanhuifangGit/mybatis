package com.ai.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ai.mapper.CardMapper;
import com.ai.pojo.Card;
import com.ai.util.PropertiesRead;

public class CardDao {
	SqlSession session = PropertiesRead.getSqlSession();
	CardMapper mapper = session.getMapper(CardMapper.class);
	public List<Card> selectAllCard() throws Exception{
		List<Card> goodsList = null ;
		try {
			goodsList = mapper.selectAllCard();
			session.commit();//使用session来管理事物
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		return goodsList;
		
	}
	public void insertCard() throws Exception{
		try {
			 mapper.insertCard();
			session.commit();//使用session来管理事物
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		
	}
}
