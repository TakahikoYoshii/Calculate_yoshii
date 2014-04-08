package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputPanel extends JFrame {
	private static InputPanel frm = null;
	//テキストフィールドのインスタンスを作成
	final JTextField textFieldBi = new JTextField("2進数：");
	final JTextField textField = new JTextField();
	final JTextField textFieldOct = new JTextField("8進数：");
	final JTextField textFieldHex = new JTextField("16進数：");
	double stackedValue = 0.0;  //演算子ボタンをおす前の数値
	boolean isStacked = false;	//演算子ボタンをおす前に数値があったか
	boolean isAfterOperator = false;		//演算子ボタンを押したかどうか
	String currentOp = null;		//押された演算子
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
		JButton button = new OperatorButton("計算(=)");
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
		//ボタンテーブルを作成
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(5, 4));
		contentPane.add(keyPanel, BorderLayout.CENTER);
		keyPanel.add(new OperatorButton("mod"), 0);
		keyPanel.add(new OperatorButton("^"), 1);
		keyPanel.add(new JButton("c"), 2);
		keyPanel.add(new JButton("d"), 3);
		keyPanel.add(new NumberButton("7"), 4);
		keyPanel.add(new NumberButton("8"), 5);
		keyPanel.add(new NumberButton("9"), 6);
		keyPanel.add(new OperatorButton("÷"), 7);
		keyPanel.add(new NumberButton("4"), 8);
		keyPanel.add(new NumberButton("5"), 9);
		keyPanel.add(new NumberButton("6"), 10);
		keyPanel.add(new OperatorButton("×"), 11);
		keyPanel.add(new NumberButton("1"), 12);
		keyPanel.add(new NumberButton("2"), 13);
		keyPanel.add(new NumberButton("3"), 14);
		keyPanel.add(new OperatorButton("-"), 15);
		keyPanel.add(new NumberButton("0"), 16);
		keyPanel.add(new NumberButton("."), 17);
		keyPanel.add(new ClearButton("C"), 18);
		keyPanel.add(new OperatorButton("+"), 19);		frame.setVisible(true);

		frame.setVisible(true);
	}
	public void appendResult(String str){
		if(!isAfterOperator){
			textField.setText(textField.getText() + str);
		}else{
			textField.setText(str);
			isAfterOperator = false;
		}
		convertCardinalNumber kisu = new convertCardinalNumber();
		textFieldBi.setText(kisu.toTwoNumber(Integer.parseInt(textField.getText())));
		textFieldOct.setText(kisu.toEightNumber(Integer.parseInt(textField.getText())));
		textFieldHex.setText(kisu.toHexNumber(Integer.parseInt(textField.getText())));
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
	
	//オペレーターボタンの定義
	private class OperatorButton extends JButton implements ActionListener{
		public OperatorButton(String str){
			super(str);
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent eve){
			if(isStacked){
				double resultValue = (Double.valueOf(textField.getText())).doubleValue();
				ActShisokuEnzan act = new ActShisokuEnzan();
				if(!currentOp.equals("="))
					textField.setText(String.valueOf(act.actEnzan(stackedValue, resultValue, currentOp)));
			}
			isAfterOperator = true;
			currentOp = this.getText();
			stackedValue = (Double.valueOf(textField.getText())).doubleValue();//明示的なboxing
			if(currentOp.equals("=")){
				isStacked = false;
			}else{
				isStacked = true;
			}
		}
	}
	
	//クリアボタンの定義
	private class ClearButton extends JButton implements ActionListener{
		public ClearButton(String str){
			super(str);
			this.addActionListener(this);
		}
		public void actionPerformed(ActionEvent eve){
			stackedValue = 0.0;
			isAfterOperator = false;
			isStacked = false;
			textField.setText(null);
			textFieldBi.setText(null);
			textFieldOct.setText(null);
			textFieldHex.setText(null);
		}
	}
	public static void main(String[] args){
		InputPanel inputPanel = getInstance();
		inputPanel.makePanel();
	}
}
