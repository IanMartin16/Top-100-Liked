import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String currentString = "";
        int index = 0;
        
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(currentString);
                currentString = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
                index++;
            } else {
                currentString += s.charAt(index);
                index++;
            }
        }
        
        return currentString;
    }

    public static void main(String[] args) {
        String encodedString1 = "3[a]2[bc]";
        System.out.println(decodeString(encodedString1)); // Output: aaabcbc

        String encodedString2 = "3[a2[c]]";
        System.out.println(decodeString(encodedString2)); // Output: accaccacc

        String encodedString3 = "2[abc]3[cd]ef";
        System.out.println(decodeString(encodedString3)); // Output: abcabccdcdcdef
    }
}


//Given an encoded string, return its decoded string.

//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
//Note that k is guaranteed to be a positive integer.

//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. 
//Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
//For example, there will not be input like 3a or 2[4].

//The test cases are generated so that the length of the output will never exceed 105.