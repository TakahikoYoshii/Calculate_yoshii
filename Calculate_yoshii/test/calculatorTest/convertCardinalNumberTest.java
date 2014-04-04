package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.convertCardinalNumber;

public class convertCardinalNumberTest {
	convertCardinalNumber cardinal = new convertCardinalNumber();
	@Test
	public void test２を２進数表示すると１０と文字列で返ってくる() {
		String str = cardinal.toTwoNumber(2);
		String correct = Integer.toBinaryString(2);
		assertEquals(correct, str);
	}
	@Test
	public void test１０を８進数表示すると１２と文字列で返ってくる() {
		String str = cardinal.toEightNumber(10);
		String correct = Integer.toOctalString(10);
		assertEquals(correct, str);
	}
	@Test
	public void test３１を１６進数表示すると１fと文字列で返ってくる() {
		String str = cardinal.toHexNumber(31);
		String correct = Integer.toHexString(31);
		assertEquals(correct, str);
	}
	
}
