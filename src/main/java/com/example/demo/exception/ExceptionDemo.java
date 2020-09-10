package com.example.demo.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int i = 41 / 0;
			byte[] bt = new byte[3];
			bt[3] = 4;
		} catch (ArithmeticException e) {
			// System.out.println("除數不能為0");
			System.err.println(e.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			// System.out.println("數組越界");
			System.err.println(e.toString());
		} catch (Exception e) {
			// System.out.println("有異常，但不知道什麽異常");
			System.err.println(e.toString());
		}

	}

}
