package answers;

public class CaesarCipher {
    private final int shift;

    //initialize class with shift value
    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    //shift letters in order to encode text
    public String encode(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int asc = text.charAt(i);

            if (charType(asc) == 2) {
                sb.append((char)asc);
                continue;
            } else if (charType(asc) == 1) {
                asc += shift;
                if (asc > 90) {
                    asc = 64 + (asc % 90);
                }
            } else {
                asc += shift;
                if (asc > 122) {
                    asc = 96 + (asc % 122);
                }
            }
            sb.append((char)asc);
        }

        return sb.toString();
    }

    //shift letters in order to decode text
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
        if (l >= 97 && l <=122) {
            return 0;
        }
        if (l <= 90 && l >= 65) {
            return 1;
        }
        return 2;
    }
}
