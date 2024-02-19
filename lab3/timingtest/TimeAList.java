package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    private static void timeAListConstructionHelper(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int opNum) {
        AList<Integer> temp = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 1; i <= opNum; i++) {
            temp.addLast(1);
        }
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(opNum);
        times.addLast(timeInSeconds);
        opCounts.addLast(opNum);
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        timeAListConstructionHelper(ns, times, opCounts, 1000);
        timeAListConstructionHelper(ns, times, opCounts, 2000);
        timeAListConstructionHelper(ns, times, opCounts, 4000);
        timeAListConstructionHelper(ns, times, opCounts, 8000);
        timeAListConstructionHelper(ns, times, opCounts, 16000);
        timeAListConstructionHelper(ns, times, opCounts, 32000);
        timeAListConstructionHelper(ns, times, opCounts, 64000);
        timeAListConstructionHelper(ns, times, opCounts, 128000);
        printTimingTable(ns, times, opCounts);

    }
}
