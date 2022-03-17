import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_JA_1205_조커_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> numArr = new ArrayList<>();
		int zerocnt = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			numArr.add(num);
			if(num == 0) zerocnt++;
		}
		
		Set<Integer> numSet = new HashSet<>(numArr);
		numArr.clear();
		for (Integer i : numSet) {
			numArr.add(i);
		}
		
		Collections.sort(numArr);
		
		int size = numArr.size();
		int i = 0;
		if(numArr.get(0) == 0) {
			i = 1;
		}
		
		int ans = zerocnt;
		for (; i < size-1; i++) {
			int cnt = 1;
			int canpass = zerocnt;
			int tmpn = 0;
			for (int j = i; j < size-1; j++) {
				if(numArr.get(j)+1+tmpn == numArr.get(j+1)) {
					cnt++;
					tmpn = 0;
				} else {
					if(canpass == 0) break;
					j--;
					canpass--;
					tmpn++;
					cnt++;
				}
			}
			
			cnt += canpass;
			
//			System.out.println(cnt);
			if(cnt > ans) {
				ans = cnt;
			}
		}
		
		System.out.println(ans);
		br.close();
	}

}
/*
1000
348 431 453 0 377 0 355 794 0 0 651 0 0 6 851 400 0 331 0 0 582 781 105 0 0 0 0 0 0 0 0 303 0 0 0 0 0 456 474 0 0 0 0 609 0 0 176 643 0 0 619 746 915 0 0 297 0 764 0 0 0 0 174 575 224 302 930 0 0 750 245 0 816 0 466 65 798 0 319 0 0 797 59 50 0 383 766 898 132 132 0 0 271 334 521 0 775 0 0 0 326 667 0 0 0 0 306 575 0 0 0 830 641 991 815 254 295 0 0 0 818 0 0 0 307 0 0 359 991 0 0 0 149 54 880 364 0 242 0 748 0 0 0 0 13 894 764 0 0 748 981 114 780 948 0 578 678 276 130 431 0 643 0 0 297 0 125 985 0 279 762 0 127 0 0 113 984 383 139 0 636 566 0 340 0 0 0 0 0 0 0 622 0 219 0 0 0 0 329 714 309 766 0 589 0 0 0 306 0 0 851 0 440 475 169 3 285 380 0 0 106 963 317 624 470 960 0 853 0 0 0 0 879 731 386 708 0 366 0 475 112 0 323 0 20 0 0 0 0 0 0 320 0 0 851 903 590 979 356 316 428 0 71 811 0 0 0 476 0 0 0 254 0 0 0 297 0 0 727 0 420 651 753 0 940 0 0 622 612 0 0 0 50 532 0 95 0 798 0 0 0 0 708 0 0 988 975 0 0 0 0 987 0 859 177 0 781 0 0 504 0 0 586 0 221 0 184 0 0 0 0 192 0 0 254 0 284 0 0
 */
