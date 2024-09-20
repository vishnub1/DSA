/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        // Create a HashMap to map original nodes to their corresponding nodes
        HashMap<Node, Node> map = new HashMap<>();

        // Step 1 : Create copies of each node and store tem in the map
        while(temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        
        // Step 2 : Connect the next & random pointers of the copies nodes using the map
        while(temp != null) {
            // Access the copied node corresponding to the current original node
            Node copyNode = map.get(temp);
            // Set the next pointer of the copied node to the copied node mapped to the next node in the original list
            copyNode.next = map.get(temp.next);
            // Set the random pointer of the copied node to the copied node mapped to the random node in the original list
            copyNode.random = map.get(temp.random);
            // Move to the next node in the original list
            temp = temp.next;

        }

        // Return the head of deep copied list from the map
        return map.get(head);
    }
}