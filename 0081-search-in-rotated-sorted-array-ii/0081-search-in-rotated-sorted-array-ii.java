class Solution {
    public static boolean search(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
            }
            else if(arr[mid]>arr[high]){ 
                if(arr[mid]<target){
                    low = mid+1;
                }
                else{
                    if(arr[low]>target){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
            else{
                if(arr[mid]>target){
                    high = mid-1;
                }
                else{
                    if(arr[high]<target){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
            }
        }
        return false;
    }
}