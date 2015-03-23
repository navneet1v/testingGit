/* wruite a program that accepts 2 int and an airhtmatic operator form the command line and performs the operations . fire the follwing user fdefined exception 
1.if the number of args are less than 3  then fire illegal number of args 
2. if the operator is not an airthmatic operator throw invalid operator exception 
3. If result is negative then throw negative result exception
*/

public class Question2{
	public static void main(String args[]){
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		char operator = Charcter.parseChar(args[2]);
		System.out.println(operator);
	}
}
