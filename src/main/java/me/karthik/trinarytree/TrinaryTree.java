/**
 * 
 */
package me.karthik.trinarytree;

import java.util.NoSuchElementException;
import me.karthik.trinarytree.node.TrinaryTreeNode;

/**
 * TrinaryTree class
 * 
 * void insertNode( newNode )          
 * void deleteNode( currentNode )
 * 
 * Throws NoSuchElementException
 * 
 * @author karthy
 *
 */
public class TrinaryTree {

	private TrinaryTreeNode rootNode;
	private StringBuilder output;

	public TrinaryTree() {
		rootNode = null;
		output = new  StringBuilder();
	}

	/**
	 * 
	 * @return output 
	 */
	public String output() 
	{
		inOrderOutput(rootNode);
		return output.toString();
	}

	/**
	 * 
	 * @param rootNode
	 */
	private void inOrderOutput(TrinaryTreeNode rootNode) 
	{
		if (rootNode != null) 
		{
			inOrderOutput(rootNode.leftNode);
			output.append(rootNode.data);
			inOrderOutput(rootNode.middleNode);
			inOrderOutput(rootNode.rightNode);
		}
	}

	/**
	 * 
	 * @param newNode
	 */
	public void insertNode(int newNode) {
		rootNode = insertNode(newNode, rootNode);
	}
	
	/**
	 * 
	 * @param currentNode
	 */
	public void deleteNode(int currentNode) {
		rootNode = deleteNode(currentNode, rootNode);
	}

	/**
	 * 
	 * @param newNode
	 * @param rootNode
	 * @return
	 */
	private TrinaryTreeNode insertNode(int newNode, TrinaryTreeNode rootNode) {
		
		if ( null == rootNode) 
			rootNode = new TrinaryTreeNode(newNode);
		 
		else if (newNode < rootNode.data) 
		{
			if (rootNode.leftNode != null) 
				rootNode.leftNode = insertNode(newNode, rootNode.leftNode);
			else 
				rootNode.leftNode = new TrinaryTreeNode(newNode);
			

		} else if (newNode > rootNode.data) 
		{
			if (rootNode.rightNode != null)
				rootNode.rightNode = insertNode(newNode, rootNode.rightNode);
			else 
				rootNode.rightNode = new TrinaryTreeNode(newNode);
			
		} else 
		{
			if (rootNode.middleNode != null) 
				rootNode.middleNode = insertNode(newNode, rootNode.middleNode);
			else 
				rootNode.middleNode = new TrinaryTreeNode(newNode);
		}
		
		return rootNode;
	}
	
	
	/**
	 * 
	 * @param currentNode
	 * @param rootNode
	 * @return
	 */
	private TrinaryTreeNode deleteNode(int currentNode, TrinaryTreeNode rootNode) 
	{
		if (null == rootNode) 
			throw new NoSuchElementException();
			
		else if (currentNode < rootNode.data)
			rootNode.leftNode = deleteNode(currentNode, rootNode.leftNode);
		else if (currentNode > rootNode.data)
			rootNode.rightNode = deleteNode(currentNode, rootNode.rightNode);
		else if (currentNode == rootNode.data) 
		{
			if (rootNode.middleNode != null) 
				rootNode.middleNode = rootNode.middleNode.middleNode;
			
			else if (rootNode.rightNode != null){
				rootNode.data = getMinVal(rootNode.rightNode).data;
				rootNode.rightNode = deleteNode(rootNode.data, rootNode.rightNode);
			}
			else 
				rootNode = rootNode.leftNode;
			
		}
		
		return rootNode;
	}

	/**
	 * 
	 * @param rootNode
	 * @return
	 */
	private TrinaryTreeNode getMinVal(TrinaryTreeNode rootNode) {
		
		if (null == rootNode.leftNode) 
			return rootNode;
		
		return getMinVal(rootNode.leftNode);
	}

}
