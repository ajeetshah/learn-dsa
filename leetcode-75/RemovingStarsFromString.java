/*
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
*/

class RemovingStarsFromString {
    public static String removeStars(String s) {
        String[] chars = s.split("");
        int leftCharsToBeRemoved = 0;
        for(int i=chars.length-1; i>-1; i--) {
            if(chars[i] == '*') {
                chars[i] = '\0';
                leftCharsToBeRemoved++;
            } else if (leftCharsToBeRemoved > 0) {
                chars[i] = '\0';
                leftCharsToBeRemoved--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // String s = "leet**cod*e";
        String s = "erase*****";
        String r = removeStars(s);
        System.out.println(r);
    }
}
