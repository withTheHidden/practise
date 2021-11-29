### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res = target - nums[i];
            for(int j = i+1;j < nums.length;j++){
                if(nums[j] == res){
                    int [] arr={i,j};
                    return arr;
                }
            }
        }
        return null;

    }
}
```