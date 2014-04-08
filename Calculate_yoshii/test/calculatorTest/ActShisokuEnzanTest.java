package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.ActShisokuEnzan;

public class ActShisokuEnzanTest {
	ActShisokuEnzan shisoku = new ActShisokuEnzan();
	
	@Test
	public void test２と３とプラスオペレーターを渡すと５が返ってくる() {
		int answer = (int)shisoku.actEnzan(2, 3, "+");
		assertEquals(5, answer);
	}
	@Test
	public void test３と１とマイナスオペレーターを渡すと２が返ってくる() {
		int answer = (int)shisoku.actEnzan(3, 1, "-");
		assertEquals(2, answer);
	}
	@Test
	public void test２と３とカケルオペレーターを渡すと６が返ってくる() {
		int answer = (int)shisoku.actEnzan(2, 3, "×");
		assertEquals(6, answer);
	}
	@Test
	public void test4と2とわるオペレーターを渡すと2が返ってくる() {
		int answer = (int)shisoku.actEnzan(4, 2, "÷");
		assertEquals(2, answer);
	}
	@Test
	public void test３７と４と余りを表すオペレーターを渡すと５が返ってくる() {
		int answer = (int)shisoku.actEnzan(37, 4, "%");
		assertEquals(1, answer);
	}
	@Test
	public void test３と４と乗数を表すオペレーターを渡すと５が返ってくる() {
		int answer = (int)shisoku.actEnzan(3, 4, "^");
		assertEquals(81, answer);
	}
	@Test
	public void test５の０乗は１が返ってくる() {
		int answer = (int)shisoku.actEnzan(5, 0, "^");
		assertEquals(1, answer);
	}

}
