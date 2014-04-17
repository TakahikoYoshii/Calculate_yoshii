package calculatorTest;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import calculator.Operand;
import calculator.OperandMap;

public class OperandMapTest {
	OperandMap operandMap;
	
	@Before 
	public void setUp(){
		operandMap = new OperandMap();
	}
	
	@Test
	public void testオペランドの一覧を取得する＿Map内容確認用テスト() {
		Map map = operandMap.getOperandMap();
        System.out.println(map.keySet());
        System.out.println(map.values());
		assertTrue(true);
	}

	@Test
	public void testプラスのオペランドを渡すとプラスのオペランドを持ったオブジェクトが返される(){
		Operand operand = operandMap.getOperand("+");
		assertEquals("+", operand.getOperand());
	}
	@Test
	public void testマイナスのオペランドを渡すとマイナスのオペランドを持ったオブジェクトが返される(){
		Operand operand = operandMap.getOperand("-");
		assertEquals("-", operand.getOperand());
	}
}
