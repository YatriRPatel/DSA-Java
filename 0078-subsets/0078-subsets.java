class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        currentSubset.add(nums[index]);
        backtrack(index + 1, nums, currentSubset, result);

        currentSubset.remove(currentSubset.size() - 1);
        backtrack(index + 1, nums, currentSubset, result);
    }
}