class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        Stack<int[]> stack = new Stack();

        int previous = Integer.MIN_VALUE;
        for(int[] array: intervals){
            if(array[0] <= previous && previous < array[1]){
                int[] previousArr = stack.pop();
                previousArr[1] = array[1];
                previous = array[1];
                stack.push(previousArr);
            }else if(previous < array[1]){
                previous = array[1];
                stack.push(array);
            }

        }

        int[][] output = new int[stack.size()][2];
        int elementLen = stack.size()  -1;
        while(!stack.isEmpty()){
            if(elementLen >= 0){
                int[] arr = stack.pop();
                output[elementLen][0] = arr[0];
                output[elementLen][1] = arr[1];
                elementLen--; 
            }
        }

        return output;
    }
}
    
