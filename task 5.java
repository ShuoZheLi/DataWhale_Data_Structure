public int lengthOfLongestSubstring(String s) {
    int ret = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, start = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) 
            start = Math.max(map.get(c)+1, start);
        ret = Math.max(ret, i-start+1); 
        map.put(c, i);
    }
    return ret;
}

public static List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new ArrayList<Integer>();
    if (S == null || L == null || L.length == 0) return res;
    int len = L[0].length(); // length of each word
    
    Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
    for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
    
    for (int i = 0; i <= S.length() - len * L.length; i++) {
        Map<String, Integer> copy = new HashMap<String, Integer>(map);
        for (int j = 0; j < L.length; j++) { // checkc if match
            String str = S.substring(i + j*len, i + j*len + len); // next word
            if (copy.containsKey(str)) { // is in remaining words
                int count = copy.get(str);
                if (count == 1) copy.remove(str);
                else copy.put(str, count - 1);
                if (copy.isEmpty()) { // matches
                    res.add(i);
                    break;
                }
            } else break; // not in L
        }
    }
    return res;
}

class Solution {
    public int balancedString(String s) {
        int[] count = new int[128];
        char[] arr = s.toCharArray();
        
        // 1) count number of QWER chars
        for (char c: arr) {
            count[c]++;
        }
        
        int need = arr.length / 4;
        
        // Sliding window
        int left = 0;
        int right = 0;
        int min = arr.length; // min substring length
        while (right <= arr.length) {
            // Move right while any of char count in strin more than 'need'
            if (count['Q'] > need || count['W'] > need || count['E'] > need || count['R'] > need) {
				if (right >= arr.length)
					break;
                char rightCh = arr[right];
                count[rightCh]--;
                right++;
                continue;
            }
            min = Math.min(min, right-left);
            if (min == 0)
                break;
            char leftCh = arr[left];
            count[leftCh]++;
            left++;
        }
        return min;
    }
}