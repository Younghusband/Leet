package com.yangfan.sort;

/*********************************************
 * SelectionSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-16
 *
 * Details:
 * 
 * 选择排序   
 * 
 * 每轮记录下标， 将每轮的第一个元素和下表元素进行交换，然后进行下一轮
 * 
 ********************************************/

public class SelectionSort {  
	
	public static void main(String[] args) {
		int [] arr= {4,3,2,1,5,6,8,7};
		selectionSort(arr);
		BubbleSort.print(arr);
	}
	
	public static void selectionSort(int [] arr){
		int location = 0;
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			location = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[location]){
					location = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[location];
			arr[location] = temp;
		}
	}

}
