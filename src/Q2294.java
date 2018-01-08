/*
문제 : n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그러면서 동전의 개수가 최소가 되도록 하려고 한다. (각각의 동전은 몇개라도 사용할 수 있다.)
입력 : 첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.
출력 : 첫째줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.
 */

import java.util.Scanner;

public class Q2294 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int[] prices= new int[K];
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i]=input.nextInt();
            prices[coin[i]-1]=1;
        }
/*        for(int i=0;i<K;i++){
            System.out.print(prices[i]+" ");
        }
        System.out.println();*/
        for(int i=0;i<K;i++){
             if(prices[i]!=0){
                for(int j=0;j<N;j++){
                    System.out.println(i+coin[j]);
                    if(i+coin[j]<K&&(prices[i+coin[j]]==0||prices[i+coin[j]]>prices[i])){
                        prices[i+coin[j]]=prices[i]+1;
                    }
                }
            }
/*            for(int a=0;a<K;a++){
                System.out.print(prices[a]+" ");
            }
            System.out.println();*/
        }
        if(prices[K-1]==0)
            System.out.println(0);
        else
            System.out.println(prices[K-1]);
    }
}
