package WorkshopExercise;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomDoublyLinkedList {

    public static class Node {

        private Node next;
        private int element;
        private Node previous;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node(int element) {
            setElement(element);
            setNext(null);
            setPrevious(null);
        }

    }

    private int size;
    private Node head;
    private Node tail;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public CustomDoublyLinkedList() {
    }

    public void addFirst(int element) {
        Node node = new Node(element);
        if (getSize() == 0) {
            setHead(node);
            setTail(node);
        } else {
            node.setNext(getHead());
            node.setPrevious(null);
            getHead().setPrevious(node);
            setHead(node);
        }
        setSize(getSize() + 1);
    }

    public void addLast(int element) {
        Node node = new Node(element);
        if (getSize() == 0) {
            setHead(node);
            setTail(node);
        } else {
            node.setNext(null);
            node.setPrevious(getTail());
            getTail().setNext(node);
            setTail(node);
        }
        setSize(getSize() + 1);
    }

    public int get(int index) {
        if (index >= 0 && index < getSize()) {
            int half = getSize() / 2;
            if (index <= half) {
                int currentIndex = 0;
                Node currentNode = getHead();
                while (currentNode.getNext() != null) {
                    if (currentIndex == index) {
                        return currentNode.getElement();
                    }
                    currentIndex++;
                    currentNode = currentNode.getNext();
                }
            } else {
                int currentIndex = half + 1;
                Node currentNode = getTail();
                while (currentNode.getPrevious() != null) {
                    if (currentIndex == index) {
                        return currentNode.getElement();
                    }
                    currentIndex++;
                    currentNode = currentNode.getPrevious();
                }
            }
        } else {
            try {
                throw new IndexOutOfBoundsException("Invalid index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    public int removeFirst() {
        if (getSize() > 1) {
            int firstElement = getHead().getElement();
            getHead().getNext().setPrevious(null);
            setHead(getHead().getNext());
            setSize(getSize() - 1);
            return firstElement;
        } else if (getSize() == 1) {
            int firstElement = getHead().getElement();
            setHead(null);
            setTail(null);
            setSize(0);
            return firstElement;
        } else {
            try {
                throw new NoSuchElementException("CustomDoublyLinkedList is Empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int removeLast() {
        if (getSize() > 1) {
            int lastElement = getTail().getElement();
            getTail().getPrevious().setNext(null);
            setTail(getTail().getPrevious());
            setSize(getSize() - 1);
            return lastElement;
        } else if (getSize() == 1) {
            int lastElement = getTail().getElement();
            setHead(null);
            setTail(null);
            setSize(0);
            return lastElement;
        } else {
            try {
                throw new NoSuchElementException("CustomDoublyLinkedList is Empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = getHead();
        while (currentNode.getNext() != null) {
            consumer.accept(currentNode.getElement());
            currentNode = currentNode.getNext();
        }
        consumer.accept(currentNode.getElement());
    }

    public int[] toArray() {
        int[] array = new int[getSize()];
        int i = 0;
        Node currentNode = getHead();
        while (currentNode.getNext() != null) {
            array[i++] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        array[i] = currentNode.getElement();
        return array;
    }

}
