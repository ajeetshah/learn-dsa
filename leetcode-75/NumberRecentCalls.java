/*

You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].

It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

Output
[null, 1, 2, 3, 3]

*/

import java.util.Queue;
import java.util.LinkedList;

class NumberRecentCalls {
    
    public static void main(String[] args) {
        p(ping(1));
        p(ping(100));
        p(ping(3001));
        p(ping(3002));
        // p(ping());
        // p(ping());
        // p(ping());
        // p(ping());
    }
    
    public static void p(int x) {
        System.out.println(x);
    }

    private static Queue<Integer> queue = new LinkedList<Integer>();

    public NumberRecentCalls() {
        queue = new LinkedList<Integer>();
    }

    public static int ping(int t) {
        int startTime = t - 3000;
        int endTime = t;
        queue.add(t);
        while(queue.peek() != null && queue.peek() < startTime) {
            queue.poll();
        }
        return queue.size();
    }

}
