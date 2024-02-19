package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    private static void timeGetLastHelper(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int N, int M) {
        SLList<Integer> temp = new SLList<>();
        for (int i = 0; i < N; i++) {
            temp.addLast(1);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < M; i++) {
            temp.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        Ns.addLast(N);
        times.addLast(timeInSeconds);
        opCounts.addLast(M);
    }
    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        timeGetLastHelper(ns, times, opCounts, 1000, 1000);
        timeGetLastHelper(ns, times, opCounts, 2000, 1000);
        timeGetLastHelper(ns, times, opCounts, 4000, 1000);
        timeGetLastHelper(ns, times, opCounts, 8000, 1000);
        timeGetLastHelper(ns, times, opCounts, 16000, 1000);
        timeGetLastHelper(ns, times, opCounts, 32000, 1000);
        timeGetLastHelper(ns, times, opCounts, 64000, 1000);
        timeGetLastHelper(ns, times, opCounts, 128000, 1000);
        printTimingTable(ns, times, opCounts);
    }
}
