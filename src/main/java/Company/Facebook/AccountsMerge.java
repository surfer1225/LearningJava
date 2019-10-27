package main.java.Company.Facebook;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
721. Accounts Merge

Given a list accounts, each element accounts[i] is a list of strings,
where the first element accounts[i][0] is a name,
and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts.
Two accounts definitely belong to the same person if there is some email that is common to both accounts.
Note that even if two accounts have the same name,
they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format:
the first element of each account is the name, and the rest of the elements are emails in sorted order.
The accounts themselves can be returned in any order.

Example 1:
Input:
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        String[] accountName = new String[accounts.size()];

        int[] roots = new int[accounts.size()];
        for (int i=0;i<roots.length;++i) roots[i]=i;

        Map<String, Integer> emailMap = new HashMap<>();

        for (int i=0;i<accounts.size();++i) {
            accountName[i] = accounts.get(i).get(0);
            for (int j=1;j<accounts.get(i).size();++j) {
                String email = accounts.get(i).get(j);
                if (emailMap.containsKey(email)) {
                    union(emailMap.get(email), i, roots);
                }
                else {
                    emailMap.put(email,i);
                }
            }
        }

        Map<Integer, Set<String>> res = new HashMap<>();
        for (List<String> account:accounts) {
            for (String email:account) {
                if (emailMap.containsKey(email)) {
                    int root = find(emailMap.get(email), roots);
                    if (res.containsKey(root)) {
                        res.get(root).add(email);
                    }
                    else {
                        Set<String> accountForIndex = new TreeSet<>();
                        accountForIndex.add(accountName[root]);
                        accountForIndex.add(email);
                        res.put(root, accountForIndex);
                    }
                    emailMap.remove(email);
                }
            }
        }

        return res.values().stream().map(LinkedList::new).collect(Collectors.toList());
    }

    private void union(int i, int j, int[] roots) {
        int iRoot = find(i, roots);
        int jRoot = find(j, roots);

        if (iRoot != jRoot) roots[iRoot] = jRoot;
    }

    private int find(int i, int[] roots) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }

        while (roots[i]!=root) {
            int next = roots[i];
            roots[i] = root;
            i = next;
        }

        return root;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(new LinkedList<>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
        accounts.add(new LinkedList<>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com")));
        accounts.add(new LinkedList<>(Arrays.asList("Mary","mary@mail.com")));
        accounts.add(new LinkedList<>(Arrays.asList("John","johnnybravo@mail.com")));

        AccountsMerge am = new AccountsMerge();
        for (List<String> accts:am.accountsMerge(accounts)) {
            for (String str:accts) System.out.println(str);
        }
    }
}
