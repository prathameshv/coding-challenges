/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hard;

/**
 *
 * @author Prathamesh Verlekar
 */
public class ProductOfArrayExceptSelf {
    
    public static void main(String[] args) {
        
        int[] testInputArr = new int[]{1,2,3,4,5};
        
        //Brute force
        int[] prodArr = productExceptSelfBruteForce(testInputArr);
        
        //Print arr
        System.out.println("Brute Force Result");
        for(int i=0; i< prodArr.length; i++){
            if(i == prodArr.length-1)
                System.out.println(prodArr[i]);
            else
                System.out.print(prodArr[i] + ",");
        }
        
        //Two arrays
        int[] prodArr2 = productExceptSelfTwoArrays(testInputArr);
        
        //Print arr
        System.out.println("Two Arrays Result");
        for(int i=0; i< prodArr2.length; i++){
            if(i == prodArr2.length-1)
                System.out.println(prodArr2[i]);
            else
                System.out.print(prodArr2[i] + ",");
        }   
        
        //One array
        int[] prodArr3 = productExceptSelfOneArray(testInputArr);
        
        //Print arr
        System.out.println("One Array Result");
        for(int i=0; i< prodArr3.length; i++){
            if(i == prodArr3.length-1)
                System.out.println(prodArr3[i]);
            else
                System.out.print(prodArr3[i] + ",");
        }  
        
    }
    /**
     * Brute Force approach.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * Auxiliary Space: O(n)
     * @param nums
     * @return int array of products
     */
    public static int[] productExceptSelfBruteForce(int[] nums) {
    
        if(nums == null || nums.length == 0)
            return null;
        
        int[] result = new int[nums.length];
        int ans = 1;
        
        for(int i=0; i< nums.length; i++){
            
            for(int j=0; j< nums.length; j++){
                if(i!=j){
                    ans = ans*(nums[j]);
                }
            }
            result[i] = ans;
            ans = 1;
        }
        return result;
    }    
    
    /**
     * O(n) approach
     * Use two arrays
     * Left array stores product of elements to the left of i, excluding i
     * Right array stores product of elements to the right of i, excluding i
     * Result is product of left and right arrays
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Auxiliary Space: O(n)
     * @param nums
     * @return 
     */
    public static int[] productExceptSelfTwoArrays(int[] nums){
        int[] ans = new int[nums.length];
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int i=0;
        
        //initialize 1st element of left and last element of right to 1
        left[0] = 1;
        right[nums.length -1] = 1;
        
        //Evaluate left array
        for(i=1;i<nums.length;i++){
            left[i] = nums[i-1]*left[i-1]; 
        }
        
        //Evaluate right array
        for(i=nums.length-2;i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }
        //Evaluate result array
        for(i=0; i<ans.length;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
    }

    /**
     * O(n) approach
     * Use one array
     * First pass, evaluate elements to the left of i, excluding i
     * Second pass, evaluate elements to the right of i, excluding i
     * Result array updated at the end of 2 passes
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Auxiliary Space: O(1)
     * @param nums
     * @return 
     */    
    public static int[] productExceptSelfOneArray(int[] nums){
        int[] ans = new int[nums.length];
        
        int i=0, temp=1, n=nums.length;
        
        //Init ans array to 1
        for(i=0;i<n-1;i++){
            ans[i]=1;
        }
        
        //Left side
        for(i=0;i<n;i++){
            ans[i] = temp;
            temp*=nums[i];
        }
        
        temp=1;
        
        //Right side
        for(i=n-1;i>=0;i--){
            ans[i]*=temp;
            temp*=nums[i];
        }
        
        return ans;
    }
}
