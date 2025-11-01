package org.example.task_15;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toDelete = new HashSet<>();
        for (int n : nums) {
            toDelete.add(n);
        }

        while (head != null && toDelete.contains(head.val)) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (toDelete.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    //тест не успел написать сам, так что представляю страшное творение чата гпт
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        int[] nums = {5};

        Solution sol = new Solution();
        ListNode result = sol.modifiedList(nums, head);

        System.out.print("Output: [");
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
            if (result != null) System.out.print(", ");
        }
        System.out.println("]");
    }
}
