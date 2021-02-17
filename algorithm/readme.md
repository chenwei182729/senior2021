##  基本流程

* #### [02.移动零](https://leetcode-cn.com/problems/move-zeroes/submissions/)
* #### [03.盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
* #### [22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

### 哈希表、映射集合

* #### [49.字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)
* #### [1.两数之和](https://leetcode-cn.com/problems/two-sum/)

### 二叉树

* #### [94.二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

### 递归

```java
public void recur(int level,int param) {
  if (level>MAX_LEVEL) {
    return;
  }
  process(level,param);
  recur(level:level+1,param);
}
```

#### *[22.括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

#### * [226.翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

####  *[98.验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/)

- #### [297.二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

> Homework

- #### [236.二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- #### [ 105.从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
- #### [77.组合](https://leetcode-cn.com/problems/combinations/)
- #### [47.全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

## 分治 && 回溯



> 分治模板

```python
def divide_conquer(problem,param1,param2,...):
    # recursion terminator
    if problem is None:
        print_result
        return
    
    data = prepare_data(problem)
    subproblem = split_problem(problem,data)
    
    # conquer subproblems
    subresult1 = self.divide_conquer(subproblem[0],p1,...)
    subresult2 = self.divide_conquer(subproblem[1],p1,...)
    subresult3 = self.divide_conquer(subproblem[2],p1,...)
    
    # process and generate the final result
    result = process_result(subresult1,subresult2,subresult3,...)
    
    # revert the current level states
```



> 回溯模板



重复性

#### * [50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

#### * [78. 子集](https://leetcode-cn.com/problems/subsets/)



#### * [169. 多数元素](https://leetcode-cn.com/problems/majority-element/)

#### * [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

#### * [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

#### * [面试题 08.12. 八皇后](https://leetcode-cn.com/problems/eight-queens-lcci/)







