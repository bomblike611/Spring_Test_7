package com.iu.aop.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class TransferService {
	@Inject
	private Transport transport;
	@Inject
	private CardCheck cardCheck;
	
	public void start(){
		transport.bus();
		transport.subway();
	}
}
