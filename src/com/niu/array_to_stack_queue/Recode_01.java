package com.niu.array_to_stack_queue;

public class Recode_01 {
    public static class ArrayStack {
        private Integer[] arr;
        private int size;

        public ArrayStack(int initSize) {
            arr = new Integer[initSize];
            size = 0;
        }

        public void push(Integer obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the stack is full");
            }
            arr[size++] = obj;
        }

        public Integer peek() {
            if (size == 0) return null;

            return arr[size - 1];
        }

        public Integer pop() {
            if (size == 0) throw new ArrayIndexOutOfBoundsException("The stack is empty");

            return arr[--size];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private int size;
        private int first;
        private int last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public void push(Integer obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("the queue is full");

            }
            size++;
            arr[last] = obj;
            last = last == arr.length - 1 ? 0 : last++;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            size--;
            int tmp = arr[first];
            first = first == arr.length - 1 ? 0 : first++;
            return tmp;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }
    }

}
