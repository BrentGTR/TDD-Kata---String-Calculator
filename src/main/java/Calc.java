class Calc {
    public static int add(String input){
        if(input.isEmpty()){
            return 0;
        }
        else {
            {
                String[] numbers = input.split("[^\\d-]+");
                int sum=0;
                StringBuilder negativeNumbers = new StringBuilder();
                for (String number : numbers){
                    if(!number.isEmpty()){
                        if(getAnInt(number) <0){
                            negativeNumbers.append(number).append(" ");
                        }
                    }
                }
                for (String number : numbers){
                    if(!number.isEmpty()){
                        if(getAnInt(number) <0){
                            throw new IllegalArgumentException("negatives not allowed "+number);
                        }
                        if(getAnInt(number) < 1001){
                            sum+= getAnInt(number);
                        }

                    }
                }
                return sum;
            }
    }}

    private static int getAnInt(String number) {
        return Integer.parseInt(number);
    }
}