import java.util.HashMap;

class EditDistance {

  static HashMap<String, Integer> seen = new HashMap<>();
  
  public static void main(String[] args) {
    //String word1 = "horse";
    //String word2 = "ros";
    String word1 = "dinitrophenylhydrazine";
    String word2 = "acetylphenylhydrazine";
    int ans = minDistance(word1, word2);
    p(ans);
  }

  public static int minDistance(String word1, String word2) {
    if(seen.containsKey(key(word1, word2))) {
      return seen.get(key(word1, word2));
    }
    if (word1.length() == 0) {
      int ans = word2.length();
      seen.put(key(word1, word2), ans);
      return ans;
    }
    if (word2.length() == 0) {
      int ans = word1.length();
      seen.put(key(word1, word2), ans);
      return ans;
    }
    if (head(word1) == head(word2)) {
      int ans = minDistance(tail(word1), tail(word2));
      seen.put(key(word1, word2), ans);
      return ans;
    }
    int ans = 1 + min(minDistance(word1, tail(word2)), minDistance(tail(word1), tail(word2)), minDistance(tail(word1), word2));
    seen.put(key(word1, word2), ans);
    return ans;
  }

  public static String key(String word1, String word2) {
    return word1+":"+word2;
  }

  public static int min(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }

  public static String tail(String x) {
    return x.substring(1);
  }

  public static char head(String x) {
    return x.charAt(0);
  }

  public static void p(int x) {
    System.out.println(x);
  }
  
  public static void p(char c) {
    System.out.println(c);
  }

}

