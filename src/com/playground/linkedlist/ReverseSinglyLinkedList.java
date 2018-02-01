package com.playground.linkedlist;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月30日 下午11:02:14
 * 
 * 反转单链表
 * 
 */

public class ReverseSinglyLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		
		head.next = ListNode1;
		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		// ListNode3.next == null
		
		ListNode h = head;   //链表遍历的时候都是一次性的，遍历完head就到末尾了，所以建立一个临时变量来遍历
		while(h!=null){
			System.out.print(h.data+"->");
			h = h.next;
		}
		
		System.out.println("\n>>>>>>>>>>>>>>翻转后<<<<<<<<<<<<<<");
		
//		head = reverse(head);
		head = reverseRe(head);
		ListNode t = head;
		
		while(t!=null){
			System.out.print(t.data+"->");
			t = t.next;
		}
		
		if(head==null){
			System.out.println("\n此时head已经为null");
		}
		
	}
	
	
	//非递归方式反转
	public static ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head!=null){
			ListNode temp = head.next;  //先将下一个结点用临时变量记录
			head.next = prev;
			prev = head;
			head = temp;  //将head指向原本下一个结点
		}
		return prev;  //这个地方一定要return
		
	}
	
	//递归方式反转
	public static ListNode reverseRe(ListNode head){
		 if(head==null||head.next ==null)  //空链表或者已经到链表末尾
	            return head;
	        ListNode prev = reverseRe(head.next);
	        head.next.next = head;
	        head.next = null;
	        return prev;
	}
	
	
	

}
