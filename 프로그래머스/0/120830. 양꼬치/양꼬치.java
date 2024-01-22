class Solution {
    public int solution(int n, int k) {
        
        int money = 0;
        int lamb = n;
        int beverage = k;
        int LAMB_PRICE = 12000;
        int BEVERAGE_PRICE = 2000;
        
        beverage -= lamb / 10;
        money = lamb*LAMB_PRICE + beverage*BEVERAGE_PRICE;
        return money;
    }
}