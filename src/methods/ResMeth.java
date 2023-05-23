package methods;
public class ResMeth {

    public String resultMeth(String stringInput){
        ErrorText errorText = new ErrorText();
        // проверяем на пустоту
        CheckData checkData = new CheckData();
        if(checkData.checkEmpty(stringInput)){
            return "error0:/n" + errorText.errorText();
        }

        //разделим на 3 операнда 2ое значение должно быть + - * / и не должно быть пустотой или пробелом
        String[] operator = stringInput.split("(?=[+\\-*/])|(?<=[+\\-*/])");
        if(operator.length != 3 ){
            String[] checkCountMin = stringInput.split("-");
            if(checkCountMin.length == 1){
                return "error1:/n" + errorText.errorText();
            }
        }else{
            if(operator[0].trim() == "" ||operator[0].trim() == "" || operator[0].trim() == ""){
                return "error2:/n" + errorText.errorText();
            }
        }

        switch (operator[1]){
            case "+":
                Plus plus = new Plus();
                return  plus.createPlus(stringInput);
            case "-":
                Minus minus = new Minus();
                return  minus.createMinus(stringInput);
            case "*":
                Multiplication multiplication = new Multiplication();
                return  multiplication.createDivision(stringInput);
            case "/":
                Division division = new Division();
                return  division.createDivision(stringInput);
            default:
                return "error3:" + "Что-то пошло не так.";
        }
    }
}
