package answers;

public class MaxAndLinear {

    //constructor for class
    public MaxAndLinear(){}

    //This searches for the max value of an array
    public int maxSearch(int[] nums) {
        //initialize max with a value of zero
        int max = 0;

        //enhanced for loop since I don't need the index of the number
        for (int n : nums) {
            //check if the current value is greater than max
            if (n > max) {
                max = n;
            }
        }

        //returns max value
        return max;
    }

    //this will do a linear search of an array for the provided target
    public boolean linearSearch(int target, int[] nums) {
        //Since we're only checking if the element exists I don't need the index
        for (int n : nums) {
            //if n is the target value we return true
            if (n == target) {
                return true;
            }
        }

        //if we made it past the loop the target was not in the array
        return false;
    }
}
