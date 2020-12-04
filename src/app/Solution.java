package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream; 

public class Solution { 
    
    public static Map<Integer, Integer> getMax(int[] inputArray){
        Map<Integer, Integer> res = new HashMap<>(); 
        int maxValue = inputArray[0]; 
        int maxIndex = 0;
        for(int i=1;i < inputArray.length;i++){ 
          if(inputArray[i] > maxValue){ 
                maxValue = inputArray[i];
                maxIndex = i;
          } 
        } 
        res.put(maxIndex, maxValue ); 
        return res;
      }
    
    public int[] solution1(int N,int[] A){
        int[]res=new int[N];
        Arrays.fill(res, 0);
        if(A.length>100000){
            System.out.println("la taille de l'array ne doit pas depasser 100,000");
        }
        else {
            for(int k=0;k<A.length;k++){
                int x =A[k];
                if(x>0 && x<N){
                    res[x-1]++;
                }
                else if(x==N+1){
                    for(int j=0;j<N;j++){
                        res[j]=getMax(res).entrySet().iterator().next().getValue();
                    }
                }
                else{
                    System.out.println("chaque valeur de l'array doit etre entre 1 et N");
                }
            }
        }
        return res;
    }

    public int countWays(int n){ 
        int res[] = new int[n+1];  
        int val = 0;  
        res[0] = 1;    
        for(int i = 1; i <= n; i++){  
            int nearesetUnreachableStep = i - 3;  
            int farthestReachableStep = i - 1;  
            if (nearesetUnreachableStep >= 0){  
                val -= res[nearesetUnreachableStep]; 
            }
            val += res[farthestReachableStep]; 
            res[i] = val;  
        }  
        return res[n]; 
    }

    public int[] solution2(int[] A, int[] B){
        int[] res = new int [A.length];
        for (int i =0; i<A.length;i++){
            int x=2*B[i];
            res[i]=countWays(A[i])%x ;
        }
        return res;
    }
    public static int[] removeElement(int[] A,int index){ 
        if (A == null || index < 0 || index >= A.length) { 
            return A; 
        } 
        return IntStream.range(0, A.length).filter(i -> i != index).map(i -> A[i]).toArray(); 
    } 
    public int solution3(int[] A){
        int[] arr = new int[A.length];
        int res=0;
        int j=A.length;
        for (int i=0; i<A.length; i++){
            arr[i] = Math.abs(A[i]);
        }
        while(j>0){
            if(res<=0){
                res+=getMax(arr).entrySet().iterator().next().getValue();
            }else{
                res-=getMax(arr).entrySet().iterator().next().getValue();
            }
            arr=removeElement(arr,getMax(arr).entrySet().iterator().next().getKey());
            j--;
        }
        return res;
        
    }
    
}
