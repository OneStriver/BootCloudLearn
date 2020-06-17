package common;

import java.util.ArrayList;
import java.util.List;
/**
 * @description:
 * @author: HeYin
 * @date: 2020/06/18
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public List<Integer> toArray() {
        List<Integer> list = new ArrayList<>();

        ListNode curNode = this;

        do {
            list.add(curNode.val);
            curNode = curNode.next;
        } while (curNode != null);

        return list;
    }

}
