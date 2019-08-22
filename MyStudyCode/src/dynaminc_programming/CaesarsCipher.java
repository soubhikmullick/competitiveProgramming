package dynaminc_programming;

public class CaesarsCipher {
    private final int CHAR_LIMIT = 127;

    public String encrypt(String text, int key) {
        if (key > 26)
            key = key % 26;
        else if (key < 0)
            key = key % 26 + 26;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    char ch = (char) (c+key);
                    if (ch >'Z')
                        result.append((char) (ch - (26 - key)));
                    else
                        result.append(ch);
                } else if (Character.isLowerCase(c)) {
                    char ch = (char) (c+key);
                    if (ch > 'z')
                        result.append((char) (ch - (26 - key)));
                    else
                        result.append(ch);
                }
            } else
                result.append(c);
        }

        return result.toString();
    }


    private String decrypt(String text, int key) {
        if (key > 26)
            key = key % 26;
        else if (key < 0)
            key = key % 26 + 26;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    char ch = (char) (c-key);
                    if (ch < 'A')
                        result.append((char) (ch + (26 - key)));
                    else
                        result.append(ch);
                } else if (Character.isLowerCase(c)) {
                    char ch = (char) (c-key);
                    if (ch < 'a')
                        result.append((char) (ch + (26 - key)));
                    else
                        result.append(ch);
                }
            } else
                result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CaesarsCipher caesarsCipher = new CaesarsCipher();
        String encrypt = caesarsCipher.encrypt("This is some message" , 5);
        String decrypt = caesarsCipher.decrypt(encrypt, 5);
        System.out.println(encrypt);
        System.out.println(decrypt);
    }

}
