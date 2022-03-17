public class Solution {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    private int start =0;
    public TreeNode str2tree(String s) {
        // write your code here
        if(s==null || s.length()==0){
            return null;
        }
        return str2treehelper(s);
    }

    public TreeNode str2treehelper(String s){
        if(start>=s.length()){
            return null;
        }
        TreeNode root =null;
        boolean neg = false;
        if(s.charAt(start) == '-'){
            neg=true;
            start++;
        }
        int num=0;
        while(start<s.length() && Character.isDigit(s.charAt(start))){
            num=num*10+ (s.charAt(start)-'0');
            start+=1;
        }
        if(neg) { num=-num;}
        root=new TreeNode(num);
        if(start >= s.length()){return root;}
        if(start< s.length() && s.charAt(start)=='('){
            start+=1;
            root.left= str2treehelper(s);
        }
        if(start < s.length() && s.charAt(start)==')'){
            start+=1;
            return root;
        }
        if(start< s.length() && s.charAt(start) == '('){
            start+=1;
            root.right=str2treehelper(s);
        }
        if(start< s.length() && s.charAt(start) == ')'){
            start+=1;
            return root;
        }
        return root;
    }
}
