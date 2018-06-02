import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main implements Runnable {
    static final int n = 4;
    static final int[] ndx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    static final int[] ndy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

    static final int[] rdx = new int[]{1, -1, 0, 0};
    static final int[] rdy = new int[]{0, 0, 1, -1};

    static final int[] bdx = new int[]{1, -1, 1, -1};
    static final int[] bdy = new int[]{1, 1, -1, -1};
    char[][] board = new char[n][n];

    boolean isMine(char c, boolean isWhite) {
        return (c != 0 && Character.isUpperCase(c) == isWhite);
    }

    boolean isEnemy(char c, boolean isWhite) {
        return (c != 0 && Character.isUpperCase(c) != isWhite);
    }

    Vector<int[]> getAllKnightMoves(int x, int y, boolean isWhite) {
        Vector<int[]> res = new Vector<>();
        for (int i = 0; i < ndx.length; i++) {
            int nx = x + ndx[i];
            int ny = y + ndy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (isMine(board[nx][ny], isWhite)) {
                continue;
            }
            res.add(new int[]{nx, ny});
        }
        return res;
    }

    Vector<int[]> getAllRookMoves(int x, int y, boolean isWhite) {
        Vector<int[]> res = new Vector<>();
        for (int i = 0; i < rdx.length; i++) {
            for (int k = 1; k < n; k++) {
                int nx = x + k * rdx[i];
                int ny = y + k * rdy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                if (isMine(board[nx][ny], isWhite)) {
                    break;
                }
                res.add(new int[]{nx, ny});
                if (isEnemy(board[nx][ny], isWhite)) {
                    break;
                }
            }
        }
        return res;
    }

    Vector<int[]> getAllBishopMoves(int x, int y, boolean isWhite) {
        Vector<int[]> res = new Vector<>();
        for (int i = 0; i < bdx.length; i++) {
            for (int k = 1; k < n; k++) {
                int nx = x + k * bdx[i];
                int ny = y + k * bdy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    break;
                }
                if (isMine(board[nx][ny], isWhite)) {
                    break;
                }
                res.add(new int[]{nx, ny});
                if (isEnemy(board[nx][ny], isWhite)) {
                    break;
                }
            }
        }
        return res;
    }

    Vector<int[]> getAllQueenMoves(int x, int y, boolean isWhite) {
        Vector<int[]> res = getAllBishopMoves(x, y, isWhite);
        res.addAll(getAllRookMoves(x, y, isWhite));
        return res;
    }

    Vector<int[]> getAllMoves(int x, int y, boolean isWhite) {
        char c = Character.toUpperCase(board[x][y]);
        switch (c) {
            case 'N':
                return getAllKnightMoves(x, y, isWhite);
            case 'B':
                return getAllBishopMoves(x, y, isWhite);
            case 'R':
                return getAllRookMoves(x, y, isWhite);
            case 'Q':
                return getAllQueenMoves(x, y, isWhite);
        }
        return new Vector<>();
    }


    int isWin(boolean isWhite, int cnt) {
        if (cnt == 0) return 0;
        boolean allWin = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (isMine(board[i][j], isWhite)) {
                    char c = board[i][j];
                    Vector<int[]> moves = getAllMoves(i, j, isWhite);
                    for (int[] pos : moves) {
                        int I = pos[0];
                        int J = pos[1];
                        char nc = board[I][J];
                        if ((isWhite && nc == 'q') ||  (!isWhite && nc == 'Q')){
                            return 1;
                        }
                        board[i][j] = 0;
                        board[I][J] = c;
                        int res = isWin(!isWhite, cnt - 1);
                        board[I][J] = nc;
                        board[i][j] = c;
                        if (res == -1) {
                            return 1;
                        } else if (res == 0) {
                            allWin = false;
                        }

                    }
                }

        if (allWin) {
            return -1;
        } else {
            return 0;
        }
    }

    void solve() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            int w = nextInt();
            int b = nextInt();
            int m = nextInt();
            for (char[] bb:board) {
                Arrays.fill(bb, (char)0);
            }
            while (w-- > 0) {
                char c = next().charAt(0);
                int x = next().charAt(0) - 'A';
                int y = nextInt() - 1;
                board[x][y] = c;
            }
            while (b-- > 0) {
                char c = next().charAt(0);
                int x = next().charAt(0) - 'A';
                int y = nextInt() - 1;
                board[x][y] = Character.toLowerCase(c);
            }
            if (isWin(true, m) == 1) {
                out.println("YES");
            } else {
                out.println("NO");
            }

        }
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();
            br.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(123);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }
}