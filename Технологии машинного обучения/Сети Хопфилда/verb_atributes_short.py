import HophildNet as hn
import pandas as pd
import numpy as np
from Hopfield_parser import convert_from, convert_to
import math

def to_test_verb_short(data, test_verb):
    hopfield_data = convert_to(data)

    if (hopfield_data.shape[0] > int(hopfield_data.shape[1]
                                         / (2 * math.log10(hopfield_data.shape[1])))):
        print('Сеть не может запомнить все образы')
        raise TimeoutError

    net = hn.HopfieldNet(hopfield_data.shape[1])
    for verb in hopfield_data:
        net.teach(verb)
    net.stop_teach()
    net.set_threshold(0)
    result_verb = convert_from(net.forward(convert_to(test_verb))[0])
    result_verb = result_verb.astype(np.int64)
    i = 0
    while i < data.shape[0]:
        if (np.array_equal(data[i], result_verb)):
            break
        i += 1
    str_num = i
    if i == data.shape[0]:
        print('Новая вершина')
        str_num = -1
    else:
        print('Новая вершина должна быть объединена с вершиной (', str_num, ')')
    return str_num