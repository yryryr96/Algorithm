import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Integer value = map.getOrDefault(genres[i], 0);
            map.put(genres[i], value+plays[i]);
        }

        List<String> rank = new ArrayList<>(map.keySet());
        rank.sort((a,b) -> map.get(b) - map.get(a));

        for (String s : rank) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < plays.length; i++) {
                if (s.equals(genres[i])) arr.add(i);
            }

            arr.sort((a,b) -> plays[b] - plays[a]);

            if (arr.size() > 2) {
                for (int i = 0; i < 2; i++) {
                    answer.add(arr.get(i));
                }
            } else {
                for (int i = 0; i < arr.size(); i++) {
                    answer.add(arr.get(i));
                }
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}