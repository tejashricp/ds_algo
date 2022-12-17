package dp;

public class KadaneAlgorithm {

    public static int getMaxSum(int arr[]){
        int n = arr.length;
        int cmax =arr[0];
        int omax =arr[0];

        for(int i=1;i<n;i++){
            if(arr[i] > arr[i] + cmax){ // if i am better than the legacy
                cmax = arr[i];
            } else {
                cmax = arr[i] + cmax;
            }

            if(cmax > omax){
                omax = cmax;
            }
        }

        return omax;
    }

    public static void main(String args){

    }

}
