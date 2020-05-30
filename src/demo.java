import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class demo {
	public static void main(String[] args) {
		int a[] = { 1, 4, 5, 3 }; // 1345
		int b[] = { 4, 5, 1, 1 };// 1145
		int m = 4;
		int n = 3;
		// System.out.println(includes2(a, b, m, n));
		BigInteger c = new BigInteger("1111111111111111");
		BigInteger d = new BigInteger("2222222222222222");
		BigInteger e = c.add(d);
		// System.out.println(e);
		final int COUNT = 10;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 0; i < COUNT; i++) {
			// 进位标志位
			int flag = 0;
			for (int j = list.size() - 1; j >= 0; j--) {
				int p = list.get(j) * 2 + flag;
				flag = p / 10;
				p = p % 10;
				list.set(j, p);
				System.out.println("i:" + i + "\tj:" + j + "\tflag:" + flag + "\tp:" + p + "\tlist:" + list.toString());
			}

			// 最高位添加进位
			if (flag == 1) {
				list.add(0, 1);
				System.out.println("\t" + list.toString());
			}
		}
	}

	public static boolean includes(int a[], int b[], int m, int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			if (!set.contains(a[i])) {
				set.add(a[i]);
			}

		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(b[i])) {
				return false;
			}

		}
		return Boolean.TRUE;
	}

	public static boolean includes2(int a[], int b[], int m, int n) {
		int i = 0, j = 0;
		if (m < n) {
			return false;
		}
		Arrays.sort(a);
		Arrays.sort(b);
		while (i < m && j < n) {
			if (a[i] < b[j])
				i++;
			else if (a[i] == b[j]) {
				i++;
				j++;
			} else if (a[i] > b[j]) {
				return false;
			}
		}
		return true;
	}
}
