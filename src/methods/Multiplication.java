package methods;

public class Multiplication {
    public String createDivision(String  stringInput){
        ErrorText errorText = new ErrorText();
        try {
            String resString = "";
            String[] dataArr = stringInput.split("\\s*\\*\\s*");
           int number = Integer.parseInt(dataArr[1]);
            CleanOperand clearQuotes = new CleanOperand();
            dataArr[0] = clearQuotes.clean(dataArr[0]);

            //проверяем более ли 10ти символов у 1го операнда
            CheckData checkData = new CheckData();
            if(!checkData.checkMaxSymbol(dataArr[0])) {
                return "error10:/nКаждый операнд не должен быть более 10 символов";
            }

            //проверяем является ли число 2го операнда более 10ти или менее 1
            if(number > 10 || number < 0 ){
                return "Ваше значение должно быть более не более 10 и не менее 1";
            }

            if( dataArr[0].contains("error6: ")){
                return "error9: У первого операнда должны быть кавычки";
            }
            for(int i = 0 ; i < number; i++ ){
                resString += dataArr[0];

            }
            if(resString.equals("")){
                return "error8:/n" + errorText.errorText();
            }else{
                //если строка более 40 символов
                if(resString.length() > 40) {
                    resString = resString.substring(0, 40) + "(...)";
                }
                return resString;
            }

        } catch (NumberFormatException e) {
            return "error7: Второй операнд не может быть преобразован в число или быть целым числом.";
        }

    }
}
