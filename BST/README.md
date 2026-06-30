# 🌳 Binary Search Tree (BST) - Concept Notes

A **Binary Search Tree (BST)** is a special type of Binary Tree where:

- Every node in the **left subtree** is smaller than the root.
- Every node in the **right subtree** is greater than the root.

> **Golden Rule:** `Left < Root < Right`

---

# 📚 Topics Covered

- BST Implementation (Search, Insert, Min, Max, Count)
- Kth Smallest Element
- Lowest Common Ancestor (LCA)
- Convert BST to Greater Sum Tree
- Sorted Array to BST
- Validate BST
- Largest BST in a Binary Tree
- Maximum Sum BST
- Morris Traversal
- Validate BST using Morris Traversal
- Delete Node (Leaf, One Child, Two Children)

---

# 1️⃣ BST Implementation

## 🔍 Search

### Idea

Compare the current node with the target value.

- Equal → Found
- Target < Root → Move Left
- Target > Root → Move Right

### Key Observation

✅ Only one path is visited.

---

## ➕ Insert (Recursive)

### Steps

1. Reach a `null` node.
2. Create a new node.
3. Return the node.
4. Parent automatically connects through recursion.

### Rule

```text
Small → Left
Large → Right
Null → Create Node
```

---

## ➕ Insert (Iterative)

Traverse until the left or right child becomes `null`, then attach the new node.

---

## 📉 Find Minimum

Move to the **leftmost node**.

```text
while(left != null)
    left
```

---

## 📈 Find Maximum

Move to the **rightmost node**.

```text
while(right != null)
    right
```

---

## 🔢 Count Nodes in Range [L, H]

### Idea

If

```text
root < L
```

Skip the left subtree.

If

```text
root > H
```

Skip the right subtree.

Otherwise

- Count current node
- Search both subtrees

### Pattern

Uses the BST property to prune unnecessary branches.

---

# 2️⃣ Kth Smallest Element

## Method 1 (Extra Space)

- Perform Inorder Traversal
- Store values in an array
- Return `k - 1` index

### Observation

✅ BST Inorder = Sorted Array

---

## Method 2 (Optimal)

No extra array required.

```text
Inorder
   ↓
Decrease k
   ↓
k == 0
   ↓
Answer Found
```

---

# 3️⃣ Lowest Common Ancestor (BST)

Uses the BST property.

```text
Both Smaller
      ↓
Go Left

Both Greater
      ↓
Go Right

Otherwise
Current Node = LCA
```

✅ Only one path is visited.

---

# 4️⃣ Convert BST → Greater Sum Tree

## Core Idea

Perform **Reverse Inorder Traversal**

```text
Right
 ↓
Root
 ↓
Left
```

Maintain a running sum.

```java
sum += root.val;
root.val = sum;
```

### Why?

Because larger values are visited first.

---

## Alternative Method

- Reverse Inorder
- Store nodes
- Prefix Sum
- Update nodes

Uses extra memory.

---

# 5️⃣ Sorted Array → BST

## Goal

Build a **Balanced BST**.

```text
Middle
   ↓
 Root

Left Half      Right Half
     ↓              ↓
 Left Tree     Right Tree
```

### Rule

Always choose the middle element as the root.

---

# 6️⃣ Validate BST

## Bottom-Up Approach

Return

- Maximum
- Minimum

Every node checks:

```text
Left Max < Root

AND

Right Min > Root
```

If any condition fails

```text
Not a BST
```

---

# 7️⃣ Largest BST

Return four values:

- Maximum
- Minimum
- Size
- isBST

Current subtree is BST only if:

```text
Left BST

AND

Right BST

AND

Left Max < Root

AND

Right Min > Root
```

If valid:

```text
size = left + right + 1
```

Update:

```text
maxSize
```

---

# 8️⃣ Maximum Sum BST

Very similar to Largest BST.

Instead of Size,

Return:

- Sum

If subtree is BST:

```text
sum = left + right + root
```

Update

```text
maxSum
```

---

# 9️⃣ Morris Traversal

## Goal

- Inorder Traversal
- No Stack
- No Recursion
- **O(1) Space**

### Algorithm

```text
Current = Root

↓

Left == null ?

↓

Visit Node

↓

Move Right

Else

↓

Find Predecessor

↓

Thread Exists?

↓

No
Create Thread
Move Left

Yes
Remove Thread
Visit Node
Move Right
```

---

# 🔟 Validate BST using Morris Traversal

Same Morris Traversal.

Maintain a variable:

```text
prev
```

During inorder traversal:

```text
prev >= current
```

↓

Not BST

### Reason

BST Inorder must always be **strictly increasing**.

---

# 1️⃣1️⃣ Delete Leaf Node

Found target.

```text
Return null
```

Parent disconnects automatically.

---

# 1️⃣2️⃣ Delete Node with One Child

If only left child exists:

```text
return left
```

If only right child exists:

```text
return right
```

Parent reconnects automatically.

---

# 1️⃣3️⃣ Delete Node with Two Children

Most important delete case.

```text
Find Inorder Predecessor
(Maximum in Left Subtree)

↓

Delete Predecessor

↓

Attach Left & Right Subtrees

↓

Return Predecessor
```

The predecessor becomes the new root of that subtree.

---

# ⭐ BST Golden Rules

- ✅ Left < Root < Right
- ✅ Inorder = Sorted Order
- ✅ Reverse Inorder = Descending Order
- ✅ Leftmost Node = Minimum
- ✅ Rightmost Node = Maximum
- ✅ Search / Insert / Delete → Only One Path
- ✅ Morris Traversal = O(1) Space
- ✅ LCA uses BST Property
- ✅ Greater Sum Tree → Reverse Inorder
- ✅ Sorted Array → Middle becomes Root
- ✅ Largest BST & Maximum Sum BST → Bottom-Up DP

---

# 📄 Handwritten Notes (PDF)

I have also prepared handwritten notes with Java implementations and detailed explanations for quick revision.

📥 **Download PDF:**

**https://drive.google.com/file/d/1J31iAKnpPpyxkg0HUTjUG-sFbOTwfsol/view?usp=drive_link**

---

# 💻 Language

- Java

---

# 🚀 Goal

The objective of this repository is to understand **BST concepts**, recognize **problem-solving patterns**, and build strong interview fundamentals instead of memorizing code.
