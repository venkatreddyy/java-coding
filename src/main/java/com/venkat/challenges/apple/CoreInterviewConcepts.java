package com.venkat.challenges.apple;

import java.util.*;

public class CoreInterviewConcepts {

    public static void main(String[] args) {
        CoreInterviewConcepts obj = new CoreInterviewConcepts();

        // 1. Detect Cycle in Linked List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Creates a cycle
        System.out.println("Has Cycle: " + obj.hasCycle(head));

        // 2. DFS and BFS
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 4; i++) graph.add(new ArrayList<>());
        graph.get(0).add(1); graph.get(0).add(2);
        graph.get(1).add(2); graph.get(2).add(0); graph.get(2).add(3);
        graph.get(3).add(3);
        System.out.print("DFS: ");
        obj.dfs(2, graph, new boolean[4]);
        System.out.println();
        System.out.print("BFS: ");
        obj.bfs(2, graph);
        System.out.println();

        // 3. Tree Traversals
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.print("Inorder: "); obj.inorder(root); System.out.println();
        System.out.print("Preorder: "); obj.preorder(root); System.out.println();
        System.out.print("Postorder: "); obj.postorder(root); System.out.println();
        System.out.print("Level Order: "); obj.levelOrder(root); System.out.println();

        // 4. LRU Cache
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("LRU Get 1: " + cache.get(1));
        cache.put(3, 3);
        System.out.println("LRU Get 2 (evicted): " + cache.get(2));

        // 5. Quicksort
        int[] arr = {10, 7, 8, 9, 1, 5};
        obj.quicksort(arr, 0, arr.length - 1);
        System.out.println("Quicksorted Array: " + Arrays.toString(arr));

        // 6. LCA in BST
        TreeNode bst = new TreeNode(6);
        bst.left = new TreeNode(2);
        bst.right = new TreeNode(8);
        bst.left.left = new TreeNode(0);
        bst.left.right = new TreeNode(4);
        TreeNode lca = obj.lowestCommonAncestor(bst, bst.left, bst.right);
        System.out.println("LCA of 2 and 8: " + lca.val);

        // 9. Check if tree is BST
        System.out.println("Is BST: " + obj.isBST(bst, null, null));

        // 10. Longest substring without repeating characters
        String input = "abcabcbb";
        System.out.println("Longest Substring Length: " + obj.lengthOfLongestSubstring(input));
    }

    // Classes and methods as previously defined...

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Include all previously defined methods from the original class here (omitted for brevity)

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) dfs(neighbor, graph, visited);
        }
    }

    public void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    static class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;
        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        public int get(int key) {
            return super.getOrDefault(key, -1);
        }
        public void put(int key, int value) {
            super.put(key, value);
        }
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
