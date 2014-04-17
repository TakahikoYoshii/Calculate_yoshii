package calculatorTest;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.BinaryTree;

public class BinaryTreeTest {

	@Test
	public void test数式２プラス３を渡して二分木を作成して通りがけ順で走査して表示すると２プラス３と表示される() throws Exception {
		BinaryTree root = new BinaryTree("2+3");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("2+3", binary.toString());
	}
	@Test
	public void test数式４マイナス２を渡して二分木を作成して通りがけ順で走査して表示すると４マイナス２と表示される() throws Exception {
		BinaryTree root = new BinaryTree("4-2");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("4-2", binary.toString());
	}
	@Test
	public void test数式５かける８を渡して二分木を作成して通りがけ順で走査して表示すると５かける８と表示される() throws Exception {
		BinaryTree root = new BinaryTree("5×8");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("5×8", binary.toString());
	}
	@Test
	public void test数式１２わる４を渡して二分木を作成して通りがけ順で走査して表示すると１２わる４と表示される() throws Exception {
		BinaryTree root = new BinaryTree("12÷4");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("12÷4", binary.toString());
	}
	@Test
	public void test数式２プラス３かける４を渡して二分木を作成して通りがけ順で走査して表示すると２プラス３かける４と表示される() throws Exception {
		BinaryTree root = new BinaryTree("2+3×4");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("2+3×4", binary.toString());
	}
	@Test
	public void test数式２かける３プラス４を渡して二分木を作成して通りがけ順で走査して表示すると２かける３プラス４と表示される() throws Exception {
		BinaryTree root = new BinaryTree("2×3+4");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("2×3+4", binary.toString());
	}
	@Test
	public void test数式１かける２まいなす３プラス４わる５を渡して二分木を作成して通りがけ順で走査して表示すると１かける２まいなす３プラス４わる５と表示される() throws Exception {
		BinaryTree root = new BinaryTree("1×2-3+4÷5");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("1×2-3+4÷5", binary.toString());
	}
	@Test
	public void test数式括弧１プラス２括弧かける３を渡して二分木を作成して通りがけ順で走査して表示すると１かける２まいなす３プラス４わる５と表示される() throws Exception {
		BinaryTree root = new BinaryTree("(1+2)×3");
		StringBuilder binary = new StringBuilder();
		root.inOrderTraverse(binary);
		assertEquals("1+2×3", binary.toString());
	}
}
