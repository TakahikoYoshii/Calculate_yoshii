package calculator;

import java.util.HashMap;
import java.util.Map;


public class OperandMap {
	private Map<String, Operand> operandMap = new HashMap<String, Operand>();
	
	public OperandMap(){
		setOperandMap();
	}
	
	private void setOperandMap(){
		for(Operand operand : Operand.values()){
			operandMap.put(operand.getOperand(), Operand.valueOf(operand.name()));
		}
	}
	public Map getOperandMap(){
		return operandMap;
	}
	
	public Operand getOperand(String operand){
		return operandMap.get(operand);
	}
}
