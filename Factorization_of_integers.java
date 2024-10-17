public class Factorization_of_integers {

	public static void main(String[] args) {
		int[] arr = new int[args.length];
		int minIn = 0;
		int maxIn = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < args[i].toCharArray().length; j++) {
				arr[i] *= 10;
				arr[i] += (int) args[i].toCharArray()[j] - '0';
			}
		}
		for (int i = 0; i < args.length; i++) {
			if (arr[minIn] > arr[i]) {
				minIn = i;
			}
			if (arr[maxIn] < arr[i]) {
				maxIn = i;
			}
		}
		int ts1 = arr[minIn] + 1;
		int ts2 = 0;
		boolean ch = true;
		while (ch) {
			ts1--;
			ch = false;
			for (int i = 0; i < args.length; i++) {
				if (arr[i] % ts1 != 0) {
					ch = true;
				}
			}

		}
		ch = true;
		while (ch) {
			ts2 += arr[maxIn];
			ch = false;
			for (int i = 0; i < args.length; i++) {
				if (ts2 % arr[i] != 0) {
					ch = true;
				}
			}

		}
		System.out.print(ts1 + " " + ts2);
	}

}
