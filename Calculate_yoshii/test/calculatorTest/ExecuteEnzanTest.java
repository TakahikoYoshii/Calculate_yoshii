package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.BinaryTree;
import calculator.ExecuteEnzan;

public class ExecuteEnzanTest {
	ExecuteEnzan enzan ;
	
	@Before 
	public void setUp(){
		enzan = new ExecuteEnzan();
	}
	@Test
	public void test数式２プラス３を与えるとそれを二分木に構造にしてその一番上のNODEを返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("2+3");
		assertEquals("+", node.getExpression());
	}
	@Test
	public void test数式３まいなす１を与えるとそれを二分木に構造にしてその一番上のNODEを返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("3-1");
		assertEquals("-", node.getExpression());
	}
	@Test
	public void test数式５まいなす２かける２を与えるとそれを二分木に構造にしてその一番上のNODEを返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("5-2×2");
		assertEquals("-", node.getExpression());
	}
	@Test
	public void test数式２プラス３を与えるとそれを二分木に構造にして計算してくれ５を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("2+3");
		int result = enzan.executeEnzan(node);
		assertEquals(5, result);
	}
	@Test
	public void test数式7マイナス２を与えるとそれを二分木に構造にして計算してくれ５を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("7-2");
		int result = enzan.executeEnzan(node);
		assertEquals(5, result);
	}
	@Test
	public void test数式1プラス２かける３を与えるとそれを二分木に構造にして計算してくれ7を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("1+2×3");
		int result = enzan.executeEnzan(node);
		assertEquals(7, result);
	}
	@Test
	public void test数式括弧1プラス２括弧かける３を与えるとそれを二分木に構造にして計算してくれ7を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("(1+2)×3");
		int result = enzan.executeEnzan(node);
		assertEquals(9, result);
	}
	@Test
	public void test数式４わる２プラス３を与えるとそれを二分木に構造にして計算してくれ5を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("4÷2+3");
		int result = enzan.executeEnzan(node);
		assertEquals(5, result);
	}
	@Test
	public void test数式４の２乗プラス３を与えるとそれを二分木に構造にして計算してくれ19を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("4^2+3");
		int result = enzan.executeEnzan(node);
		assertEquals(19, result);
	}
	@Test
	public void test数式5mod2プラス３を与えるとそれを二分木に構造にして計算してくれ4を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("5%2+3");
		int result = enzan.executeEnzan(node);
		assertEquals(4, result);
	}
	@Test
	public void test数式プラスプラスを与えると正しい数式を入力して下さいと返す() {
		String result = enzan.calculateNumericalFomula("++");
		assertEquals("正しい数式を入力して下さい。", result);
	}
	@Test
	public void test数式マイナスかけるを与えると正しい数式を入力して下さいと返す() {
		String result = enzan.calculateNumericalFomula("-×");
		assertEquals("正しい数式を入力して下さい。", result);
	}
	@Test
	public void test数式括弧３プラス２括弧まいなす括弧括弧１プラス２括弧括弧を与えるとそれを二分木に構造にして計算してくれ4を返す() throws Exception {
		BinaryTree node = enzan.convertBinaryTree("(3+2)-((1+2))");
		int result = enzan.executeEnzan(node);
		assertEquals(2, result);
	}
}
