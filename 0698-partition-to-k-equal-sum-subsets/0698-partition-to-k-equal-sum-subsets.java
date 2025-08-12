class Solution {
    public boolean f(int sum,int start,int cnt,int[] nums,int mask,int[] dp,int tot,int k){
        if(cnt==k){
            return mask==(1<<nums.length)-1;
        }
        if(dp[mask]!=-1){
            return dp[mask]==1;
        }
        boolean ans=false;
        for(int i=start;i<nums.length;i++){
            if((mask & (1<<i))==0){
                int newsum=sum+nums[i];
                if(newsum>tot/k){
                    continue;
                }
                if(newsum==tot/k){
                    ans|=f(0,0,cnt+1,nums,mask|(1<<i),dp,tot,k);
                }
                else{
                    ans|=f(newsum,i+1,cnt,nums,mask|(1<<i),dp,tot,k);
                }
            }
        }
        dp[mask]=ans?1:0;
        return ans;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int tot=0;
        for(int val:nums){
            tot+=val;
        }
        if(tot%k!=0){
            return false;
        }
        Arrays.sort(nums);
        if(nums[n-1]>tot/k){
            return false;
        }
        int mask=(1<<n);
        int[] dp=new int[mask];
        Arrays.fill(dp,-1);
        return f(0,0,0,nums,0,dp,tot,k);
    }
}