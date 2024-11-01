package answers;

public class CaesarCipher {

    //this will hold the shift value we are using
    //it is final because we won't change it once it is initialized
    private final int shift;

    //initialize class with shift value
    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    //shift letters in order to encode text
    public String encode(String text) {
        //using StringBuilder class to append shifted values to string
        StringBuilder sb = new StringBuilder();

        //loop through the entire string
        for (int i = 0; i < text.length(); i++) {
            //set asc to the ascii value of the char
            //when appending to the string I cast it to the character it represents
            int asc = text.charAt(i);

            /*
            check what the char is
            2: not a letter
            1: uppercase letter
            0/other: lowercase letter
             */
            if (charType(asc) == 2) {
                //since it is not a letter we will append it to string and continue loop
                sb.append((char)asc);
                continue;
            } else if (charType(asc) == 1) {
                asc += shift;
                if (asc > 90) {
                    //if we shift past the ascii values for uppercase
                    //we take amount past and add it to start
                    asc = 64 + (asc % 90);
                }
            } else {
                asc += shift;
                if (asc > 122) {
                    //if we shift past the ascii values for lowercase
                    //we take amount past and add it to start
                    asc = 96 + (asc % 122);
                }
            }
            sb.append((char)asc);
        }

        //we convert StringBuilder into a string and return it
        return sb.toString();
    }

    /*
    This will decode the text
    Logic is the same as encode, but this time we shift the other way
    So refer to that function if something doesn't make sense
     */
    public String decode(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int asc = text.charAt(i);

            if (charType(asc) == 2) {
                sb.append((char)asc);
                continue;
            }
            else if (charType(asc) == 1) {
                asc -= shift;
                if (asc < 65) {
                    asc = 91 - (65 % asc);
                }
            } else {
                asc -= shift;
                if (asc < 97) {
                    asc = 123 - (97 % asc);
                }
            }
            sb.append((char)asc);
        }
        return sb.toString();
    }

    //will determine if uppercase,lowercase, or not a letter
    private int charType(int l) {

        //lowercase are ascii value between 97 and 122
        if (l >= 97 && l <=122) {
            return 0;
        }

        //uppercase are ascii values between 65 and 90
        if (l <= 90 && l >= 65) {
            return 1;
        }

        //returns 2 if not a letter
        return 2;
    }
}
