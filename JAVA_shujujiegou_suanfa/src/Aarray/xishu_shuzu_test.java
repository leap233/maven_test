package Aarray;
import java.util.ArrayList;
import java.util.Arrays;
public class xishu_shuzu_test {
	//将二维数组转换成稀疏数组的方法 传的参数为一个二维数组
	public static int[][] sparr(int arr1[][]){
		int sum = 0; //计数器 记录有效数据个数
		//取出有效数据个数
		for (int i = 0; i < arr1.length; i++) {
			for (int i1 = 0; i1 < arr1.length; i1++) {
				if(arr1[i][i1]!=0){
					sum++;
				}
			}
		}
		int sparr1[][] = new int[sum+1][3]; //创建一个稀疏数组并赋值
		sparr1[0][0] = arr1.length;    //获取二维数组的行
		sparr1[0][1] = arr1[0].length; //获取二维数组的列
		sparr1[0][2] = sum;
		int count = 0; //计数器 记录第几个元素
		for (int i = 0; i < arr1.length; i++) {
			for (int i1 = 0; i1 < arr1.length; i1++) {
				if(arr1[i][i1]!=0){
					count++;
					sparr1[count][0] = i;
					sparr1[count][1] = i1;
					sparr1[count][2] = arr1[i][i1];
				}
			}
		}
		//输出
		for (int i = 1; i < sparr1.length; i++) {
			System.out.printf("%d\t%d\t%d\t",sparr1[i][0],sparr1[i][1],sparr1[i][2]);
			System.out.println();
		}
		return sparr1;
	}
	//将稀疏数组转换成二维数组的方法 传的参数为一个稀疏数组
	public static int[][] erarr(int xishu[][]){
		//创建一个二维数组并赋初值
		int arr[][] = new int[xishu[0][0]][xishu[0][1]];
		for (int i = 1; i < xishu.length; i++) {
			for (int i1 = 0; i1 < arr.length; i1++) {
				arr[xishu[i][0]][xishu[i][1]] = xishu[i][2];
			}
		}
		//输出
		for (int[] ints : arr) {
			for (int ints1 : ints) {
				System.out.printf("%d\t",ints1);
			}
			System.out.println();
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr1[][] = new int[8][8];
		arr1[1][3] = 1;
		arr1[2][5] = 2;
		arr1[3][6] = 1;
		System.out.println("开始的二维数组");
		for (int[] ints : arr1) {
			for (int ints1 : ints) {
				System.out.printf("%d\t",ints1);
			}
			System.out.println();
		}
		System.out.println("调用二维转换稀疏函数");
		int arr2[][] = sparr(arr1);   //complete
		System.out.println("调用稀疏恢复二维函数");
		erarr(arr2);       //complete

	}
}
