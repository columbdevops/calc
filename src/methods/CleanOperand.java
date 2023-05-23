package methods;

import java.io.IOException;

public class CleanOperand {
    ErrorText errorText = new ErrorText();
    public String clean(String  operand) {
    String str_res = "";
    char[] arrChar = operand.toCharArray();
    int check = 0;
    for(int i = 0; i < arrChar.length; i++){
        if(arrChar[i] == '\"' ){
            check++;
        }else{
                str_res += arrChar[i];
        }
    }
    // если одна кавычки выдаём исключение
    if(check != 2){
        try {
            throw new IOException();
        } catch (IOException e) {
            return "error6: " + errorText.errorText();
        }
    }
    return str_res;
    }
}
