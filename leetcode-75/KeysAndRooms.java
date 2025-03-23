/*

There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. 
Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. 
Each key has a number on it, denoting which room it unlocks,
and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, 
return true if you can visit all the rooms, or false otherwise.

Example 1:

Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

Example 2:

Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.

Example 3:
Input: rooms = [[4],[3,4],[],[],[1]]
*/

import java.util.List;
import java.lang.Integer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class KeysAndRooms {
  
  public static void main(String[] args) {
    List<Integer> key0 = Arrays.asList(1,3);
    List<Integer> key1 = Arrays.asList(3,0,1);
    List<Integer> key2 = Arrays.asList(2);
    List<Integer> key3 = Arrays.asList(0);
    List<List<Integer>> rooms = Arrays.asList(key0, key1, key2, key3);
    boolean ans = canVisitAllRooms(rooms);
    System.out.println(ans);
  }
  public static void visitRoom(Set<Integer> keysUsed, Set<Integer> keysUnused, 
      Integer key, List<List<Integer>> rooms) {
    
    keysUnused.remove(key);
    keysUsed.add(key);
    
    List<Integer> newKeys = rooms.get(key);

    for(Integer nk: newKeys) {
      if(!keysUsed.contains(nk)) {
        keysUnused.add(nk);
      }
    }
  }

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> keysUsed = new HashSet<>();
    Set<Integer> keysUnused = new HashSet<>(Arrays.asList(0));
    
    while(!keysUnused.isEmpty()) {
      List<Integer> arr = new ArrayList<>(keysUnused);
      for(Integer key: arr) {
        visitRoom(keysUsed, keysUnused, key, rooms);
      }
    }

    if (keysUsed.size() != rooms.size()) return false;
    return true;
  }

}

