package allProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BJ_1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		HashMap<Integer, String> neverHeard = new HashMap<>();
		HashMap<Integer, String> neverSeen = new HashMap<>();


		for(int i = 0; i < N; i++) {
			String input = sc.nextLine();
			neverHeard.put(i, input);
		}
		for(int i = 0; i < M; i++) {
			String input = sc.nextLine();
			neverSeen.put(i, input);
		}
		
		
		for(int i = 0; i < M; i++) {
			System.out.println(neverSeen.get(i));
		}
			
//		ArrayList<String> match = new ArrayList<>();
//		int count = 0;
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				if(neverHeard[i].equals(neverSeen[j]) == true) {
//					match.add(count, neverHeard[i]);
//					count++;
//				}
//			}
//		}
		
		
		ArrayList<String> match = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(neverSeen.containsValue(neverHeard.get(i))) {
				match.add(neverHeard.get(i));
				count++;
			}
		}

		Collections.sort(match);
//		if(match.isEmpty() == false) {
			System.out.println(count);
			for(int i = 0; i < count; i++) {
				System.out.println(match.get(i));
			}
//		} 
	}
}
