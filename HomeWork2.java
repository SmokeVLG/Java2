/**
 * Java 2 home work for Lesson 2
 * author Denisov Maxim
 * date 20/08/2018
 *
 * @link https://github.com/SmokeVLG/Java2/blob/master/HomeWork2.java
 */

public class HomeWork2 {

    private static final int SIZE_OF_MAS = 4;

    private static class MyArraySizeException extends Exception {

        @Override
        public String getMessage() {
            return "Неверный размер массива.";
        }
    }

    private static class MyArrayDataException extends Exception {
        @Override
        public String getMessage() {
            return "Неверное значение в массиве.";
        }
    }

    private static int getSum(String[][] mas) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (mas.length != SIZE_OF_MAS) {
            throw new MyArraySizeException();
        }
        for (String[] str : mas) {
            if (str.length != SIZE_OF_MAS) {
                throw new MyArraySizeException();
            }
            for (String curNumStr : str) {
                try {
                    sum += Integer.parseInt(curNumStr);
                } catch (Exception e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        //test 1
        System.out.println("test 1\n ");
        String[][] mas = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            int result = getSum(mas);
            System.out.println("Итоговая сумма - >" + String.valueOf(result));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        //test 2
        System.out.println("test 2\n ");
        String[][] mas2 = {{"1", "2", "3", "4", "4"}, {"1", "2", "3", "4", "4"}, {"1", "2", "3", "4", "4"}, {"1", "2", "3", "4", "4"}};
        try {
            int result = getSum(mas2);
            System.out.println("Итоговая сумма - >" + String.valueOf(result));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        //test 3
        System.out.println("test 3\n ");
        String[][] mas3 = {{"1", "2", "3", "g"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            int result = getSum(mas3);
            System.out.println("Итоговая сумма - >" + String.valueOf(result));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }
}
