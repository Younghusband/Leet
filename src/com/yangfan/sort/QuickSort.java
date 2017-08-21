package yangfan.sort;

import java.util.*;

/*********************************************
 * QuickSort.java
 * Author: Vermouth.yf
 * Created on: 2017-8-21
 *
 * Details:   ��������
 *            ���ȶ������ܻ�ı���ͬ��СԪ�صĳ�ʼ���λ�á�
 *            
 ********************************************/

public class QuickSort {
	
	public static void main(String[] args) {
//		int [] arr = generateRandom(10,1,20);
		int [] arr = {4,2,1,3,5,7,6};
		quickSort(arr);
		print(arr);
	}
	
	
	
    private static int partition(int []array,int lo,int hi){
        //�̶����зַ�ʽ
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//�Ӻ�벿����ǰɨ��
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//��ǰ�벿�����ɨ��
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    private static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }
	
	
	public static void quickSort(int[] arr) {
		sort(arr,0,arr.length-1);
	}


	/**
	 * Author: Vermouth.yf 
	 * Date: 2017-8-21 
	 * @param nums   �����С
	 * @param min    ������Сֵ
	 * @param max    �������ֵ
	 * @return
	 */
	public static int[] generateRandom(int nums, int min, int max){
		int [] arr = new int[nums];  //��ʼ�����֮�������
		Random ran = new Random();
		for(int i=0;arr[arr.length-1]==0;i++){
			int temp = ran.nextInt(max);
			boolean flag = false;
			if(temp>=min&&temp<=max){
				flag=!flag;   //Ϊ�˽������ò���
			}
			if(flag){  //У��Ԫ���Ƿ����������Ѿ�����,������� ������һ��ѭ��
				checkAndAdd(arr,temp);
			}
		}
		System.out.println("���ɵ����������:");
		for(int i: arr)
		   System.out.print(i+"->");
		return arr;
	}
	
	
	/**
	 * ����������Ƿ����и�target, �������κβ���������ӵ�����ĩβ
	 * ��ͷ������β,����0�͸�ֵ��break. ��������target��ֱֵ��break
	 * @param arr
	 * @param target
	 */
	public static void checkAndAdd(int [] arr,int target){
		int index = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				arr[i]=target;
				index = i;
				System.out.println("�ڵ�"+(index+1)+"��λ���ϲ������������");
				break;
			}
			if(arr[i]==target){
				break;
			}
		}
	}
	
	public static void print(int [] arr){
		System.out.println("\n>>>>>>>>>>>>>>>>>����������>>>>>>>>>>>>>>>>>");
		for(int i: arr)
			   System.out.print(i+"->");	
		
	}

}
