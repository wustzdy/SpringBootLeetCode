//
// Created by 朱大洋 on 2021/8/17.
//

#include<iostream>
using namespace std;
#define MaxSize 100
typedef struct {
    int data[MaxSize];
    int Length;
} SqList;
//搜索整个顺序表，查找最小值元素并记住其位置，搜索结束后用最后一个元素填补空出的原最小值元素的位置。
//顺序表查找最小值并返回被删元素的值
bool Del_Min(SqList &L, int value) {
    if (L.Length == 0)
        return false;
    value = L.data[0];
    int pos = 0;
    for (int i = 1; i < L.Length; i++) {
        if (L.data[i] < value) {
            value = L.data[i];
            pos = i; //循环找最小值的元素
        }
    }
    //空出的位置由最后一个填补
    L.data[pos] = L.data[L.Length - 1];
    L.Length--;
    return true;
}

int main() {
    SqList L;//定义顺序表

    cout << "请输入数组L长度:";
    cin >> L.Length;

    cout << "请输入数组L的值：";
    for (int i = 0; i < L.Length; i++) {
        cin >> L.data[i];
    }
    Del_Min(L,2);

    cout << "删除后的数组为";
    for (int i = 0; i < L.Length; i++)
        cout << L.data[i] << " ";
    cout << endl;
    return 0;
}