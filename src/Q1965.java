/* 문제 : 정육면체 모양의 상자들이 일렬로 늘어서 있다. 상자들마다 크기가 주어져 있는데, 앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면, 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수가 있다. 예를 들어 앞에서부터 순서대로 크기가 (1, 5, 2, 3, 7)인 5개의 상자가 있다면, 크기 1인 상자를 크기 5인 상자에 넣고, 다시 이 상자들을 크기 7인 상자 안에 넣을 수 있다. 하지만 이렇게 상자를 넣을 수 있는 방법은 여러 가지가 있을 수 있다. 앞의 예에서 차례대로 크기가 1, 2, 3, 7인 상자들을 선택하면 총 4개의 상자가 한 개의 상자에 들어가게 된다.

상자들의 크기가 주어질 때, 한 번에 넣을 수 있는 최대의 상자 개수를 출력하는 프로그램을 작성하시오.
입력 : 파일의 첫 번째 줄은 상자의 개수 n (1≤n ≤1000)을 나타낸다. 두 번째 줄에는 각 상자들의 크기가 순서대로 주어진다.
출럭 : 첫째 줄에 한 줄에 넣을 수 있는 최대의 상자 개수를 출력한다.
*/

import java.util.Scanner;

public class Q1965 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = input.nextInt();
        }
        int[] boxes = new int[N];
        boxes[0]=1;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(array[i]>array[j]&&boxes[i]<=boxes[j]){
                    boxes[i]=boxes[j]+1;
                }
            }
            if(boxes[i]==0) boxes[i]=1;
        }
        System.out.println(boxes[N-1]);
    }
}
