package kadai04;

//プリセットとして提供するセルパターンをまとめたクラス

import java.util.Random;

public class CellPattern {

	enum Pattern { GLIDER, SPACESHIP, GALAXY, RANDOM }

	//グライダーパターン
	private static final int[][] glider_ptn = {
			{0,1,0},
			{0,0,1},
			{1,1,1}
	};

	//宇宙船パターン
	private static final int[][] spaceship_ptn = {
			{1,0,0,1,0},
			{0,0,0,0,1},
			{1,0,0,0,1},
			{0,1,1,1,1}
	};

	//銀河パターン
	private static final int[][] galaxy_ptn = {
			{1,1,1,1,1,1,0,1,1},
			{1,1,1,1,1,1,0,1,1},
			{0,0,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,1,1},
			{1,1,0,0,0,0,0,0,0},
			{1,1,0,1,1,1,1,1,1},
			{1,1,0,1,1,1,1,1,1}
	};

	//乱数パターン
//	private static int[][] random_ptn = random.rand();


	//パターンの生成
	//@param cells 盤面の二重配列
	//@param p パターンの指定

	public static void patternGenerator(LifeCell[][] cells,CellPattern.Pattern p) {
		int pattern[][] = {{}};

		switch(p) {
			case GLIDER:
				pattern = glider_ptn;
				break;

			case SPACESHIP:
				pattern = spaceship_ptn;
				break;

			case GALAXY:
				pattern = galaxy_ptn;
				break;

			case RANDOM:
				pattern = random.rand();
				break;
		}

		int x_max = cells[0].length;
		int y_max = cells.length;

		//盤面の大きさより、パターンの生成領域超えていた場合
		if(Const.sponeLocation.width + pattern[0].length > x_max) { return; }

		if(Const.sponeLocation.height + pattern.length > y_max) { return; }

		//パターンに合わせて、強制的に盤面塗り替え
		for(int y = 0; y < pattern.length; y++) {

			for(int x = 0; x < pattern[0].length; x++) {
				LifeCell cell = cells[Const.sponeLocation.height + y][Const.sponeLocation.width + x];

				if(pattern[y][x] == 1) {
					cell.forceSpawn();

				}else{
					cell.forceKill();

				}

			}

		}

	}

}

//乱数の作成
class random{
	public static int[][] rand() {
		int i = 0;
		int r[][] =new int[50][50];
		for(i = 0;i < r.length -1;i++) {
			for(int j=0;j < r.length;j++) {
				Random ran = new Random();
				r[i][j] = ran.nextInt(2);
			}
		}
		return r;
	}
}