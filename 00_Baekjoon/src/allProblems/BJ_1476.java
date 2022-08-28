package allProblems;

import java.util.Scanner;

public class BJ_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt() - 1;	// E의 범위 1 ~ 15
		int S = sc.nextInt() - 1;	// S의 범위 1 ~ 28
		int M = sc.nextInt() - 1;	// M의 범위 1 ~ 19
		int year = 0;
		
		while(true) {
				if(year % 15 == E && year % 28 == S && year % 19 == M) {
					System.out.println(year + 1);
					break;
				}
				year++;
		}
	}
}

/* 모듈러하면 나머지가 0 ~ 14인데
 * 문제에서 나머지가 1 ~ 15인게 문제다
 * 전체적으로 1을 빼준 다음에 나중에 더해주면 된다
 * 이럴경우 year 시작을 0부터 해야지 1부터 하게 된다.
 */