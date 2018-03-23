public class Main {
    public static void main(String[] args) {
        HashView hashView = new ClosedHashTable(13);
        hashView.insert(1);
        hashView.insert(1);
        hashView.insert(14);
        hashView.insert(1);
        hashView.remove(1);
//        hashView.insert(28);
//        hashView.insert(2);
//        hashView.insert(3);
        hashView.print();

//        TaylorSeries ts = new TaylorSeries();
//        System.out.println(ts.getArccosSeries(-1, 0.001));
    }
}
