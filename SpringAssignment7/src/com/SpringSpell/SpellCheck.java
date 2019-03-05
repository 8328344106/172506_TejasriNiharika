package com.SpringSpell;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
public class SpellCheck {

	public static void main(String[] args) 
	{
		

				// TODO Auto-generated method stub
				ExpressionParser parser = new SpelExpressionParser();
				Expression exp = parser.parseExpression("'Hello World'");
				String message = (String) exp.getValue();
				System.out.println(message);

	}

}
