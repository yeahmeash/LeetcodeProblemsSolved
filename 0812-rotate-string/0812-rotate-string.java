class Solution {
    public boolean rotateString(String s, String goal) {
       if(s.length()!=goal.length()){
        return false;
       }
        String name=s+s;
       return name.contains(goal);

    }
}