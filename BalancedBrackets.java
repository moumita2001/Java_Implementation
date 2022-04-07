package practice;

import java.io.*;

class Result {

 
    public static String isBalanced(String s) {
    char[] braces=new char[s.length()];
    int top=-1;
    boolean k=true;
    char ch,ret;
    for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            //System.out.println(ch);
        if(ch=='{'||ch=='('||ch=='['){
            top++;
            braces[top]=ch;
           //System.out.println(braces[top]+" "+top); 
          // System.out.println(" "+top);
        //ret=braces[top];
        }
        
        
        else if(ch=='}'){
           // System.out.println(ch);
           if(top==-1){
            k=false;
            break;
            
        }
            if('{'==braces[top]){
               // System.out.println(braces[top]+" "+top); 
               // System.out.println(ch);
                k=true;
                top--;
            }
            else{
           // System.out.println(ch);
            //System.out.println(braces[top]+" "+top); 
            //System.out.println(ch);
            k=false;
            break;
        }     
        }
        else if(ch==']'){
            if(top==-1){
            k=false;
            break;
            
        }
           // System.out.println(ch);
            if('['==braces[top]){
               // System.out.println(braces[top]+" "+top); 
                //System.out.println(ch); 
                k=true;
                top--;
            }
            else{
           // System.out.println(ch);
            //System.out.println(braces[top]+" "+top); 
            //System.out.println(ch);
            k=false;
            break;
        } 
        }
        else if(ch==')'){
            if(top==-1){
            k=false;
            break;
            
        }
           // System.out.println(ch);
           if('('==braces[top]){
               //System.out.println(braces[top]+" "+top); 
              // System.out.println(ch);
                k=true;
                top--;
        }
        else{
           // System.out.println(ch);
           // System.out.println(braces[top]+" "+top); 
            //System.out.println(ch);
            k=false;
            break;
        }
        }
        
            
            
        }
        if(k){
            if(top!=-1){
                return "NO";
            }
            else{
                return "YES";
            }
        }
        else{
            return "NO";
        }
        
    }
        
    

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter valid string");
        String str=bf.readLine();
        
        System.out.println(Result.isBalanced(str));
    }
}
