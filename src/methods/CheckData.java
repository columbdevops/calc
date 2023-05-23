package methods;

public class CheckData {
    public boolean checkEmpty(String stringInput){
        if(stringInput.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public boolean checkMaxSymbol(String stringInput){
        char[] charArray = stringInput.toCharArray();
        if(charArray.length <= 10) {
            return true;
        }else{
            return false;
        }
    }
}
