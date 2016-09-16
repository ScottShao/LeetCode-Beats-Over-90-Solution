public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (H < B || F > D || E > C || G < A) return (C - A) * (D - B) + (G - E) * (H - F);
        int bx, by, tx, ty;
        bx = Math.max(E, A);
        by = Math.max(B, F);
        tx = Math.min(G, C);
        ty = Math.min(D, H);
        return (C - A) * (D - B) + (G - E) * (H - F) - (tx - bx) * (ty - by);
    }
}