// 연결리스트 구현 연습
// 코드 출처 : https://youtu.be/x22G_r0cln4

package week4.linkedlist.implement.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    // Node 객체 생성
    private class Node{
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    // 앞쪽에 데이터 삽입
    public void addFirst(Object input) {
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
        size++;

        if(head.next == null) {
            tail = head;
        }
    }

    // 뒷쪽에 데이터 삽입
    public void addLast(Object input) {
        Node newNode = new Node(input);
        if(size == 0) {
            addFirst(input);
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 인덱스로 특정 노드 탐색
    Node node(int index) {
        Node x = head;
        for(int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // 특정 인덱스에 노드 추가
    public void add(int k, Object input) {
        if(k == 0) {
            addFirst(input);
        } else {
            Node temp1 = node(k - 1);
            Node temp2 = temp1.next;

            Node newNode = new Node(input);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;
            if(newNode.next == null) {
                tail = newNode;
            }
        }
    }

    // LinkedList 안 전체 노드 데이터 값 출력
    public String toString() {
        if(head == null) {
            return "[]";
        } else {
            Node temp = head;
            String str = "[";

            while(temp.next != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            str += temp.data;

            return str + "]";
        }
    }

    // 앞쪽 데이터 삭제
    public Object removeFirst() {
        Node temp = head;
        head = head.next;
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    // 특정 인덱스 노드 삭제
    public Object remove(int k) {
        if(k == 0) {
            return removeFirst();
        } else {
            Node temp = node(k - 1);
            Node todoDeleted = temp.next;
            temp.next = todoDeleted.next;
            Object returnData = todoDeleted.data;
            if(todoDeleted == tail) {
                tail = temp;
            }
            todoDeleted = null;
            size--;
            return returnData;
        }
    }

    // 마지막 노드 삭제
    public Object removeLast() {
        return remove(size-1);
    }

    // LinkedList의 size 반환
    public int size() {
        return size;
    }

    // 특정 인덱스 노드의 데이터 값 반환
    public Object get(int k) {
        Node temp = node(k);
        return temp.data;
    }

    // 특정 데이터 값을 갖는 노드의 인덱스 반환
    public int indexOf(Object data) {
        Node temp = head;
        int index = 0;

        while(temp.data != data) {
            temp = temp.next;
            index++;
            if(temp == null) {
                return -1;
            }
        }
        return index;
    }
}
