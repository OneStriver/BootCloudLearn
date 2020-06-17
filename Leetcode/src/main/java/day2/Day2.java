package day2;

import common.ListNode;

import java.util.Arrays;

/**
 * @description:
 * @author: HeYin
 * @date: 2020/06/18
 */
public class Day2 {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 结果的头结点（非首元结点）
        ListNode result = new ListNode(0);

        // 临时引用变量
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp = result;

        // 进位变量
        int carry = 0;

        // 两个链表的引用均为非空时
        while (tmp1 != null && tmp2 != null) {
            int sum = carry + tmp1.val + tmp2.val;
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }

        // l1长度大于l2时
        while (tmp1 != null) {
            int sum = carry + tmp1.val;
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }

        // l2长度大于l1时
        while (tmp2 != null) {
            int sum = carry + tmp2.val;
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            tmp2 = tmp2.next;
        }

        // 处理可能的进位
        if (carry == 1) {
            tmp.next = new ListNode(1);
        }

        // 返回首元结点
        return result.next;

    }


}
