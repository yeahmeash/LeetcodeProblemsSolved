class Solution {
    public boolean isRobotBounded(String instructions) {
    // North, East, South, West
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int x = 0, y = 0;   // start at origin
    int dir = 0;        // 0 = north

    for (char ch : instructions.toCharArray()) {
        if (ch == 'G') {
            x += directions[dir][0];
            y += directions[dir][1];
        } else if (ch == 'L') {
            dir = (dir + 3) % 4;  // turn left (counterclockwise)
        } else if (ch == 'R') {
            dir = (dir + 1) % 4;  // turn right (clockwise)
        }
    }

    // In circle if back at origin or not facing north
    return (x == 0 && y == 0) || dir != 0;
}

}