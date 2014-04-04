package calculator;

import java.util.ArrayList;

public class convertCardinalNumber {

	public String toTwoNumber(int number) {
		ArrayList<Integer> twoNumberArray = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		do{
			twoNumberArray.add(number%2);
			number /= 2;
		}while(number != 0);
		for(int i=twoNumberArray.size()-1 ; i>=0 ; i--){
			sb.append(twoNumberArray.get(i));
		}
		return sb.toString();
	}

	public String toEightNumber(int number) {
		ArrayList<Integer> eightNumberArray = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		do{
			eightNumberArray.add(number%8);
			number /= 8;
		}while(number != 0);
		for(int i=eightNumberArray.size()-1 ; i>=0 ; i--){
			sb.append(eightNumberArray.get(i));
		}
		return sb.toString();	
	}

	public String toHexNumber(int number) {
		ArrayList<Character> hexNumberArray = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder();
		do{
			char hexNumber = convertHexNumber(number%16);
			System.out.println(hexNumber);
			hexNumberArray.add(hexNumber);
			number /= 16;
			System.out.println(number);
		}while(number > 0);
		for(int i=hexNumberArray.size()-1 ; i>=0 ; i--){
			sb.append(hexNumberArray.get(i));
		}
		return sb.toString();	
	}
	public Character convertHexNumber(int number){
		if(number < 10){
			return (char)number;
		}else{
			switch(number){
			case 10:
				return 'a';
			case 11:
				return 'b';
			case 12:
				return 'c';
			case 13:
				return 'd';
			case 14:
				return 'e';
			case 15:
				return 'f';
			default:
				return null;
			}
		}
	}
}
