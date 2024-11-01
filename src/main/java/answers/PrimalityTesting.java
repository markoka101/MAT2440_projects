package answers;

public class PrimalityTesting {
    //constructor
    public PrimalityTesting(){}

    //returns true or false if n is prime
    public boolean isPrime(int n) {
        //check if n is 1
        if (n == 1) {
            return false;
        }

        //limit is square root of the number
        int limit = (int)Math.sqrt(n);

        //check all numbers from 2 to limit if factor
        for (int i = 2; i <= limit; i++) {

            //take mod of number and i
            // if it's zero then it's not prime
            if (n % i == 0) {
                return false;
            }
        }

        //if loop ends, it's a prime number
        return true;
    }
}
