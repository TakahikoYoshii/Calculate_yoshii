package calculator;

public class BinaryTree {
	private String expression;
	public BinaryTree left;
	public BinaryTree right;
	
	public String getExpression(){
		return this.expression;
	}

	public BinaryTree(String expression) throws Exception{
		this.expression = expression;
		this.parse();
	}
	private void parse() throws Exception{
		int position = -1;//優先度が一番低い演算子の位置
		int nest = 0;//括弧の数
		int priority = 0;//各演算子の優先度
		int lowestPriority = 3;//演算子の優先度の最小値
		for(int i=0 ; i<expression.length()-1 ; i++){
			switch(expression.charAt(i)){
			case'+':priority=1;break;
			case'-':priority=1;break;
			case'×':priority=2;break;
			case'÷':priority=2;break;
			case'^':priority=3;break;
			case'%':priority=3;break;
			case'(':nest++;continue;//括弧内の方が優先度が高い
			case')':nest--;continue;
			default:continue;
			}
			if(nest == 0 && priority <= lowestPriority){
				lowestPriority = priority;
				position = i;
			}
		}
		if(position < 0){
//			System.out.println("OK");
			left = null;
			right = null;
			return;
		}
		//演算子より左の式を左のノードに入れる
		left = new BinaryTree(removeBracket(this.expression.substring(0, position)));
		//演算子より右の式を右のノードに入れる
		right = new BinaryTree(removeBracket(this.expression.substring(position+1)));
		//自身の値を演算子のみに入れ直す
		this.expression = this.expression.substring(position, position+1);
	}
	private String removeBracket(String str) throws Exception {
		if (!(str.startsWith("(") && str.endsWith(")")))//括弧で始まっていなければ、そのまま返す
			return str;
		
		int nest = 1;

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '(')
				nest++;
		    else if (str.charAt(i) == ')')
		        nest--;
			if (nest == 0)
		        return str;
		}

		if (nest != 1)
			throw new Exception("unbalanced bracket: " + str);

		str = str.substring(1, str.length() - 1);

		if (str.startsWith("("))
			return removeBracket(str);
		else
			return str;
	}

	
	public StringBuilder inOrderTraverse(StringBuilder sb) {
		if(left != null){//左があったら左に移動
			left.inOrderTraverse(sb);
		}
		sb.append(expression);
		if(right !=null){//右があったら右に移動
			right.inOrderTraverse(sb);
		}
		return sb;
	}
	
	
}
