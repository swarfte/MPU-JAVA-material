package chapter18.ex1;

/**
 * @author swarfte
 * @title Identifying anagrams
 */
public class Ch18Ex1 {

    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "lappe";
        System.out.println(identifyingAnagrams(s1, s2));

    }

    public static boolean identifyingAnagrams(String a, String b) {
        int[] letters = new int[256];
        return identifyingAnagrams(a, b, 0, letters);
    }

    public static boolean identifyingAnagrams(String a, String b, int index, int[] letters) {
        if (a.length() != b.length()) {
            return false;
        }
        if (index != a.length()) {
            letters[a.charAt(index)]++;
            identifyingAnagrams(a, b, index + 1, letters);
            letters[a.charAt(index)]--;
        } else {
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
