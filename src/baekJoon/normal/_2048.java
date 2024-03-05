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
        // 하... clone()은 얕은 복사였다....
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
        // 오른쪽부터 움직이며 합친다
        // 2 2 2 -> 0 2 4
        // 4 4 4 -> 0 4 8
        // 8 8 8 -> 0 8 16
        int tempK, tempValue;
        // TODO 여기 이렇게 하면 안된다. 2 0 2 같은 예외 케이스가 발생하게 된다.
//        for(int i=0; i<n; i++) {
//            for(int k=n-1; k>=1; k--) {
//                if(arr[i][k-1] == arr[i][k] && arr[i][k] != 0) {
//                    // 오른쪽 -> 왼쪽으로 이동하면서 합치기
//                    arr[i][k] *= 2;
//                    arr[i][k-1] = 0;
//                }
//            }
//        }
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
                }
            }
        }

    }

    public static void left(int[][] arr) {
        // 왼쪽부터 움직이며 합친다
        // 2 2 2 -> 4 2 0
        // 4 4 4 -> 8 4 0
        // 8 8 8 -> 16 8 0
        int tempK, tempValue;
        for(int i=0; i<n; i++) {
            for(int k=0; k<n-1; k++) {
                if(arr[i][k] == arr[i][k+1]  && arr[i][k] != 0) {
                    arr[i][k] *= 2;
                    arr[i][k+1] = 0;
                }
            }
        }
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
                }
            }
        }
    }

    public static void up(int[][] arr) {
        // 2 4 8 -> 4 8 16
        // 2 4 8 -> 2 4 8
        // 2 4 8 -> 0 0 0
        int tempI, tempValue;
        for(int k=0; k<n; k++) {
            for(int i=0; i<n-1; i++) {
                if(arr[i][k] == arr[i+1][k] && arr[i][k] != 0) {
                    arr[i][k] *= 2;
                    arr[i+1][k] = 0;
                }
            }
        }
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
                }
            }
        }
    }

    public static void down(int[][] arr) {
        // 2 4 8 -> 0 0 0
        // 2 4 8 -> 2 4 8
        // 2 4 8 -> 4 8 16
        int tempI, tempValue;
        for(int k=0; k<n; k++) {
            for(int i=n-1; i>=1; i--) {
                if(arr[i][k] == arr[i-1][k] && arr[i][k] != 0) {
                    arr[i][k] *= 2;
                    arr[i-1][k] = 0;
                }
            }
        }
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
                }
            }
        }
    }

}
