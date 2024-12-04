class Solution {
    static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static StringBuilder sb = new StringBuilder();
	static Point lPoint;
	static Point rPoint;
	static int[][] pad;

	public String solution(int[] numbers, String hand) {
		pad = new int[4][5];
		lPoint = new Point(4, 1);
		rPoint = new Point(4, 3);
		for (int number : numbers) {
			Point targetPoint = getPoint(number);
			if (number == 1 || number == 4 || number == 7) {
				useHand(targetPoint, true);
			} else if (number == 3 || number == 6 || number == 9) {
				useHand(targetPoint, false);
			} else {
				int distL = getDistance(targetPoint, lPoint);
				int distR = getDistance(targetPoint, rPoint);
				if (distL < distR) {
					useHand(targetPoint, true);
				} else if (distL > distR) {
					useHand(targetPoint, false);
				} else {
					useHand(targetPoint, hand.equals("left"));
				}
			}
		}
		return sb.toString();
	}

	private static int getDistance(Point target, Point current) {
		return Math.abs(target.x - current.x) + Math.abs(target.y - current.y);
	}

	private static void useHand(Point point, boolean isLeftHand) {
		if (isLeftHand) {
			sb.append('L');
			lPoint = point;
		} else {
			sb.append('R');
			rPoint = point;
		}
	}

	private static Point getPoint(int number) {
		if (number == 0) {
			return new Point(4, 2);
		}
		int x = number % 3 == 0 ? (number + 3) / 3 - 1 : (number + 3) / 3;
		int y = (number + 3) - 3 * x;
		return new Point(x, y);
	}
}