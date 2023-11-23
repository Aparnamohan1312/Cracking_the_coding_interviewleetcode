class Solution {
    public int maxArea(int[] height) {
        int right = height.length-1, left = 0,area=0, max=0;
        while(right!=left){
            area = (right-left);
            if(height[right]>height[left]){
                area*=height[left];
                left++;
                max = Math.max(max,area); //repeated
            }
        
            else{
               area*=height[right];
               right--;
               max = Math.max(max,area);//(1,18) 18,40
        }}
        return max;
    }
}
//Brute_force
//         int min=0,width=0,product=0, max =0;
//        // List<Integer> area = new ArrayList<>();
//         for(int i=0;i<height.length;i++){
   
//             for(int j=i+1; j<height.length;j++){
//                 min = Math.min(height[i],height[j]);
//                 width = j-i;
//                 product = min*width;
//                 max = Math.max(max,product);
//                 //area.add(product);
//             }}
//         return max;