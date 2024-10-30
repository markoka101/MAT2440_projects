package answers;

public class MaxAndLinear {

    public MaxAndLinear(){}

    public int maxSearch(int[] nums) {
        int max = 0;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

    public boolean linearSearch(int target, int[] nums) {
        for (int n : nums) {
            if (n == target) {
                return true;
            }
        }

        return false;
    }
}
