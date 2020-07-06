package leetcode;

/**
 * Title :1290. 二进制链表转整数
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式
 *
 * 请你返回该链表所表示数字的 十进制值
 *
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30
 * 每个结点的值不是 0 就是 1
 *
 * Description :
 * Created by jiangjunchi on 2020/07/06 19:09
 **/
public class GetDecimalValue {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static int getDecimalValueDiy(ListNode head) {
        StringBuilder stringBuilder=new StringBuilder();
        while(head!=null){
            stringBuilder.append(head.val);
            head=head.next;
        }
        return Integer.parseInt(stringBuilder.toString(),2);

    }

    /**
     * 时间复杂度：O(N)，其中 N 是链表中的节点个数
     * 空间复杂度：O(1)
     */
    private static int getDecimalValueOfi(ListNode head) {
        if(head==null){
            return 0;
        }

        int res=0;
        while(head!=null){
            res= (res<<1) +head.val;
            head=head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode one=new ListNode(0);
        ListNode two=new ListNode(1);
        head.next=one;
        one.next=two;
        System.out.println(getDecimalValueOfi(head));
    }

}
