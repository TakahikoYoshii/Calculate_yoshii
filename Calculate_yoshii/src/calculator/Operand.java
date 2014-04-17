package calculator;

public enum Operand {
	PLUS("+"){
		public int execute(int x, int y){
			return x+y;
		}
	},
	MINUS("-"){
		public int execute(int x, int y){
			return x-y;
		}		
	},
	MULTI("×"){
		public int execute(int x, int y){
			return x*y;
		}		
	},
	DIVIDE("÷"){		
		public int execute(int x, int y){
			return x/y;
		}
	},
	MOD("%"){		
		public int execute(int x, int y){
			return x%y;
		}
	},
	RAISEPOWER("^"){
		public int execute(int x, int y){
			int answer = 1;
			for(int i=0 ; i<y ; i++){
				answer *= x;
			}
			return answer;
		}
	},
	EMPTY(""){
		public int execute(int x, int y){
			return 0;
		}
	};
	private final String operand;
	Operand(String operand){
		this.operand = operand;
	}
	public String getOperand(){
		return operand;
	}
	public abstract int execute(int x, int y);
}
