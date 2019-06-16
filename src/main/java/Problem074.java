
public class Problem074 {
	
	static int getNumberOfTimes(int n, int x) {
		int times = 0;
		
		for (int i = 1; i <= n; i++) {
			if (x % i == 0 && x <= i*n) {
				times++;
			}
		}
		
		return times;
	}

	public static void main(String[] args) {
		System.out.println(getNumberOfTimes(6, 12));//4
		System.out.println(getNumberOfTimes(1, 1));//1
		System.out.println(getNumberOfTimes(2, 4));//1
		System.out.println(getNumberOfTimes(3, 6));//2
	}

}
