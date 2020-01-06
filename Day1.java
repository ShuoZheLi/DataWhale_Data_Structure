import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {

	}

	// 写了一个简易arraylist类，姑且就叫DyArray吧。
	public static void solution1(int num) {
		DyArray list = new DyArray<Integer>();
		for(int i=2; i<=200; i++) {
			if(i%5==0 || i%7==0) {
				list.add(i);
			}
		}
		System.out.println(list.toString());
	}
	
	// 从开始每行都检查简化成了只检查当前元素的下一行然后直接换下一个元素
	public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length-1; i++) {
			for(int j=0; j<matrix[0].length-1; j++) {
			    if(matrix[i][j]!=matrix[i+1][j+1]){
                    return false;
                }
			}
		}
		return true;
    }

	// 错误的认为是subset sum问题，想了很久如何用递归来解
	// 后来发现可以直接简化成 2 sum问题，先使用排序来避免重复
	// 锁定一个数并求出与之求和并为0的数，然后对后段数组进行搜索
	// 检查下一个数是否与当前数重复，如果是则持续移位来避免重复
	// 由于第一个锁定的数不重复，且后两位数检测了是否重复
	// 配合使用排序来避免了重复的问题。这点值得总结跟学习。
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int target = 0 - nums[i];
				int low = i + 1;
				int high = nums.length - 1;
				while (low < high) {
					if (nums[low] + nums[high] == target) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1])
							low++;
						while (low < high && nums[high] == nums[high - 1])
							high--;
						low++;
						high--;
					} else if (nums[low] + nums[high] > target) {
						high--;
					} else {
						low++;
					}
				}
			}
		}
		return result;
	}

}
