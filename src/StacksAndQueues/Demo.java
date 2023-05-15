package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Stack
        // push(element) - insert element
        // pop() - remove topmost element
        // peek() - get topmost element

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Queue
        // offer(element) - add element at the start of the Queue
        // poll() - remove first element of the Queue
        // peek() - get first element of the Queue

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        // PriorityQueue
        PriorityQueue<Integer> priorityQueue  = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.offer(36);
        priorityQueue.offer(105);
        priorityQueue.offer(65);
        priorityQueue.offer(12);
        priorityQueue.offer(78);

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

    }
}










