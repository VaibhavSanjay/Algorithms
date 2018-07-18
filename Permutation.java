import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
// Java program to print all permutations of a
// given string.
public class Permutation
{
	
	private static Set<String> permutationsSet;
	private static ArrayList<String> permutationsCollection;
	
	public static Set<String> getPermsSet(String inp)
	{
		permutationsSet = new HashSet<String>();
		permuteSet(inp, 0, inp.length() - 1);
		return permutationsSet;
	}
	
	public static ArrayList<String> getPermsCollection(String inp)
	{
		permutationsCollection = new ArrayList<String>();
		permuteCollection(inp, 0, inp.length() - 1);
		return permutationsCollection;
	}
	
	/**
	* permutation function
	* @param str string to calculate permutation for
	* @param l starting index
	* @param r end index
	*/
	private static void permuteSet(String str, int l, int r)
	{
		if (l == r)
			permutationsSet.add(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permuteSet(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}
	
	private static void permuteCollection(String str, int l, int r)
	{
		if (l == r)
			permutationsCollection.add(str);
		else
		{
			for (int i = l; i <= r; i++)
			{
				str = swap(str,l,i);
				permuteCollection(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	/**
	* Swap Characters at position
	* @param a string value
	* @param i position 1
	* @param j position 2
	* @return swapped string
	*/
	private static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
}

// This code is contributed by Mihir Joshi
