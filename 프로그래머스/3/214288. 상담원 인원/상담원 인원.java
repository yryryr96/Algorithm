import java.util.*;

class Solution {
    
    static List<List<int[]>> typeInfo = new ArrayList<>();
    static int N,K;
    static List<List<Integer>> counselComb = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        K = k;
        N = n;
        
        for(int i = 0; i < k+1; i++) {
            typeInfo.add(new ArrayList<>());
        }
        
        for(int[] req : reqs) {
            int s = req[0];
            int e = req[1];
            int t = req[2];
            
            typeInfo.get(t).add(new int[]{s,e});
        }
        
        getCounselComb(0, 0, new ArrayList<>());
        System.out.println(counselComb.size());
        for(List<Integer> comb : counselComb) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            for(int i = 0; i < k; i++) {
                sb.append(comb.get(i) + " ");
                sum += calculate(i+1, comb.get(i));
            }
            System.out.println(sb.toString() + " " + sum);
            ans = Math.min(ans, sum);
        }
        
        answer = ans;
        
        return answer;
    }
    
    static int calculate(int type, int k) {
        
        List<int[]> reqs = typeInfo.get(type);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        int result = 0;
        for(int[] req : reqs) {
            
            if(q.size() == k) {
                
                int[] fastest = q.poll();
                int fastestEnd = fastest[0] + fastest[1];
                
                if(fastestEnd > req[0]) {
                    int waiting = fastestEnd - req[0];
                    result += waiting;
                    q.add(new int[]{fastestEnd, req[1]});
                } else {
                    q.add(new int[]{req[0], req[1]});
                }
                
                
            } else {
                q.add(new int[]{req[0], req[1]});
            }
        }
        
        return result;
    }
    
    static void getCounselComb(int depth, int sum, List<Integer> arr) {
        
        if(depth == K) {
            if(sum == N) {
                counselComb.add(arr);
            }          
            return;
        }
        
        if(sum >= N) return;
        
        for(int i = 1; i <= N; i++) {
            
            List<Integer> nArr = new ArrayList<>(arr);
            nArr.add(i);
            getCounselComb(depth + 1, sum + i, nArr);
        }
    }
}