import numpy as np


def coding(input_message):
    #вставить проверочные биты
    i = 0
    control_bits_ind = []
    while( len( input_message ) > 2**i ):
        input_message.insert( 2**i - 1, 0 )
        control_bits_ind.append( 2**i - 1 )
        i += 1

    #заполняем матрицу преобразования
    transform_matrix = [dec_num_to_bin(x, len(control_bits_ind))\
                        for x in range (1, len(input_message)+1) ]

    #рассчитываем контрольные биты
    mx = np.matrix(transform_matrix)
    my = np.matrix(input_message)
    control_bits = my * mx
    control_bits = control_bits.tolist()[0]
    control_bits = list(map (lambda x : x % 2 , control_bits))

    #вставляем биты
    i = 0
    while (i < len(control_bits_ind)):
        input_message[control_bits_ind[i]] = control_bits[i]
        i+=1
    return input_message


def decoding(input_message):
    #определяем контрольные биты
    control_bits_ind = []
    i = 0
    while (len(input_message) > 2 ** i):
        control_bits_ind.append(2 ** i - 1)
        i += 1
    # заполняем матрицу преобразования
    transform_matrix = [dec_num_to_bin(x, len(control_bits_ind)) \
                        for x in range(1, len(input_message) + 1)]
    #перемножаем матрицы
    mx = np.matrix(transform_matrix)
    my = np.matrix(input_message)
    syndrome_matrix = my * mx
    syndrome_matrix = syndrome_matrix.tolist()[0]
    syndrome_matrix = list(map (lambda x : x % 2 , syndrome_matrix))
    #изменяем бит
    syndrome_int = bin_to_dec(syndrome_matrix[::-1])
    is_mistake_was = False
    if (not syndrome_int == 0):
        if(input_message[syndrome_int - 1]):
            input_message[syndrome_int - 1] = 0
        else:
            input_message[syndrome_int - 1] = 1
        is_mistake_was = True
    #убираем контрольные биты
    control_bits_ind.reverse()
    i = 0
    while control_bits_ind:
        del input_message[control_bits_ind.pop(0)]
        i += 1
    return is_mistake_was, input_message



def dec_num_to_bin(num, length):
    i = 0
    bin_num = []
    while(i < length):
        bin_num.append((num >> i) & 1 )
        i += 1
    return bin_num

def bin_to_dec(num):
    num_int = 0
    i = 0
    while ( i < len(num)):
        num_int = (num_int << 1)+num[i]
        i += 1
    return num_int

def interference(message, interference_vec):
    return list(map(lambda x, y: x^y, message, interference_vec))