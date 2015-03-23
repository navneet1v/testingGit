//a program accepts 2 integer as comand line arg it displays all prime numbers between these 2 . using assertions validate the input for thje follwing creiteria . bith should be +ve int and int1< int2 
public class Question1{
	public static void main(String args[]){
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		if(!(num1<=num2 && num1>0 && num2>0))
			return;
		//if(num1<num2)
		//	return;
		System.out.println("Prime numbers between " + num1 + " and " + num2 + " is:");
		for(int i = num1+1 ; i<num2;i++){
			int f = 0;
			for(int j = 2;j < i/2+1 ; j++){
				if(i%j==0){
					f = 1;
					break;
				}
			}
			if(f==0)
				System.out.println(i);
		}		
	}
}