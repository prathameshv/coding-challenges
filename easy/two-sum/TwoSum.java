/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easy;

import java.util.HashMap;

/**
 *
 * @author pv044038
 */
public class TwoSum {
    public static void main(String[] args) {
        
        System.out.println("Two Sum by Brute Force Approach");
        int[] ret;
        
        ret = twoSumBruteForce(new int[]{10, 15, 3, 7}, 17);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");
        
        System.out.println("Two Sum by Hashmap approach");
        ret = twoSumOptimized(new int[]{7, 9, 3, 4}, 13);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");        
        
    }
    
    public static int[] twoSumBruteForce(int[] numbers, int sum){
        
        if(numbers == null || numbers.length < 2)
            return new int[]{0, 0};
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i] + numbers[j] == sum){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0, 0};
    }
    
    public static int[] twoSumOptimized(int[] numbers, int sum){
        
        if(numbers == null || numbers.length < 2)
            return new int[]{0, 0};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(numbers[i])){
                return new int[]{map.get(numbers[i]) ,i};
            }
            else{
                map.put(sum - numbers[i], i);
            }
        }
        return new int[]{0, 0};
    }    
}
