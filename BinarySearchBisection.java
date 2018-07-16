
public class BinarySearchBisection {
	static double EPS = 0.000000001;
	static double MAX_VALUE = 10000; // replace with the max value we can get for an answer
	static boolean can(double f) {
		// this method should return whether this certain value for the bisection can work or not
		return true; // replace with code
	}
	
	public static void main(String[] args) {
		// binary search the answer, then simulate
		double low = 0.0, high = MAX_VALUE, mid = 0.0, ans = 0.0;
		while (high - low > EPS) {
			mid = (low + high)/2;
			if (can(mid)) {
				ans = mid; // this can be moved to the else if the passing value is on the lower end
				// If the value has to be exactly something, just stick to one
				high = mid;
			} else {
				low = mid;
			}
		}
		System.out.println(ans);
	}

}
