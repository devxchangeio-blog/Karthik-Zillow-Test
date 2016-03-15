/**
 * 
 */
package me.karthik.trinarytree;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

/**
 * 
 * @author karthik
 *
 */
public class TrinaryTreeTest {

	@Test
	public void testInsertNodes()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9);
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		assertEquals("2245579", trinaryTree.output());
	}
	
	@Test
	public void testDeleteSingleNode()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9); 
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		
		trinaryTree.deleteNode(9);//deleting 3rd Node
		
		assertEquals("224557", trinaryTree.output());
	}
	
	@Test
	public void testDeleteMultipleNode()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9); 
		trinaryTree.insertNode(5); 
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		
		trinaryTree.deleteNode(5);//deleting 4th Node
		trinaryTree.deleteNode(9);//deleting 3rd Node
		
		assertEquals("22457", trinaryTree.output());
	}
	
	@Test
	public void testDeleteAllNode()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9); 
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		
		trinaryTree.deleteNode(2);
		trinaryTree.deleteNode(2);
		trinaryTree.deleteNode(7); 
		trinaryTree.deleteNode(5);
		trinaryTree.deleteNode(9);
		trinaryTree.deleteNode(4);
		trinaryTree.deleteNode(5);
		
		assertEquals("", trinaryTree.output());
	}
	
	
	@Test(expected=NoSuchElementException.class)
	public void testDeleteNonExistingNode()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9);
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		
		trinaryTree.deleteNode(8); // non existing node
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDelete()
	{
		TrinaryTree trinaryTree = new TrinaryTree();
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(4);
		trinaryTree.insertNode(9);
		trinaryTree.insertNode(5);
		trinaryTree.insertNode(7);
		trinaryTree.insertNode(2);
		trinaryTree.insertNode(2);
		
		trinaryTree.deleteNode(9); // deleting the existing node
		trinaryTree.deleteNode(9); // no node to delete
	}

}
