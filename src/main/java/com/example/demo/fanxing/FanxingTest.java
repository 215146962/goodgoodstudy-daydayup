package com.example.demo.fanxing;

public class FanxingTest {

	public static void main(String[] args) {
		Object1<String> obj = new Object1<String>();
		obj.setObj("HelloWorld");
		System.out.println(obj.getObj());
		System.out.println(Object1.fun("van"));
		System.out.println("------------泛型接口");
		Object2 obj2=new Object2();
		System.out.println("1+2="+obj2.add(1.0, 2.0));
	}

}

class Object1<T> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public static <C>C fun(C obj) {
		
		return obj;
	}
}

class Object2 implements CalGeneric<Double>{

	@Override
	public Double add(Double a, Double b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
}

interface CalGeneric <T>{
	T add(T a,T b);
}
