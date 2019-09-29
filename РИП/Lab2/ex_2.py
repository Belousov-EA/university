#!/usr/bin/env python3
from librip.gens import gen_random
from librip.iterators import Unique

data1 = ['He', 'he', 'm']
data2 = gen_random(1, 3, 10)

# Реализация задания 2

def Unique( list, ignore_case = None):
    ignore_list = []
    if ignore_case is None:
        ignore_case = False
    for item in list:
        if ignore_case:
            if type(item) is str:
                copy_item = item
                copy_item.lower()
                if not copy_item.lower() in ignore_list:
                    ignore_list.append(copy_item.lower())
                    yield item
            else:
                if not item in ignore_list:
                    ignore_list.append(item)
                    yield item
if __name__ == "__main__":
    for i in Unique( data1, True ):
        print( i )