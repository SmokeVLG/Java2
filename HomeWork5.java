public class Main {

    private static final int size = 10000000;
    private static final int h = size / 2;

    public static void main(String[] args) {
        simpleMethod();
        try {
            methodWithThread();
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    //Первый просто бежит по массиву и вычисляет значения.
    private static void simpleMethod() {
        float[] arr = new float[size];
        //инициализация массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        //изменение массива
        getNewValues(arr);
        System.out.printf("\nВремя работы первого метода %s миллисекнды", System.currentTimeMillis() - a);
    }

    //Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
    //потом склеивает эти массивы обратно в один
    private static void methodWithThread() throws InterruptedException {
        float[] arr = new float[size];
        //инициализация массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        //изменение массива
        //первый массив
        float[] a1 = new float[h];
        //второй массив
        float[] a2 = new float[h];
        //разбиваем массива на два
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        //Получаем новые значения
        Thread t1 = new Thread(() -> getNewValues(a1));
        Thread t2 = new Thread(() -> getNewValues(a2));
        t1.start();
        t2.start();
        System.out.println("\nОжидание завершения потоков.");
        t1.join();
        t2.join();
        //Склеиваем массивы
        System.arraycopy(a1, 0, arr, 0, h - 1);
        System.arraycopy(a2, 0, arr, h, h - 1);
        System.out.printf("\nВремя работы второго метода %s миллисекнды", System.currentTimeMillis() - a);
    }

    private static void getNewValues(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));

        }
    }

}

