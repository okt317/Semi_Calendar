package calculator;

import java.util.Scanner;

public class CalLogic {
	public static void main(String[] args) {
		int dap = 0;
		String mid = null;
		int mid_num=0;
		
		Scanner g = new Scanner(System.in);
		System.out.println("첫번째 수를 적으세요");
		String fir_point = g.nextLine();
		int fir_num = Integer.parseInt(fir_point);
		System.out.println("0(+) 1(-) 2(*) 3(/) 중 입력하시오");
		mid = g.nextLine(); 		
		/*
		mid_num = Integer.parseInt(mid);
		for(;mid_num>3;) {
			System.out.println("다시 적어주세요");
			mid = g.nextLine(); 		
			mid_num = Integer.parseInt(mid);
		}
		*/
		
		while(mid.equals("+")|mid.equals("-")) {
			System.out.println("틀렸습니다 다시 적으세요");
			mid = g.nextLine();			
		}
		
		System.out.println("마지막 수를 적으세요");
		String las_point = g.nextLine();
		int las_num = Integer.parseInt(las_point);
		/*
		if (mid == "+") {
			dap = fir_num + las_num;}
		else if (mid == "-")
			dap = fir_num - las_num;
		else if (mid == "*")
			dap = fir_num * las_num;
		else
			dap = fir_num / las_num;
		*/
		
		if (mid_num == 0) {
			dap = fir_num + las_num;}
		else if (mid_num == 1)
			dap = fir_num - las_num;
		else if (mid_num == 2)
			dap = fir_num * las_num;
		else
			dap = fir_num / las_num;
		
		System.out.println(dap);
	}
}
