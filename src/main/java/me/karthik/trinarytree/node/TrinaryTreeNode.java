/**
 * 
 */
package me.karthik.trinarytree.node;

/**
 * @author karthik
 *
 */
public class TrinaryTreeNode {

	public TrinaryTreeNode leftNode; //left node should always less than current node

	public TrinaryTreeNode rightNode; //right node should always greater than current node

	public TrinaryTreeNode middleNode; //middlw node should always equal to current node

	public int data;

	public TrinaryTreeNode(int data) {
		this.data = data;
	}

}
