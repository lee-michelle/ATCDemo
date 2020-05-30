import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigIntegers {
	public static void main(String[] args) {
		String A = "123456789123456789123456789";
		String B = "123456789123456789123456789";
		String C = "1";
		String D = "2";
		String E = "123456789123456789123";
		String F = "123456789123456789123456789";
		String G = "123456789123456789123";
		String H = "123456789123";
		BigInteger bgA = new BigInteger(G);
		BigInteger bgB = new BigInteger(H);
		BigInteger i = bgA.add(bgB);
		System.out.println(i);
		System.out.println(sub(G, H));
	}

	public static String sub(String A, String B) {
		if (!isNumeric(A) || !isNumeric(B)) {
			return "ERROR";
		}
		ArrayList<Integer> listA = new ArrayList<Integer>();
		ArrayList<Integer> listB = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			listA.add(i, Integer.parseInt(String.valueOf(A.charAt(i))));
		}
		for (int i = 0; i < B.length(); i++) {
			listB.add(i, Integer.parseInt(String.valueOf(B.charAt(i))));
		}
		list.add(1);
		int m = listA.size();
		int n = listB.size();
		int flag = 0;
		if (m < n) {
			for (int i = 0; i < n - m; i++) {
				listA.add(i, 0);
			}
		}
		if (m >= n) {
			for (int i = 0; i < m - n; i++) {
				listB.add(i, 0);
			}
		}
		for (int i = listA.size() - 1; i >= 0; i--) {
			int p = listA.get(i) + listB.get(i) + flag;
			flag = p / 10;
			p = p % 10;
			list.set(0, p);
			if (flag == 1) {
				list.add(0, 1);
			}
			if (flag == 0) {
				list.add(0, 0);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (!(i == 0 && list.get(i) == 0)) {
				sb.append(list.get(i));
			}
		}
		return sb.toString();
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
}
