题目

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

解决思路

1.排列顺序为由小到大排序，所以建立一个返回指针head指向两个链表中首元素较小的的那个链表，
2.将两个链表合并。建立两个指针p1,p2分别指向两个链表，依次比较p1,p2所指向元素的值，把小的连接到新的链表中，并向后移动。直到p1,p2其中一个指向NULL。
3.将另外那个p1没有指向NULL的链表连接到新链表后面。
（没有说的特别清楚，看代码比较容易理解）

代码

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode *p1,*p2,*q1,*q2,*p,*head;
    p1=l1;
    p2=l2;
    if(l1==NULL){
        return l2;
    }else if(l2==NULL){
        return l1;
    }
    
    if( p1->val < p2->val ){
        head=p1;
        p1=p1->next;
    }else{
        head=p2;
        p2=p2->next;
    }
        p=head;
    while(p1!=NULL && p2!=NULL){
        if(p1->val <= p2->val){
            p->next=p1;
            p=p1;
            p1=p1->next;
        }else{
            p->next=p2;
            p=p2;
            p2=p2->next;
        }
        
    }
    
    if(p1!=NULL){
        p->next=p1;
    }else{
        p->next=p2;
    }
    return head;
}