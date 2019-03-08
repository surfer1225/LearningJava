package main.java.DataStructure.Tree;

/*
449. Serialize and Deserialize BST

Serialization is the process of converting a data structure or object into a sequence of bits
so that it can be stored in a file or memory buffer,
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that a binary search tree can be serialized to a string and
this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states.
Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return " ,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","),new int[]{0});
    }

    private TreeNode deserialize(String[] data, int[] i) {
        if (data.length == i[0]-1) return null;
        if (data[i[0]].equals(" ")) {
            i[0]++;
            return null;
        }

        TreeNode tn = new TreeNode(Integer.valueOf(data[i[0]++]));

        tn.left = deserialize(data, i);
        tn.right = deserialize(data, i);

        return tn;
    }

    /*
    static final String DELIMITER = ",";
    static final String NULL = "#";

	// Encodes a tree to a single string.
    public String serialize(TreeNode root)
	{
        StringJoiner joiner = new StringJoiner(DELIMITER);
        buildString(root, joiner);
        return joiner.toString();
    }

    private void buildString(TreeNode root, StringJoiner joiner)
	{
        if(root == null)
		{
			joiner.add(NULL);
		}
        else
		{
            joiner.add(String.valueOf(root.val));
            buildString(root.left, joiner);
            buildString(root.right, joiner);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
	{
        Queue<String> q = new ArrayDeque<>();
        q.addAll(Arrays.asList(data.split(DELIMITER)));
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q)
	{
        String val = q.poll();

        if(val.equals(NULL))
        {
            return null;
        }
        else
        {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(q);
            root.right = buildTree(q);
            return root;
        }
    }
     */
}
