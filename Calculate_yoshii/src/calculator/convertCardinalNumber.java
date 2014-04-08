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
		ArrayList<String> hexNumberArray = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		do{
			hexNumberArray = convertHexNumber(number%16, hexNumberArray);
			number /= 16;
		}while(number > 0);
		for(int i=hexNumberArray.size()-1 ; i>=0 ; i--){
			sb.append(hexNumberArray.get(i));
		}
		return sb.toString();	
	}
	public ArrayList<String> convertHexNumber(int number, ArrayList<String> hexNumber){
		if(number < 10){
			hexNumber.add(Integer.toString(number));
			return hexNumber;
		}else{
			switch(number){
			case 10:
				hexNumber.add("a");
				return hexNumber;
			case 11:
				hexNumber.add("b");
				return hexNumber;
			case 12:
				hexNumber.add("c");
				return hexNumber;
			case 13:
				hexNumber.add("d");
				return hexNumber;
			case 14:
				hexNumber.add("e");
				return hexNumber;
			case 15:
				hexNumber.add("f");
				return hexNumber;
			default:
				return hexNumber;
			}
		}
	}
}
