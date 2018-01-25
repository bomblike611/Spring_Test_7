package com.iu.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transport {
	
	public void bus(){
		System.out.println("============= BUS ===============");
		System.out.println("            유튜브 보기");
		throw new NumberFormatException();
	}
	
	public void subway(){
		System.out.println("============= Subway ===============");
		System.out.println("             노래 감상");
		
	}
	
}
