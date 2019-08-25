import java.util.Stack;

public class LongestValidParen{
    public static int longestValidParentheses(String s) {
        int openParenCount = 0;
        int unclosedCount = 0;   //"(()" -> has hanging open paren -> unclosedCt = 2 
        int closedCount = 0;    //"()" closedCt = 2
        int longestValidCount = 0;

        //SWAP updated closedCt and update unclosedCt for clarity

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){     
                openParenCount++;
            } else if(s.charAt(i) == ')'){
                if (openParenCount > 1){     //update unclosedCt
                    openParenCount--;
                    unclosedCount += 2;
                } else  if (openParenCount == 1){   //update closedCt
                    openParenCount--;
                    unclosedCount += 2;
                    closedCount += unclosedCount;
                    unclosedCount = 0;
                } else {    //invalid 
                    if (closedCount > longestValidCount){
                        longestValidCount = closedCount;
                    }
                    closedCount = 0;   //reset the count
                }
            }
        }
        longestValidCount = (closedCount > longestValidCount) ? closedCount : longestValidCount;
        longestValidCount = (unclosedCount > longestValidCount) ? unclosedCount : longestValidCount;
        return longestValidCount;
    }

    public static int longestValidParentheses2(String s) {
        Stack<Character> parenCounter = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                parenCounter.push('(');
            } else  { //if (s.charAt(i) == ')')
                parenCounter.peek();
            }
        }
        while (!parenCounter.isEmpty()){
            System.out.println(parenCounter.pop());

        }
        return 2;
    }

    public static void test(){
        System.out.println("Count: " + longestValidParentheses2("(()(()"));
        //"(() (() (() )))"
        //"())"
    }

    /*} else if(s.charAt(i) == ')'){
            if (openParenCount == 1){
                openParenCount--;
                unclosedCount += 2;
                closedCount = unclosedCount;
                unclosedCount = 0;
            } else if (openParenCount > 1){     //update unclosedCt
                openParenCount--;
                unclosedCount += 2;
            } else {    //invalid 
                if (closedCount > longestValidCount){
                    longestValidCount = closedCount;
                }
                closedCount = 0;   //reset the count
            }
        }*/
}