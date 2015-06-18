//http://a2oj.com/Submission.jsp?ID=69000

package securitycameras;

import java.util.Scanner;

public class SecurityCameras {
    static int minimumCams = 0;
    public static int getMinimumCams(int arr[][]){
        int maxNode = 0;
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            
            int connectedEdges = 0;
            for (int j = 1; j < arr.length; j++)
                connectedEdges += arr[i][j];
            
            if (connectedEdges > tmp){
                maxNode = i;
                tmp = connectedEdges;
            }
        }
        boolean strainEdges = false;
        for (int i=1; i < arr.length; i++) {
            for (int j=1; j < arr.length; j++) {
                if (j == maxNode || i == maxNode)
                    arr[i][j] = 0;
                if (arr[i][j] != 0)
                    strainEdges = true;
            }
        }
        minimumCams++;
        if (strainEdges)
            getMinimumCams(arr);
        return minimumCams;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int [] finalC = new int [T];
        for (int i=0; i<T; i++) {
            int N = scanner.nextInt();
            int E = scanner.nextInt();
            int [][] arr = new int[N+1][N+1];

            for (int j=1; j <= E; j++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                arr[A][B] = 1;
                arr[B][A] = 1;
            }
            finalC[i] = getMinimumCams(arr);
            minimumCams = 0;
        }
    for(int i=0; i<T; i++)
        System.out.println(finalC[i]);
    } 
}
