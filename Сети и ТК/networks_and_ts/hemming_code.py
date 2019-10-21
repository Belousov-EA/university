def input_parse(i):
    return int(i, 2)


def coding(message):
    control_bit_ind = set()
    #вставляем контрольные биты
    i = 0
    while(len(message) > 2**i):
        message = message[:2**i-1]+'0'+message[2**i-1:]
        i += 1
        control_bit_ind.add(i)
    transformation_column = [btoa( t, lenb( len( message ) + 1 ) ) \
                             for t in range(1, len(message)+1)]
    control_bits = []
    for row_i in range(i+1):
        control_bit = 0
        transformation_string = ""
        for column in transformation_column:
            print (row_i)
            print (column)
            print (transformation_string)
            print( len(message))
            print ('новая итерация')
            transformation_string += column[row_i]
        print( 'строка' )
        print (transformation_string)

    return
        #control_bit = int(message) & ()
        #control_bits.append(control_bit)
    return control_bits




def interference(input_message):
    pass


def decoding(input_message):
    pass


def atob(str_num):
    return int(str_num, 2)

def btoa(int_num, length):
    str_num = bin(int_num)[2:]
    if length < len( str_num ):
        raise ValueError
    if length > len( str_num ):
        str_num = '0'*(length - len(str_num))+str_num
    return str_num

def lenb(int_num):
    return len( bin(int_num)[2:] )