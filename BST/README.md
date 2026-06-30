🌳 Binary Search Tree (BST) - Concept Notes
1. BST Implementation (Search, Insert, Min, Max, Count)
🔹 Search
Compare current node with target.
If equal → Found.
If target smaller → Go Left.
If target greater → Go Right.

Remember: Only one path is visited.

🔹 Insert (Recursive)
Reach a null position.
Create new node.
Return node.
Parent automatically connects through recursion.
small -> left
large -> right
null -> create node
🔹 Insert (Without Return)
Traverse until left/right becomes null.
Attach new node there.
🔹 Minimum

Go left until left becomes null.

while(left != null)
    left
🔹 Maximum

Go right until right becomes null.

while(right != null)
    right
🔹 Count Nodes in Range [L,H]

Idea:

root < L
Skip Left

root > H
Skip Right

Otherwise
Count current
Search both sides

Uses BST property to prune unnecessary nodes.

2. Kth Smallest Element
Method-1 (Extra Space)
Do inorder.
Store values.
Return k-1 index.
BST Inorder = Sorted Array
Method-2 (Better)

No extra array.

Inorder
↓

Decrease k

↓

k==0

↓

Answer Found
3. Lowest Common Ancestor (BST)

Use BST property.

Both smaller
↓

Go Left

Both greater
↓

Go Right

Otherwise

Current node is LCA

Only one path is visited.

4. Convert BST → Greater Sum Tree
Core Idea

Reverse Inorder

Right

↓

Root

↓

Left

Keep a running sum.

sum += root.val

root.val = sum

Because larger values are visited first.

Alternate Method
Reverse inorder
Store nodes
Traverse array
Prefix sum
Update nodes

Uses extra space.

5. Sorted Array → BST

Goal:

Balanced BST.

Middle

↓

Root

Left Half

↓

Left Subtree

Right Half

↓

Right Subtree

Always choose middle element.

6. Validate BST (Bottom-Up)

Return

Maximum
Minimum

Every node checks

Left Max < Root

AND

Right Min > Root

If any node fails

flag = false
7. Largest BST Size

Return 4 things

Maximum

Minimum

Size

isBST

Current subtree is BST only if

Left BST

AND

Right BST

AND

Left Max < Root

AND

Right Min > Root

If BST

size = left + right + 1

Update maxSize
8. Maximum Sum BST

Almost same as Largest BST.

Instead of size

Return

Sum

If subtree is BST

sum = left + right + root

Update maxSum
9. Morris Traversal

Goal

Inorder

Without Stack

Without Recursion

O(1) Space

Algorithm

curr = root

↓

If left is null

Print

Move Right

Else

Find predecessor

(Rightmost node of left subtree)

↓

If thread not created

pred.right = curr

Move Left

↓

Else

Remove thread

Print current

Move Right

Remember

Thread Create

↓

Go Left

Thread Remove

↓

Visit Node

↓

Go Right
10. Validate BST using Morris Traversal

Same Morris traversal.

Extra variable

prev

During inorder

if(prev >= curr.val)

Not BST

Because inorder of BST must be strictly increasing.

11. Delete Node (Leaf)

Found target

↓

Simply return

null

Parent automatically disconnects through recursion.

12. Delete Node (One Child)

Found target

If only left exists

return left

If only right exists

return right

Parent reconnects automatically.

13. Delete Node (Two Children)

Most important delete case.

Steps

Find predecessor
(Maximum in Left Subtree)

↓

Delete predecessor

↓

Attach

pred.left

pred.right

↓

Return predecessor

Predecessor becomes new root of that subtree.



⭐ BST Golden Rules

✅ Left < Root < Right

✅ Inorder = Sorted

✅ Reverse Inorder = Descending

✅ Leftmost = Minimum

✅ Rightmost = Maximum

✅ Search / Insert / Delete → One Path

✅ Morris = O(1) Space

✅ LCA uses BST property

✅ Greater Sum Tree = Reverse Inorder

✅ Sorted Array → Middle becomes Root

✅ Largest BST / Max Sum BST → Bottom-up DP (return max, min, size/sum, isBST)


## 📄 Full Notes PDF

👉 https://drive.google.com/file/d/1J31iAKnpPpyxkg0HUTjUG-sFbOTwfsol/view?usp=drive_link