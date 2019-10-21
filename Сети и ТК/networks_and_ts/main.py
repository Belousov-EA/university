from np_hemming_code import *
from pandas import DataFrame


message = [1, 0, 1, 0]
find = [0, 0, 0, 0, 0, 0, 0]
correct = [0, 0, 0, 0, 0, 0, 0]
num_mistake = [1, 2, 3, 4, 5, 6, 7]
num = [0, 0, 0, 0, 0, 0, 0]
find_ab = [0., 0., 0., 0., 0., 0., 0.]
corr_ab = [0., 0., 0., 0., 0., 0., 0.]


def main():
    try:
        for i in range(1, bin_to_dec([1, 1, 1, 1, 1, 1, 1])+1):
            mistake_vec = dec_num_to_bin(i, 7)
            transmittion_loop(mistake_vec)
        for i in range(7):
            find_ab[i] = find[i] / num[i]
            corr_ab[i] = correct[i] / num [i]


        df = DataFrame({'Разрядность ошибки':num_mistake,'Количество ошибок' : num, \
                        'Исправленные ошибки': correct, 'Корректирующая способность' : corr_ab,\
                        'Обнаруженные ошибки': find, 'Обнаруживающая способность' : find_ab})
        df.to_excel('report.xlsx', sheet_name='sheet1', index=False)
        print("Выполненно успешно")
    except:
        print("Ошибка")


def transmittion_loop(mistake_vec):
    mistake_num = sum(mistake_vec)
    num[mistake_num - 1] += 1
    coding_message = coding(message.copy())
    interference_message = interference(coding_message, mistake_vec)
    is_mistake_was, decoding_message = decoding(interference_message)
    if message == decoding_message:
        correct[mistake_num - 1] += 1
    if is_mistake_was:
        find[mistake_num - 1] += 1

if __name__ == '__main__':
    main()


