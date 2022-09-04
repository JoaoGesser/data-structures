package com.data.structures;

public class MyOwnArrayMain {

    public static void main(String[] args) {
	    var numbers = new MyOwnArray(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        numbers.insert(70);
        numbers.insert(80);
        numbers.insert(90);
        numbers.removeAt(0);
        System.out.println(numbers.indexOf(50));
        numbers.print();
    }

    static class MyOwnArray {
        int initialLenth;
        int lasPositionUsed = 0;
        int[] array;

        public MyOwnArray(int initialLenth) {
            this.initialLenth = initialLenth;
            this.array = new int[initialLenth];
        }

        public void insert(int value) {
            if (lasPositionUsed == array.length) increaseArraySize();
            array[lasPositionUsed++] = value;
        }

        public void removeAt(int index) {
            if (index < 0 || index >= lasPositionUsed)
                throw new IllegalArgumentException();

            for (int i = index; i < lasPositionUsed; i++)
                if (i == lasPositionUsed - 1) {
                    array[i] = 0;
                } else {
                    array[i] = array[i+1];
                }


            lasPositionUsed--;
        }

        public int indexOf(int valueIndex) {
            for (int i = 0; i < array.length; i++)
                if (array[i] == valueIndex)
                    return i;


            return -1;
        }

        public void print() {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }

        private void increaseArraySize() {
            int[] newArray = new int[array.length + initialLenth];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            this.array = newArray;
        }

    }




}
