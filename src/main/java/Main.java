package main;

import java.util.Scanner;

public class test
{

    public static void main(String[] args)
    {
    	// בדיקות תור רמה 2
        Queue<Character> qChars = new Queue<>();
        qChars.insert('c');
        qChars.insert('c');
        qChars.insert('a');
        qChars.insert('c');
        System.out.println("Counts result: " + counts(qChars)); 
        System.out.println("----------------------------------------");
        int[] sorted1 = {1, 3, 5, 10};
        int[] sorted2 = {2, 4, 6, 9};
        Queue<Integer> qSort1 = buildTor(sorted1);
        Queue<Integer> qSort2 = buildTor(sorted2);
        System.out.print("Merge result: ");
        print(merge(qSort1, qSort2));
        System.out.println("----------------------------------------");
        int[] evens = {2, 4, 1, 10, 10, 10, 5, 8, 8, 8};
        Queue<Integer> qEvens = buildTor(evens);
        System.out.println("Max Even Sequence Sum: " + maxEvenSum(qEvens));

        System.out.println("----------------------------------------");
        Queue<String> qStr = new Queue<>();
        qStr.insert("dodo");
        qStr.insert("maama");
        qStr.insert("dodo");
        qStr.insert("yakov");
        System.out.println(ex2_2(qStr));
        System.out.println("----------------------------------------");
        int[]array = {4,6,6,8,1,9,4,5};
        Queue<Integer> q12 = buildTor(array);
        //Queue<Integer> q_tar = ex3_2(q12);
        //print(q_tar);
        ex4_2(q12);
        print(q12);
         

        
        

        /*int[]a = {21,50,79,35,65};
        int[]arr = {4,6,2,8,1,9,4,5};
        Queue<Integer> q2 = buildTor(arr);
        Queue<Integer> q = buildTor(a);
        
        // בדיקות תור רמה 1
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
        */
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

    public static <T> Queue<T> ex1(Queue<T> q)
    {
        Queue<T> newQueue = new Queue<T>();
        Queue<T> cloneQueue = new Queue<T>();
        
        while(!q.isEmpty())
        {
            T x = q.remove();
            newQueue.insert(x);
            cloneQueue.insert(x);
        }
        
        while(!cloneQueue.isEmpty())
        {
            T x = cloneQueue.remove();
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
    // תור רמה 2
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
    public static <T> boolean isIN(Queue<T> q, T x)
    {
        Queue<T> copy = ex1(q); 
        while(!copy.isEmpty())
        {
            T current = copy.remove();
            if(current.equals(x))
                return true;
        }
        return false;
    }
    public static <T> int isIN_count(Queue<T> q, T x)
    {
    	int counter = 0;
        Queue<T> copy = ex1(q); 
        while(!copy.isEmpty())
        {
            T current = copy.remove();
            if(current.equals(x))
                counter++;;
        }
        return counter;
    }
    public static boolean ex2_2(Queue<String> q)
    {
    	Queue<String> copy = ex1(q); 
    	while(!copy.isEmpty())
    	{
    		if(isIN_count(q,copy.remove())>1)
    			return true;
    	}
    	return false;
    }
    public static <T> Queue<T> ex3_2(Queue<T> q)
    {
        Queue<T> result = new Queue<>(); 
        Queue<T> copy = ex1(q);          

        while (!copy.isEmpty()) {
            T current = copy.remove();
            if (!isIN(result, current)) {
                result.insert(current);
            }
        }
        return result;
    }
    public static void ex4_2(Queue<Integer> q)
    {
        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();

        while (!q.isEmpty())
        {
            int min = q.head();
            
            while (!q.isEmpty())
            {
                int x = q.remove();
                if (x < min) 
                	min = x;
                q1.insert(x);
            }

            boolean removed = false;
            while (!q1.isEmpty())
            {
                int x = q1.remove();
                if (x == min && !removed) 
                {
                    q2.insert(x);
                    removed = true;
                } else {
                    q.insert(x);
                }
            }
        }

        while (!q2.isEmpty())
        {
            q.insert(q2.remove());
        }
    }
    

}
