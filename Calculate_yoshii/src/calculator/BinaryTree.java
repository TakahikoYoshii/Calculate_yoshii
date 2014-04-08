package calculator;

public class BinaryTree {
	public String expression;
	public BinaryTree left;
	public BinaryTree right;
	
	public BinaryTree(String expression){
		this.expression = expression;
		this.parse();
	}
	private void parse(){
		int position = -1;//優先度が一番低い演算子の位置
		int priority = 0;//各演算子の優先度
		int lowestPriority = 3;//演算子の優先度の最小値
		for(int i=0 ; i<expression.length()-1 ; i++){
			switch(expression.charAt(i)){
			case'+':priority=1;break;
			case'-':priority=1;break;
			case'×':priority=2;break;
			case'÷':priority=2;break;
			default:continue;
			}
			if(priority <= lowestPriority){
				lowestPriority = priority;
				position = i;
			}
		}
		System.out.println(position);
		if(position < 0){
//			System.out.println("OK");
			left = null;
			right = null;
			return;
		}
		//演算子より左の式を左のノードに入れる
		left = new BinaryTree(this.expression.substring(0, position));
		System.out.println(left.expression);
//		left.parse();
		//演算子より右の式を右のノードに入れる
		right = new BinaryTree(this.expression.substring(position+1));
		System.out.println(right.expression);
//		right.parse();
		//自身の値を演算子のみに入れ直す
		this.expression = this.expression.substring(position, position+1);
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
