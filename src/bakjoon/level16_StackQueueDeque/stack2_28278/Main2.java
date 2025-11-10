package bakjoon.level16_StackQueueDeque.stack2_28278;

import java.io.IOException;

public class Main2 {	
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = nextInt();
        int[] stack = new int[N];
        int top = -1;

        while (N-- > 0) {
            int order = nextInt();
            if (order == 1) {
                stack[++top] = nextInt();
            } else if (order == 2) {
                sb.append(top > -1 ? stack[top--] : -1).append('\n');
            } else if (order == 3) {
                sb.append(top + 1).append('\n');
            } else if (order == 4) {
                sb.append(top > -1 ? 0 : 1).append('\n');
            } else if (order == 5) {
                sb.append(top > -1 ? stack[top] : -1).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int nextInt() throws IOException {
        int n = 0;
        boolean isNega = false;
        int c = System.in.read();

        while (c <= ' ') c = System.in.read();

        if (c == '-') {
            isNega = true;
            c = System.in.read();
        }

        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) >= '0' && c <= '9');

        return isNega ? -n : n;
    }
}