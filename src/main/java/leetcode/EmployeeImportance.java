package main.java.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Employee targetEmployee = null;
        for (Employee e:employees) {
            if (e.id==id) targetEmployee = e;
            employeeMap.put(e.id,e);
        }
        if (targetEmployee==null) return 0;

        int[] importance = new int[1];
        dfs(targetEmployee,employeeMap,importance);
        return importance[0];
    }

    private void dfs(Employee target, Map<Integer, Employee> employeeMap, int[] importance) {
        importance[0]+=target.importance;

        for (Integer i:target.subordinates) dfs(employeeMap.get(i),employeeMap,importance);
    }
}
