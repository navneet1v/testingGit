/* write a program that accepts 2 int and an airthmatic operator form the command line and performs the operations . fire the follwing user defined exception 
1.if the number of args are less than 3  then fire illegal number of args 
2. if the operator is not an airthmatic operator throw invalid operator exception 
3. If result is negative then throw negative result exception
*/

public class Question2{
	public static void main(String args[]){
	
		try{
			IllegalNumberOfArgsException e = new IllegalNumberOfArgsException();
			if(args.length < 3)
				throw e;
		}catch(IllegalNumberOfArgsException ex){
			System.out.println(ex.toString());
			return ;
		}
	
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		char operator = args[2].charAt(0);
		System.out.println(operator);
		int res = 0;
		try{
			
			if(operator == '+'){				
				res = num1 + num2;
			}else if(operator == '-'){
				res = num1 - num2;
			}else if(operator == '*'){
				res = num1 * num2;
			}else if(operator == '/'){
				res = num1 / num2;
			}else{
				InvalidOperatorException e = new InvalidOperatorException();
				throw(e);
			}
			
			if(res<0){
				NegativeResultException e = new NegativeResultException();
				throw(e);
			}
			
		}catch(InvalidOperatorException ex){
			System.out.println(ex.toString());
			return ;
		}catch(NegativeResultException ex){
			System.out.println(ex.toString());
			return ;
		}catch(Exception e){
			System.out.println("Exception : Cannot divide by zero");
			return ;
		}
		System.out.println("The result is " + res);
	}
	
	public static class IllegalNumberOfArgsException extends Exception{
		public IllegalNumberOfArgsException(){}
		public String toString(){
			return "Exception : Number of args is less ";
		}
	}
	
	public static class InvalidOperatorException extends Exception{
		public InvalidOperatorException(){}
		public String toString(){
			return "Exception : The operator is not valid ";
		}
	}
	
	public static class NegativeResultException extends Exception{
		public NegativeResultException(){}
		public String toString(){
			return "Exception : The result is negative ";
		}
	}
	
	
}
