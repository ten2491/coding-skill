package kadai01;

import java.util.*;

public class kadaiclass01 {

	public static void main(String[] args) {
		int ziki[] = new int[4];
		int tekicnt = 0;
		int tekiki[][] = new int[4][99];

		System.out.println("＜当たり判定計算機＞");
		System.out.println("自機のx軸,y軸,幅,高さを順に入力");
		Scanner sc1 = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			ziki[i] = sc1.nextInt();
		}

		System.out.println("敵機の数を入力");
		Scanner sc2 = new Scanner(System.in);
		tekicnt = sc2.nextInt();

		for(int cnt = 1; cnt <= tekicnt; cnt++) {
			System.out.println("敵機" + cnt + "のx軸,y軸,幅,高さを順に入力");
			Scanner sc3 = new Scanner(System.in);
			for(int i = 0; i < 4; i++) {
				tekiki[cnt-1][i] = sc1.nextInt();
			}
		}

		for(int j = 0; j < tekicnt; j++) {
			if(	(ziki[0] < tekiki[j][0] + tekiki[j][2]) &&
				(ziki[0] + ziki[2] > tekiki[j][0]) &&
			   	(ziki[1] < tekiki[j][1] + tekiki[j][3]) &&
			   	(ziki[1] + ziki[3] > tekiki[j][1]) ) {
				System.out.println("敵機" + (j+1) + "が当たり");
			}
		}
	}

}
