package com.playground.search;

import com.playground.sort.QuickSort;

/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月28日 上午1:14:18
 * 
 * 
 * 二分查找  返回下标  非递归
 * 
 * 二分查找 有两个注意点
 * 
 * 1.  mid = (hi+lo)/2  这样有溢出风险
 * 2.  更新lo和hi的时候用mid会有死循环风险  不过我暂时没有模拟出来
 * 
 */

public class BinarySearch1 {
	
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		
		int target = 2;
		int index = binaryS(arr,target);
		System.out.println(target+"的位置在:\t"+index);
		
		int key = binarySearchRecur(arr,target,0,arr.length-1);
		System.out.println(target+"的位置在:\t"+key);
		
		
		
	}
	
	
	static int binaryS(int []arr, int t){
		int lo=0;
		int hi=arr.length-1;
		int mid = 0;
		while(hi>=lo){
			mid = (hi+lo)>>>1;   //防止溢出
			if(arr[mid]==t){
				return mid+1;   //返回的不是下标，而是这个元素所在的位置
			}else if(arr[mid]<t){
				lo = mid+1;
			}else if(arr[mid]>t){
				hi = mid-1;
			}
			
		}
		return -1;
	}
	
	
	static int binarySearchRecur(int[]arr,int key,int lo,int hi){
		if(hi>=lo){
		int mid = (hi+lo)>>>1;
		if(key==arr[mid]){
			return mid+1;
		}else if(key>arr[mid]){
			return binarySearchRecur(arr,key,mid+1,hi);
		}else {
			return binarySearchRecur(arr,key,lo,mid-1);
		      }
		}
		return -1;
	}
	
	
	

}
