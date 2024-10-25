package LeetCode.Medium.CourseSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private boolean[] recStack;

    private boolean dfs(int startCourse) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startCourse);
        while (!stack.isEmpty()) {
            int course = stack.peek();
            if (!visited[course]) {
                visited[course] = true;
                recStack[course] = true;
            }
            boolean hasUnvisitedNeighbor = false;
            for (int neighbor : adjList.get(course)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    hasUnvisitedNeighbor = true;
                    break;
                } else if (recStack[neighbor]) {
                    return true;
                }
            }
            if (!hasUnvisitedNeighbor) {
                stack.pop();
                recStack[course] = false;
            }
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList<>();
        visited = new boolean[numCourses];
        recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
