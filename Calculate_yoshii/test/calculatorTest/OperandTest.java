package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.Operand;

public class OperandTest {
	Operand operand ;
	
	@Test
	public void testPLUSのオブジェクトに２と３を渡すと５が返ってくる() {
		operand = Operand.PLUS;
		int result = operand.execute(2, 3);
		assertEquals(5, result);
	}
	@Test
	public void testMINUSのオブジェクトに4と1を渡すと3が返ってくる() {
		operand = Operand.MINUS;
		int result = operand.execute(4, 1);
		assertEquals(3, result);
	}
	@Test
	public void testMULTIのオブジェクトに3と4を渡すと12が返ってくる() {
		operand = Operand.MULTI;
		int result = operand.execute(3, 4);
		assertEquals(12, result);
	}
	@Test
	public void testDIVIDEのオブジェクトに4と2を渡すと2が返ってくる() {
		operand = Operand.DIVIDE;
		int result = operand.execute(4, 2);
		assertEquals(2, result);
	}
	@Test
	public void testMODのオブジェクトに5と３を渡すと2が返ってくる() {
		operand = Operand.MOD;
		int result = operand.execute(5, 3);
		assertEquals(2, result);
	}
	@Test
	public void testRAISEPOWERのオブジェクトに２と３を渡すとが返ってくる() {
		operand = Operand.RAISEPOWER;
		int result = operand.execute(2, 3);
		assertEquals(8, result);
	}
}
