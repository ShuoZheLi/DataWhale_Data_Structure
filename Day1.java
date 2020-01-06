import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {

	}

	// д��һ������arraylist�࣬���Ҿͽ�DyArray�ɡ�
	public static void solution1(int num) {
		DyArray list = new DyArray<Integer>();
		for(int i=2; i<=200; i++) {
			if(i%5==0 || i%7==0) {
				list.add(i);
			}
		}
		System.out.println(list.toString());
	}
	
	// �ӿ�ʼÿ�ж����򻯳���ֻ��鵱ǰԪ�ص���һ��Ȼ��ֱ�ӻ���һ��Ԫ��
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

	// �������Ϊ��subset sum���⣬���˺ܾ�����õݹ�����
	// �������ֿ���ֱ�Ӽ򻯳� 2 sum���⣬��ʹ�������������ظ�
	// ����һ�����������֮��Ͳ�Ϊ0������Ȼ��Ժ�������������
	// �����һ�����Ƿ��뵱ǰ���ظ���������������λ�������ظ�
	// ���ڵ�һ�������������ظ����Һ���λ��������Ƿ��ظ�
	// ���ʹ���������������ظ������⡣���ֵ���ܽ��ѧϰ��
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
