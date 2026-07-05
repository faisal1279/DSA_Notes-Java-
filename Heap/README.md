# 🔥 Heap – Interview Revision Notes (Java)

> These notes are designed for **quick interview revision**. Instead of memorizing code, focus on understanding the **pattern**, **idea**, and **approach** behind each problem.

---

# 📚 Topics Covered

- Kth Smallest Element
- Kth Largest Element
- Nearly Sorted Array
- Last Stone Weight
- Minimum Cost of Ropes
- K Closest Points to Origin
- K Closest Elements
- Top K Frequent Elements
- Check if a Binary Tree is a Max Heap
- Convert BST to Max Heap
- Min Heap Implementation
- Find Median from Data Stream
- Smallest Range in K Sorted Lists

---

# 1️⃣ Kth Smallest Element

## 🎯 Pattern

Use a **Max Heap** of size **K**.

---

## 💡 Idea

- Traverse all elements.
- Insert every element into the Max Heap.
- If heap size becomes greater than **K**, remove the **largest** element.
- At the end, the heap contains the **K smallest elements**.
- The top of the heap is the **Kth smallest element**.

---

## ❓ Why Max Heap?

Because we always want to remove the **largest** element among the current **K smallest** elements.

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

## 🧠 Memory Trick

```text
Need K Smallest

↓

Use Max Heap

↓

Keep Heap Size = K

↓

Remove Largest
```

---

# 2️⃣ Kth Largest Element

## 🎯 Pattern

Use a **Min Heap** of size **K**.

---

## 💡 Idea

- Traverse every element.
- Insert each element into the Min Heap.
- If heap size becomes greater than **K**, remove the **smallest** element.
- Finally, the heap contains the **K largest elements**.
- Heap top is the **Kth largest element**.

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

## 🧠 Memory Trick

```text
Need K Largest

↓

Use Min Heap

↓

Keep Heap Size = K

↓

Remove Smallest
```

---

# 3️⃣ Nearly Sorted Array

## 🔍 Observation

Every element is at most **K positions away** from its correct position.

---

## 🎯 Pattern

Use a **Min Heap**.

---

## 💡 Idea

1. Insert elements one by one.
2. Whenever heap size becomes greater than **K**, remove the minimum element and place it into the array.
3. After traversal, remove the remaining elements.

---

## 🧠 Memory Trick

```text
Insert

↓

Heap Size > K

↓

Remove Minimum Immediately
```

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

# 4️⃣ Last Stone Weight

## 🎯 Pattern

Use a **Max Heap**.

---

## 💡 Idea

Always pick the **two largest stones**.

1. Remove the largest stone.
2. Remove the second largest stone.
3. If both are equal → destroy both.
4. Otherwise, insert their difference back into the heap.
5. Continue until one stone remains.

---

## 🧠 Memory Trick

```text
Largest

+

Second Largest

↓

Smash

↓

Insert Difference
```

---

## ⏱ Time Complexity

```text
O(N log N)
```

---

# 5️⃣ Minimum Cost of Ropes

## 🎯 Pattern

Use a **Min Heap**.

---

## 💡 Greedy Observation

To minimize the total cost, always connect the **two smallest ropes first**.

---

## 💡 Idea

1. Insert all ropes into a Min Heap.
2. Remove the two smallest ropes.
3. Add their sum to the answer.
4. Insert the merged rope back into the heap.
5. Continue until only one rope remains.

---

## 🧠 Memory Trick

```text
Smallest

+

Smallest

↓

Add Cost

↓

Insert Again
```

---

## ⏱ Time Complexity

```text
O(N log N)
```

---

# 📌 Quick Revision (Problems 1–5)

| Problem | Heap Used | Core Idea |
|---------|-----------|-----------|
| Kth Smallest | Max Heap | Keep only K smallest elements |
| Kth Largest | Min Heap | Keep only K largest elements |
| Nearly Sorted Array | Min Heap | Remove when heap size exceeds K |
| Last Stone Weight | Max Heap | Always remove the two largest |
| Minimum Cost of Ropes | Min Heap | Always merge the two smallest |

---

# 🚀 Continue Reading

➡️ **Part 2 covers:**

- K Closest Points to Origin
- K Closest Elements
- Top K Frequent Elements
- Check if Binary Tree is a Max Heap
- Convert BST to Max Heap
---

# 6️⃣ K Closest Points to Origin

## 📐 Distance Formula

```text
distance = x² + y²
```

> **Note:** There is no need to calculate the square root because the relative order remains the same.

---

## 🎯 Pattern

Use a **Max Heap** of size **K**.

---

## 💡 Idea

Store:

```text
(distance, x, y)
```

- Traverse all points.
- Calculate the squared distance.
- Insert into the Max Heap.
- If heap size becomes greater than **K**, remove the **farthest** point.
- Finally, the heap contains the **K closest points**.

---

## 🧠 Memory Trick

```text
Need K Closest

↓

Use Max Heap

↓

Remove Farthest Point
```

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

# 7️⃣ K Closest Elements

## 📐 Difference Formula

