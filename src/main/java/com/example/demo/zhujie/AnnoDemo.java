package com.example.demo.zhujie;

@MyAnno3
public class AnnoDemo {
	
	public String name;
	
	@Deprecated
	public void show1() {
		
	}
	
	@MyAnno(value = "deepdarkfanstic", show4 = @MyAnno2,show5 = PersonEnum.BILI,
			show3 = {"Do you like van♂游戏？","boy♂next♂door"})
	public void show2() {
		
	}
	
	@MyAnno3
	public void show3() {
		
	}
}
