class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[args.length];
		for(int i=0; i<args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		moveZeroes(nums);
		p("Final nums: ", nums);
	}

	public static void p(String s) {
		System.out.println(s);
	}

	public static void p(String heading, int[] nums) {
		p(heading);
		for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
		p("");
	}

	public static void moveZeroes(int[] nums) {
		int l = 0;
		int r = 1;
		for(;l<nums.length && r<nums.length;) {
			if(nums[r] != 0) {
				swap(nums, l, r);
				l++;
				r++;
			} else {
				r++;
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
