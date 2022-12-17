package misc;

import java.util.HashMap;
import java.util.Map;

/*
* add
* remove
* peek
*
* map, linked list, head, tail
*
*
* */
public class LRUCache {
    private Map<Integer, ListNode> map = new HashMap<>();
    ListNode head;
    ListNode tail;
    int size;
    int capacity = 5;

    public void add(int value){
        ListNode node = new ListNode();
        node.val = value;
        //empty list
        if(head == null){
            head = node;
            tail = node;
            size = size + 1;
        }

        //size full
        //map contains/not contain
        else if (size == capacity){
            ListNode newTail = tail.prev;
            newTail.next = null;
            tail = newTail;

            head.prev = node;
            node.next = head;
            head = node;
        }

        //existing element
        else if(map.containsKey(value)){
            ListNode existingNode = map.get(value);
            node = existingNode;
            ListNode prev = existingNode.prev;
            ListNode next = existingNode.next;
            prev.next = next;
            next.prev = prev;

            existingNode.next = head;
            existingNode.prev = null;

            head.prev = existingNode;
            head = existingNode;
        }
        //new element
        else {
            node.next = head;

            head.prev = node;
            head = node;
            size = size + 1;
        }

        //add element to map
        map.put(value, node);

    }

    public void remove(int value){
        ListNode node = map.get(value);
        //middle element
        ListNode prev = node.prev;
        ListNode next = node.next;
        if(prev != null)
            prev.next = next;
        if(next != null)
            next.prev = prev;

        if(head.val == value)
            head = head.next;
        if(tail.val == value)
            tail = tail.prev;
        //element is head or tail
        //remove element from map
        map.remove(value);
    }

    public int peek(){
        if(head != null)
            return head.val;
        return -1;
    }
}

class ListNode{
    int val;
    ListNode prev;
    ListNode next;
}
