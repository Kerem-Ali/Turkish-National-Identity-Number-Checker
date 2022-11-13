import java.util.stream.IntStream;
import java.util.Scanner;

public class IdentityNumberChecker {

	public static void main(String[] args) {
		
		Scanner scanner= new Scanner (System.in);
		System.out.print("TC kimlik numara kontrolu\nLutfen TC Kimlik numaranizi giriniz: ");
		if(scanner.hasNextLine()) {
			String identityNumber=scanner.nextLine();
			boolean valid=checkLenght(identityNumber)&&checkallnumeric(identityNumber)&&checkFirstnotZero(identityNumber)&&verifyAlgorithm(identityNumber)&&checkLastDigit(identityNumber);
			if(valid) {
				System.out.println("Girdiginiz numara onaylandi!");
			}
			else {
				System.out.println("Girdiginiz numara gecersiz!");
			}
		}
		else {
			System.out.println("HATALI giris yaptiniz!Girdiginiz veriyi kontrol edin!");
		}
		

	}

	public static boolean checkallnumeric(String strNumber) {
		if(strNumber==null || strNumber.length()==0) {return false;}
		
		try {
			long l=Long.parseLong(strNumber);
		}
		catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	
	public static boolean checkLenght(String number) {
		if(number.length()==11) {
			return true;}else {return false;}
	}
	
	public static boolean checkFirstnotZero(String number) {
		return !number.startsWith("0");
	}
	
	public static boolean verifyAlgorithm(String number) {
		int nums[]= new int [number.length()];
		for (int i = 0; i < number.length(); i++) {
            nums[i] = number.charAt(i);}
        
		int firstNums[]=new int [5];
		int counta=0;
		for (int a = 0; a < number.length()-2; a+=2) {
			//System.out.println(counta);
            firstNums[counta] = Integer.parseInt(String.valueOf(number.charAt(a)));
            counta+=1;
            }
        int firstNumsSum=IntStream.of(firstNums).sum();
        //printList(firstNums);
      
        int secondNums[]=new int [5];
        int countb=0;
    	for (int b = 1; b < number.length()-2; b+=2) {
    		//System.out.println(number.charAt(b));
    		secondNums[countb] = Integer.parseInt(String.valueOf(number.charAt(b)));
    		countb+=1;
    		}
    	int secondNumsSum=IntStream.of(secondNums).sum();
    	
    	//System.out.println(firstNumsSum);
    	//System.out.println(secondNumsSum);
    	
    	return (firstNumsSum*7-secondNumsSum)%10==Character.getNumericValue(number.charAt(9));}
	
	public static boolean checkLastDigit(String number) {
		int beforelast[]=new int [10];
		for(int q=0;q<number.length()-1;q++) {
			beforelast[q]=Integer.parseInt(String.valueOf(number.charAt(q)));	
		}
		int lastsum=IntStream.of(beforelast).sum();
		//System.out.println(lastsum);
		return lastsum%10==Integer.parseInt(String.valueOf(number.charAt(number.length()-1)));
	}
	
	
	public static void printList(int[] array) {
		for(int x=0;x<array.length;x++) {
			System.out.println(array[x]);
		}
	}
}