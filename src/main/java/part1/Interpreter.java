package part1;

import Util.ConstVal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by seven on 05/07/16.
 */
public class Interpreter {



    String text;
    int pos = 0;
    Token currentToken;

    public Interpreter(String text) {
        this.text = text;
        this.pos = 0;
    }

    public void error() throws Exception {
        throw new Exception("Error parsing input.");
    }

    public void skipWhiteSpace(){
        while(pos < text.length() && text.charAt(pos) == ' '){
            pos += 1;
        }
    }

    public Token getNextToken() throws Exception {
        String text = this.text;
        skipWhiteSpace();
        if (pos > text.length() - 1){
            return new Token(ConstVal.EOF, null);
        }


        String currentChar=String.valueOf(text.charAt(pos));
        if(currentChar.matches("\\d")) {
            StringBuffer sb = new StringBuffer();
            while ((currentChar = String.valueOf(text.charAt(pos))).matches("\\d")) {
                sb.append(currentChar);
                pos += 1;
            }
            return new Token(ConstVal.INTEGER, sb.toString());
        }

        if(currentChar.equals("+")){
            this.pos += 1;
            return new Token(ConstVal.PLUS, currentChar);
        }

        if(currentChar.equals("-")){
            this.pos += 1;
            return new Token(ConstVal.MINUS, currentChar);
        }
        error();
        return new Token();
    }

    public void eat(String tokenType) throws Exception {
        if(this.currentToken.type.equals(tokenType)) this.currentToken = this.getNextToken();
        else this.error();
    }

    public int expr() throws Exception {
        this.currentToken  = this.getNextToken();

        Token left = this.currentToken;
        eat(ConstVal.INTEGER);
        Token op = this.currentToken;
        eat(op.type);
        Token right = this.currentToken;
        eat(ConstVal.INTEGER);

        int result = 0;
        if(op.value.equals("+")){
            result = Integer.parseInt(left.value) + Integer.parseInt(right.value);
        }
        else if(op.value.equals("-")){
            result = Integer.parseInt(left.value) - Integer.parseInt(right.value);
        }
        return result;
    }


    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            System.out.printf("calc> ");
            while((line = br.readLine()) != null){
                System.out.println(line);
                Interpreter interpreter = new Interpreter(line);
                System.out.println(interpreter.expr());
                System.out.printf("calc> ");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
