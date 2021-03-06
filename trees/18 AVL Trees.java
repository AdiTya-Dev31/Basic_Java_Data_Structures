/**


        For making Balanced Binary Search Tree (AVL tree) - 
        
        condition -->  (left sub tree height) - (right sub tree height) should be --> { -1, 0 , 1}
        
        for making a BBST (AVL) tree - 
        
        step1 - sort the array
        
        step2 - recursivlly      // HINT - mid parts are the roots
                
                    - root = mid
                    - root.left = recursiveCall(0, mid-1)
                    - root.right = recursiveCall(mid+1, r);
                    
         example  - arr[] = {3,2,1,7,4,5,6};
         
         BST -     3
                 /   \
                2     7     <--   for this node 7  (left - right) = (3 - 0) = 3 hence not balanced
               /     /
              1     4
                     \
                      5
                       \
                        6

        Sorted -    1 2 3 (4) 5 6 7    4=mid=root
        
        step1   -     4
                    /   \
                1(2)3   5(6)7      2=mid of left subtree   6 is the mid of right subtree 
                  
        step2   -      4
                     /   \
                    2     6
                   / \   /  \
                  1   3 5    7     now its perfectly balanced subtree


**/



import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        this.data = x;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    
    public static void preorder(Node root){   // left root right
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    // A V L  Function
    public static Node AVL(int[] arr, int l, int r){     // mids are the roots 
        if(l>r) return null;
        int m = (l+r)/2;
        Node root = new Node(arr[m]);     // setting middle element as the root of the current tree
        root.left = AVL(arr, l, m-1);     // calling for the left subtree
        root.right = AVL(arr, m+1, r);    // calling for the right subtree
        return root;
    }
    
    
    public static Node makeBst(Node root, int x){
        if(root == null) return new Node(x);
        if(x <= root.data) root.left = makeBst(root.left, x);
        if(x > root.data) root.right = makeBst(root.right, x);
        return root;
    }
    
    public static Node makeBst(int[] arr){
        Node root = null;
        for(int x : arr) root = makeBst(root, x);
        return root;
    }
    
    
    public static void main(String[] args){
        int[] arr = {3,2,1,6,4,5};
        Node root = makeBst(arr);
        Arrays.sort(arr);
        root = AVL(arr, 0, arr.length-1);
        preorder(root);
    }
    
}

//  3 1 2 5 4 6 
