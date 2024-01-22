class Solution {
    public double solution(int[] numbers) {
        
        double avg = 0;
        int sum = 0;
        int size = numbers.length;
        
        for (int number : numbers) {
            sum += number;
        }
        
        avg = (double) sum / size;
        return avg;
    }
}