import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class puzzles {

	String palindrome;
	String reveseString;
	public static void main(String[] args) {
		//recursiveReverse("Seattle");	
		//hourGlass();
		
		plusMinus();

	}
	
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<>();
		int aValue = 0;
		int bValue = 0;
				
        for(int i=0; i<a.size(); i++)
        	if(a.get(i)> b.get(i))
        		aValue++;
        	else if(b.get(i)>a.get(i))
        		bValue++;
        
        result.add(aValue);
        result.add(bValue);
        
        return result;

    }
	
	public static void hourGlass()
	{
		int[][] arr = new int[6][6];
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		
		Scanner read = new Scanner(System.in);
		
		for(int i=0; i<6; i++)
			for(int j=0; j<6; j++)
				arr[i][j] = read.nextInt();
		
		for(int k=0; k<=3; k++)
			for(int p=0; p<=3; p++)
			{
				sum =arr[k][p]+arr[k][p+1]+arr[k][p+2]+arr[k+1][p+1]+arr[k+2][p]+arr[k+2][p+1]+arr[k+2][p+2];
				if(sum > maxSum)
					maxSum = sum;
			}
		System.out.println(maxSum);
		read.close();
				
	
	}
	
	public static void iterativeReverse(String input)
	{
		char[] inputChar = input.toCharArray();		
		
		for(int i=inputChar.length-1; i>=0; i--)
			System.out.print(inputChar[i]);		
	}
	
	public static void recursiveReverse(String input)
	{
				
		if(input.isEmpty())
			return;		
		System.out.println((input.substring(1)+input.charAt(0)));
		
	}
	
	public static String format(int value)
	{
		return String.format("%02d", value);
	}
	public static void printMinMax()
	{
		
		String str = "hh:mm:ssAM";
		String str1 = "07:05:45AM";
		int  hours = Integer.parseInt(str1.substring(0, 2));
		int  minutes = Integer.parseInt(str1.substring(3, 5));
		int  seconds = Integer.parseInt(str1.substring(6, 8));
		String  midday = str1.substring(8, 10);
		
		if(midday.contains("PM"))
		{
			if(hours != 12)
				hours = 12+hours;			
		}
		else
		{
			if(hours == 12)
				hours = 00;			
		}
		String formattedHours = String.format("%02d", hours);
		String formattedminutes = String.format("%02d", minutes);
		String formattedseconds = String.format("%02d", seconds);
	
		System.out.println(format(hours)+":"+format(minutes)+":"+format(seconds));
		
		
	}

	public static void diagonalSum()
	{
		int leftDiagonal = 0;
		int rightDiagonal = 0;		
	

		int[][] arr = {{11,2,4},{4,5,6},{10,8,-12}};  
		
		for(int i=0,j=0,k=(arr.length-1),l=0; i<arr.length; i++,j++,k--,l++)
		{
			leftDiagonal += arr[i][j];
			rightDiagonal += arr[k][l];
		}
		
		System.out.println(Math.abs(leftDiagonal-rightDiagonal));
		
	}

	public static void plusMinus()
	{
		//int[] arr = {1,1,0,-1,-1};
		int[] arr = {-4,-3,-9,0,4,1};
		
		double positive= 0.0, negative =0.0, zero = 0.0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] > 0)
				positive++;
			else if(arr[i] < 0)
				negative++;
			else
				zero++;
		}	
		
		double length = arr.length;
		
		String positiveFormat = String.format("%07f", formatPrecision((positive/length),6));
		String negativeFormat = String.format("%07f", formatPrecision((negative/length),6));
		String zeroFormat     = String.format("%07f", formatPrecision((zero/length),6));
		System.out.println(positiveFormat);
		System.out.println(negativeFormat);
		System.out.println(zeroFormat);
	}
	
	public static double formatPrecision(double value, int precision)
	{
		long position = (long)Math.pow(10, precision);
		return ((double)Math.round(value * position)/position);
		
	}


}
