/*
문제 : n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. (각각의 동전은 몇개라도 사용할 수 있다.)
입력 : 첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.
출력 : 첫째줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q2294 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] prices = new int[n];
        for(int i=0;i<n;i++) {
            prices[i] = input.nextInt();
        }
        System.out.println(search(prices,k,1));
    }

    public static int search(int[] prices,int money,int count){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<prices.length;i++){
            if(prices[i]<=money)
            arrayList.add(prices[i]);
        }
        if(arrayList.contains(money)) return count;
        while(!arrayList.isEmpty()){
//            System.out.println(arrayList);
            count++;
            int l = arrayList.size();
            for(int i=0;i<l;i++){
                for(int j=0;j<prices.length;j++){
                    int sum = arrayList.get(i)+prices[j];
                    if(sum==money) return count;
                    if(sum<money&&!arrayList.contains(sum))
                    arrayList.add(sum);
                }
            }
            for(int i=0;i<l;i++){
                arrayList.remove(0);
            }
        }
        return -1;
    }
}
