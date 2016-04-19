package com.example.maths;

import java.util.Random;

public class Maths {

	private int a;
	private String sign;
	private int b;
	private int c;

	public int getA() {
		return a;
	}

	public String getSign() {
		return sign;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public static Maths newMath(Integer option) {
		Maths m = new Maths();
		Random random = new Random();
		m.a = random.nextInt(option) + 1;
		m.sign = (random.nextInt(2) == 0) ? "+" : "-";
		if (m.sign.equals("+")) {
			m.b = random.nextInt(option + 1 - m.a);
			m.c = m.a + m.b;
		} else {
			m.b = random.nextInt(m.a);
			m.c = m.a - m.b;
		}

		return m;
	}
}
