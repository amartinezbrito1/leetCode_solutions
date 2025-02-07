class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int reverse=0;
        //creating a copy of original to later compare
        int xcopy=x;

        while(x>0){
            //storage | keep the current num just keep adding next | grabbing the end
            reverse = (reverse*10) + (x % 10);
            //dropping the end 
            x /=10; //same as x =x/10
        }
        return reverse == xcopy;
    }
}