```text
abs(element - target)
```

---

## 🎯 Pattern

Use a **Max Heap**.

---

## 💡 Store

```text
(difference, value)
```

---

## Comparator Priority

Priority should be:

- Smaller Difference
- If differences are equal → Smaller Value

---

## 💡 Idea

- Compute the difference between every element and the target.
- Store `(difference, value)` in the Max Heap.
- Keep heap size equal to **K**.
- Remove larger differences.
- Finally, sort the answer before returning.

---

## 🧠 Memory Trick

```text
Difference

↓

Max Heap

↓

Keep K Smallest Differences

↓

Sort Answer
```

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

# 8️⃣ Top K Frequent Elements

## Step 1️⃣

Count frequencies using

```text
HashMap

Element → Frequency
```

---

## Step 2️⃣

Use a **Min Heap**.

Store:

```text
(element, frequency)
```

---

## 💡 Idea

- Count frequency of every element.
- Insert into Min Heap.
- If heap size becomes greater than **K**, remove the element with the lowest frequency.
- Finally, heap contains the **K most frequent elements**.

---

## 🧠 Memory Trick

```text
Count Frequency

↓

HashMap

↓

Min Heap

↓

Keep K Highest Frequency
```

---

## ⏱ Time Complexity

```text
O(N log K)
```

---

# 9️⃣ Check if a Binary Tree is a Max Heap

A Heap must satisfy **two conditions**.

---

## ✅ Condition 1

### Complete Binary Tree (CBT)

---

## ✅ Condition 2

### Max Heap Property

```text
Parent > Left Child

Parent > Right Child
```

---

## 🔍 Checking Complete Binary Tree

### Step 1

Calculate

```text
Total Number of Nodes
```

---

### Step 2

Assign indices like an array.

```text
Root = 1

Left = 2 × i

Right = 2 × i + 1
```

---

### Step 3

If any node gets

```text
Index > Size
```

then the tree is **not complete**.

---

## 🔍 Checking Heap Property

For every node,

```text
Parent > Left Child

Parent > Right Child
```

Check recursively.

---

## ✅ Final Answer

```text
isCompleteBinaryTree

AND

isMaxHeap
```

---

## 🧠 Memory Trick

```text
Heap Tree

↓

Complete Binary Tree

+

Heap Property
```

---

# 🔟 Convert BST → Max Heap

## 🔍 Observation

BST Inorder gives

```text
Sorted Order
```

Max Heap requires

```text
Parent > Children
```

---

## 💡 Idea

### Step 1

Perform

```text
Inorder Traversal
```

Store all values.

---

### Step 2

Perform

```text
Postorder Traversal
```

Assign values from the inorder list while visiting nodes.

---

## ❓ Why Postorder?

Postorder visits

```text
Left

↓

Right

↓

Root
```

Since the root is visited last,

it receives the **largest value**.

---

## 🧠 Memory Trick

```text
Inorder

↓

Collect

↓

Postorder

↓

Fill

↓

Max Heap
```

---

## ⏱ Time Complexity

```text
O(N)
```

---

# 📌 Quick Revision (Problems 6–10)

| Problem | Heap Used | Core Idea |
|---------|-----------|-----------|
| K Closest Points | Max Heap | Keep only K nearest points |
| K Closest Elements | Max Heap | Keep K minimum differences |
| Top K Frequent | Min Heap | Keep K highest frequencies |
| Check Max Heap Tree | Recursion | CBT + Heap Property |
| BST → Max Heap | Inorder + Postorder | Collect sorted values, then fill using postorder |

---

# 🚀 Continue Reading

➡️ **Part 3 covers:**

- Min Heap Implementation
- Find Median from Data Stream
- Smallest Range in K Sorted Lists
- Common Heap Patterns
- Final Interview Cheat Sheet
- Handwritten Notes PDF
- LinkedIn Profile
---

# 1️⃣1️⃣ Min Heap Implementation

## 🎯 Goal

Implement a **Min Heap** using an array.

---

## 📌 Indexing

```text
Parent = i / 2

Left Child = 2 × i

Right Child = 2 × i + 1
```

---

## ➕ Insert Operation

### Steps

1. Insert the new element at the last position.
2. Perform **Bubble Up**.
3. If

```text
Child < Parent
```

swap them.

4. Continue until heap property is restored.

---

## ❌ Delete Operation

### Steps

1. Remove the root.
2. Move the last element to the root.
3. Perform **Bubble Down**.
4. Swap with the smaller child until the heap property becomes valid.

---

## 🧠 Memory Trick

```text
Insert

↓

Bubble Up

-----------------

Delete Root

↓

Bubble Down
```

---

## ⏱ Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert | O(log N) |
| Delete | O(log N) |
| Peek | O(1) |

---

# 1️⃣2️⃣ Find Median from Data Stream

## 🎯 Pattern

Use **Two Heaps**

```text
Max Heap
   ↓
Left Half

Min Heap
   ↓
Right Half
```

---

## 💡 Insertion

If the new number is smaller,

```text
Insert into Max Heap
```

