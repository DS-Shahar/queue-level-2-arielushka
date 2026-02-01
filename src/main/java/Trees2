public class Trees2 {

    public static void main(String[] args) {
        BinNode<Integer> t1 = buildTree1();
        BinNode<Integer> t2 = buildTree2();

        System.out.println(ex14(t1));
        System.out.println(ex18(t1, t2));
        System.out.println(ex20(t1));
    }

    public static BinNode<Integer> buildTree1() {
        BinNode<Integer> n1 = new BinNode<>(10);
        BinNode<Integer> n2 = new BinNode<>(-5);
        BinNode<Integer> n3 = new BinNode<>(20);
        BinNode<Integer> n4 = new BinNode<>(-10);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        return n1;
    }

    public static BinNode<Integer> buildTree2() {
        BinNode<Integer> n1 = new BinNode<>(10);
        BinNode<Integer> n2 = new BinNode<>(-5);
        n1.setLeft(n2);
        return n1;
    }

    public static int ex14(BinNode<Integer> t) {
        if (t == null)
            return 0;
        return 1 + ex14(t.getLeft()) + ex14(t.getRight());
    }

    public static boolean ex18(BinNode<Integer> t1, BinNode<Integer> t2) {
        if (t2 == null)
            return true;
        if (!isExists(t1, t2.getValue()))
            return false;
        return ex18(t1, t2.getLeft()) && ex18(t1, t2.getRight());
    }

    private static boolean isExists(BinNode<Integer> t, int val) {
        if (t == null)
            return false;
        if (t.getValue() == val)
            return true;
        return isExists(t.getLeft(), val) || isExists(t.getRight(), val);
    }

    public static int ex20(BinNode<Integer> t) {
        return sumPos(t) - Math.abs(sumNeg(t));
    }

    private static int sumPos(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = (t.getValue() > 0) ? t.getValue() : 0;
        return current + sumPos(t.getLeft()) + sumPos(t.getRight());
    }

    private static int sumNeg(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = (t.getValue() < 0) ? t.getValue() : 0;
        return current + sumNeg(t.getLeft()) + sumNeg(t.getRight());
    }
}
