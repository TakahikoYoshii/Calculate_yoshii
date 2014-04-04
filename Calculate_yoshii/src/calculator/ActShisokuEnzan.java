package calculator;

public class ActShisokuEnzan {
	public double actEnzan(double x, double y, char op){
		switch(op){
		case '+':
			return pulus(x, y);
		case '-':
			return minus(x, y);
		case '×':
			return multi(x, y);
		case '÷':
			return divide(x, y);
		case '%':
			return mod(x, y);
		case '^':
			return raisePower(x, y);
		default:
			return 0/0; 
		}
	}

	private double pulus(double x, double y) {
		return x+y;
	}

	private double minus(double x, double y) {
		return x-y;
	}

	private double multi(double x, double y) {
		return x*y;
	}

	private double divide(double x, double y) {
		return x/y;
	}	

	private double mod(double x, double y) {
		return x%y;
	}
	
	private double raisePower(double x, double y){
		double answer = 1;
		for(int i=0 ; i<y ; i++){
			answer *= x;
		}
		return answer;
	}
}
