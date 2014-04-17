package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class ExecuteEnzan {

	public BinaryTree convertBinaryTree(String string) throws Exception {
		BinaryTree node = new BinaryTree(string);
		return node;
	}

	public int executeEnzan(BinaryTree node) {
		OperandMap operandMap = new OperandMap();
		Map opeMap = operandMap.getOperandMap();
	    if (node.left != null && node.right != null) {
		      int leftOperand  = executeEnzan(node.left);
		      int rightOperand = executeEnzan(node.right);
		      Operand operand = (Operand) opeMap.get(node.getExpression());
		      return operand.execute(leftOperand, rightOperand);
	    }else {
		      return Integer.parseInt(node.getExpression());
	    }
	}

	public String calculateNumericalFomula(String text) {
		BinaryTree node;
		try {
			node = this.convertBinaryTree(text);
		} catch (Exception e) {
			return "正しい数式を入力して下さい。";
		}
		
		if(this.checkText(text)){
			return String.valueOf(this.executeEnzan(node));
		}
		return "正しい数式を入力して下さい。";
	}

	private boolean checkText(String text) {
		if(Pattern.matches(".*[\\+,\\-,\\×,\\÷,\\,^,\\%]{2,}.*", text))
			return false;
		return true;
	}
}
