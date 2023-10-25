import java.util.*;
// public class bst {
//     Node root;
//     class Node{
//         int key;
//         int value;
//         Node left;
//         Node right;
//         Node(int key, int value){
//             this.key = key;
//             this.value = value;
//         }
//     }

//   public void addNode(int key, int value){
//     Node newNode = new Node(key,value);
//     if(root == null){
//         root = newNode;
//         return; //to improve readibility
//     }
    
//     Node currNode = root;
//        //recursive :TODO
//         while(true){
           
//              Node parent = currNode; //reduce scope of variables
//              currNode = currNode.key > key ? currNode.left : currNode.right;
        
//             if(currNode == null){
//               if (parent.key > key) {
//                       parent.left = newNode;
//                     } 
//             else {
//                 parent.right = newNode;
//              }
//                 return;
//             }
//     }
//     //Node parent = null;
//     // while(currNode != null) {
//     //     parent = currNode;
//     //     currNode = currNode.key > key ? currNode.left : currNode.right;
//     // }
//     // if (parent.key > key) {
//     //     parent.left = newNode;
//     // } else {
//     //     parent.right = newNode;
//     // }
//   }
//   public  void inOrder(Node currNode ){
// if(currNode!=null){
//     inOrder(currNode.left);
//     System.out.println(currNode.key);

// }
//   }
//   public static void main(String[] args){
//     bst tree = new bst();
//     tree.addNode(1, 25);
//     tree.addNode(2, 30);
//     tree.addNode(3, 50);
//     tree.addNode(0, 20);
//     tree.addNode(8, 80);

//     tree.inOrder(tree.root);
//   }
// }
 class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }}
public class bst{
   
        //Recursion
        public static void inOrderfun(ArrayList<Integer> inorder, Node curr){
                if(curr == null)
                return;
                inOrderfun(inorder, curr.left);
                inorder.add(curr.data);
                inOrderfun(inorder, curr.right);
        }
        public static void main(String[] args){
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right = new Node(3);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
            ArrayList<Integer> inorder = new ArrayList<>();
            inOrderfun(inorder,root);
            System.out.println("Inorder traversal:");
            for(int i=0;i<inorder.size();i++)
            System.out.print(inorder.get(i) + " ");
        }
}

//1 25
//2 60
//3 50
//Node currNode = root;
    