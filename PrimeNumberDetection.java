
public class PrimeNumberDetection {
	
	public static void main(String[] args) {
		int number = 7;
		for (int i =3; i < 200 ; i ++) {
			boolean bPrime = isPrimeNumber(i);
			if (bPrime) 
				System.out.println("Number is prime : " + i);
			else
				System.out.println("Number is not prime : " + i);
		}		
	}
	
	public static boolean isPrimeNumber(int number) {
		if (number > 2) {
			if (number % 2 == 0)
				return false;
			int sqrtofnum = floorsqrt(number);
			//System.out.println(" Square root of a number : " + sqrtofnum);
			for(int i =3; i < sqrtofnum; ) {
				while ( number % i == 0)
					return false;
				i = i + 2;
			}
			return true;
		}	
		return false;
	}
	
	public static int floorsqrt(int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		int i =1, result =1;
		while(result < number) {
			if (result == number)
				return result;
			i++;
			result = i * i;
		}
		return i-1;
	}

}
