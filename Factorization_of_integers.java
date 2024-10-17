public class Prog {
	public static void Factorization_of_integers(String[] args) {
		int n = 0;
		for (int k = 0; k < args.length; k++) {
			for (int j = 0; j < args[k].toCharArray().length; j++) {
				n *= 10;
				n += args[k].toCharArray()[j] - 48;
			}
			int tmp = 1;
			int cold = 1;
			tmp = 1;
			String str = "";
			tmp = 1;
			int[] arr = new int[cold];
			int[] arrst = new int[cold];
			for (int i = 0; i < cold; i++) {
				tmp = nextPrime(tmp);
				arr[i] = tmp;
				tmp++;
				arrst[i] = 0;
			}
			if (isPrime(n)) {
				System.out.println(n + " = " + n + "^" + 1);
			}
			int col = 0;
			while (!isPrime(n)) {
				col++;
				tmp = 1;
				for (int i = cold - 1; i >= 0; i--) {
					if (arrst[i] != 0) {
						tmp *= Math.pow(arr[i], arrst[i]);
					}
				}
				if (tmp < n) {
					arrst[0]++;
				}

				if (Math.pow(arr[cold - 1], arrst[cold - 1]) < n && tmp > n) {
					for (int i = 0; i < cold - 1; i++) {
						if (arrst[i] != 0) {
							int c = 1;
							while (n % arr[i + c] != 0 && i + c < cold - 1) {
								c++;
							}
							arrst[i + c]++;
							arrst[i] = 0;
							break;
						}
					}
				}

				if (tmp > n && Math.pow(arr[cold - 1], arrst[cold - 1]) > n) {
					for (int i = 0; i < cold; i++) {
						arrst[i] = 0;
						if (i == cold - 1) {
							cold++;
							arr = new int[cold];
							arrst = new int[cold];
							tmp = 1;
							for (int j = 0; j < cold; j++) {
								do {
									tmp = nextPrime(tmp);
								} while (n % tmp != 0);
								arr[j] = tmp;
								arrst[j] = 0;
							}
							arrst[cold - 1] = 1;
							break;
						}
					}
				}
				if (arr[cold - 1] > n) {
					System.out.println("Error");
					tmp = n;
					break;
				}
				if (tmp == n) {
					str = "";
					for (int i = 0; i < cold; i++) {
						if (arrst[i] != 0) {
							if (str != "") {
								str += " x ";
							}
							str += arr[i] + "^" + arrst[i];
						}
					}
					System.out.println(n + " = " + str);
					break;
				}
			}
		}
	}
	
	public static int nextPrime(int x) {
		boolean t = true;
		int tmp = x;
		while (t) {
			tmp++;
			t = !isPrime(tmp);
		}
		return tmp;
	}
	
	public static boolean isPrime(int n) {
	   	for(int i = 2; i <= Math.sqrt(n); i++) {
	   		if(n % i == 0) {
	   			return false;
	   		}
	   	}
	   	return true;
	}
	
	public static void main(String[] args) {
		Factorization_of_integers(new String[] {"533321"});
	}
}
