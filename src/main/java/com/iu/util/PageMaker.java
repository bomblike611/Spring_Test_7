package com.iu.util;

public class PageMaker {

	public void pageMaker(int totalCount,ListData listData){
		
		
		
		//1.totalCount
		//2.totalPage
		int totalPage=0;
		if(totalCount%listData.getPerPage()==0){
			totalPage=totalCount/listData.getPerPage();
		}else{
			totalPage=totalCount/listData.getPerPage()+1;
		}
		//3.totalBlock
		int perBlock=5;
		int totalBlock=0;
		if(totalPage%perBlock==0){
			totalBlock=totalPage/perBlock;
		}else{
			totalBlock=totalPage/perBlock+1;
		}
		int curBlock=0;
		if(listData.getCurPage()%perBlock==0){
			curBlock=listData.getCurPage()/perBlock;
		}else{
			curBlock=listData.getCurPage()/perBlock+1;
		}
		//5.startNum,lastNum
		int startNum=(curBlock-1)*perBlock+1;
		int lastNum=curBlock*perBlock;
		
		//6. 
		if(curBlock==totalBlock){
			lastNum=totalPage;
		}
		
		listData.setStartNum(startNum);
		listData.setLastNum(lastNum);
		listData.setCurBlock(curBlock);
		listData.setTotalBlock(totalBlock);
		
	}	
	
}
