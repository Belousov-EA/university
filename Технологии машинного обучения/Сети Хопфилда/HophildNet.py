#! /usr/bin/env python
# -*- coding: utf-8 -*-
import numpy as np
import random

class HopfieldNet:
    def __init__(self, sign_num):
        self.W = np.zeros((sign_num, sign_num), dtype=int) #матрица связей
        self.sign_num = sign_num                           #количество нейронов
        self.threshold = 0                                 #порог функции активации

    #Обучение сети
    def teach(self, array):
        array = np.array(array)
        #Если размер входного образа не совпадает с количеством нейронов сети
        #поднимаем исключение
        if not array.size == self.sign_num:
            raise ValueError
        #Получаем матрицу путем перемножения транспонированного вектора входных значений на
        # сам вектор
        string = np.matrix(array)
        column = string.transpose()
        matrix = column.dot(string)
        #Прибавляем полученную матрицу к матрице связей сети
        self.W += matrix

    #Устанавливаем порог функции активации
    def set_threshold(self, threshold):
        self.threshold = threshold

    #Конец обучения - обнуляем главную диагональ
    def stop_teach(self):
        i = 0
        while i < self.sign_num:
            self.W[i][i] = 0
            i += 1

    #Функция распознования образа
    def forward(self, value):
        return self._forward(value, self.activation)

    def _forward(self, value, activation):
        prev_value = np.zeros(self.sign_num, dtype=int)
        y = np.array(value)
        #Поднимаем исключение, если размерность взодного образа не совпадает
        #с количеством нейронов сети
        if not y.size == self.sign_num:
            raise ValueError
        i = 0
        while True:
            #матричное умножение, предоставляемое библиотекой numpy
            y = np.copy(self.W.dot(y))
            #применяем к результату функцию активации
            activation(y)
            #если, y равен y, полученному на предыдущей итерации, то мы притянулись
            #к аттрактору, возвращаем y и количество итераций i
            if np.array_equal(prev_value, y):
                return y, i+1
            #в ином случае, обновляем значение y на предыдущей итерации и инкрементируем
            #количество итераций
            prev_value = np.copy(y)
            i += 1
            #если количество итераций очень велико - мы попали в ситуацию, называемую
            #динамический аттрактор, выходим из бесконечного цикла
            if i == 10000:
                return y, float('nan')

    def forward_async(self, value):
        return self._forward_async(value, self.activation_async)

    def _forward_async(self, value, activation):
        prev_value = np.zeros(self.sign_num, dtype=int)
        y = np.array(value)
        # Поднимаем исключение, если размерность взодного образа не совпадает
        # с количеством нейронов сети
        if not y.size == self.sign_num:
            raise ValueError
        i = 0
        index_mass = np.array([ k for k in range(self.sign_num)])
        max = 0
        min = 100
        while True:
            # тут оборабатываем нейроны по одному
            #для этого выбираем случайный нейрон ...
            random.shuffle(index_mass)
            #...и считаем его новое значение
            k = 0
            while k < self.sign_num:
                new_value = 0
                for j in range(self.sign_num):
                    new_value += self.W[k][j] * y[j]
                #_max = np.amax(new_value)
                #_min = np.amin(new_value)
                y[k] = activation(new_value)
                k += 1
                #if _max > max:
                #    max = _max
                #if _min < min:
                #    min = _min

            # если, y равен y, полученному на предыдущей итерации, то мы притянулись
            # к аттрактору, возвращаем y и количество итераций i
            if np.array_equal(prev_value, y):
                return y, i + 1, max, min
            # в ином случае, обновляем значение y на предыдущей итерации и инкрементируем
            # количество итераций
            prev_value = np.copy(y)
            i += 1
            # если количество итераций очень велико - мы попали в ситуацию, называемую
            # динамический аттрактор, выходим из бесконечного цикла
            if i == 10000:
                return y, float('nan')

    #Пороговая функция активации
    def activation(self, value):
        i = 0
        while i < value.size:
            value[i] = self.activation_async(value[i])
            i += 1

    def activation_async(self, value):
        if value >= self.threshold:
            return 1
        else:
            return -1

    def get_max_activation_threshold(self):
        return int(np.max(np.abs(np.dot(self.W, np.ones(len(self.W))))))

