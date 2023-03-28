public class PGM_StringCompression {
        public int solution (String s){
            int l = s.length();
            int answer = l;
            int B = l;
            int c1 = 0;
            for (int j = 1; j <= l / 2; j++) {
                B = l;
                for (int i = 0; i < l - (j + l % j); i = i + j) {
                    if (j == 1) {
                        if (s.charAt(i) == (s.charAt(i + 1))) {
                            c1++;
                        } else {
                            if (c1 != 0) {
                                if (c1 > 8) {
                                    B = B - c1 + 2;
                                    c1 = 0;
                                } else {
                                    B = B - c1 + 1;
                                    c1 = 0;
                                }
                            }
                        }
                    } else {
                        if (s.substring(i, i + j).equals(s.substring(i + j, i + j + j))) {
                            c1++;
                        } else {
                            if (c1 != 0) {
                                if (c1 > 8) {
                                    B = B - c1 * j + 2;
                                    c1 = 0;
                                } else {
                                    B = B - c1 * j + 1;
                                    c1 = 0;
                                }
                            }
                        }
                    }
                }
                if (c1 != 0) {
                    if (c1 > 8) {
                        B = B - c1 * j + 2;
                        c1 = 0;
                    } else {
                        B = B - c1 * j + 1;
                        c1 = 0;
                    }
                }
                if (B < answer) {
                    answer = B;
                }
            }
            return answer;
        }

}