Otherwise,

```text
Insert into Min Heap
```

---

## ⚖️ Balancing

The difference between heap sizes should **never be greater than 1**.

---

## 📊 Median

### If both heaps have equal size

```text
(MaxHeap Top + MinHeap Top) / 2
```

### Otherwise

```text
Top of the Larger Heap
```

---

## 🧠 Memory Trick

```text
Two Heaps

↓

Balance

↓

Median
```

---

## ⏱ Time Complexity

| Operation | Complexity |
|-----------|------------|
| Insert | O(log N) |
| Find Median | O(1) |

---

# 1️⃣3️⃣ Smallest Range in K Sorted Lists ⭐

One of the **most important Heap interview problems.**

---

## 🎯 Goal

Find the **smallest range** that contains **at least one element from every list**.

---

## 🚀 Initial Step

Insert the **first element of every row** into a Min Heap.

Store

```text
(value, row, column)
```

Also maintain

```text
Current Maximum
```

---

## 🔁 Loop

1. Remove the minimum element.
2. Current range becomes

```text
[min, max]
```

3. Update the answer if this range is smaller.
4. Move **only that row**.
5. Insert the next element from the same row.
6. Update the current maximum.

Repeat.

---

## 🛑 When to Stop?

Stop as soon as **one row becomes exhausted.**

Because it is no longer possible to include one element from every list.

---

## 🧠 Memory Trick

```text
Remove Minimum

↓

Move Same Row

↓

Insert Next Element

↓

Update Maximum
```

---

## ⏱ Time Complexity

```text
O(N × K × log K)
```

(Depends on the number of rows and elements.)

---

# 🔥 Common Heap Patterns

---

## Pattern 1

### Need K Smallest Elements

✅ Use **Max Heap**

Examples:

- Kth Smallest

---

## Pattern 2

### Need K Largest Elements

✅ Use **Min Heap**

Examples:

- Kth Largest

---

## Pattern 3

### Need the Smallest Element Repeatedly

✅ Use **Min Heap**

Examples:

- Minimum Cost of Ropes
- Merge K Sorted Lists
- Smallest Range in K Lists

---

## Pattern 4

### Need the Largest Element Repeatedly

✅ Use **Max Heap**

Examples:

- Last Stone Weight

---

## Pattern 5

### Running Median

✅ Use

```text
Max Heap

+

Min Heap
```

Example:

- Find Median from Data Stream

---

## Pattern 6

### Check Heap Tree

Need

```text
Complete Binary Tree

+

Heap Property
```

---

## Pattern 7

### BST → Max Heap

```text
BST

↓

Inorder

↓

Sorted Values

↓

Postorder

↓

Max Heap
```

---

# 📋 Final Interview Cheat Sheet

| Problem | Heap Used | Main Idea |
|----------|-----------|-----------|
| Kth Smallest | Max Heap | Keep only K smallest elements |
| Kth Largest | Min Heap | Keep only K largest elements |
| Nearly Sorted Array | Min Heap | Remove when heap size exceeds K |
| Last Stone Weight | Max Heap | Always remove the two largest |
| Minimum Cost of Ropes | Min Heap | Always merge the two smallest |
| K Closest Points | Max Heap | Keep only K nearest points |
| K Closest Elements | Max Heap | Keep K minimum differences |
| Top K Frequent | Min Heap | Keep K highest frequencies |
| Check Max Heap Tree | Recursion | Complete Binary Tree + Heap Property |
| BST → Max Heap | Inorder + Postorder | Collect sorted values and fill using postorder |
| Min Heap Implementation | Array | Bubble Up & Bubble Down |
| Find Median | Two Heaps | Balance both heaps |
| Smallest Range in K Lists | Min Heap | Always move the row of the removed minimum element |

---

# ⭐ Heap Golden Rules

- ✅ Min Heap → Smallest element on top
- ✅ Max Heap → Largest element on top
- ✅ K Smallest → Max Heap
- ✅ K Largest → Min Heap
- ✅ Running Median → Two Heaps
- ✅ Nearly Sorted Array → Min Heap
- ✅ Merge Problems → Min Heap
- ✅ Last Stone Weight → Max Heap
- ✅ BST → Max Heap = Inorder + Postorder
- ✅ Heap Tree = Complete Binary Tree + Heap Property

---

# 📄 Handwritten Notes (PDF)

I have also prepared handwritten notes with Java implementations and interview-focused explanations for quick revision.

📥 **Download PDF**

**https://drive.google.com/file/d/1Xj0vezg2wcX9B_ZiEZ8bgqKXRuXr-ynA/view?usp=drive_link**

---

# 👨‍💻 Connect with Me

**LinkedIn**

**https://www.linkedin.com/in/mohammad-faisal-b30059237/**

---

# 💻 Language

- Java

---

# 🎯 Goal

The goal of this repository is to build strong **Heap fundamentals**, recognize **problem-solving patterns**, and prepare for coding interviews through **concept-based learning** rather than memorizing solutions.

---

⭐ **If you found these notes helpful, consider giving this repository a Star!**