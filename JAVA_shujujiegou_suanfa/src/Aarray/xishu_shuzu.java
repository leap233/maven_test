package Aarray;

import java.util.Arrays;

public class xishu_shuzu {
	public static void main(String[] args) {
		//1.创建一个二维数组 11*11
		//0:没有棋子 1:黑子 2:蓝子
		int chessarr1[][] = new int [11][11];
		chessarr1[1][2] = 1;
		chessarr1[2][3] = 2;
		chessarr1[5][7] = 1;
		//输出原始二维数组
		System.out.println("原始的二维数组");
		for (int[] ints : chessarr1) {
			for (int anInt : ints) {
				System.out.printf("%d\t",anInt);
			}
			System.out.println();
		}
		//遍历二维数组 得到非零数据的个数
		int sum = 0;
		for (int i = 0; i < chessarr1.length; i++) {
			for (int j = 0; j < chessarr1.length; j++) {
				if(chessarr1[i][j]!=0)
					sum++;
			}
		}
		System.out.println(sum);
	//创建对应的稀疏数组
		int sparearr[][] = new int[sum+1][3];
		//给稀疏数组赋值(第一行)
		sparearr[0][0] = 11;
		sparearr[0][1] = 11;
		sparearr[0][2] = sum;
	//存放数据 遍历二维数组
		int count = 0; //计数器
		for (int i = 0; i < chessarr1.length; i++) {
			for (int i1 = 0; i1 < chessarr1.length; i1++)
				if (chessarr1[i][i1] != 0) {
					{
						count++;
						sparearr[count][0] = i;
						sparearr[count][1] = i1;
						sparearr[count][2] = chessarr1[i][i1];
					}
				}
		}
		System.out.println();
		System.out.println("转换完成的稀疏数组");
		for (int i = 0; i < sparearr.length; i++) {
			System.out.printf("%d\t%d\t%d\t",sparearr[i][0],sparearr[i][1],sparearr[i][2]);
			System.out.println();
		}
		System.out.println("将稀疏数组恢复成二维数组");
		//读取稀疏数组的第一行
		int chessarr2[][] = new int[sparearr[0][0]][sparearr[0][1]];
		for (int i = 1; i < sparearr.length; i++) {
			chessarr2[sparearr[i][0]][sparearr[i][1]] = sparearr[i][2];
		}
		System.out.println("恢复后的二维数组");
		for (int[] ints : chessarr2) {
			for (int anInt : ints) {
				System.out.printf("%d\t",anInt);
			}
			System.out.println();
		}
	}
}
