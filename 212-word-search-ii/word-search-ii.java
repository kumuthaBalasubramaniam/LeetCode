class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node,
List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) {
            return;
        }

        node = node.next[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new TrieNode();
                }
                node = node.next[idx];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}