/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

public class Solution {

    // A map to remember already-cloned nodes.
    // Key = original node, Value = cloned node.
    // This prevents infinite loops in cyclic graphs.
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        // If the original graph is empty, return null.
        if (node == null) return null;

        // If this node has already been cloned earlier,
        // simply return the cloned version.
        // (This handles cycles and repeated neighbors.)
        if (map.containsKey(node)) return map.get(node);

        // Create a clone of the current node (copy only the value for now).
        Node clone = new Node(node.val);

        // Store the clone in the map so future visits know it already exists.
        map.put(node, clone);

        // Recursively clone all its neighbors and add them to the clone's neighbor list.
        for (Node nei : node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }

        // Return the fully cloned node.
        return clone;
    }
}
