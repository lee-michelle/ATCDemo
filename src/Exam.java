
public class Exam {

	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 2, 4, 5, 6, 7 };
		int[] b = { 4, 5, 6 };
		int[] c = { 6 };
		int[] d = { 6, 9 };
		System.out.println(sub(a, b));
	}

	public static int sub(int[] a, int[] b) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < a.length; j++) {
			sb.append(a[j]);
		}
		StringBuffer sbb = new StringBuffer();
		for (int k = 0; k < b.length; k++) {
			sbb.append(b[k]);
		}
		String sStr = sb.toString();
		String bStr = sbb.toString();
		int sustlt = -1;
		sustlt = sStr.lastIndexOf(bStr);
		if (sustlt == -1) {
			return -1;
		}
		return sustlt;
	}

}
