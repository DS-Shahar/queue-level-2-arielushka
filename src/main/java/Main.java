package main;

import java.util.Scanner;

public class test
{

    public static void main(String[] args)
    {
        Queue<Character> qChars = new Queue<>();
        qChars.insert('c');
        qChars.insert('c');
        qChars.insert('a');
        qChars.insert('c');
        System.out.println("Counts result: " + counts(qChars)); 

        int[] sorted1 = {1, 3, 5, 10};
        int[] sorted2 = {2, 4, 6, 9};
        Queue<Integer> qSort1 = buildTor(sorted1);
        Queue<Integer> qSort2 = buildTor(sorted2);
        System.out.print("Merge result: ");
        print(merge(qSort1, qSort2));

        int[] evens = {2, 4, 1, 10, 10, 10, 5, 8, 8, 8};
        Queue<Integer> qEvens = buildTor(evens);
        System.out.println("Max Even Sequence Sum: " + maxEvenSum(qEvens));

        System.out.println("----------------------------------------");

        int[]a = {21,50,79,35,65};
        int[]arr = {4,6,2,8,1,9,4,5};
        Queue<Integer> q2 = buildTor(arr);
        Queue<Integer> q = buildTor(a);
        
 
        Queue<Integer> q1 = ex1(q);
        print(q1);
        //-----------------2-------------------
        System.out.println(ex2(q));
        //-----------------3-------------------
        System.out.println(ex3(q,2));
        //-----------------4-------------------
        System.out.println(ex4(q,q2));
        //-----------------5-------------------
        System.out.println(ex5(q,2));
    }

    public static void print(Queue<Integer> q)
    {
        Queue<Integer> cloneQueue = ex1(q);
        while(!cloneQueue.isEmpty())
        {
            int x = cloneQueue.remove();
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static Queue<Integer> buildTor(int[]a)
    {
        Queue<Integer> q = new Queue<>();
        for(int i = 0; i<a.length;i++)
            q.insert(a[i]);
        return q;
    }

    public static Queue<Integer> ex1(Queue<Integer> q)
    {
        Queue<Integer> newQueue = new Queue<>();
        Queue<Integer> cloneQueue = new Queue<>();
        while(!q.isEmpty())
        {
            int x = q.remove();
            newQueue.insert(x);
            cloneQueue.insert(x);
        }
        while(!cloneQueue.isEmpty())
        {
            int x = cloneQueue.remove();
            q.insert(x);
        }
        return newQueue;
    }

    public static double ex2(Queue<Integer> q)
    {
        double sum = 0;
        int counter = 0;
        Queue<Integer> clone = ex1(q);
        while(!clone.isEmpty())
        {
            int x = clone.remove();
            sum = sum + x;
            counter++;
        }
        return sum / counter;
    }

    public static int ex3(Queue<Integer> q,int num)
    {
        int counter = 0;
        Queue<Integer> cloneQueue = ex1(q);
        while(!cloneQueue.isEmpty())
        {
            int x = cloneQueue.remove();
            if(num % x == 0)
                counter++;
        }
        return counter;
    }

    public static boolean ex4(Queue<Integer> q,Queue<Integer> q2)
    {
        Queue<Integer> clone = ex1(q);
        while(!clone.isEmpty())
        {
            int x = clone.remove();
            Queue<Integer> clone2 = ex1(q2);
            boolean stop = false;
            while(!clone2.isEmpty())
            {
                if(clone2.remove() % x == 0)
                {
                    stop = true;
                    break;
                }
            }
            if(!stop)
                return false;
        }
        return true;
    }

    public static boolean ex5(Queue<Integer> q, int x)
    {
        int index = 0;
        Queue<Integer> cloneQueue = ex1(q);
        while(!cloneQueue.isEmpty())
        {
            int num = cloneQueue.remove();
            if(num == x)
                index++;
            else
                index = 0;
        }
        return index >1;
    }

    // ----------------------------------------------------
    // New Functions (תשובות לשאלות)
    // ----------------------------------------------------

    public static Queue<Integer> counts(Queue<Character> q)
    {
        Queue<Integer> res = new Queue<>();
        if(q.isEmpty()) return res;

        Queue<Character> temp = new Queue<>();
        char prev = q.remove();
        temp.insert(prev);
        int count = 1;

        while(!q.isEmpty())
        {
            char current = q.remove();
            temp.insert(current);
            if(current == prev)
            {
                count++;
            }
            else
            {
                res.insert(count);
                count = 1;
                prev = current;
            }
        }
        res.insert(count);
        
        while(!temp.isEmpty())
            q.insert(temp.remove());

        return res;
    }

    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2)
    {
        Queue<Integer> res = new Queue<>();
        Queue<Integer> c1 = ex1(q1);
        Queue<Integer> c2 = ex1(q2);

        Integer x = null;
        Integer y = null;

        if(!c1.isEmpty()) x = c1.remove();
        if(!c2.isEmpty()) y = c2.remove();

        while(x != null && y != null)
        {
            if(x < y)
            {
                res.insert(x);
                if(!c1.isEmpty()) x = c1.remove(); else x = null;
            }
            else
            {
                res.insert(y);
                if(!c2.isEmpty()) y = c2.remove(); else y = null;
            }
        }
        while(x != null)
        {
            res.insert(x);
            if(!c1.isEmpty()) x = c1.remove(); else x = null;
        }
        while(y != null)
        {
            res.insert(y);
            if(!c2.isEmpty()) y = c2.remove(); else y = null;
        }
        return res;
    }

    public static int maxEvenSum(Queue<Integer> q)
    {
        Queue<Integer> copy = ex1(q);
        int maxLen = 0;
        int maxSum = 0;
        int currentLen = 0;
        int currentSum = 0;

        while(!copy.isEmpty())
        {
            int val = copy.remove();
            if(val % 2 == 0)
            {
                currentLen++;
                currentSum += val;
            }
            else
            {
                if(currentLen > maxLen)
                {
                    maxLen = currentLen;
                    maxSum = currentSum;
                }
                currentLen = 0;
                currentSum = 0;
            }
        }
        if(currentLen > maxLen)
        {
            maxSum = currentSum;
        }
        return maxSum;
    }
    public static void change(Stack<Integer> s)
    {
    	Queue<Integer> q = new Queue<>();
    	while(!s.isEmpty())
    	{
    		q.insert(s.pop());
    	}
    	while(!q.isEmpty())
    	{
    		s.push(q.remove());
    	}
    }
    public static void change(Queue<Integer> q)
    {
    	Stack<Integer> s = new Stack<>();
    	while(!q.isEmpty())
    	{
    		s.push(q.remove());
    	}
    	while(!s.isEmpty())
    	{
    		q.insert(s.pop());
    	}
    }
}
