# 🌳 Binary Tree Revision Notes

## 1. What is a Binary Tree?

A Binary Tree is a hierarchical data structure where each node can have at most two children:

* Left Child
* Right Child

Example:

```
    10
   /  \
  5    15
 / \     \
2   7     20
```

Here, 10 is the Root Node.

---

# 2. Tree Traversals

Traversal means visiting every node of a tree.

### Preorder Traversal

Root → Left → Right

Uses:

* Tree Copy
* Serialization
* Flatten Tree

### Inorder Traversal

Left → Root → Right

Uses:

* Produces sorted order in BST

### Postorder Traversal

Left → Right → Root

Uses:

* Delete Tree
* Bottom-Up Calculations

### Level Order Traversal (BFS)

Visits nodes level by level using a Queue.

Uses:

* Level Order Problems
* Zigzag Traversal
* Infection Tree

---

# 3. Size of a Tree

Size represents the total number of nodes in the tree.

Example:

```
1
```

/ 
2   3

Size = 3

---

# 4. Sum of a Tree

Sum is the total of all node values.

Example:

```
1
```

/ 
2   3

Sum = 6

---

# 5. Maximum and Minimum Value

Find the largest or smallest value present in the tree.

Example:

```
 10
/  \
```

5   20

Maximum = 20

Minimum = 5

---

# 6. Height of a Tree

Height is the length of the longest path from the root to a leaf node.

Example:

```
1
```

/
2
/
3

Height = 3

Key Idea:

Height is calculated using information from both left and right subtrees.

---

# 7. Same Tree

Two trees are considered the same if:

* Their structure is identical.
* Their node values are identical.

---

# 8. Symmetric Tree

A tree is symmetric if its left and right subtrees are mirror images of each other.

Example:

```
    1
  /   \
 2     2
/ \   / \
```

3  4  4  3

This tree is symmetric.

---

# 9. Balanced Binary Tree

A tree is balanced if, for every node:

| Left Height - Right Height | ≤ 1

Benefits:

* Better performance for searching and traversal operations.

---

# 10. Diameter of a Binary Tree

Diameter is the longest path between any two nodes in the tree.

Important:

The diameter does not always pass through the root.

Example:

```
    1
   / \
  2   3
 / \
4   5
```

Diameter Path:

4 → 2 → 1 → 3

---

# 11. Binary Tree Paths

Find all root-to-leaf paths.

Example:

```
1
```

/ 
2   3

5

Output:

1→2→5

1→3

---

# 12. Path Sum I

Question:

Does there exist a root-to-leaf path whose sum equals the target value?

Return Type:

Boolean (True / False)

---

# 13. Path Sum II

Question:

Return all root-to-leaf paths whose sum equals the target value.

Return Type:

List of Paths

---

# 14. Path Sum III

Question:

Count the number of paths whose sum equals the target value.

Important:

A valid path does not need to start at the root.

Return Type:

Count

---

# 15. Invert Binary Tree

Swap the left and right children of every node.

Before:

```
  1
 / \
2   3
```

After:

```
  1
 / \
3   2
```

---

# 16. Lowest Common Ancestor (LCA)

The Lowest Common Ancestor of two nodes is the first common parent shared by both nodes.

Example:

```
    3
   / \
  5   1
 / \
6   2
```

LCA(6, 2) = 5

---

# 17. Construct Binary Tree

Given:

* Preorder Traversal
* Inorder Traversal

We can reconstruct the original tree.

Key Observation:

The first element of Preorder is always the Root.

---

# 18. Zigzag Level Order Traversal

A variation of BFS where traversal direction alternates at each level.

Level 1 → Left to Right

Level 2 → Right to Left

Level 3 → Left to Right

And so on.

---

# 19. Flatten Binary Tree

Convert a binary tree into a linked-list-like structure.

Example:

Before:

```
  1
 / \
2   5
```

After:

1 → 2 → 3 → 4 → 5

---

# 20. Infection Tree

Determine how long it takes to infect the entire tree starting from a specific node.

Key Idea:

Convert the tree into a graph using Parent Mapping.

Possible infection directions:

* Left Child
* Right Child
* Parent

Solution Pattern:

Parent Map + BFS

---

# Interview Pattern Recognition

If the question asks about:

Size, Sum, Max, Min
→ Aggregation Pattern

Height
→ Height DFS

Longest Path
→ Diameter Pattern

Compare Two Trees
→ Same Tree Pattern

Mirror Structure
→ Symmetric Tree Pattern

Target Sum
→ Path Sum Family

Common Parent
→ LCA Pattern

Modify Tree Structure
→ Invert / Flatten Pattern

Level-by-Level Traversal
→ BFS Pattern

Alternate Level Direction
→ Zigzag Pattern

Build a Tree
→ Construction Pattern

Infect Nodes
→ Graph + BFS Pattern

---

# Core Binary Tree Recursion Pattern

Most Binary Tree problems follow this idea:

1. Solve the left subtree.
2. Solve the right subtree.
3. Use the results to solve the current node.

Think:

"Get information from left and right, then make a decision at the current node."

This is the foundation of Binary Tree recursion.


## 📄 Full Notes PDF

👉 https://drive.google.com/file/d/19N39tqe2fvbvyPSDe6cnCLw5Xc-NajCL/view?usp=sharing