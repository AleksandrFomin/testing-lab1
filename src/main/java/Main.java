public class Main {
    public static void main(String[] args) throws NoSpaceAvailableException, NoSuchValueException {
//        HashView hashView = new ClosedHashTable(29);
//        hashView.insert(29);
//        hashView.insert(28);
////        hashView.insert(2);
////        hashView.insert(3);
//        hashView.print();

        TaylorSeries ts = new TaylorSeries();
        System.out.println(ts.getArccosSeries(-1, 0.001));
    }
}
