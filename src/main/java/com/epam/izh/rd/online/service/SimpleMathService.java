package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maxValue = values[0];
        for (int element: values){
            maxValue = maxValue > element ? maxValue : element;
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int element: values) {
            sum += element;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int lengthOfEven = 0;
        for (int element: values) {
            if ((element % 2) == 0) {
                lengthOfEven++;
            }
        }
        int[] arrayOfEven = new int[lengthOfEven];
        int index = 0;
        for (int element: values) {
            if ((element % 2) == 0) {
                arrayOfEven[index] = element;
                index++;
            }
        }
        return arrayOfEven;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long factorial = 1L;
        if (initialVal > 0) {
            for (int i = initialVal; i > 1; i--) {
                factorial *= i;
            }
        } else if (initialVal < 0) {
            throw new IllegalArgumentException("Value is not valid: " + initialVal);
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number > 0) {
            long[] arrayOfFibonacci = new long[number + 1];
            arrayOfFibonacci[0] = 0L;
            arrayOfFibonacci[1] = 1L;
            for(int i = 2; i < (number + 1); i++) {
                arrayOfFibonacci[i] = arrayOfFibonacci[i - 2] + arrayOfFibonacci[i - 1];
            }
            return arrayOfFibonacci[number];
        } else if (number < 0) {
            throw new IllegalArgumentException("Value is not valid: " + number);
        }
        return 0L;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] sortedArray = new int[values.length];
        int temp = 0;
        System.arraycopy(values, 0, sortedArray, 0, values.length);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean isPrime = true;
        if (number > 2) {
            if (number != 3 && number != 5 && number != 7) {
                if ((number % 2 != 0) && (number % 3 != 0) && (number % 5 != 0) && (number % 7 != 0)) {
                    isPrime = true;
                } else {
                    isPrime = false;
                }
            } else {
                isPrime = true;
            }
        } else if (number == 2) {
            isPrime = true;
        } else {
            throw new IllegalArgumentException("Value is not valid: " + number);
        }
        return isPrime;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] reversedArray = new int[values.length];
        int reversedIndex = reversedArray.length - 1;
        for (int element: values) {
            reversedArray[reversedIndex] = element;
            reversedIndex--;
        }
        return reversedArray;
    }
}
