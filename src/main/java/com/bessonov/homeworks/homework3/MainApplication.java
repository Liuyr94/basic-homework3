package com.bessonov.homeworks.homework3;

import java.util.Arrays;
import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
        //Создаём экземпляр класса Random для генерации случайных чисел
        Random random = new Random();

        //Генерируем диапазон случайных чисел от 8 до 12 включительно.
        int arraLength = random.ints(8, 12).findFirst().getAsInt();

        //Создаём двухмерный массив на основе сгенерированного диапазона и заполняем его случайными числами с
        // помощью метода randomGenerateArray
        int[][] arr = randomGenerateArray(new int[arraLength][arraLength]);

        //Вызываем метод для подсчета и возврата суммы всех элементов которые больше ноля, в двухмерном массиве
        //И выводим на экран результат
        System.out.println("Сумма всех элементов двухмерного массива равняется = " + sumOfPositiveElements(arr));

        //Вызываем метод для печати квадра из звездочек
        printStarSquare(arraLength);

        //Вызываем метод для зануления его левой диагонали.
        zerosTheDiagonals(arr);

        //Находим максимальный элемент массива
        System.out.println("Максимальный элемент массива равен = " + findMax(arr));

        //Суммируем все элементы второй строки 2-х мерного массива если её нет то возвращаем -1
        System.out.println(sumElementsSecondRow(arr));
    }

    /**
     * Метод для заполнения двухмерного массива случайными числами от 0 до 1212
     *
     * @param array
     * @return
     */
    private static int[][] randomGenerateArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) ((Math.random() * 899) + 100);
            }
        }
        return array;
    }

    /**
     * Cчитает и возвращает сумму всех элементов двухмерного массива которые больше ноля.
     *
     * @param array
     */
    private static int sumOfPositiveElements(int[][] array) {
        int result = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt > 0) {
                    result += anInt;
                }
            }
        }
        return result;
    }

    /**
     * Печает квадрат звёздочек со сторонами size
     *
     * @param size
     */
    private static void printStarSquare(int size) {
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Принимает в качестве аргумента двумерный целочисленный массив, и зануляюет левую диаганаль
     *
     * @param array
     */
    private static void zerosTheDiagonals(int[][] array) {
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            array[i][j] = 0;
        }
        for (int[] arr : array) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * Метод находит максимальный элемент массива
     *
     * @param array
     * @return
     */
    private static int findMax(int[][] array) {
        int result = array[0][0];
        for (int[] ints : array) {
            for (int j = 1; j < ints.length; j++) {
                if (ints[j] > result) {
                    result = ints[j];
                }
            }
        }
        return result;
    }

    /**
     * Метод считает сумму элементов второй строки двумерного массива и озвращает результат, если второй строки не
     * существует, то в качестве результата возвращаем -1
     *
     * @param array
     * @return
     */
    private static int sumElementsSecondRow(int[][] array) {
        if (array.length > 1) {
            int result = 0;
            for (int i = 0; i < array[1].length; i++) {
                result += array[1][i];
            }
            return result;
        } else {
            return -1;
        }
    }
}