#include<iostream>
#include<stdo.h>
using namespace std;

#define MaxSize 100

//将两个有序顺序表合并为一个新的有序表，并由函数返回结果顺序表
typedef struct{
	int data[MaxSize];
	int Length;
}SqList;

//1.保证顺序表A+顺序表B的长度不超过MaxSize
//2.两个指针分别指向A,B，判断指针所指向值的大小，更小的值赋给顺序表C，指针k指向表C
//3.表A,B长度不相等，一个表扫描完后，另一个表剩余元素全部赋给C
bool merge(SqList A,SqList B,SqList &C){
	if(A.Length+B.Length>MaxSize)
		return false;
	int i=0,j=0,k=0;//指向表A,B,C的指针
	while(i<A.Length && j<B.Length){
			if(A.data[i]<=B.data[j])
				C.data[k++]=A.data[i++];
			else
				C.data[k++]=B.data[j++];
		}

	while(i<A.Length)//表B扫描完
		C.data[k++]=A.data[i++];
	while(j<B.Length)//表A扫描完
		C.data[k++]=B.data[j++];

	C.Length=k;
	return true;
}

int main(){
	SqList LA,LB,LC;//定义顺序表

	cout<<"请输入数组A和B的长度:";
	cin>>LA.Length>>LB.Length;

	cout<<"请输入数组A的值：";
	for(int i=0;i<LA.Length;i++)
	{
		cin>>LA.data[i];
	}

	cout<<"请输入数组B的值：";
	for(int i=0;i<LB.Length;i++)
	{
		cin>>LB.data[i];
	}

	merge(LA,LB,LC);

	cout<<"合并后的数组为";
	for(int i=0;i<LC.Length;i++)
		cout<<LC.data[i]<<" ";
	cout<<endl;
	return 0;
}