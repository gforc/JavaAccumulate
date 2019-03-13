
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c; 
            } else if (c == ')' && stack[--top] != '(') { ####先匹配c == ')'，如果匹配成功，再匹配stack[--top] != '('，无论是否匹配上，top都自己减1；如果c == ')'没有匹配成功，直接跳到下一个if语句，不在匹配&&后面的，所有top不会减1.
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
            System.out.println(top);
        }
        return top == 1;
    }
    
