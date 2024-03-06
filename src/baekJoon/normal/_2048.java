package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2048 {
    static int n;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        dfs("", arr);
        System.out.println(result);
    }

    public static void dfs(String seq, int[][] arr) {
        if(seq.length() == 5) {
            template(seq, arr);
            return;
        }
        dfs(seq+"R", arr);
        dfs(seq+"L", arr);
        dfs(seq+"U", arr);
        dfs(seq+"D", arr);
    }

    public static void template(String seq, int[][] arr) {
        int[][] clone = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                clone[i][k] = arr[i][k];
            }
        }
        for(int i=0; i<seq.length(); i++) {
            if(seq.charAt(i) == 'R') {
                right(clone);
            } else if(seq.charAt(i) == 'L') {
                left(clone);
            } else if(seq.charAt(i) == 'U') {
                up(clone);
            } else if(seq.charAt(i) == 'D'){
                down(clone);
            }
        }
        // 가장 큰 수 찾기
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                result = Math.max(result, clone[i][k]);
            }
        }
    }

    public static void right(int[][] arr) {
        int tempK, tempValue;
        boolean[][] flag = new boolean[n][n];
        // TODO 여기 이렇게 하면 안된다. 2 0 2 같은 예외 케이스가 발생하게 된다. 여기도 한칸 이동이 아니라 while로 처리해야 함
        for(int i=0; i<n; i++) {
            for(int k=n-1; k>=0; k--) {
                if(arr[i][k] != 0) {
                    tempK = k+1;
                    tempValue = arr[i][k];
                    while(tempK <= n-1 && arr[i][tempK] == 0) {
                        arr[i][tempK] = tempValue;
                        arr[i][tempK-1] = 0;
                        tempK++;
                    }
                    // 멈췄을 때 tempK가 자신과 같다면, 합치고 자신을 0으로 바꾼다.
                    // 2 2 4 2 -> 여기서 8이 나오는 경우를 방지하기 위해서 어쩔 수 없이 boolean 배열을 둬야할 것 같다.
                    if(tempK != n && arr[i][tempK] == tempValue && !flag[i][tempK]) {
                        flag[i][tempK] = true;
                        arr[i][tempK] *= 2;
                        arr[i][tempK-1] = 0;
                    }
                }
            }
        }
    }

    public static void left(int[][] arr) {
        int tempK, tempValue;
        boolean[][] flag = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int k=0; k<=n-1; k++) {
                if(arr[i][k] != 0) {
                    tempK = k-1;
                    tempValue = arr[i][k];
                    while(tempK >= 0 && arr[i][tempK] == 0) {
                        arr[i][tempK] = tempValue;
                        arr[i][tempK+1] = 0;
                        tempK--;
                    }
                    if(tempK >= 0 && arr[i][tempK] == tempValue && !flag[i][tempK]) {
                        flag[i][tempK] = true;
                        arr[i][tempK] *= 2;
                        arr[i][tempK + 1] = 0;
                    }
                }
            }
        }
    }

    public static void up(int[][] arr) {
        int tempI, tempValue;
        boolean[][] flag = new boolean[n][n];
        for(int k=0; k<n; k++) {
            for(int i=0; i<=n-1; i++) {
                if(arr[i][k] != 0) {
                    tempI = i-1;
                    tempValue = arr[i][k];
                    while(tempI >= 0 && arr[tempI][k] == 0) {
                        arr[tempI][k] = tempValue;
                        arr[tempI+1][k] = 0;
                        tempI--;
                    }
                    if(tempI >= 0 && arr[tempI][k] == tempValue && !flag[tempI][k]) {
                        flag[tempI][k] = true;
                        arr[tempI][k] *= 2;
                        arr[tempI+1][k] = 0;
                    }
                }
            }
        }
    }

    public static void down(int[][] arr) {
        int tempI, tempValue;
        boolean[][] flag = new boolean[n][n];
        for(int k=0; k<n; k++) {
            for(int i=n-1; i>=0; i--) {
                if(arr[i][k] != 0) {
                    tempI = i+1;
                    tempValue = arr[i][k];
                    while(tempI <= n-1 && arr[tempI][k] == 0) {
                        arr[tempI][k] = tempValue;
                        arr[tempI-1][k] = 0;
                        tempI++;
                    }
                    if(tempI != n && arr[tempI][k] == tempValue && !flag[tempI][k]) {
                        flag[tempI][k] = true;
                        arr[tempI][k] *= 2;
                        arr[tempI-1][k] = 0;
                    }
                }
            }
        }
    }

}
