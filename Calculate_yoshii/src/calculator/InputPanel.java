package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputPanel extends JFrame {
	private static InputPanel frm = null;
	//テキストフィールドのインスタンスを作成
	final JTextField textFieldBi = new JTextField("2進数：");
	final JTextField textField = new JTextField("");
	final JTextField textFieldOct = new JTextField("8進数：");
	final JTextField textFieldHex = new JTextField("16進数：");
//	double stackedValue = 0.0;  //演算子ボタンをおす前の数値
//	boolean isStacked = false;	//演算子ボタンをおす前に数値があったか
//	boolean isAfterOperator = false;		//演算子ボタンを押したかどうか
//	String currentOp = null;		//押された演算子
	private InputPanel() {
		// フレームのタイトル
		setTitle("計算機");
		setLocation(200, 200);
		setSize(500, 500);
		setBackground(Color.LIGHT_GRAY);
		//setVisible(true);
		// ウィンドウを閉じる時
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	public static InputPanel getInstance(){
		if(frm == null){
			return frm = new InputPanel();
		}
		return frm;
	}
	public void makePanel(){
		InputPanel frame = InputPanel.getInstance();
		//JframeよりContentPaneを作成
		Container contentPane = frame.getContentPane();
		//ラベルのインスタンスを作成
//		JLabel label = new JLabel("計算機");
		//ラベルをContentPaneに配置
//		contentPane.add(label, BorderLayout.CENTER);
		//ボタンのインスタンスを作成
		JButton button = new CalculateButton("計算(=)");
		//ボタンをContentPaneに配置
		contentPane.add(button, BorderLayout.SOUTH);
		final JTextArea textarea = new JTextArea(5, 0);
		//スクロールペインにテキストエリアを追加
		JScrollPane scrollPane = new JScrollPane();
		//テキストフィールドをContentPaneに配置
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(4, 1));
		contentPane.add(textPanel, BorderLayout.NORTH);
		textPanel.add(textFieldBi);
		textPanel.add(textFieldOct);
		textPanel.add(textField);
		textPanel.add(textFieldHex);
		textField.setEditable(false);
		textFieldBi.setEditable(false);
		textFieldOct.setEditable(false);
		textFieldHex.setEditable(false);
		//ボタンテーブルを作成
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(6, 4));
		contentPane.add(keyPanel, BorderLayout.CENTER);
		keyPanel.add(new NumberButton(""), 0);
		keyPanel.add(new NumberButton(""), 1);
		keyPanel.add(new NumberButton("("), 2);
		keyPanel.add(new NumberButton(")"), 3);
		keyPanel.add(new NumberButton("mod"), 4);
		keyPanel.add(new NumberButton("^"), 5);
		keyPanel.add(new JButton("c"), 6);
		keyPanel.add(new JButton("d"), 7);
		keyPanel.add(new NumberButton("7"), 8);
		keyPanel.add(new NumberButton("8"), 9);
		keyPanel.add(new NumberButton("9"), 10);
		keyPanel.add(new NumberButton("÷"), 11);
		keyPanel.add(new NumberButton("4"), 12);
		keyPanel.add(new NumberButton("5"), 13);
		keyPanel.add(new NumberButton("6"), 14);
		keyPanel.add(new NumberButton("×"), 15);
		keyPanel.add(new NumberButton("1"), 16);
		keyPanel.add(new NumberButton("2"), 17);
		keyPanel.add(new NumberButton("3"), 18);
		keyPanel.add(new NumberButton("-"), 19);
		keyPanel.add(new NumberButton("0"), 20);
		keyPanel.add(new NumberButton("00"), 21);
		keyPanel.add(new ClearButton("C"), 22);
		keyPanel.add(new NumberButton("+"), 23);		
		frame.setVisible(true);

		frame.setVisible(true);
	}
//	public void initialResult(){
//		textField.setText(null);		
//	}
	public void appendResult(String str){
		if(textField.getText() == "計算式記入")
			textField.setText(null);		
		if(str == "mod"){
			textField.setText(textField.getText() + "%");
		}else{
			textField.setText(textField.getText() + str);
		}
		convertCardinalNumber kisu = new convertCardinalNumber();
		textFieldBi.setText(kisu.toTwoNumber(Integer.parseInt(textField.getText())));
		textFieldOct.setText(kisu.toEightNumber(Integer.parseInt(textField.getText())));
		textFieldHex.setText(kisu.toHexNumber(Integer.parseInt(textField.getText())));
		textField.setEditable(false);
		textFieldBi.setEditable(false);
		textFieldOct.setEditable(false);
		textFieldHex.setEditable(false);
	}
	public void getResult(String result){
		convertCardinalNumber kisu = new convertCardinalNumber();
		textField.setText(result);
		textFieldBi.setText(kisu.toTwoNumber(Integer.parseInt(result)));
		textFieldOct.setText(kisu.toEightNumber(Integer.parseInt(result)));
		textFieldHex.setText(kisu.toHexNumber(Integer.parseInt(result)));
		textField.setEditable(false);
		textFieldBi.setEditable(false);
		textFieldOct.setEditable(false);
		textFieldHex.setEditable(false);
	}
	//数字ボタンの定義
	private class NumberButton extends JButton implements ActionListener{
		public NumberButton(String str){
			//JButtonのコンストラクタ
			super(str);
			this.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent eve){
			String keyNumber = this.getText();
			appendResult(keyNumber);
		}
	}
	private class CalculateButton extends JButton implements ActionListener{
		public CalculateButton(String str){
			super(str);
			this.addActionListener(this);			
		}
		public void actionPerformed(ActionEvent eve){
			ExecuteEnzan executeEnzan = new ExecuteEnzan();
			String result = executeEnzan.calculateNumericalFomula(textField.getText());
			getResult(result);
		}
	}
	//オペレーターボタンの定義
//	private class OperatorButton extends JButton implements ActionListener{
//		public OperatorButton(String str){
//			super(str);
//			this.addActionListener(this);
//		}
//		public void actionPerformed(ActionEvent eve){
//			if(isStacked){
//				double resultValue = (Double.valueOf(textField.getText())).doubleValue();
//				ActShisokuEnzan act = new ActShisokuEnzan();
//				if(!currentOp.equals("="))
//					textField.setText(String.valueOf(act.actEnzan(stackedValue, resultValue, currentOp)));
//			}
//			isAfterOperator = true;
//			currentOp = this.getText();
//			stackedValue = (Double.valueOf(textField.getText())).doubleValue();//明示的なboxing
//			if(currentOp.equals("=")){
//				isStacked = false;
//			}else{
//				isStacked = true;
//			}
//		}
//	}
	
	//クリアボタンの定義
	private class ClearButton extends JButton implements ActionListener{
		public ClearButton(String str){
			super(str);
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent eve){
//			stackedValue = 0.0;
//			isAfterOperator = false;
//			isStacked = false;
			textField.setText(null);
			textFieldBi.setText(null);
			textFieldBi.setText("2進数：");
			textFieldOct.setText(null);
			textFieldOct.setText("8進数：");
			textFieldHex.setText(null);
			textFieldHex.setText("16進数：");
		}
	}
	public static void main(String[] args){
		InputPanel inputPanel = getInstance();
		inputPanel.makePanel();
	}
}
