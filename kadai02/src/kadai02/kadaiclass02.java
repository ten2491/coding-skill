package kadai02;

import java.util.*;

public class kadaiclass02 {

	public static void main(String[] args) {
		int flag = 0;
		int card[][] = new int[5][2];
		int handan[][] = new int [1][2];
		int hozon[][] = new int [1][2];
		char henkan[][] = new char[5][2];

		System.out.println("＜ポーカー＞");
		System.out.println("カードのスート(スペード=0,クラブ=1,ダイヤ=2,ハート=3)と数字(エース=1,ジャック=11,クイーン=12,キング=13)を5枚入力");

		for(int cnt = 0; cnt < 5; cnt++) {
			flag = 0;
			System.out.println(cnt+1 + "枚目");
			Scanner sc1 = new Scanner(System.in);
			for(int i = 0; i < 2; i++) {
				handan[0][i] = sc1.nextInt();
			}
			for(int i = 0; i < 2; i++) {
				hozon[0][i] = handan[0][i];
			}

			//正しいカードが入力されてるか判断
			while(((handan[0][0] == card[0][0] && handan[0][1] == card[0][1]) ||
				   (handan[0][0] == card[1][0] && handan[0][1] == card[1][1]) ||
				   (handan[0][0] == card[2][0] && handan[0][1] == card[2][1]) ||
				   (handan[0][0] == card[3][0] && handan[0][1] == card[3][1]) ||
				   (handan[0][0] == card[4][0] && handan[0][1] == card[4][1])) ||
				   (3 < handan[0][0]) || (0 == handan[0][1] || 13 < handan[0][1])) {
				flag = 1;
				System.out.println("正しいスート・数字が入力されてないか、スートと数字が同じカードが存在しています。もう一度入力してください。");
				System.out.println(cnt+1 + "枚目");
				Scanner sc2 = new Scanner(System.in);
				for(int i = 0; i < 2; i++) {
					handan[0][i] = sc2.nextInt();
				}
			}

			if(flag == 0) {
				for(int i = 0; i < 2; i++) {
					card[cnt][i] = hozon[0][i];
				}
			}
			if(flag == 1) {
				for(int i = 0; i < 2; i++) {
					card[cnt][i] = handan[0][i];
				}
			}

		}

		for(int j = 0; j < 5; j++) {
			int i = 0;
			if(card[j][i] == 0) {
				henkan[j][i] = 'S';
			}
			if(card[j][i] == 1) {
				henkan[j][i] = 'C';
			}
			if(card[j][i] == 2) {
				henkan[j][i] = 'D';
			}
			if(card[j][i] == 3) {
				henkan[j][i] = 'H';
			}
			if(card[j][i+1] == 1) {
				henkan[j][i+1] = 'A';
			}
			if(card[j][i+1] == 11) {
				henkan[j][i+1] = 'J';
			}
			if(card[j][i+1] == 12) {
				henkan[j][i+1] = 'Q';
			}
			if(card[j][i+1] == 13) {
				henkan[j][i+1] = 'K';
			}
		}

		for(int j = 0; j < 5; j++) {
			int i = 0;
			if(card[j][i+1] == 1 || card[j][i+1] == 11 || card[j][i+1] == 12 || card[j][i+1] == 13) {
				System.out.println(henkan[j][i] + "" + henkan[j][i+1]);
			} else {
				System.out.println(henkan[j][i] + "" + card[j][i+1]);
			}
		}

		//数字を昇順に並び替え
		Arrays.sort(card, (a, b) -> Integer.compare(a[1], b[1]));
		//昇順に並んでるかテスト表示用
//		for(int j = 0; j < 5; j++) {
//			int i = 0;
//			System.out.println(card[j][i] + " " + card[j][i+1]);
//		}

		//ロイヤルストレートフラッシュ
		if((card[0][0] == card[1][0] && card[0][0] == card[2][0] && card[0][0] == card[3][0] && card[0][0] == card[4][0]) &&
		    (card[0][1] == 1 && card[1][1] == 10 && card[2][1] == 11 && card[3][1] == 12 && card[4][1] == 13)) {
				System.out.println("ロイヤルストレートフラッシュ");
				System.exit(0);
		}

		//ストレートフラッシュ
		if(card[0][0] == card[1][0] && card[0][0] == card[2][0] && card[0][0] == card[3][0] && card[0][0] == card[4][0]) {
			if((card[0][1]+1 == card[1][1] && card[1][1]+1 == card[2][1] && card[2][1]+1 == card[3][1] && card[3][1]+1 == card[4][1]) ||
			   (card[2][1]+1 == card[3][1] && card[3][1]+1 == card[4][1] && card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13) ||
			   (card[3][1]+1 == card[4][1] && card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13 && card[1][1]+14 == card[2][1]+13) ||
			   (card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13 && card[1][1]+14 == card[2][1]+13 && card[2][1]+14 == card[3][1]+13)) {
				System.out.println("ストレートフラッシュ");
				System.exit(0);
			}
		}

		//フラッシュ
		if(card[0][0] == card[1][0] && card[0][0] == card[2][0] && card[0][0] == card[3][0] && card[0][0] == card[4][0]) {
			System.out.println("フラッシュ");
			System.exit(0);
		}

		//ストレート
		if((card[0][1]+1 == card[1][1] && card[1][1]+1 == card[2][1] && card[2][1]+1 == card[3][1] && card[3][1]+1 == card[4][1]) ||
		   (card[2][1]+1 == card[3][1] && card[3][1]+1 == card[4][1] && card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13) ||
		   (card[3][1]+1 == card[4][1] && card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13 && card[1][1]+14 == card[2][1]+13) ||
		   (card[4][1]+1 == card[0][1]+13 && card[0][1]+14 == card[1][1]+13 && card[1][1]+14 == card[2][1]+13 && card[2][1]+14 == card[3][1]+13)) {
				System.out.println("ストレート");
				System.exit(0);
		}

		//フルハウス
		if((card[0][1] == card[1][1] && (card[2][1] == card[3][1] && card[3][1] == card[4][1])) || ((card[0][1] == card[1][1] && card[1][1] == card[2][1]) && card[3][1] == card[4][1])) {
			System.out.println("フルハウス");
			System.exit(0);
		}

		//フォーカード
		if((card[0][1] == card[1][1] && card[1][1] == card[2][1] && card[2][1] == card[3][1]) || (card[1][1] == card[2][1] && card[2][1] == card[3][1] && card[3][1] == card[4][1])) {
			System.out.println("フォーカード");
			System.exit(0);
		}

		//スリーカード
		if((card[0][1] == card[1][1] && card[1][1] == card[2][1]) || (card[1][1] == card[2][1] && card[2][1] == card[3][1]) || (card[2][1] == card[3][1] && card[3][1] == card[4][1])) {
			System.out.println("スリーカード");
			System.exit(0);
		}

		//ツーペア
		if((card[0][1] == card [1][1] && card[2][1] == card[3][1]) || (card[0][1] == card[1][1] && card[3][1] == card[4][1]) || (card[1][1] == card[2][1] && card[3][1] == card[4][1])) {
			System.out.println("ツーペア");
			System.exit(0);
		}

		//ワンペア
		if(card[0][1] == card[1][1] || card[1][1] == card[2][1] || card[2][1] == card[3][1] || card[3][1] == card[4][1]) {
			System.out.println("ワンペア");
			System.exit(0);
		}

		//ハイカード
		System.out.println("ハイカード");

	}

}
