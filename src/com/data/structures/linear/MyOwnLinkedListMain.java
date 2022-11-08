package com.data.structures.linear;

import java.util.Objects;

public class MyOwnLinkedListMain {

    public static void main(String[] args) {
        var linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(9);
        linkedList.addFirst(8);
        linkedList.addFirst(7);
        linkedList.addLast(100);
        linkedList.addLast(109);
        linkedList.addLast(108);

        linkedList.deleteFirst();
        linkedList.deleteLast();
        System.out.println(linkedList.contains(100));
        System.out.println(linkedList.contains(108));
        System.out.println(linkedList.indexOf(10));
        System.out.println(linkedList.indexOf(9));
        System.out.println(linkedList.indexOf(108));
        System.out.println(linkedList.indexOf(109));

    }

    static class LinkedList {
        private Node first;
        private Node last;

        public void addFirst(int value) {
            if (Objects.isNull(first)) {
                this.first = new Node(value);
                this.last = first;
            } else {
                this.first = new Node(value, first);
            }
        }

        public void addLast(int value) {
            if (Objects.isNull(last)) {
                this.last = new Node(value);
                this.first = last;
            } else {
                var lastNode = new Node(value);
                last.setNext(lastNode);
                this.last = lastNode;
            }
        }

        public void deleteFirst() {
            if (Objects.isNull(first.getNext())) {
                this.first = null;
                this.last = null;
            } else {
                var next = first.getNext();
                first.disconnectNext();
                this.first = next;
            }
        }

        public void deleteLast() {
            if (Objects.isNull(first.getNext())) {
                this.first = null;
                this.last = null;
            } else {
                var lastNode = first.lastNodeWithLink();
                lastNode.disconnectNext();
                this.last = lastNode;
            }

        }
        
        public boolean contains(int value) {
            return Objects.nonNull(first) && first.contains(value);
        }

        public int indexOf(int value) {
            if (Objects.isNull(first)) return -1;

            var count = 0;
            var lasNodeSearching = first;
            do {
                if (lasNodeSearching.getValue() == value) {
                    return count;
                }
                if (Objects.isNull(lasNodeSearching.getNext())) {
                    return -1;
                }

                lasNodeSearching = lasNodeSearching.getNext();
                count++;
            } while(true);
        }


        //indexOf
    }

    static class Node {
        private final int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void disconnectNext() {
            this.next = null;
        }

        public Node lastNodeWithLink() {
            return Objects.nonNull(next.getNext())
                    ? next.lastNodeWithLink()
                    : this;
        }

        public boolean contains(int value) {
            return this.value == value || (Objects.nonNull(next) && next.contains(value));
        }
    }




}
