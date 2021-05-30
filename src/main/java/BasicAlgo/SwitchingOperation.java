package main.java.BasicAlgo;

/*
Problem Given a projection for n months of operations u1, u2, . . . , un at Venice and v1, v2, . . . , vn at Neo-Venezia
and a moving cost of m, determine the cost of a schedule of operations for n months that minimizes cost.
 */
public class SwitchingOperation {
    public int getMinScheduleCost(int[][] schedule, int switch_cost) {
        int[][] schedule_cost = new int[2][schedule[0].length];
        schedule_cost[0][0] = schedule[0][0];
        schedule_cost[1][0] = schedule[1][0];

        for (int i = 1; i < schedule[0].length; ++i) {
            schedule_cost[0][i] = Math.min(schedule_cost[0][i - 1] + schedule[0][i], schedule_cost[1][i - 1] + schedule[0][i] + switch_cost);
            schedule_cost[1][i] = Math.min(schedule_cost[1][i - 1] + schedule[1][i], schedule_cost[0][i - 1] + schedule[1][i] + switch_cost);
        }

        for (int i=0;i<2;++i) {
            System.out.print("cost: ");
            for (int j=0;j<schedule[i].length;++j) {
                System.out.print(schedule_cost[i][j] + ", ");
            }
            System.out.println();
        }

        return Math.min(schedule_cost[0][schedule[0].length - 1], schedule_cost[1][schedule[0].length - 1]);
    }

    public static void main(String[] args) {
        SwitchingOperation so = new SwitchingOperation();
        System.out.println(so.getMinScheduleCost(new int[][]{{30,10,15,50,76},{20,20,25,20,26}}, 12));
    }
}
