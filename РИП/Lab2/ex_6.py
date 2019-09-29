#!/usr/bin/env python3
import json
import sys
from librip.ctxmngrs import timer
from librip.decorators import print_result
from ex_1 import field, gen_random
from ex_2 import Unique as unique

path = sys.argv[1]

# Здесь необходимо в переменную path получить
# путь до файла, который был передан при запуске

with open(path) as f:
    data = json.load(f)
    data = [x['job-name'] for x in data]


# Далее необходимо реализовать все функции по заданию, заменив `raise NotImplemented`
# Важно!
# Функции с 1 по 3 дожны быть реализованы в одну строку
# В реализации функции 4 может быть до 3 строк
# При этом строки должны быть не длиннее 80 символов

@print_result
def f1(arg):
    return [x for x in unique(arg, True)]



@print_result
def f2(arg):
    return list(filter(lambda x: 'программист' in x or 'Программист' in x, arg))


@print_result
def f3(arg):
    return ['{0} с опытом Python'.format(x) for x in arg]


@print_result
def f4(arg):
    salary_list = gen_random(100_000, 200_000, len(arg))
    return dict(zip(arg, salary_list))

with timer():
    f4(f3(f2(f1(data))))
