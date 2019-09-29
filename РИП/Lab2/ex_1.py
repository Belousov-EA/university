#!/usr/bin/env python3
from librip.gens import field
import random


goods = [
    {'title': 'Ковер', 'price': 2000, 'color': 'green'},
    {'title': 'Диван для отдыха', 'price': 5300, 'color': 'black'},
    {'title': 'Стелаж', 'price': 7000, 'color': 'white'},
    {'title': 'Вешалка для одежды', 'price': 800, 'color': 'white'},
    {'price' : 2000}
]

# Реализация задания 1
def field( list, *args ):
    if list is None:
        return None
    for arg in args:
        for item in list:
            if arg in item:
                yield item


def gen_random( start, finish, num ):
    for i in range( num ):
        yield random.randint( start, finish )

if __name__ == '__main__':
    for i in gen_random(1, 3, 5):
        print( i )