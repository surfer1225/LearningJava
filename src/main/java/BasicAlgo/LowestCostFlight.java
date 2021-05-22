package main.java.BasicAlgo;

public class LowestCostFlight {
    /**
     *
     * @param flightGraph: cost bet/w 2 destinations
     * @param k: till k that allows transfer flights
     * @return the minimum cost bet/w 2 airports after k airports open up
     */
    public int getMinCost(int[][] flightGraph, int k, int start, int dest) {
        int[][] costGraph = new int[flightGraph.length][flightGraph[0].length];
        for (int i=0;i<flightGraph.length;++i) {
            for (int j=0;j<flightGraph[0].length;++j) {
                costGraph[i][j] = flightGraph[i][j];
            }
        }
        for (int i=0;i<k;++i) {
            for (int m=0;m<flightGraph.length;++m) {
                for (int n=m+1;n<flightGraph[0].length;++n) {
                    costGraph[m][n] = Math.min(costGraph[m][n], costGraph[m][i] + costGraph[i][n]);
                }
            }
        }
        return flightGraph[start-1][dest-1];
    }
}
