package methods;

public class Division {
    public String createDivision(String  stringInput){

        try {
            String resString = "";
            String[] dataArr = stringInput.split("\\s*/\\s*");
            CleanOperand clearQuotes = new CleanOperand();
            dataArr[0] = clearQuotes.clean(dataArr[0]);

            int number = Integer.parseInt(dataArr[1]);
            if(number == 0){
                return "На ноль делить нельзя!";
            }
            //проверяем более ли 10ти символов у 1го операнда
            CheckData checkData = new CheckData();
            if(!checkData.checkMaxSymbol(dataArr[0])) {
                return "error10:/nКаждый операнд не должен быть более 10 символов";
            }

            //проверяем является ли число 2го операнда более 10ти или менее 1
            if(number > 10 || number < 0 ){
                return "Ваше значение должно быть более не более 10 и не менее 1";
            }

            // производим действие и уменьшаем длину строки
            char[] charArray = dataArr[0].toCharArray();
            int valDvision = charArray.length / number;
            for(int i = 0 ; i < valDvision; i++ ){
                resString += charArray[i];
            }
            if(resString.equals("")){
                return "При делении результат получился менее 0, поэтому мы показываем вам пустую строку!";
            }else{
                return resString;
            }
        } catch (NumberFormatException e) {
            return "error4: Второй операнд не может быть преобразован в число или быть целым числом.";
        }
    }
}
