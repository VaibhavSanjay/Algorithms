
public class CoinChangeAmount {
	
	private static int[] coinValue = new int[] {1, 5, 10, 25, 50};
	
	public static void main(String[] args) {
		System.out.println(change(18));
	}
	
	public static int change (int value) {
		if (value == 0) {
			return 0;
		} else if (value < 0) {
			return 1000000;
		} else {
			int retVal = 1000000;
			for (int i = 0; i < coinValue.length; i++) {
				retVal = Math.min(retVal, change(value - coinValue[i]));
			}
			return retVal + 1;
		}
	}

}
