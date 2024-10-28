import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 이거 완전 KT 1번 완전탐색이랑 똑같다
		// 2^31은 int 범위인 2,140,000,000 정도다
		// 우선 잘 모르겠으니 생각나는 방식으로 완전 완전탐색하자
		// 시간초과 나면.. 다시해.. 다른게 안 떠올라
		int N = Integer.parseInt(br.readLine());

		// 여기서 문자로 합치면 (1, 233, 4) 긴자리를 처리 못해서 안 된다 
		// 숫자들을 문자로 저장하고, 제일 긴 길이 찾기
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				list[i].add(num);
			}

			max = Math.max(max, list[i].size());
			
		}
		
		
		// 길이 1부터 끝까지
		// 가 아니라 파일이 1개 있으면 0개를 비교해도 된다
		loop:
		for(int len = 0; len <= max; len++) {
			
			// 이때 중복되는 지 보게 HashSet에 넣기
			HashSet<String> hs = new HashSet<>();
			
			for(int i = 0; i < N; i++) {
				
				// j번째 파일을 길이 i개로 잘라서 넣는다
				// 길이보다 작은 건 0으로 채워지는데, 그러면 안 넣어도 된다
				if(list[i].size() < len) continue;
				
				// 그게 아니면 중복인지 보기
				String segment = "";
				for(int j = 0; j < len; j++) {
					segment += list[i].get(j);
				}
				
				// 중복이 발생하면, 길이를 다음걸로 넘어가기
				if(hs.contains(segment)) continue loop;
				
				// 그게 아니면 넣기
				else hs.add(segment);
			}
			
			// 여기 온 건 중복이 없어서 온 거다. 이게 최솟값이어서 출력
			System.out.println(len);
			break;
		
		}

	}
}
