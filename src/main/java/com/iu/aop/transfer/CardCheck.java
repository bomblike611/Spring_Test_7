package com.iu.aop.transfer;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CardCheck {
	
	@Around("excution (* com.iu.aop.transfer..Transport.*())")
	public void check(){
		System.out.println("삑-----------------------------");
	}
	
	@Before("excution (* com.iu.aop.transfer..Transport.*())")
	public void fingerPrint(){
		System.out.println("지문 해제ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ");
	}
	
}
