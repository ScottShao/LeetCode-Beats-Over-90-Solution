public class Codec {

    public String encode(List<String> strs) {
        return strs.stream()
                   .map(s -> s.replace("/", "//").replace("*", "/*") + "*")
                   .collect(Collectors.joining()); 
    }
    
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                str.append(s.charAt(++i));
            } else if (s.charAt(i) == '*') { 
                res.add(str.toString()); 
                str.setLength(0); 
            } else {
                str.append(s.charAt(i));
            }
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));