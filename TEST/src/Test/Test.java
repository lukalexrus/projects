package Test;

public class Test {

	private double a;
	private double b;
	private double c;
	
	public void Test()
	{                 //Тело начинается на следующей строке
		a=0;
		b=0;
		c=0;
	}
	
	public boolean zero()
	{   if(b==0)         //Тело начинается на этой строке
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void summ(double s1,double s2){ //Тело начинается сразу после метода
		a=s1;
		b=s2;
		c=a+b;		
	}
	
	public void sub(double s1,double s2){ a=s1; //Первая команда на той же строке что и название метода
		b=s2;
		c=a-b;		
	}
	
	public void mul(double s1,double s2)
	
	                                       //Тело начинается не сразу после названия метода
	{
		a=s1;
		b=s2;
		c=a*b;		
	}
	
	public void div(double s1,double s2)
	
	                                     //Тело начинается не сразу после названия метода. 
										 //Первая команда начинается не на следующей строке после скобки.
	
	{
		
		a=s1;
		b=s2;
		if(zero())
		{
		 c=a/b;
		}
		else
		{
			c=0;
			System.out.println("Divide by zero");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Test test=new Test();
		test.sub(3.17,5.5);
		/*test.summ(3.17,5.5);
		 * test.sub(5.5,3.17);
		 * test.mul(3.17,5.5);
		 * test.div(3.17,5.5);
		 * test.div(3.17,0);
		 */
		System.out.println(test.a+" + "+test.b+" = "+test.c);
	}

}
