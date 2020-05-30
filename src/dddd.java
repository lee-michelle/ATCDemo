import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class dddd {
	public static void main(String[] args) {
		String A = "123456789123456789123456789";
		String B = "123456789123456789123456789";
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < A.length(); i++) {

			listA.add(i, Integer.parseInt(String.valueOf(A.charAt(i))));
		}
		for (int i = 0; i < B.length(); i++) {
			listB.add(i, Integer.parseInt(String.valueOf(B.charAt(i))));
		}
		final int COUNT = 10;
		list.add(1);
		for (int i = 0; i < COUNT; i++) {
			// 进位标志位
			int flag = 0;
			for (int j = list.size() - 1; j >= 0; j--) {
				int p = listA.get(i) + listB.get(i) + flag;
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
