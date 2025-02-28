import java.lang.StringBuilder;

class MergeStringsAlternately {

    public static void main (String[] args) {
        if (args.length < 2) {
            print("2 arguments are required!");
            return;
        }
        print(mergeAlternately(args[0], args[1]));
    }

    public static String mergeAlternately(String word1, String word2) {
		  StringBuilder res = new StringBuilder();
		  int i, j;
		  for(i=0, j=0; i<word1.length() && j<word2.length(); i++, j++) {
			  res.append(word1.charAt(i)).append(word2.charAt(j));
      }
		  if (i < word1.length()) {
			  res.append(word1.substring(i));
		  } else if (j < word2.length()) {
			  res.append(word2.substring(j));
		  }
      return res.toString();
	}

    public static void print(String text) {
        System.out.println(text);
    }

}
