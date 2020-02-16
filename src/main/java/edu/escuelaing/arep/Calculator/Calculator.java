package edu.escuelaing.arep.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private MergeSort sorter;
    public Calculator(){
        sorter = new MergeSort();

    }

    public Double[] Ordenar(String sNumeros){
        List<String> Lnums = Arrays.asList(sNumeros.split(","));
        Double[] nums = new Double[Lnums.size()];
        for(int i=0;i<Lnums.size();i++){
            nums[i]=(Double.valueOf(Lnums.get(i)));
            
        }
        
        Comparable[] numeros=sorter.mergeSort(nums);
        for (int j=0; j<numeros.length;j++){
            nums[j]=Double.valueOf(String.valueOf(numeros[j]));
        }
        
        return nums;
    }

    public Double sumatoria(Double[] numeros){
        Double sum =0.0;
        for (Double d: numeros){
            sum+=d;

        }
        return sum;
    }
}