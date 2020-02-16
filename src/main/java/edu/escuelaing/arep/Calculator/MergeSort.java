package edu.escuelaing.arep.Calculator;


public class MergeSort {
    public MergeSort() {
    }

    
    public Comparable[] mergeSort(Comparable[] nums) {
        int l = nums.length; 
        if (l <= 1) {
            return nums;
        }
        
        Comparable[] L = new Comparable[l / 2];
        Comparable[] R = new Comparable[l - L.length];
        for (int i=0;i<l/2; i++){
            L[i]=nums[i];
        }
        for (int j =l/2; j<l;j++){
            R[j-l/2]=nums[j];
        }
        L=mergeSort(L);
        R=mergeSort(R);  
        return merge(L, R, nums);
    }
    
    
    private Comparable[] merge(Comparable[]  L,Comparable[]  R, Comparable[] nums){
        int l =0;
        int r=0;
        int n =0;
        
        while(n<nums.length){
            if(l<L.length && r<R.length){
            
            if(L[l].compareTo(R[r])<0){
                nums[n]=L[l];
                n++;
                l++;
                
            }
            else{
                nums[n]=R[r];
                n++;
                r++;
            }
            
            }
            else {
                
                if (l >= L.length) {
                    while (r < R.length) {
                        nums[n] = R[r];
                        n++;
                        r++;
                    }
                }
                if (r >= R.length) {
                    while (l < L.length) {
                        nums[n] = L[l];
                        l++;
                        n++;
                    }
                }
            }
        }
        return nums;
    }
    
}