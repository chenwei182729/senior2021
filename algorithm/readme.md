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



## 深度优化搜索 & 广度优先搜索 & 优先级优先（启发式）搜索



> 深度优先搜索


```python
visited = set()
def dfs(node,visited):
    if node in visited:
        return
    
    visited.add(node)
    
	for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
```


非递归方式


```python
visited = set()
def dfs(self,tree):
    if tree.root is None:
        return []
    
    visited,stack = [],[tree.root]
	while stack:
        node = stack.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        stack.push(nodes)
```


> 广度优先搜索

```python
visited = set()
def bfs(graph,start,end):
    queue = []
    queue.append([start])
    visited.add(start)

	while queue:
        node = queue.pop()
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.push(nodes)
```





#### * [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

#### * [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)

一般能想到的回溯的方式是逐个改变基因中的碱基(A、C、G、T)，当改变后的基因在基因库中 步数+1 并进入下一层。
但题目中说明了每一次基因变化都属于基因库，那么遍历基因库，找到库中与当前基因相差一个碱基的就是下一步变化的基因，这时步数+1并进入下一层会比上面的方式省很多。

```java
class Solution {
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }
    private void dfs (HashSet<String> step, int stepCount, 
        String current, String end, String[] bank) {
        if (current.equals(end)) 
            minStepCount = Math.min(stepCount, minStepCount);
        for (String str: bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) 
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}
```



#### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)

#### [515. 在每个树行中找最大值](https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/)









