package DataStructure.SegmentTree;

/**
 * Created by Frank on 2016/11/12.
 */
public class RangeSumQueryMutable {
    public class NumArray {
        private class SegmentTreeNode {
            int start, end, sum;
            SegmentTreeNode left, right;

            public SegmentTreeNode() {
            }

            public SegmentTreeNode(int start, int end, int sum) {
                this.start = start;
                this.end = end;
                this.sum = sum;
                this.left = null;
                this.right = null;
            }
        }

        SegmentTreeNode root;

        public NumArray(int[] nums) {
            root = buildTree(0, nums.length - 1, nums);
        }

        private SegmentTreeNode buildTree(int start, int end, int[] nums) {
            if (nums == null || start > end) {
                return null;
            }
            if (start == end) {
                return new SegmentTreeNode(start, end, nums[start]);
            }
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = buildTree(start, mid, nums);
            SegmentTreeNode right = buildTree(mid + 1, end, nums);

            SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum + right.sum);
            root.left = left;
            root.right = right;

            return root;
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        private void update(SegmentTreeNode root, int index, int value) {
            if (root == null || index < root.start || index > root.end) {
                return;
            }
            if (index == root.start && index == root.end) {
                root.sum = value;
                return;
            }
            update(root.left, index, value);
            update(root.right, index, value);

            root.sum = root.left.sum + root.right.sum;
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }

        private int sumRange(SegmentTreeNode root, int start, int end) {
            if (root == null || start > end || start > root.end || end < root.start) {
                return 0;
            }
            start = Math.max(start, root.start);
            end = Math.min(end, root.end);

            if (start == root.start && end == root.end) {
                return root.sum;
            }

            int left = sumRange(root.left, start, end);
            int right = sumRange(root.right, start, end);

            return left + right;
        }
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);