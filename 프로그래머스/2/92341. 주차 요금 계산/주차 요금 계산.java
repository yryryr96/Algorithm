import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int bt = fees[0]; // basic time
        int bf = fees[1]; // basic fee
        double pt = fees[2]; // per time
        int pf = fees[3]; // per time
        int limit = 23*60 + 59;
        
        Set<Integer> cars = new HashSet<>();
        Map<Integer, Integer> inInfo = new HashMap<>();
        Map<Integer, Integer> outInfo = new HashMap<>();
        Map<Integer, Integer> totalMinuteInfo = new HashMap<>();
        Map<Integer, Boolean> flag = new HashMap<>();
        
        // records -> "시각 차량번호 내역"
        for(String record : records) {
            
            String[] info = record.split(" ");
            int time = timeToMinute(info[0]);
            int carNumber = Integer.parseInt(info[1]);
            String history = info[2];
                        
            if (history.equals("IN")) {
                inInfo.put(carNumber, time);
                flag.put(carNumber, false);
            } else {
                int inTime = inInfo.get(carNumber);
                int totalMinute = totalMinuteInfo.getOrDefault(carNumber, 0);
                
                totalMinuteInfo.put(carNumber, totalMinute + (time - inTime));
                outInfo.put(carNumber, totalMinute + (time - inTime));
                
                flag.put(carNumber, true);
            }
            
            cars.add(carNumber);
        }
        
        for(int car : cars) {
            
            boolean f = flag.getOrDefault(car, true);
            if (!f) {
                int time = totalMinuteInfo.getOrDefault(car, 0);
                totalMinuteInfo.put(car, time + (limit - inInfo.get(car)));
            }
        }
        
        List<int[]> result = new ArrayList<>();
        
        for(int car : cars) {
                        
            double time = (double) totalMinuteInfo.get(car);
            // double time = 0;
            int fee = bf;
            
            if(time > bt) {
                int f = (int) Math.ceil((time - bt) / pt) * pf;
                fee += f;   
            }

            result.add(new int[]{car, fee});
        }
        
        answer = new int[result.size()];
        Collections.sort(result, (a,b) -> a[0] - b[0]);
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i)[1];
        }
                
        return answer;
    }
    
    
    
    static int timeToMinute(String time) {
        
        String[] info = time.split(":");
        int hour = Integer.parseInt(info[0]) * 60;
        int minute = Integer.parseInt(info[1]);
        
        return hour + minute;
    }
}