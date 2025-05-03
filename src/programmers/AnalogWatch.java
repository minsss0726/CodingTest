package programmers;

class AnaloWatch {

	boolean isFirst = true;

	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = 0;

		if (h1 < 12 && h2 >= 12) {
			int am_h = h1 % 12;
			int pm_h = h2 % 12;

			isFirst = true;
			answer += checkAlram(am_h, m1, s1);
			isFirst = false;
			Run_am: while (timeToSec(am_h, m1, s1) < timeToSec(11, 59, 59)) {
				s1++;
				answer += checkAlram(am_h, m1, s1);
				if (s1 == 60) {
					s1 = 0;
					m1++;
					if (m1 == 60) {
						m1 = 0;
						am_h++;
						if (am_h == 12) {
							break Run_am;
						}
					}
				}
			}

			int pm_h2 = 0;
			m1 = 0;
			s1 = 0;
			isFirst = true;
			answer += checkAlram(pm_h2, m1, s1);
			isFirst = false;
			Run_pm: while (timeToSec(pm_h2, m1, s1) < timeToSec(pm_h, m2, s2)) {
				s1++;
				answer += checkAlram(pm_h2, m1, s1);
				if (s1 == 60) {
					s1 = 0;
					m1++;
					if (m1 == 60) {
						m1 = 0;
						pm_h2++;
						if (pm_h2 == 12) {
							break Run_pm;
						}
					}
				}
			}
		} else {
			h1 = (h1 % 12);
			h2 = (h2 % 12);
			isFirst = true;
			answer += checkAlram(h1, m1, s1);
			isFirst = false;
			Run: while (timeToSec(h1, m1, s1) < timeToSec(h2, m2, s2)) {
				s1++;
				answer += checkAlram(h1, m1, s1);
				if (s1 == 60) {
					s1 = 0;
					m1++;
					if (m1 == 60) {
						m1 = 0;
						h1++;
						if (h1 == 12) {
							break Run;
						}
					}
				}
			}

		}
		return answer;
	}

	public int timeToSec(int h, int m, int s) {
		int time = (h * 60 * 60) + (m * 60) + s;
		return time;
	}

	public int checkAlram(int h, int m, int s) {
		int alram = 0;

		double s_d = (double) s;
		double m_d = (double) m + (s_d / (double) 60);
		double h_d = ((double) h * (double) 5) + (m_d / (double) 12);

		double m_1 = (double) 1 / (double) 60;
		double h_1 = (double) 1 / (double) 60 / (double) 12;

		if (isFirst) {
			if (s_d == m_d || s_d == h_d) {
				alram++;
			}
		} else {
			if (((s_d - (double) 1) < (m_d - m_1)) && (s_d >= m_d)) {
				alram++;
			}
			if (((s_d - (double) 1) < (h_d - h_1)) && (s_d >= h_d)) {
				alram++;
				if (h_d == m_d) {
					alram--;
				}
			}
		}
		return alram;
	}

}