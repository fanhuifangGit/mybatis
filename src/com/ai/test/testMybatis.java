package com.ai.test;

import java.sql.Timestamp;
import java.util.List;


import com.ai.pojo.Card;
import com.ai.util.PropertiesRead;
import com.ai.util.PropertyUtil;

public class testMybatis {
	
	static{
		PropertiesRead.init();
	}
	public static void main(String[] args) {
		 	CardDao cardDao=new CardDao();
			List<Card> goodsList=null;
			try {
				goodsList = cardDao.selectAllCard();
				System.out.println(goodsList.toString());
				Card card=new Card();
 				card.setCardNo("652");
				card.setCardPwd("54654");
				card.setCardState("456");
				PropertyUtil.loadProps();
//				card.setEffetTime(new Timestamp(20180521));
//				cardDao.insertCard();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
